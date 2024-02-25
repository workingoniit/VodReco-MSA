package com.my.Mypage.service.mypage.viewMyWishList;

import com.my.Mypage.dto.mypage.ViewMyWishListDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserWishListViewService {
    Optional<List<ViewMyWishListDto>> findMyWishList(String subsr);
}
