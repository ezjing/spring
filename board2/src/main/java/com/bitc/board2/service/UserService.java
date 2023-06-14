package com.bitc.board2.service;

import com.bitc.board2.dto.UserDto;

public interface UserService {  // 인터페이스에서는 public 생략 가능
    // 사용자 정보가 있는지 없는지 확인
    public int isUserInfo(String userId, String userPw) throws Exception;
    
    // 사용자 정보 가져오기
    public UserDto getUserInfo(String userId) throws Exception;
}
