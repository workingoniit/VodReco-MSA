package com.main.MainPage.controller;

import com.main.MainPage.dto.BasicInfoOfVodDto;
import com.main.MainPage.service.category.viewKidsEtcCategories.CategoryGenreViewKidsEtcServiceImpl;
import com.main.MainPage.service.category.viewKidsEtcVods.CategoryGenreViewKidsEtcVodsServiceImpl;
import com.main.MainPage.service.category.viewMovieCategories.CategoryGenreViewMovieServiceImpl;
import com.main.MainPage.service.category.viewMovieVods.CategoryGenreViewMovieVodsServiceImpl;
import com.main.MainPage.service.category.viewTVCategories.CategoryGenreViewTVServiceImpl;
import com.main.MainPage.service.category.viewTVVods.CategoryGenreViewTVVodsServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CategoryGenreController {
    private final CategoryGenreViewTVServiceImpl categoryGenreViewTVService;
    private final CategoryGenreViewKidsEtcServiceImpl categoryGenreViewKidsEtcService;
    private final CategoryGenreViewMovieServiceImpl categoryGenreViewMovieService;
    private final CategoryGenreViewTVVodsServiceImpl categoryGenreViewTVVodsService;
    private final CategoryGenreViewMovieVodsServiceImpl categoryGenreViewMovieVodsService;
    private final CategoryGenreViewKidsEtcVodsServiceImpl categoryGenreViewKidsEtcVodsService;


    @GetMapping("/tv")
    public List<String> sendTvCategories() {
        return categoryGenreViewTVService.viewTVCategoriesList();
    }

    @GetMapping("/movie")
    public List<String> sendMovieGenres() {
        return categoryGenreViewMovieService.viewMovieGenresList();
    }

    @GetMapping("/kids")
    public List<String> sendKidsEtcCategories() {
        return categoryGenreViewKidsEtcService.viewKidsEtcCategoriesList();
    }

    @GetMapping("/tv/{genre1}")
    public List<BasicInfoOfVodDto> sendTVVodInfos(@PathVariable String genre1) {
        return categoryGenreViewTVVodsService.getTVVodsInfo(genre1);
    }

    @GetMapping("/movie/{genre2}")
    public List<BasicInfoOfVodDto> sendMovieVodInfos(@PathVariable String genre2) {
        return categoryGenreViewMovieVodsService.getMovieVodsInfo(genre2);
    }

    @GetMapping("/kids/{genre3}")
    public List<BasicInfoOfVodDto> sendKidsEtcVodInfos(@PathVariable String genre3) {
        return categoryGenreViewKidsEtcVodsService.getKidsEtcVodsInfo(genre3);
    }

}
