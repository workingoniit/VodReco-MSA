package com.detail.UserActivityCUD.util;

import com.detail.UserActivityCUD.domain.UserRating;
import com.detail.UserActivityCUD.dto.UpdateMyRatingDto;
import org.springframework.stereotype.Component;

@Component

public class FromUpdateMyRatingDtoToUserRatingWrapper {
    public UserRating toUserRating(UpdateMyRatingDto updateMyRatingDto) {
        return this.updateMyRatingDtoToUserRating(updateMyRatingDto);
    }

    private UserRating updateMyRatingDtoToUserRating(UpdateMyRatingDto updateMyRatingDto) {
        return UserRating.builder()
                .uniqueId(updateMyRatingDto.getUniqueId())
                .subsr(updateMyRatingDto.getSubsr())
                .title(updateMyRatingDto.getTitle())
                .contentId(updateMyRatingDto.getContentId())
                .posterurl(updateMyRatingDto.getPosterurl())
                .rating(updateMyRatingDto.getRating())
                .rating_date(updateMyRatingDto.getRating_date())
                .review(updateMyRatingDto.getReview())
                .build();
    }
}
