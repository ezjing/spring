package com.bitc.springboard_ljw.service;

import com.bitc.springboard_ljw.dto.LoginDto;
import com.bitc.springboard_ljw.mapper.LoginMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private LoginMapper loginMapper;

    @Override
    public int loginCheck(String userId, String userPw) throws Exception {
        return loginMapper.loginCheck(userId, userPw);
    }

    @Override
    public LoginDto getUser(String userId, String userPw) throws Exception {
        return loginMapper.getUser(userId, userPw);
    }

    @Override
    public void joinUser(LoginDto login) throws Exception {
        loginMapper.joinUser(login);
    }
}
