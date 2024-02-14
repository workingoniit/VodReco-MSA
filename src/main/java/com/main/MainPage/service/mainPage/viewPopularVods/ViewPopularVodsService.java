package com.main.MainPage.service.mainPage.viewPopularVods;

import com.main.MainPage.dto.ViewPopularVodsDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ViewPopularVodsService {
    List<ViewPopularVodsDto> getTop10PopularVods();
}
