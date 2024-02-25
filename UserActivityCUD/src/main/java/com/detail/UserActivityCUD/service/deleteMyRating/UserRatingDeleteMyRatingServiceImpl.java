package com.detail.UserActivityCUD.service.deleteMyRating;

import com.detail.UserActivityCUD.repository.UserRatingRepository;
import com.detail.UserActivityCUD.sqs.AmazonSQSSender;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;


@Service
@RequiredArgsConstructor
@Transactional
public class UserRatingDeleteMyRatingServiceImpl implements UserRatingDeleteMyRatingService{
    private final UserRatingRepository userRatingRepository;
    private final AmazonSQSSender amazonSQSSender;


    @Override
    public void deleteRating(String contentId, String subsr) {
        String uniqueId = subsr + contentId;
        userRatingRepository.deleteByUniqueId(uniqueId);

        // SQS에 delete 메시지 보내기 : 메시지 보내는 행위까지가 단일 트랜잭션
        String message = "rating delete, " + uniqueId;
        amazonSQSSender.sendMessage(amazonSQSSender.getQueueName(), UUID.randomUUID().toString(), message);

    }
}

