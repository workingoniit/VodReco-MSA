package com.main.MainPage.mongoRepository;


import com.main.MainPage.domain.Rec.DescriptionResult;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DescriptionResultRepository extends MongoRepository<DescriptionResult, String> {
    DescriptionResult findBySubsr(String subsr);
    //파라미터 없이 findAll하면 repository에서 정의한 pk가 리스트로 뽑힘(231218)
}
