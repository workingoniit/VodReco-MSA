package com.detail.DetailPageView.mongoRepository;

import com.detail.DetailPageView.domain.UserRating;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserRatingRepository extends MongoRepository<UserRating, String> {

    List<UserRating> findAllByContentId(String contentId);
    void deleteByUniqueId(String uniqueId);
    List<UserRating> findAllBySubsr(String contentId);

    UserRating findByUniqueId(String uniqueId);
}
