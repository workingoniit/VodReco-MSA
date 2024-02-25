package com.detail.UserActivityEventListener.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "user_rating")
@Getter
@NoArgsConstructor
public class UserRating {
    @Id
    // @Id 붙이면 내가 지정한 unique_id라는 키값 무시됨. mongoDB에는 _id라는 이름으로 데이터 삽입됨
    @Field(name = "unique_id")
//    @ColumnDefault("defaultId")
    private String uniqueId;
    @Field
    private String subsr;
    private String contentId;
    private Integer rating;
    @Field
    private String review;
    private String rating_date;
    private String title;
    private String posterurl;

    @Builder
    public UserRating(String uniqueId, String subsr, String contentId, Integer rating, String review, String rating_date, String title, String posterurl) {
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
