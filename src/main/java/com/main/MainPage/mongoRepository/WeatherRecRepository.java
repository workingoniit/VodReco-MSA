package com.main.MainPage.mongoRepository;

import com.main.MainPage.domain.Rec.WeatherRec;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface WeatherRecRepository extends MongoRepository<WeatherRec, String> {

    List<WeatherRec> findAll(); //findAll하면 PK만 나옴? (231218) TODO : 확인 필요
}
