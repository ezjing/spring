package com.bitc.board2.service;

import com.bitc.board2.dto.Board2Dto;
import com.bitc.board2.mapper.Board2Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.List;

// @Service : 해당 클래스가 상속받은 interface 이름으로 동작하도록 설정(따로 변수 선언 해줄필요 없음)
@Service
public class Board2ServiceImpl implements Board2Service {
    // BoardMapper 인터페이스 타입의 변수 선언
    @Autowired
    private Board2Mapper board2Mapper;

    // 부모인 BoardService에서 상속받은 메소드를 구현
    @Override
    public List<Board2Dto> selectBoardList() throws Exception {
        // BoardMapper 인터페이스에서 제공하는 메소드를 실행
        return board2Mapper.selectBoardList();
    }

    // 게시판 상세 글 보기
    // 해당 게시글에 첨부된 첨부파일 목록도 함께 불러옴
    @Override
    public Board2Dto selectBoardDetail(int boardIdx) throws Exception {
        // 1. 컨트롤러에서 전달된 게시물 버호 가져오기
        // 2. mapper를 사용하여 DB에서 지정한 게시물의 조회수 업데이트
        // 3. mapper를 사용하여 DB에서 지정한 게시물 정보 가져오기
        // 4. mapper를 사용하여 DB에서 지정한 게시물에 첨부된 첨부파일 목록 가져오기
        // 5. 가져온 파일 목록 BoardDto 타입에 저장
        // 6. 가져온 기세물 정보를 컨트롤러로 리턴

        // 전달받은 게시물 번호를 사용하여 mybatis mapper의 updateHitCount() 메소드 실행
        board2Mapper.updateHitCount(boardIdx);
        // 전달받은 게시물 번호를 사용하여 mybatis mapper의 selectBoardDetail() 메소드 실행
        // 조회된 정보를 BoardDto 클래스 타입의 변수에 대입
        Board2Dto board = board2Mapper.selectBoardDetail(boardIdx);
        
        // 저장된 정보를 컨트롤러로 리턴
        return board;
    }

    // 게시판 글 등록 구현
    @Override
    public void insertBoard(Board2Dto board, MultipartHttpServletRequest uploadFiles) throws Exception {
        // 1. 컨트롤러에서 전달된 데이터 가져오기
        // 2. mapper 를 사용하여 DB에 데이터 등록

        // 전달받은 데이터를 매개변수로 사용하여 mybatis mapper의 insertBoard() 메소드 실행
        board2Mapper.insertBoard(board); // 게시물 글 추가하는 거
    }

    // 게시판 글 수정
    @Override
    public void updateBoard(Board2Dto board) throws Exception {
        // 1. 컨트롤러에서 전달된 데이터 가져오기
        // 2. mapper 를 사용하여 DB에 데이터 등록
        
        // 전달받은 데이터를 매개변수로 사용하여 mybatis mapper의 updateBoard() 메소드 실행
        board2Mapper.updateBoard(board);
    }

    @Override
    public void deleteBoard(int boardIdx) throws Exception {
        // 1. 컨트롤러에서 전달된 데이터 가져오기
        // 2. mapper 를 사용하여 DB에 데이터 등록

        // 전달받은 데이터를 매개변수로 사용하여 mybatis mapper의 deleteBoard() 메소드 실행
        board2Mapper.deleteBoard(boardIdx);
    }
}
