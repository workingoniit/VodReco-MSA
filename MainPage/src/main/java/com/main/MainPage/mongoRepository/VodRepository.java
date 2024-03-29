package com.main.MainPage.mongoRepository;


import com.main.MainPage.domain.Vod;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

//@Repository jpa가 아니라면 안 써도 됨
public interface VodRepository extends MongoRepository<Vod,String> {
    //    Vod findByContentId(String contentId);
    Vod findByContentId(String contentId);
    List<Vod> findAllByGenre(String genre);

    List<Vod> findByUniqueTemplatesContaining(String tags);

    List<Vod> findByCategory(String category);


    //검색기능
    //@Query("{'$or':[ {'title': { $regex: ?0, $options: 'i' }}, {'actors': { $regex: ?0, $options: 'i' }} ]}")
    //List<Vod> findByTitleIgnoreCaseContainingOrActorsIgnoreCaseContaining(Pattern title, Pattern actors);

    //@Query("{$or:[ {'actors': ?0} ]}")
    List<Vod> findByActorsIgnoreCaseContaining(String actor);
    //@Query("{$or:[ {'title': ?0} ]}")
    List<Vod> findByTitleContainingIgnoreCase(String title);

    List<Vod> findByCategoryAndGenre(String category, String genre);


}