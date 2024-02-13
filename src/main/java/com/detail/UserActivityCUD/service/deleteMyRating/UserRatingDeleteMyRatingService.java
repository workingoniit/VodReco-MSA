package com.detail.UserActivityCUD.service.deleteMyRating;

import org.springframework.stereotype.Service;

@Service
public interface UserRatingDeleteMyRatingService {
    void deleteRating(String contentId, String subsr);
}
