package com.bitc.board1.service;

import com.bitc.board1.dto.BoardDto;

import java.util.List;

public interface BoardService {
    public List<BoardDto> selectBoardList() throws Exception;   // interface는 기본적으로 public이 붙음 안써줘도 됨
}
