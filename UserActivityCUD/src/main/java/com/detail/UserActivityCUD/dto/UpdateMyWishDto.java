package com.detail.UserActivityCUD.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class UpdateMyWishDto {
    private String uniqueId;
    private String subsr;
    private String contentId;
    private Integer wish;
    private String title;
    private String posterurl;

    @Builder
    public UpdateMyWishDto(String uniqueId, String subsr, String contentId, Integer wish, String title, String posterurl) {
        this.uniqueId = uniqueId;
        this.subsr = subsr;
        this.contentId = contentId;
        this.wish = wish;
        this.title = title;
        this.posterurl = posterurl;
    }

}

