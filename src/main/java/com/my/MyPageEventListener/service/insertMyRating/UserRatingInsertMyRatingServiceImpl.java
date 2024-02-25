package com.my.MyPageEventListener.service.insertMyRating;

import com.my.MyPageEventListener.dto.InsertOrUpdateMyRatingDto;
import com.my.MyPageEventListener.mongoRepository.UserRatingRepository;
import com.my.MyPageEventListener.util.InsertOrUpdateMyRatingDtoToUserRatingWrapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class UserRatingInsertMyRatingServiceImpl implements UserRatingInsertMyRatingService {
    private final UserRatingRepository userRatingRepository;
    private final InsertOrUpdateMyRatingDtoToUserRatingWrapper toUserRatingWrapper;
    @Override
    public void insertRating(List<String> messagelistExceptClassifier) {
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
