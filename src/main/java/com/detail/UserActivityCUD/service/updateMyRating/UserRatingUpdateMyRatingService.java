package com.detail.UserActivityCUD.service.updateMyRating;

import com.detail.UserActivityCUD.dto.UpdateMyRatingRequestDto;
import org.springframework.stereotype.Service;

@Service
public interface UserRatingUpdateMyRatingService {

    void updateRating(String contentId, UpdateMyRatingRequestDto updateMyRatingRequestDto);

}
