package com.detail.UserActivityEventListener.service.updateMyRating;

import com.detail.UserActivityEventListener.mongoRepository.UserRatingRepository;
import com.detail.UserActivityEventListener.util.InsertOrUpdateMyRatingDtoToUserRatingWrapper;
import dto.InsertOrUpdateMyRatingDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class UserRatingUpdateMyRatingServiceImpl implements UserRatingUpdateMyRatingService {
    private final UserRatingRepository userRatingRepository;
    private final InsertOrUpdateMyRatingDtoToUserRatingWrapper toUserRatingWrapper;
    @Override
    public void updateRating(List<String> messagelistExceptClassifier) {
        String uniqueId = messagelistExceptClassifier.get(0);
        String subsr = messagelistExceptClassifier.get(1);
        String contentId = messagelistExceptClassifier.get(2);
        Integer rating = Integer.parseInt(messagelistExceptClassifier.get(3));
        String review = messagelistExceptClassifier.get(4);
        String rating_date = messagelistExceptClassifier.get(5);
        String title = messagelistExceptClassifier.get(7);
        String posterurl = messagelistExceptClassifier.get(6);

        InsertOrUpdateMyRatingDto insertOrUpdateMyRatingDto = InsertOrUpdateMyRatingDto.builder()
                .uniqueId(uniqueId)
                .subsr(subsr)
                .contentId(contentId)
                .rating(rating)
                .review(review)
                .rating_date(rating_date)
                .title(title)
                .posterurl(posterurl)
                .build();
        userRatingRepository.save(toUserRatingWrapper.toUserRating(insertOrUpdateMyRatingDto));
    }

}
