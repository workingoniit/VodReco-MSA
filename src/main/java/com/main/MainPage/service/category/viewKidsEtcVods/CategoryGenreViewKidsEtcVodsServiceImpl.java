package com.main.MainPage.service.category.viewKidsEtcVods;

import com.main.MainPage.domain.Vod;
import com.main.MainPage.dto.BasicInfoOfVodDto;
import com.main.MainPage.mongoRepository.VodRepository;
import com.main.MainPage.util.ContentIdToBasicInfoOfVodsWrapper;
import com.main.MainPage.util.VodtoVodDtoWrapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryGenreViewKidsEtcVodsServiceImpl implements CategoryGenreViewKidsEtcVodsService {
    private final VodRepository vodRepository;
    private final VodtoVodDtoWrapper vodtoVodDtoWrapper;
    private final ContentIdToBasicInfoOfVodsWrapper contentIdToBasicInfoOfVodsWrapper;

    @Override
    public List<BasicInfoOfVodDto> getKidsEtcVodsInfo(String genre3) {
        //변수명은 genre3이지만 실제로는 카테고리인 키즈, 미분류,  .. 등이 들어옴(231212)
//        String decodedGenre = URLDecoder.decode(genre3, "ascii");
        String replacedGenre = genre3.replaceAll(":", "/");
        if (replacedGenre == "기타") {
            List<Vod> list = vodRepository.findByCategory("미분류");
            List<String> contentIds = new ArrayList<>();
            List<BasicInfoOfVodDto> basicInfoOfVodDtoList = new ArrayList<>();
            for (Vod v : list) {
                contentIds.add(v.getContentId());
            }
            return contentIdToBasicInfoOfVodsWrapper.getBasicInfoOfVodDtos(basicInfoOfVodDtoList, contentIds, vodtoVodDtoWrapper, vodRepository);
        } else {
            List<Vod> list = vodRepository.findByCategory(replacedGenre);
            List<String> contentIds = new ArrayList<>();
            List<BasicInfoOfVodDto> basicInfoOfVodDtoList = new ArrayList<>();
            for (Vod v : list) {
                contentIds.add(v.getContentId());
            }
            return contentIdToBasicInfoOfVodsWrapper.getBasicInfoOfVodDtos(basicInfoOfVodDtoList, contentIds, vodtoVodDtoWrapper, vodRepository);
        }
    }
}
