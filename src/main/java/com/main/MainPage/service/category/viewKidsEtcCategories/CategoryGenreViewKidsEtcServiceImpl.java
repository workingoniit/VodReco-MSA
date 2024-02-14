package com.main.MainPage.service.category.viewKidsEtcCategories;

import com.main.MainPage.domain.CategoryGenre;
import com.main.MainPage.mongoRepository.CategoryGenreRepository;
import com.main.MainPage.util.StringToListWrapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryGenreViewKidsEtcServiceImpl implements CategoryGenreViewKidsEtcService{
    private final CategoryGenreRepository categoryGenreRepository;
    private final StringToListWrapper stringToListWrapper;

    @Override
    public List<String> viewKidsEtcCategoriesList(){
        CategoryGenre kidsEtc = categoryGenreRepository.findByMaster("키즈/기타");
        List<String> list = stringToListWrapper.stringToList(kidsEtc.getSlave());
        //"미분류" → "기타" 대체 (231212)
        Collections.replaceAll(list, "미분류", "기타");
        return list;
    }
}
