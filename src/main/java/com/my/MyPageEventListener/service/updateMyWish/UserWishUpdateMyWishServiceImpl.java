package com.my.MyPageEventListener.service.updateMyWish;

import com.my.MyPageEventListener.dto.UpdateMyWishDto;
import com.my.MyPageEventListener.mongoRepository.UserWishRepository;
import com.my.MyPageEventListener.util.FromUpdateMyWishDtoToUserWishWrapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class UserWishUpdateMyWishServiceImpl implements UserWishUpdateMyWishService{
    private final UserWishRepository userWishRepository;
    private final FromUpdateMyWishDtoToUserWishWrapper toUserWishWrapper;
    @Override
    @Transactional
    public void saveWish(List<String> messageListExceptClassifier) {
        String uniqueId = messageListExceptClassifier.get(0);
        String subsr = messageListExceptClassifier.get(1);
        String contentId = messageListExceptClassifier.get(2);
        Integer wish = Integer.parseInt(messageListExceptClassifier.get(3));
        String title = messageListExceptClassifier.get(4);
        String posterurl = messageListExceptClassifier.get(5);

        UpdateMyWishDto updateMyWishDto = UpdateMyWishDto.builder().uniqueId(uniqueId).subsr(subsr)
                .contentId(contentId).wish(wish).title(title).
                posterurl(posterurl).build();
        userWishRepository.save(toUserWishWrapper.toUserWish(updateMyWishDto));
    }
}
