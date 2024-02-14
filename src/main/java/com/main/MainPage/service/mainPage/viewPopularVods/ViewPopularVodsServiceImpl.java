package com.main.MainPage.service.mainPage.viewPopularVods;

import com.main.MainPage.domain.Rec.PopularVod;
import com.main.MainPage.dto.ViewPopularVodsDto;
import com.main.MainPage.mongoRepository.PopularVodRepository;
import com.main.MainPage.util.TimeUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ViewPopularVodsServiceImpl implements ViewPopularVodsService {

    private final PopularVodRepository popularVodRepository;
    private final TimeUtil timeUtil;

    public List<ViewPopularVodsDto> getTop10PopularVods() {
        // 시간대에 따른 VOD 가져오기
        LocalDateTime now = LocalDateTime.now();
        String timeGroup = timeUtil.getTimeGroup(now);

        // 시간대에 맞는 상위 10개 VOD 조회
        List<PopularVod> popularVods = popularVodRepository.findTop10ByTimeGroupOrderByCountDesc(timeGroup);

        // PopularVod 객체를 BasicInfoOfVodDto로 변환하여 필요한 정보만 추출
        return popularVods.stream()
                .map(popularVod -> mapToDto(popularVod, timeGroup)) // timeGroup을 매핑하는 부분으로 변경
                .collect(Collectors.toList());
    }

    private ViewPopularVodsDto mapToDto(PopularVod popularVod, String timeGroup) {
        return ViewPopularVodsDto.builder()
                .contentId(popularVod.getContentId())
                .title(popularVod.getTitle())
                .posterurl(popularVod.getPosterurl())
                .timeGroup(timeGroup) // 시간대 정보 설정
                .build();
    }
}


