package com.detail.DetailPageView.mongoRepository;


import com.detail.DetailPageView.domain.Vod;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

//@Repository jpa가 아니라면 안 써도 됨
public interface VodRepository extends MongoRepository<Vod,String> {
    //    Vod findByContentId(String contentId);
    Vod findByContentId(String contentId);
    List<Vod> findAllByGenre(String genre);

    List<Vod> findByUniqueTemplatesContaining(String tags);
//    List<Vod> findByUniqueTemplatesContaining(String tag);
//    List<Vod> findBySeriesId(String seriesId);

    List<Vod> findByCategory(String category);


    //@Query("{$or:[ {'actors': ?0} ]}")
    List<Vod> findByActorsIgnoreCaseContaining(String actor);
    //@Query("{$or:[ {'title': ?0} ]}")
    List<Vod> findByTitleContainingIgnoreCase(String title);

    List<Vod> findByCategoryAndGenre(String category, String genre);

}