package com.main.MainPage.util;

import com.main.MainPage.domain.Vod;
import com.main.MainPage.dto.VodDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@RequiredArgsConstructor
public class VodtoVodDtoWrapper {
    private final StringToListWrapper stringToListWrapper;

    public VodDto toVodDto(Vod vod){
        return VodtoVodDto(vod);
    }
    private VodDto VodtoVodDto(Vod vod) {
        if (vod.getUniqueTemplates() == null) {
            return VodDto.builder()
                    .contentId(vod.getContentId())
                    .title(vod.getTitle())
                    .category(vod.getCategory())
                    .genre(vod.getGenre())
                    .disp_rtm(vod.getDisp_rtm())

                    .description(vod.getDescription())
                    .actors(vod.getActors())
                    .posterurl(vod.getPosterurl())
                    .grade(vod.getGrade())
                    .country(vod.getCountry())

                    .release_year(vod.getRelease_year())
                    .director(vod.getDirector())
                    .uniqueTemplates(new ArrayList<>())

                    .build();
        }
        return VodDto.builder()
                .contentId(vod.getContentId())
                .title(vod.getTitle())
                .category(vod.getCategory())
                .genre(vod.getGenre())
                .disp_rtm(vod.getDisp_rtm())

                .description(vod.getDescription())
                .actors(vod.getActors())
                .posterurl(vod.getPosterurl())
                .grade(vod.getGrade())
                .country(vod.getCountry())

                .release_year(vod.getRelease_year())
                .director(vod.getDirector())
                .uniqueTemplates(stringToListWrapper.stringToList(vod.getUniqueTemplates()))

                .build();
    }
}
