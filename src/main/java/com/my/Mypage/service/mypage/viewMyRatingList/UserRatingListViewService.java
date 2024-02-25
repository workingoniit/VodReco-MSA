package com.my.Mypage.service.mypage.viewMyRatingList;

import com.my.Mypage.dto.mypage.ViewMyRatingListDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserRatingListViewService {
    Optional<List<ViewMyRatingListDto>> findMyRatingList(String subsr);
}
