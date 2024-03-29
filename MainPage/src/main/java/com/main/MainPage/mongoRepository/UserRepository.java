package com.main.MainPage.mongoRepository;


import com.main.MainPage.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

//mongoRepository 패키지에 넣어놓고 JpaRepository를 extend하고 있었음(231123)

//@Repository
public interface UserRepository extends MongoRepository<User, String> {
    List<User> findBySubsr(String subsr);
}
