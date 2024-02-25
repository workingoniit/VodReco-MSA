package com.main.MainPage.service.category.viewTVVods;

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
public class CategoryGenreViewTVVodsServiceImpl implements CategoryGenreViewTVVodsService{
    private final VodRepository vodRepository;
    private final VodtoVodDtoWrapper vodtoVodDtoWrapper;
    private final ContentIdToBasicInfoOfVodsWrapper contentIdToBasicInfoOfVodsWrapper;

    @Override
    public List<BasicInfoOfVodDto> getTVVodsInfo(String genre1){
        //변수명은 genre1이지만 TV 시사/교양, TV애니메이션, .. 등이 들어옴(231212)
//        String decodedGenre = URLDecoder.decode(genre1, "ascii");
        String replacedGenre = genre1.replaceAll(":", "/");
        List<Vod> list = vodRepository.findByCategory(replacedGenre);
        List<String> contentIds = new ArrayList<>();
        List<BasicInfoOfVodDto> basicInfoOfVodDtoList = new ArrayList<>();
        for (Vod v : list) {
            contentIds.add(v.getContentId());
        }
        return contentIdToBasicInfoOfVodsWrapper.getBasicInfoOfVodDtos(basicInfoOfVodDtoList, contentIds, vodtoVodDtoWrapper, vodRepository);
    }
}
