package com.detail.DetailPageView.service.viewEveryRating;

import com.detail.DetailPageView.dto.rating.ViewEveryRatingResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserRatingViewEveryRatingService {
    List<ViewEveryRatingResponseDto> findEveryUserRating(String contentId);
}
