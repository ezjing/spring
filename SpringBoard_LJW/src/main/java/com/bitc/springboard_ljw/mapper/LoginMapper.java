package com.bitc.springboard_ljw.mapper;

import com.bitc.springboard_ljw.dto.LoginDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface LoginMapper {
    // Mapper의 @Param은 생략 불가능 생략시 500오류 발생(BoardMapper에서 글쓰기는 없이 됐는데 Dto 객체는 없어도 된는지 물어보기.)

    int loginCheck(@Param("userId") String userId, @Param("userPw") String userPw) throws Exception;

    LoginDto getUser(@Param("userId") String userId, @Param("userPw") String userPw) throws  Exception;

    void joinUser(LoginDto login) throws Exception;
}
