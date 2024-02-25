package com.my.Mypage.dto.mypage;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ViewMyWishResponseDto {
    private Integer wish;

    @Builder
    public ViewMyWishResponseDto(Integer wish) {
        this.wish = wish;
    }
}
