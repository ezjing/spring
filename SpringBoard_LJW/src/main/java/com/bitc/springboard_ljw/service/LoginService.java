package com.bitc.springboard_ljw.service;

import com.bitc.springboard_ljw.dto.LoginDto;

public interface LoginService {
    int loginCheck(String userId, String userPw) throws Exception;

    LoginDto getUser(String userId, String userPw) throws Exception;

    void joinUser(LoginDto login) throws Exception;
}
