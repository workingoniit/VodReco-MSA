package com.main.MainPage.util.forRecommendation;

import com.main.MainPage.domain.Rec.PersonalResult;
import com.main.MainPage.dto.Recommendation.PersonalResultDto;
import com.main.MainPage.util.StringToListWrapper;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class PersResultToPersResultDto {
    private final StringToListWrapper stringToListWrapper;

    public PersonalResultDto toPersResultDto(PersonalResult personalResult) {
        return this.personalResultToPersonalResultDto(personalResult);
    }

    private PersonalResultDto personalResultToPersonalResultDto(PersonalResult personalResult) {
        return PersonalResultDto.builder()
                .subsr(personalResult.getSubsr())
                .contentId(stringToListWrapper.stringToList(personalResult.getContentId()))
                .personal_words(personalResult.getPersonal_words())
                .build();
    }
}
