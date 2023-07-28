package com.bitc.security.service;

import com.bitc.security.data.dto.AddUserRequest;

public interface UserService {
    public Long save (AddUserRequest dto);  // 인터페이스에서는 public 생략 가능

}
