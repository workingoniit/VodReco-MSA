package com.detail.UserActivityCUD.controller;


import com.detail.UserActivityCUD.dto.UpdateMyRatingRequestDto;
import com.detail.UserActivityCUD.dto.UpdateMyWishRequestDto;
import com.detail.UserActivityCUD.service.deleteMyRating.UserRatingDeleteMyRatingServiceImpl;
import com.detail.UserActivityCUD.service.updateMyRating.UserRatingUpdateMyRatingServiceImpl;
import com.detail.UserActivityCUD.service.updateMyWish.UserWishUpdateMyWishServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;


//vod별 상세페이지

@RestController
@RequestMapping("/detail")
@Transactional
@RequiredArgsConstructor
public class VodDetailController {
    private final UserWishUpdateMyWishServiceImpl userWishUpdateMyWishService;
    private final UserRatingUpdateMyRatingServiceImpl userRatingUpdateMyRatingService;
    private final UserRatingDeleteMyRatingServiceImpl userRatingDeleteMyRatingService;



//    상세페이지에서 찜 or 평점 변경

    //  wish insert(0or1)
    @PostMapping(value = "/{content_id}/wish")
//    public void saveMyFirstWish(@PathVariable("content_id")
//                                    @Schema(description = "content_id", example = "22222")
    public ResponseEntity<Void> saveMyFirstWish(@PathVariable("content_id")
                                                    String contentId,
                                                    @RequestBody UpdateMyWishRequestDto updateMyWishRequestDto) {
        //[jjae] - 변경코드
        //[jjae]- [ 발생가능한 에러 ]
        //유효성 검사 오류: 클라이언트가 잘못된 데이터를 보낸 경우 (예: 필수 필드 누락, 잘못된 형식 등)
        //데이터베이스 오류: 데이터 저장 시 데이터베이스 연결이 실패하는 경우, 저장 실패 등
        try {
        userWishUpdateMyWishService.saveWish(updateMyWishRequestDto, contentId);
        return ResponseEntity.ok().build();
        } catch (Exception e) {
//            에러 코드 500
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

        //처리 오류: 어떤 이유로 인해 찜을 저장하는 로직이 실패하는 경우
    }

    // rating 최초 insert
    @PostMapping(value = "/{content_id}/rating")
    public ResponseEntity<String> saveMyFirstRating(@PathVariable("content_id")
                                                        String contentId, @RequestBody UpdateMyRatingRequestDto updateMyRatingRequestDto) {
        if (updateMyRatingRequestDto.getRating() == 0 || updateMyRatingRequestDto.getReview().isEmpty()) {
            return ResponseEntity.badRequest().body("Rating cannot be 0 and Review cannot be null.");
        } else {
            userRatingUpdateMyRatingService.saveRating(contentId, updateMyRatingRequestDto);
            return ResponseEntity.ok().build();
        }
        // [jjae] - 발생할 수 있는 에러
        //입력 유효성 검사 오류: 클라이언트가 잘못된 데이터를 전송하는 경우
        //데이터베이스 저장 오류: 데이터 저장 시 데이터베이스에서 오류가 발생하는 경우
        //인증 및 권한 오류: 사용자가 권한이 없는 작업을 수행하려고 시도하는 경우 --> 권한이 없을일은,, 로그인하지 않은 사용자인데 이건 불가능한 에러

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
            userRatingUpdateMyRatingService.saveRating(contentId, updateMyRatingRequestDto);
            return ResponseEntity.ok().build();
        }
    }

    //rating 삭제
//    @Transactional
    @DeleteMapping(value = "/{content_id}/rating")

    public ResponseEntity<Void> deleteMyRating(@PathVariable("content_id")
                                                   String contentId, @RequestBody UpdateMyRatingRequestDto updateMyRatingRequestDto) {
        System.out.println("삭제된 rating 정보 = " + contentId);
        //[jjae] - 변경코드
        try {
        userRatingDeleteMyRatingService.deleteRating(contentId, updateMyRatingRequestDto.getSubsr());
        return ResponseEntity.ok().build();
        } catch (Exception e) {
//            에러코드 500
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


}




