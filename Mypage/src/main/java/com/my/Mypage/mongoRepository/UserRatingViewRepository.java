package com.my.Mypage.mongoRepository;

import com.my.Mypage.domain.UserRatingView;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserRatingViewRepository extends MongoRepository<UserRatingView, String> {

    List<UserRatingView> findAllByContentId(String contentId);
    void deleteByUniqueId(String uniqueId);
    List<UserRatingView> findAllBySubsr(String contentId);

    UserRatingView findByUniqueId(String uniqueId);
}
