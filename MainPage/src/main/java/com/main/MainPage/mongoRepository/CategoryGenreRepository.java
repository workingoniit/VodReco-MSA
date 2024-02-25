package com.main.MainPage.mongoRepository;

import com.main.MainPage.domain.CategoryGenre;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CategoryGenreRepository extends MongoRepository<CategoryGenre, String> {
    CategoryGenre findByMaster(String master);
}
