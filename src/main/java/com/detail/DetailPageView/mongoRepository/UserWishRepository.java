package com.detail.DetailPageView.mongoRepository;

import com.detail.DetailPageView.domain.UserWish;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserWishRepository extends MongoRepository<UserWish, String> {

    //    UserWishView findBySubsrAndContentId(String contentId, String subsr);
    List<UserWish> findAllBySubsr(String subsr);

    UserWish findByUniqueId(String uniqueId);
}
