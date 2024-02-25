package com.main.MainPage.service.category.viewTVCategories;

import com.main.MainPage.domain.CategoryGenre;
import com.main.MainPage.mongoRepository.CategoryGenreRepository;
import com.main.MainPage.util.StringToListWrapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryGenreViewTVServiceImpl implements CategoryGenreViewTVService{
    private final CategoryGenreRepository categoryGenreRepository;
    private final StringToListWrapper stringToListWrapper;

    @Override
    public List<String> viewTVCategoriesList(){
        CategoryGenre tv = categoryGenreRepository.findByMaster("TV");
        return stringToListWrapper.stringToList(tv.getSlave());
    }
}
