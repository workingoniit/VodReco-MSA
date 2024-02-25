package com.detail.UserActivityEventListener.service.updateMyRating;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserRatingUpdateMyRatingService {

    void updateRating(List<String> messageListExceptClassifier);

}
