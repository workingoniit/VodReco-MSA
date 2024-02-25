package com.my.Mypage.mongoRepository;

import com.my.Mypage.domain.UserWatchTotal;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserWatchTotalRepository extends MongoRepository<UserWatchTotal, Object> {

    List<UserWatchTotal> findBySubsr(String subsr);

}
