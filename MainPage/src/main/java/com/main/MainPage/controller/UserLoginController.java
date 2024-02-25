package com.main.MainPage.controller;

import com.main.MainPage.dto.LoginDto;
import com.main.MainPage.service.login.UserLoginServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserLoginController {
    private final UserLoginServiceImpl userLoginService;

    //셋탑아이디 로그인
    // [재아] 로그인 성공, 실패 나눠서 구현
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDto loginDto) {
        if (userLoginService.ValidateUser(loginDto).equals(loginDto.getSubsr())) {
            return ResponseEntity.ok().body(userLoginService.ValidateUser(loginDto));
        } else {
            //에러코드 401(UnAuthorized)
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
    }

}
