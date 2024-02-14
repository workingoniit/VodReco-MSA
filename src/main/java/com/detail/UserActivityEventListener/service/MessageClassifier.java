package com.detail.UserActivityEventListener.service;

import com.detail.UserActivityEventListener.service.deleteMyRating.UserRatingDeleteMyRatingServiceImpl;
import com.detail.UserActivityEventListener.service.insertMyRating.UserRatingInsertMyRatingServiceImpl;
import com.detail.UserActivityEventListener.service.updateMyRating.UserRatingUpdateMyRatingServiceImpl;
import com.detail.UserActivityEventListener.util.StringToListWrapper;
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

    public void classifyMessage(String message) {
        List<String> messageList = stringToListWrapper.stringToList(message);
        String event = messageList.get(0);
        if (Objects.equals(event, "rating delete")) {
            String uniqueId = messageList.get(1);
            userRatingDeleteMyRatingService.deleteRating(uniqueId);
        }
        else if (Objects.equals(event, "rating update")) {
            List<String> messageListExceptClassifier = messageList.subList(1, messageList.size());
            userRatingUpdateMyRatingService.updateRating(messageListExceptClassifier);
        } else if (Objects.equals(event, "rating insert")) {
            List<String> messageListExceptClassifier = messageList.subList(1, messageList.size());
            userRatingInsertMyRatingService.insertRating(messageListExceptClassifier);
        }
    }

}
