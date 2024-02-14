package com.main.MainPage.util.forRecommendation;

import com.main.MainPage.domain.Rec.MoodResult;
import com.main.MainPage.dto.Recommendation.MoodResultDto;
import com.main.MainPage.util.StringToListWrapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MoodResultToMoodResultDtoWrapper {
    private final StringToListWrapper stringToListWrapper;

    public MoodResultDto toMoodResultDto(MoodResult moodResult) {
        return this.moodResultToMoodResultDto(moodResult);
    }

    private MoodResultDto moodResultToMoodResultDto(MoodResult moodResult) {
        return MoodResultDto.builder()
                .subsr(moodResult.getSubsr())
                .contentId(stringToListWrapper.stringToList(moodResult.getContentId()))
                .build();
    }
}
