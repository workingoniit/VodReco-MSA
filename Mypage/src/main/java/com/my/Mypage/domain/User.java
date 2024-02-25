package com.my.Mypage.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user_id")
@Getter
//@AllArgsConstructor // TODO : 리팩토링 시 Access Level 좁히기
@NoArgsConstructor
public class User {
//    @Id
    private String subsr;

}