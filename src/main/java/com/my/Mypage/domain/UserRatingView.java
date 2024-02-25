package com.my.Mypage.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@NoArgsConstructor
@Document(collection = "user_rating")
public class UserRatingView {
    @Id
    private String uniqueId;
    private String subsr;
    @Field(name = "content_id")
    private String contentId;
    private Integer rating;
    private String review;
    private String rating_date;
    private String title;
    private String posterurl;

    @Builder
    public UserRatingView(String uniqueId, String subsr, String contentId, Integer rating, String review, String rating_date, String title, String posterurl) {
        this.uniqueId = uniqueId;
        this.subsr = subsr;
        this.contentId = contentId;
        this.rating = rating;
        this.review = review;
        this.rating_date = rating_date;
        this.title = title;
        this.posterurl = posterurl;
    }
}
