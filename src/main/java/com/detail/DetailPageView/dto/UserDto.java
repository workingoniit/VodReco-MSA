package com.detail.DetailPageView.dto;


import com.detail.DetailPageView.domain.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
//@Builder
//@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private String subsr;

    @Builder
    public UserDto(String subsr) {
        this.subsr = subsr;
    }

    public static UserDto from(User user) {
        if(user == null) return null;

        return UserDto.builder().subsr(user.getSubsr()).build();
    }
}
