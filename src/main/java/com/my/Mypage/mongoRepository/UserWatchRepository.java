package com.my.Mypage.mongoRepository;

import com.my.Mypage.domain.UserWatch;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserWatchRepository extends MongoRepository<UserWatch, String> {
    List<UserWatch> findBySubsr(String subsr);

    List<UserWatch> findAllBySubsr(String subsr);

    List<UserWatch> findBySubsrOrderByUserPreferenceDesc(String subsr);
}
