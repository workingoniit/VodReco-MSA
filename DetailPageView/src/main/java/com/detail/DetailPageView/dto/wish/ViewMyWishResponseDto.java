package com.detail.DetailPageView.dto.wish;

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
