package com.detail.UserActivityCUD.service.updateMyRating;


import com.detail.UserActivityCUD.dto.UpdateMyRatingDto;
import com.detail.UserActivityCUD.dto.UpdateMyRatingRequestDto;
import com.detail.UserActivityCUD.mongoRepository.VodRepository;
import com.detail.UserActivityCUD.repository.UserRatingRepository;
import com.detail.UserActivityCUD.util.FromUpdateMyRatingDtoToUserRatingWrapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserRatingUpdateMyRatingServiceImpl implements UserRatingUpdateMyRatingService {
    private final UserRatingRepository userRatingRepository;
    private final VodRepository vodRepository;
    private final FromUpdateMyRatingDtoToUserRatingWrapper toUserRatingWrapper;

    @Override
    public void saveRating(String contentId, UpdateMyRatingRequestDto updateMyRatingRequestDto) {
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
    }

}
