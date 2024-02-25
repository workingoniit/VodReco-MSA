package com.detail.DetailPageView.controller;


import com.detail.DetailPageView.dto.UserDto;
import com.detail.DetailPageView.dto.rating.ViewEveryRatingResponseDto;
import com.detail.DetailPageView.dto.vodDetail.VodDetailResponseDto;
import com.detail.DetailPageView.dto.wish.ViewMyWishResponseDto;
import com.detail.DetailPageView.service.viewDetailInfo.VodViewDetailInfoServiceImpl;
import com.detail.DetailPageView.service.viewEveryRating.UserRatingViewEveryRatingServiceImpl;
import com.detail.DetailPageView.service.viewMyWish.UserWishViewMyWishServiceImpl;
import com.detail.DetailPageView.service.viewVodsByTag.VodviewVodsByTagServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;


//vod별 상세페이지

@RestController // = @Controller + @ResponseBody 객체 리턴하면 json으로 만들어주는 역할
@RequestMapping("/detail")
@Transactional
@RequiredArgsConstructor
public class VodDetailController {
    private final VodViewDetailInfoServiceImpl vodViewDetailInfoService;
    private final UserWishViewMyWishServiceImpl userWishViewMyWishService;
    private final UserRatingViewEveryRatingServiceImpl userRatingViewEveryRatingService;
    private final VodviewVodsByTagServiceImpl vodviewVodsByTagService;
    //상세페이지 열릴 때
    //[에러코드 관련] - 상세페이지 열때 모든 정보는 DB에서 꺼내오기 때문에 오류발생확률 낮음 -> GlobalExceptionHandler에서 처리
    // 조회 결과 없는 경우에는 null(200) 전송

    //1. 기본정보
    @GetMapping(value = "/{content_id}")
    public ResponseEntity<VodDetailResponseDto> getVodDetail(@PathVariable("content_id")
                                                                 String contentId) {//변하는 값을 얻을 때는 @PathVariable 써야함
        VodDetailResponseDto vodDetailResponseDto = vodViewDetailInfoService.getVodByContentId(contentId);
        return ResponseEntity.ok(vodDetailResponseDto);
//        } else {
//            //에러 코드 404
//            return ResponseEntity.notFound().build();
//        }
    }


    //2. 기존 wish 조회
    //별도의 requestDto 만들지 않고 동일하게 subsr 필드 하나만 있는 UserDto 사용함(231119)
    @PostMapping(value = "/{content_id}/mywish")
    public ResponseEntity<Integer> findMyWish(@PathVariable("content_id")
                                                  String contentId,
                                              @RequestBody UserDto userDto) {
        ViewMyWishResponseDto viewMyWishResponseDto = userWishViewMyWishService.findMyWish(userDto.getSubsr(), contentId);
        //[jjae] - 변경코드
        if (viewMyWishResponseDto == null) {
            //[세연] 에러 코드 404
            //return ResponseEntity.notFound().build();
            return ResponseEntity.ok().body(null);
        }
        return ResponseEntity.ok(viewMyWishResponseDto.getWish());
    }

    //3. content_id에 해당하는 Vod에 대한 모든 사용자의 rating + review 조회

    @GetMapping(value = "/{content_id}/rating")
    public ResponseEntity<List<ViewEveryRatingResponseDto>> findEveryRating(@PathVariable("content_id") String contentId) {
        //return Optional.ofNullable(userRatingViewEveryRatingService.findEveryUserRating(contentId));
        List<ViewEveryRatingResponseDto> ratings = userRatingViewEveryRatingService.findEveryUserRating(contentId);
        //[jjae] - 변경코드
        if (ratings.isEmpty()) {
            //[세연] 조회 결과 없으면 204(231128), wish조회 API와 status 통일 요망
            return ResponseEntity.ok().body(null);
        }
        return ResponseEntity.ok(ratings);
    }

    }




