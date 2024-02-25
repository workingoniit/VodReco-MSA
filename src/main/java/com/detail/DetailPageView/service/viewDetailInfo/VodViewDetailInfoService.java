package com.detail.DetailPageView.service.viewDetailInfo;

import com.detail.DetailPageView.dto.vodDetail.VodDetailResponseDto;
import org.springframework.stereotype.Service;

@Service
public interface VodViewDetailInfoService {
    VodDetailResponseDto getVodByContentId(String contentId);
}
