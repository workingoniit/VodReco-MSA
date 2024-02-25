package com.main.MainPage.util.forRecommendation;


import com.main.MainPage.domain.Rec.DescriptionResult;
import com.main.MainPage.dto.Recommendation.DescriptionResultDto;
import com.main.MainPage.util.StringToListWrapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DescResultToDescResultDtoWrapper {
    private final StringToListWrapper stringToListWrapper;

    public DescriptionResultDto toDescResultDto(DescriptionResult descriptionResult) {
        return this.descResultToDescResultDto(descriptionResult);
    }

    private DescriptionResultDto descResultToDescResultDto(DescriptionResult descriptionResult) {
        return DescriptionResultDto.builder()
                .subsr(descriptionResult.getSubsr())
                .contentId(stringToListWrapper.stringToList(descriptionResult.getContentId()))
                .build();
    }
}
