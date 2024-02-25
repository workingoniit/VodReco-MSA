package com.detail.UserActivityCUD.controller;


import com.detail.UserActivityCUD.dto.UpdateMyRatingRequestDto;
import com.detail.UserActivityCUD.dto.UpdateMyWishRequestDto;
import com.detail.UserActivityCUD.service.insertMyRating.UserRatingInsertMyRatingServiceImpl;
import com.detail.UserActivityCUD.service.deleteMyRating.UserRatingDeleteMyRatingServiceImpl;
import com.detail.UserActivityCUD.service.updateMyRating.UserRatingUpdateMyRatingServiceImpl;
import com.detail.UserActivityCUD.service.updateMyWish.UserWishUpdateMyWishServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;


//vod별 상세페이지

@RestController
@RequestMapping("/detail")
@Transactional
@RequiredArgsConstructor
public class VodDetailController {
    private final UserWishUpdateMyWishServiceImpl userWishUpdateMyWishService;
    private final UserRatingUpdateMyRatingServiceImpl userRatingUpdateMyRatingService;
    private final UserRatingDeleteMyRatingServiceImpl userRatingDeleteMyRatingService;
    private final UserRatingInsertMyRatingServiceImpl userRatingInsertMyRatingService;



//    상세페이지에서 찜 or 평점 변경

    //  wish insert(0or1)
    @PostMapping(value = "/{content_id}/wish")
//    public void saveMyFirstWish(@PathVariable("content_id")
//                                    @Schema(description = "content_id", example = "22222")
    public ResponseEntity<Void> saveMyFirstWish(@PathVariable("content_id")
                                                    String contentId,
                                                    @RequestBody UpdateMyWishRequestDto updateMyWishRequestDto) {
        try {
        userWishUpdateMyWishService.saveWish(updateMyWishRequestDto, contentId);
        return ResponseEntity.ok().build();
        } catch (Exception e) {
//            에러 코드 500
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // rating 최초 insert
    @PostMapping(value = "/{content_id}/rating")
    public ResponseEntity<String> saveMyFirstRating(@PathVariable("content_id")
                                                        String contentId, @RequestBody UpdateMyRatingRequestDto updateMyRatingRequestDto) {
        if (updateMyRatingRequestDto.getRating() == 0 || updateMyRatingRequestDto.getReview().isEmpty()) {
            return ResponseEntity.badRequest().body("Rating cannot be 0 and Review cannot be null.");
        } else {
            userRatingInsertMyRatingService.insertRating(contentId, updateMyRatingRequestDto);
            return ResponseEntity.ok().build();
        }
    }

    //rating 변경
    @PutMapping(value = "/{content_id}/rating")
    public ResponseEntity<Void> updateMyRating(@PathVariable("content_id")
                                                   String contentId,
                                               @RequestBody UpdateMyRatingRequestDto updateMyRatingRequestDto) {
        if (updateMyRatingRequestDto.getRating() == 0 || updateMyRatingRequestDto.getReview().isEmpty()) {
            return ResponseEntity.badRequest().build();
        } else {
            // 유효한 경우에만 변경 로직을 수행하도록 처리
            userRatingUpdateMyRatingService.updateRating(contentId, updateMyRatingRequestDto);
            return ResponseEntity.ok().build();
        }
    }

    //rating 삭제
//    @Transactional
    @DeleteMapping(value = "/{content_id}/rating")

    public ResponseEntity<Void> deleteMyRating(@PathVariable("content_id")
                                                   String contentId, @RequestBody UpdateMyRatingRequestDto updateMyRatingRequestDto) {
        System.out.println("삭제된 rating 정보 = " + contentId);
        try {
        userRatingDeleteMyRatingService.deleteRating(contentId, updateMyRatingRequestDto.getSubsr());
        return ResponseEntity.ok().build();
        } catch (Exception e) {
//            에러코드 500
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


}




