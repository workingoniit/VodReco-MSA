package com.main.MainPage.service.category.viewMovieCategories;

import com.main.MainPage.domain.CategoryGenre;
import com.main.MainPage.mongoRepository.CategoryGenreRepository;
import com.main.MainPage.util.StringToListWrapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryGenreViewMovieServiceImpl implements CategoryGenreViewMovieService {
    private final CategoryGenreRepository categoryGenreRepository;
    private final StringToListWrapper stringToListWrapper;

    @Override
    public List<String> viewMovieGenresList(){
        CategoryGenre movieGenre = categoryGenreRepository.findByMaster("영화");
        return stringToListWrapper.stringToList(movieGenre.getSlave());
    }
}
