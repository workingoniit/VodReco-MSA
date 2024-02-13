package com.detail.UserActivityCUD.service.updateMyWish;

import com.detail.UserActivityCUD.dto.UpdateMyWishDto;
import com.detail.UserActivityCUD.dto.UpdateMyWishRequestDto;
import com.detail.UserActivityCUD.mongoRepository.VodRepository;
import com.detail.UserActivityCUD.repository.UserWishRepository;
import com.detail.UserActivityCUD.util.FromUpdateMyWishDtoToUserWishWrapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserWishUpdateMyWishServiceImpl implements UserWishUpdateMyWishService{
    private final UserWishRepository userWishRepository;
    private final VodRepository vodRepository;
    private final FromUpdateMyWishDtoToUserWishWrapper toUserWishWrapper;
    @Override
    @Transactional
    public void saveWish(UpdateMyWishRequestDto updateMyWishRequestDto, String contentId) {
        //이대로 mysql에 삽입하면 unique_id라는 컬럼 create되어 데이터 삽입됨(240213)
        String uniqueId = updateMyWishRequestDto.getSubsr() + contentId;
        UpdateMyWishDto updateMyWishDto = UpdateMyWishDto.builder().uniqueId(uniqueId).subsr(updateMyWishRequestDto.getSubsr())
                .contentId(contentId).wish(updateMyWishRequestDto.getWish()).title(vodRepository.findByContentId(contentId).getTitle()).
                posterurl(vodRepository.findByContentId(contentId).getPosterurl()).build();
        userWishRepository.save(toUserWishWrapper.toUserWish(updateMyWishDto));
    }
}
