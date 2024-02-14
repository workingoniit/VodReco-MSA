package com.main.MainPage.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user_id")
@Getter
//@AllArgsConstructor // Accesslevel 좁히는 방법 있음, 목적이 있다면 추가 가능(231102)
@NoArgsConstructor
public class User {
    private String subsr;
}