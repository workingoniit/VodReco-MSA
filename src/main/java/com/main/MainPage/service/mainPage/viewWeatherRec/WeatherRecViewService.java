package com.main.MainPage.service.mainPage.viewWeatherRec;

import com.main.MainPage.dto.WeatherRecDto;
import org.springframework.stereotype.Service;

@Service
public interface WeatherRecViewService {
    WeatherRecDto sendWeatherRecommendations();
}
