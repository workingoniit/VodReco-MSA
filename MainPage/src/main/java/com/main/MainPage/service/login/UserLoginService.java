package com.main.MainPage.service.login;

import com.main.MainPage.dto.LoginDto;
import org.springframework.stereotype.Service;

@Service
public interface UserLoginService {
    String ValidateUser(LoginDto loginDto);
}
