package com.main.MainPage.service.mainPage.getReco;

import com.main.MainPage.dto.Recommendation.client.MainResponseDto;
import org.springframework.stereotype.Service;

@Service
public interface VodGetRecoService {

    MainResponseDto getAllContentIdsFromModel(String subsr);

}
