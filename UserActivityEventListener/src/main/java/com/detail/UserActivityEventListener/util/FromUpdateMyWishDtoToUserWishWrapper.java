package com.detail.UserActivityEventListener.util;

import com.detail.UserActivityEventListener.domain.UserWish;
import com.detail.UserActivityEventListener.dto.UpdateMyWishDto;
import org.springframework.stereotype.Component;

@Component
public class FromUpdateMyWishDtoToUserWishWrapper {
    public UserWish toUserWish(UpdateMyWishDto updateMyWishDto) {
        return this.updateMyWishToUserWish(updateMyWishDto);
    }
    private UserWish updateMyWishToUserWish(UpdateMyWishDto updateMyWishDto) {
        return UserWish.builder().subsr(updateMyWishDto.getSubsr()).uniqueId(updateMyWishDto.getUniqueId()).contentId(updateMyWishDto.getContentId())
                .title(updateMyWishDto.getTitle()).wish(updateMyWishDto.getWish()).posterurl(updateMyWishDto.getPosterurl())
                .build();

    }
}
