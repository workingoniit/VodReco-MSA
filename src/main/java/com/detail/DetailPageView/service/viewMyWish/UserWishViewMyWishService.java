package com.detail.DetailPageView.service.viewMyWish;

import com.detail.DetailPageView.dto.wish.ViewMyWishResponseDto;
import org.springframework.stereotype.Service;

@Service
public interface UserWishViewMyWishService {
    public ViewMyWishResponseDto findMyWish(String subsr, String contentId);
}
