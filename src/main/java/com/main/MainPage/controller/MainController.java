package com.main.MainPage.controller;

import com.main.MainPage.dto.Recommendation.client.MainResponseDto;
import com.main.MainPage.dto.UserDto;
import com.main.MainPage.dto.WeatherRecDto;
import com.main.MainPage.service.mainPage.getReco.VodGetRecoServiceImpl;
import com.main.MainPage.service.mainPage.viewWeatherRec.WeatherRecViewServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/main")
public class MainController {
    private final VodGetRecoServiceImpl vodGetRecoService;
    private final WeatherRecViewServiceImpl weatherRecViewService;


    @PostMapping("")
    public MainResponseDto getAllRecoFromModel(@RequestBody UserDto userDto) {
        return vodGetRecoService.getAllContentIdsFromModel(userDto.getSubsr());
    }



    //날씨 기반 추천
    @GetMapping("/weather")
    public WeatherRecDto sendWeatherRecs() {
        return weatherRecViewService.sendWeatherRecommendations();
    }
}


