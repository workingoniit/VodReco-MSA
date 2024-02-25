package com.detail.UserActivityEventListener.mongoRepository;

import com.detail.UserActivityEventListener.domain.UserWish;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserWishRepository extends MongoRepository<UserWish, Integer> {
    UserWish findBySubsrAndContentId(String contentId, String subsr);
    List<UserWish> findAllBySubsr(String subsr);
}
