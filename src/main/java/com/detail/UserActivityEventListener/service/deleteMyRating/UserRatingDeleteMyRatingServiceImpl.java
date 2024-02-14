package com.detail.UserActivityEventListener.service.deleteMyRating;

import com.detail.UserActivityEventListener.mongoRepository.UserRatingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserRatingDeleteMyRatingServiceImpl implements UserRatingDeleteMyRatingService{
    private final UserRatingRepository userRatingRepository;

    @Override
//    public void deleteRating(String contentId, String subsr) {
    public void deleteRating(String uniqueId) {
//        String uniqueId = subsr + contentId;
        userRatingRepository.deleteByUniqueId(uniqueId);
    }

}

