package com.main.MainPage.service.mainPage.getReco;

import com.main.MainPage.domain.Rec.DescriptionResult;
import com.main.MainPage.domain.Rec.MoodResult;
import com.main.MainPage.domain.Rec.PersonalResult;
import com.main.MainPage.dto.Recommendation.client.MainResponseDto;
import com.main.MainPage.mongoRepository.DescriptionResultRepository;
import com.main.MainPage.mongoRepository.MoodResultRepository;
import com.main.MainPage.mongoRepository.PersonalResultRepository;
import com.main.MainPage.util.StringToListWrapper;
import com.main.MainPage.util.forRecommendation.SetDataToSendToClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class VodGetRecoServiceImpl implements VodGetRecoService {
    private final SetDataToSendToClient setDataToSendToClient;
    private final DescriptionResultRepository descriptionResultRepository;
    private final MoodResultRepository moodResultRepository;
    private final PersonalResultRepository personalResultRepository;
    private final StringToListWrapper stringToListWrapper;



    @Override
    public MainResponseDto getAllContentIdsFromModel(String subsr) {
        DescriptionResult allDescBySubsr = descriptionResultRepository.findBySubsr(subsr);
        MoodResult allMoodBySubsr = moodResultRepository.findBySubsr(subsr);
        PersonalResult allPersBySubsr = personalResultRepository.findBySubsr(subsr);

//        List<String> descIds = setDataToSendToClient.filterNullPosterurl(stringToListWrapper.stringToList(allDescBySubsr.getContentId()));
//        List<String> moodIds = setDataToSendToClient.filterNullPosterurl(stringToListWrapper.stringToList(allMoodBySubsr.getContentId()));
//        List<String> persIds = setDataToSendToClient.filterNullPosterurl(stringToListWrapper.stringToList(allPersBySubsr.getContentId()));

        return MainResponseDto.builder()
                .description_data(stringToListWrapper.stringToList(allDescBySubsr.getContentId()).stream().map(setDataToSendToClient :: buildToClient1stDto).toList())
                .genre_data(stringToListWrapper.stringToList(allMoodBySubsr.getContentId()).stream().map(setDataToSendToClient :: buildToClient1stDto).toList())
                .personal_data(stringToListWrapper.stringToList(allPersBySubsr.getContentId()).stream().map(setDataToSendToClient :: buildToClient1stDto).toList())
                .personal_words(personalResultRepository.findBySubsr(subsr).getPersonal_words())
                .genre_words(moodResultRepository.findBySubsr(subsr).getGenre_words())
                .build();


    }


}






