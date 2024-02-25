package com.detail.DetailPageView.service.viewVodsByTag;

import com.detail.DetailPageView.dto.vodDetail.TagsResponseDto;
import org.springframework.stereotype.Service;

@Service

public interface VodviewVodsByTagService {

    TagsResponseDto sendEachTagVods(String contentId);
}
