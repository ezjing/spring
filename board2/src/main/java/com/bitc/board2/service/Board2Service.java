package com.bitc.board2.service;

import com.bitc.board2.dto.Board2Dto;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.List;

public interface Board2Service {
    // 게시판 글 목록 보기(DB의 모든 데이터를 배열형식으로 불러와 저장해야해서 리스트)
    public List<Board2Dto> selectBoardList() throws Exception;   // interface는 기본적으로 public이 붙음 안써줘도 됨
    
    // 게시판 글 상세 보기(데이터(글) 하나만 들고오면 돼서 배열형식의 DTO클래스)
    Board2Dto selectBoardDetail(int boardIdx) throws Exception;
    
    // 게시판 글 등록
    // 업로드된 파일 정보 확인을 위한 MultipartHttpServletRequest 타입의 매개변수 추가
    void insertBoard(Board2Dto board, MultipartHttpServletRequest multipart) throws Exception;    // Exception하면 스프링에서 알아서 오류 처리해서 try-catch 안써도 됨
    
    // 게시판 글 수정
    void updateBoard(Board2Dto board) throws Exception;
    
    // 게시판 글 삭제
    void deleteBoard(int boardIdx) throws Exception;
}
