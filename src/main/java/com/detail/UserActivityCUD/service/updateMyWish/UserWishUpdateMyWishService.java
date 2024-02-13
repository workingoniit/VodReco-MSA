package com.detail.UserActivityCUD.service.updateMyWish;

import com.detail.UserActivityCUD.dto.UpdateMyWishRequestDto;
import org.springframework.stereotype.Service;

@Service
public interface UserWishUpdateMyWishService {
    void saveWish(UpdateMyWishRequestDto updateMyWishRequestDto, String contentId);
}
