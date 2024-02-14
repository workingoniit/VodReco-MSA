package com.detail.UserActivityCUD.service.updateMyWish;

import com.detail.UserActivityCUD.dto.UpdateMyWishDto;
import com.detail.UserActivityCUD.dto.UpdateMyWishRequestDto;
import com.detail.UserActivityCUD.mongoRepository.VodRepository;
import com.detail.UserActivityCUD.repository.UserWishRepository;
import com.detail.UserActivityCUD.sqs.AmazonSQSSender;
import com.detail.UserActivityCUD.util.FromUpdateMyWishDtoToUserWishWrapper;
import com.detail.UserActivityCUD.util.ListToStringWrapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class UserWishUpdateMyWishServiceImpl implements UserWishUpdateMyWishService{
    private final UserWishRepository userWishRepository;
    private final VodRepository vodRepository;
    private final FromUpdateMyWishDtoToUserWishWrapper toUserWishWrapper;
    private final ListToStringWrapper listToStringWrapper;
    private final AmazonSQSSender amazonSQSSender;

    @Override
    @Transactional
    public void saveWish(UpdateMyWishRequestDto updateMyWishRequestDto, String contentId) {
        //이대로 mysql에 삽입하면 unique_id라는 컬럼 create되어 데이터 삽입됨(240213)
        String uniqueId = updateMyWishRequestDto.getSubsr() + contentId;
        UpdateMyWishDto updateMyWishDto = UpdateMyWishDto.builder().uniqueId(uniqueId).subsr(updateMyWishRequestDto.getSubsr())
                .contentId(contentId).wish(updateMyWishRequestDto.getWish()).title(vodRepository.findByContentId(contentId).getTitle()).
                posterurl(vodRepository.findByContentId(contentId).getPosterurl()).build();
        userWishRepository.save(toUserWishWrapper.toUserWish(updateMyWishDto));

        List<String> messageList = new ArrayList<>();
        messageList.add(uniqueId);
        messageList.add(updateMyWishDto.getSubsr());
        messageList.add(updateMyWishDto.getContentId());
        messageList.add(String.valueOf(updateMyWishDto.getWish()));
        messageList.add(updateMyWishDto.getTitle());
        messageList.add(updateMyWishDto.getPosterurl());

        String message = "wish insert or update, " + listToStringWrapper.listToString(messageList);

        //sqs에 메시지 보내기
        amazonSQSSender.sendMessage(amazonSQSSender.getQueueName(), UUID.randomUUID().toString(), message);
    }
}
