package com.bitc.springboard_ljw.service;

import com.bitc.springboard_ljw.dto.BoardDto;

import java.util.List;

public interface BoardService {
    // 게시판 글 목록
    List<BoardDto> selectBoardList() throws Exception;
    
    // 상세 글 보기
    BoardDto selectBoardDetail(int idx) throws Exception;

    // 수정
    void updateBoardEdit(BoardDto board) throws Exception;

    void updateBoardDelete(int idx) throws Exception;

    void insertBoard(BoardDto board) throws  Exception;
}
