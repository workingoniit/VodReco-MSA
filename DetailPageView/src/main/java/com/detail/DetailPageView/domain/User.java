package com.detail.DetailPageView.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user_id")
@Getter
@NoArgsConstructor
public class User {
    private String subsr;

}