package com.my.MyPageEventListener.service;

import com.my.MyPageEventListener.service.deleteMyRating.UserRatingDeleteMyRatingServiceImpl;
import com.my.MyPageEventListener.service.insertMyRating.UserRatingInsertMyRatingServiceImpl;
import com.my.MyPageEventListener.service.updateMyRating.UserRatingUpdateMyRatingServiceImpl;
import com.my.MyPageEventListener.service.updateMyWish.UserWishUpdateMyWishServiceImpl;
import com.my.MyPageEventListener.util.StringToListWrapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
@Component
public class MessageClassifier {
    private final StringToListWrapper stringToListWrapper;
    private final UserRatingDeleteMyRatingServiceImpl userRatingDeleteMyRatingService;
    private final UserRatingUpdateMyRatingServiceImpl userRatingUpdateMyRatingService;
    private final UserRatingInsertMyRatingServiceImpl userRatingInsertMyRatingService;
    private final UserWishUpdateMyWishServiceImpl userWishUpdateMyWishService;
    public void classifyMessage(String message) {
        List<String> messageList = stringToListWrapper.stringToList(message);
        String event = messageList.get(0);
        if (Objects.equals(event, "rating delete")) {
            String uniqueId = messageList.get(1);
            userRatingDeleteMyRatingService.deleteRating(uniqueId);
        } else if (Objects.equals(event, "rating update")) {
            List<String> messageListExceptClassifier = messageList.subList(1, messageList.size());
            userRatingUpdateMyRatingService.updateRating(messageListExceptClassifier);
        } else if (Objects.equals(event, "rating insert")) {
            List<String> messageListExceptClassifier = messageList.subList(1, messageList.size());
            userRatingInsertMyRatingService.insertRating(messageListExceptClassifier);
        } else if (Objects.equals(event, "wish insert or update")) {
            List<String> messageListExceptClassifier = messageList.subList(1, messageList.size());
            userWishUpdateMyWishService.saveWish(messageListExceptClassifier);
        }
    }

}
