package com.detail.UserActivityCUD.service.updateMyRating;


import com.detail.UserActivityCUD.dto.UpdateMyRatingDto;
import com.detail.UserActivityCUD.dto.UpdateMyRatingRequestDto;
import com.detail.UserActivityCUD.mongoRepository.VodRepository;
import com.detail.UserActivityCUD.repository.UserRatingRepository;
import com.detail.UserActivityCUD.sqs.AmazonSQSSender;
import com.detail.UserActivityCUD.util.FromUpdateMyRatingDtoToUserRatingWrapper;
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
public class UserRatingUpdateMyRatingServiceImpl implements UserRatingUpdateMyRatingService {
    private final UserRatingRepository userRatingRepository;
    private final VodRepository vodRepository;
    private final FromUpdateMyRatingDtoToUserRatingWrapper toUserRatingWrapper;
    private final ListToStringWrapper listToStringWrapper;
    private final AmazonSQSSender amazonSQSSender;


    @Override
    public void updateRating(String contentId, UpdateMyRatingRequestDto updateMyRatingRequestDto) {
        String uniqueId = updateMyRatingRequestDto.getSubsr() + contentId;
        UpdateMyRatingDto updateMyRatingDto = UpdateMyRatingDto.builder()
                .uniqueId(uniqueId)
                .subsr(updateMyRatingRequestDto.getSubsr())
                .contentId(contentId)
                .rating(updateMyRatingRequestDto.getRating())
                .review(updateMyRatingRequestDto.getReview())
                .rating_date(updateMyRatingRequestDto.getRating_date())
                .title(vodRepository.findByContentId(contentId).getTitle())
                .posterurl(vodRepository.findByContentId(contentId).getPosterurl())
                .build();
        userRatingRepository.save(toUserRatingWrapper.toUserRating(updateMyRatingDto));

        List<String> messageList = new ArrayList<>();
        messageList.add(uniqueId);
        messageList.add(updateMyRatingDto.getSubsr());
        messageList.add(contentId);
        messageList.add(String.valueOf(updateMyRatingDto.getRating()));
        messageList.add(updateMyRatingDto.getReview());
        messageList.add(updateMyRatingDto.getRating_date());
        messageList.add(updateMyRatingDto.getTitle());
        messageList.add(updateMyRatingDto.getPosterurl());
        String message = "rating update, " + listToStringWrapper.listToString(messageList);

        amazonSQSSender.sendMessage(amazonSQSSender.getQueueName(), UUID.randomUUID().toString(), message);


        //TODO :
//        updateRating, uniqueId, ... 해서 통으로 보내고
//                StringtoListWrapper 파쿠리해와서 파싱해가지고 리스트로 만들고 인덱싱하자 ㅎㅎ
//                if list.size() == 2 -> delete라 판단 / ..
//        이렇게 하는 이유: MQ로 주고받는 데이터 사이즈 줄이려고. 성능 위함

    }

}
