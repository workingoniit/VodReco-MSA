package com.detail.UserActivityCUD.mongoRepository;


import com.detail.UserActivityCUD.dto.Vod;
import org.springframework.data.mongodb.repository.MongoRepository;


//@Repository jpa가 아니라면 안 써도 됨
public interface VodRepository extends MongoRepository<Vod,String> {
    Vod findByContentId(String contentId);

}