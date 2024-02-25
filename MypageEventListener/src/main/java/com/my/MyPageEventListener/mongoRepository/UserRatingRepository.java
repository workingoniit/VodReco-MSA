package com.my.MyPageEventListener.mongoRepository;

import com.my.MyPageEventListener.domain.UserRating;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRatingRepository extends MongoRepository<UserRating, Integer> {

    List<UserRating> findAllByContentId(String contentId);

    List<UserRating> findAllBySubsr(String contentId);

    void deleteByUniqueId(String uniqueId);
}
