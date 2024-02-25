package com.main.MainPage.mongoRepository;

import com.main.MainPage.domain.Rec.PersonalResult;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PersonalResultRepository extends MongoRepository<PersonalResult, String> {
    PersonalResult findBySubsr(String subsr);


}
