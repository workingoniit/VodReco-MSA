package com.detail.DetailPageView.service.viewDetailInfo;

import com.detail.DetailPageView.dto.VodDto;
import com.detail.DetailPageView.dto.vodDetail.VodDetailResponseDto;
import com.detail.DetailPageView.mongoRepository.VodRepository;
import com.detail.DetailPageView.util.VodtoVodDtoWrapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class VodViewDetailInfoServiceImpl implements VodViewDetailInfoService {
    private final VodRepository vodRepository;
    private final VodtoVodDtoWrapper vodtoVodDtoWrapper;



    // content_id로 Vod 조회
    @Override
    public VodDetailResponseDto getVodByContentId(String contentId) {
//        String d;
        //findByContentId 조회 불가능한 에러: @Id 제거하니 해결(231124)
        VodDto vodDto = vodtoVodDtoWrapper.toVodDto(vodRepository.findByContentId(contentId));
//        if (vodDto.getIsSeries() == 1) {
//            d = vodDto.getTitleDescription();
//        } else {
//            d = vodDto.getDescription();
//        }
        return VodDetailResponseDto.builder()

                .title(vodDto.getTitle())
                .contentId(vodDto.getContentId())
                .category(vodDto.getCategory())
                .genre(vodDto.getGenre())
                .country(vodDto.getCountry())

                .actors(vodDto.getActors())
                .director(vodDto.getDirector())
                .posterurl(vodDto.getPosterurl())
                .description(vodDto.getDescription())
                .release_year(vodDto.getRelease_year())

                .disp_rtm(vodDto.getDisp_rtm())
                .grade(vodDto.getGrade())
                .tags(vodDto.getUniqueTemplates())

                .build();

    }
}
