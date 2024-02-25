package com.detail.UserActivityCUD.service.insertMyRating;

import com.detail.UserActivityCUD.dto.UpdateMyRatingRequestDto;
import org.springframework.stereotype.Service;

@Service
public interface UserRatingInsertMyRatingService {

    void insertRating(String contentId, UpdateMyRatingRequestDto updateMyRatingRequestDto);

}
