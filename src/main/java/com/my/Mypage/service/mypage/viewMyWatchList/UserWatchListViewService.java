package com.my.Mypage.service.mypage.viewMyWatchList;

import com.my.Mypage.dto.mypage.ViewMyWatchListDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserWatchListViewService {
    Optional<List<ViewMyWatchListDto>> findMyWatchList(String subsr);

}
