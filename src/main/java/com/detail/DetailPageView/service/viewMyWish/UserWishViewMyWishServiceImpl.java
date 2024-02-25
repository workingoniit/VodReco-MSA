package com.detail.DetailPageView.service.viewMyWish;

import com.detail.DetailPageView.domain.UserWish;
import com.detail.DetailPageView.dto.wish.ViewMyWishResponseDto;
import com.detail.DetailPageView.mongoRepository.UserWishRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserWishViewMyWishServiceImpl implements UserWishViewMyWishService {

    private final UserWishRepository userWishViewRepository;

    @Override
    public ViewMyWishResponseDto findMyWish(String subsr, String contentId){
        String uniqueId = subsr + contentId;
        Optional<UserWish> byUniqueId = Optional.ofNullable(userWishViewRepository.findByUniqueId(uniqueId));

        if (byUniqueId.isEmpty() || byUniqueId.get().getWish() == 0) {
            return null;
        }
        // TODO : 변환 메서드 별도 클래스로 분리 요망
        return byUniqueId.get().toViewMyWishResponseDto(byUniqueId.get());
    }
}
