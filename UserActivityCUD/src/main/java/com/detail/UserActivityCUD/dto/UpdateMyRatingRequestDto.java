package com.detail.UserActivityCUD.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UpdateMyRatingRequestDto {

    private String subsr;
    private Integer rating;
    private String review;
    private String rating_date;
}
