package com.my.MyPageEventListener.domain;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@NoArgsConstructor
@Document(collection = "user_wish")
public class UserWish {
    @Id
    //Id를 content_id + subsr로 만드는 방안 고려하기(231123)
    @Field(name = "unique_id")
    private String uniqueId;
    private String subsr;
    @Field(name = "content_id")
    private String contentId;
    private Integer wish;
    private String title;
    private String posterurl;

    @Builder
    public UserWish(String uniqueId, String subsr, String contentId, Integer wish, String title, String posterurl) {
        this.uniqueId = uniqueId;
        this.subsr = subsr;
        this.contentId = contentId;
        this.wish = wish;
        this.title = title;
        this.posterurl = posterurl;
    }


}
