package com.main.MainPage.mongoRepository;

import com.main.MainPage.domain.Rec.PopularVod;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PopularVodRepository extends MongoRepository<PopularVod, Long> {
    List<PopularVod> findTop10ByTimeGroupOrderByCountDesc(String timeGroup);
}
