package com.detail.DetailPageView.service.viewEveryRating;

import com.detail.DetailPageView.domain.UserRating;
import com.detail.DetailPageView.dto.rating.ViewEveryRatingResponseDto;
import com.detail.DetailPageView.mongoRepository.UserRatingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserRatingViewEveryRatingServiceImpl implements UserRatingViewEveryRatingService{

    private final UserRatingRepository userRatingViewRepository;

    @Override
    public List<ViewEveryRatingResponseDto> findEveryUserRating(String contentId) {
        List<ViewEveryRatingResponseDto> ratingResponseDtos = new ArrayList<>();
        List<UserRating> ratingList = userRatingViewRepository.findAllByContentId(contentId);
        if (ratingList == null) {
            return null;
        }
        for (UserRating r : ratingList) {
            ViewEveryRatingResponseDto viewEveryRatingResponseDto = ViewEveryRatingResponseDto.builder().subsr(r.getSubsr()).rating_date(r.getRating_date()).rating(r.getRating()).review(r.getReview()).title(r.getTitle()).posterurl(r.getPosterurl()).build();
            ratingResponseDtos.add(viewEveryRatingResponseDto);
        }
        return ratingResponseDtos;

    }
}
