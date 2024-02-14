package com.main.MainPage.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class WeatherRecDto {
    private String weather;
    private List<BasicInfoOfVodDto> vodsList;
    private String weatherImg;

    @Builder
    public WeatherRecDto(String weather, List<BasicInfoOfVodDto> vodsList, String weatherImg) {
        this.weather = weather;
        this.vodsList = vodsList;
        this.weatherImg = weatherImg;
    }

}