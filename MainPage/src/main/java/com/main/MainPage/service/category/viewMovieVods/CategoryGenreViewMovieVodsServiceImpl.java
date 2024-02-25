package com.main.MainPage.service.category.viewMovieVods;

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
public class CategoryGenreViewMovieVodsServiceImpl implements CategoryGenreViewMovieVodsService{
    private final VodRepository vodRepository;
    private final VodtoVodDtoWrapper vodtoVodDtoWrapper;
    private final ContentIdToBasicInfoOfVodsWrapper contentIdToBasicInfoOfVodsWrapper;

    @Override
    public List<BasicInfoOfVodDto> getMovieVodsInfo(String genre2) {
//        String decodedGenre = URLDecoder.decode(genre2, "ascii");
        String replacedGenre = genre2.replaceAll(":", "/");
        List<Vod> list = vodRepository.findByCategoryAndGenre("영화", replacedGenre);
        List<String> contentIds = new ArrayList<>();
        List<BasicInfoOfVodDto> basicInfoOfVodDtoList = new ArrayList<>();
        for (Vod v : list) {
            contentIds.add(v.getContentId());
        }
        return contentIdToBasicInfoOfVodsWrapper.getBasicInfoOfVodDtos(basicInfoOfVodDtoList, contentIds, vodtoVodDtoWrapper, vodRepository);
    }
}
