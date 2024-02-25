package com.detail.UserActivityEventListener.service.insertMyRating;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserRatingInsertMyRatingService {

    void insertRating(List<String> messageListExceptClassifier);

}
