package com.detail.UserActivityEventListener.service.updateMyWish;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserWishUpdateMyWishService {
    // 컬럼: id / subsr / content_id / wish(0or1) / title / posterurl
    void saveWish(List<String> messageListExceptClassifier);
}
