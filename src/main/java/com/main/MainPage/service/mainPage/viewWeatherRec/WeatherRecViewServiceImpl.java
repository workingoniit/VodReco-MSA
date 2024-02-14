package com.main.MainPage.service.mainPage.viewWeatherRec;

import com.main.MainPage.domain.Rec.WeatherRec;
import com.main.MainPage.dto.BasicInfoOfVodDto;
import com.main.MainPage.dto.WeatherRecDto;
import com.main.MainPage.mongoRepository.VodRepository;
import com.main.MainPage.mongoRepository.WeatherRecRepository;
import com.main.MainPage.util.ContentIdToBasicInfoOfVodsWrapper;
import com.main.MainPage.util.VodtoVodDtoWrapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class WeatherRecViewServiceImpl implements WeatherRecViewService{
    private final WeatherRecRepository weatherRecRepository;
    private final ContentIdToBasicInfoOfVodsWrapper contentIdToBasicInfoOfVodsWrapper;
    private final VodtoVodDtoWrapper vodtoVodDtoWrapper;
    private final VodRepository vodRepository;

    @Override
    public WeatherRecDto sendWeatherRecommendations() {
        WeatherRec weatherRec = weatherRecRepository.findAll().get(0);
        List<String> contentIdList = weatherRec.getContentIdList();
        List<BasicInfoOfVodDto> list = new ArrayList();
        List<BasicInfoOfVodDto> basicInfoOfVodDtos = contentIdToBasicInfoOfVodsWrapper.getBasicInfoOfVodDtos(list, contentIdList, vodtoVodDtoWrapper, vodRepository);
        return WeatherRecDto.builder()
                .weather(weatherRec.getWeather()).vodsList(basicInfoOfVodDtos).weatherImg(weatherRec.getWeatherImg())
                .build();
    }

}
