package com.detail.UserActivityEventListener.util;

import com.detail.UserActivityEventListener.domain.UserRating;
import com.detail.UserActivityEventListener.dto.InsertOrUpdateMyRatingDto;
import org.springframework.stereotype.Component;

@Component
public class InsertOrUpdateMyRatingDtoToUserRatingWrapper {
    public UserRating toUserRating(InsertOrUpdateMyRatingDto insertOrUpdateMyRatingDto) {
        return this.updateMyRatingDtoToUserRating(insertOrUpdateMyRatingDto);
    }

    private UserRating updateMyRatingDtoToUserRating(InsertOrUpdateMyRatingDto insertOrUpdateMyRatingDto) {
        return UserRating.builder()
                .uniqueId(insertOrUpdateMyRatingDto.getUniqueId())
                .subsr(insertOrUpdateMyRatingDto.getSubsr())
                .title(insertOrUpdateMyRatingDto.getTitle())
                .contentId(insertOrUpdateMyRatingDto.getContentId())
                .posterurl(insertOrUpdateMyRatingDto.getPosterurl())
                .rating(insertOrUpdateMyRatingDto.getRating())
                .rating_date(insertOrUpdateMyRatingDto.getRating_date())
                .review(insertOrUpdateMyRatingDto.getReview())
                .build();
    }
}
