package com.main.MainPage.mongoRepository;

import com.main.MainPage.domain.Rec.MoodResult;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MoodResultRepository extends MongoRepository<MoodResult, String> {
    MoodResult findBySubsr(String subsr);
}
