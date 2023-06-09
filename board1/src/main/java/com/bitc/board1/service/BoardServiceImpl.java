package com.bitc.board1.service;

import com.bitc.board1.common.FileUtils;
import com.bitc.board1.dto.BoardDto;
import com.bitc.board1.dto.BoardFileDto;
import com.bitc.board1.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.Iterator;
import java.util.List;

// @Service : 해당 클래스가 상속받은 interface 이름으로 동작하도록 설정(따로 변수 선언 해줄필요 없음)
@Service
public class BoardServiceImpl implements BoardService {
    // BoardMapper 인터페이스 타입의 변수 선언
    @Autowired
    private BoardMapper boardMapper;

    @Autowired
    private FileUtils fileUtils;

    // 부모인 BoardService에서 상속받은 메소드를 구현
    @Override
    public List<BoardDto> selectBoardList() throws Exception {
        // BoardMapper 인터페이스에서 제공하는 메소드를 실행
        return boardMapper.selectBoardList();
    }

    // 게시판 상세 글 보기
    // 해당 게시글에 첨부된 첨부파일 목록도 함께 불러옴
    @Override
    public BoardDto selectBoardDetail(int boardIdx) throws Exception {
        // 1. 컨트롤러에서 전달된 게시물 버호 가져오기
        // 2. mapper를 사용하여 DB에서 지정한 게시물의 조회수 업데이트
        // 3. mapper를 사용하여 DB에서 지정한 게시물 정보 가져오기
        // 4. mapper를 사용하여 DB에서 지정한 게시물에 첨부된 첨부파일 목록 가져오기
        // 5. 가져온 파일 목록 BoardDto 타입에 저장
        // 6. 가져온 기세물 정보를 컨트롤러로 리턴

        // 전달받은 게시물 번호를 사용하여 mybatis mapper의 updateHitCount() 메소드 실행
        boardMapper.updateHitCount(boardIdx);
        // 전달받은 게시물 번호를 사용하여 mybatis mapper의 selectBoardDetail() 메소드 실행
        // 조회된 정보를 BoardDto 클래스 타입의 변수에 대입
        BoardDto board = boardMapper.selectBoardDetail(boardIdx);

        // 첨부파일 목록 가져오기
        List<BoardFileDto> boardFileList = boardMapper.selectBoardFileList(boardIdx);

        // BoardDto 객체에 가져온 첨부파일 리스트를 추가
        board.setFileList(boardFileList);
        
        // 저장된 정보를 컨트롤러로 리턴
        return board;
    }

    // 게시판 글 등록 구현
    @Override
    public void insertBoard(BoardDto board, MultipartHttpServletRequest uploadFiles) throws Exception {
        // 1. 컨트롤러에서 전달된 데이터 가져오기
        // 2. mapper 를 사용하여 DB에 데이터 등록

        // 전달받은 데이터를 매개변수로 사용하여 mybatis mapper의 insertBoard() 메소드 실행
        boardMapper.insertBoard(board); // 게시물 글 추가하는 거

        List<BoardFileDto> fileList = fileUtils.parseFileInfo(board.getBoardIdx(), uploadFiles);


        // CollectionUtils : 스프링프레임워크에서 제공하는 클래스
        if (CollectionUtils.isEmpty(fileList) == false) {
            boardMapper.insertBoardFileList(fileList);  // 게시물의 첨부파일 추가하는거
        }

//        // 서버로 전달된 파일 정보를 분석
//        // ObjectUtils : 스프링 프레임워크에서 제공하는 유틸클래스
//        // isEmpty() : 객체의 내용이 비었으면 true, 있으면 false
//        if (ObjectUtils.isEmpty(uploadFiles) == false) {
//            // 업로드된 파일의 파일명 목록을 Iterator 타입으로 가져옴
//            // 제네릭을 사용하여 가져오는 데이터 타입을 고정
//            Iterator<String> iterator = uploadFiles.getFileNames(); // Iterator은 문자열 타입 고정이고 향상된 for문과 유사하다
//            String name;    // 파일명을 저장하기 위한 변수
//
//            // 파일명 목록이 있는지 확인 후 반복문 실행
//            while (iterator.hasNext()) {
//                // 파일 이름 가져오기
//                name = iterator.next();
//                // 지정한 파일명을 가지고 있는 파일에 대한 모든 정보를 가져옴
//                List<MultipartFile> fileInfoList = uploadFiles.getFiles(name);
//
//                for (MultipartFile fileInfo : fileInfoList) {
//                    System.out.println("***** start file info *****");
//                    // 원본 파일명 가져오기
//                    System.out.println("file name : " + fileInfo.getOriginalFilename());
//                    // 파일 크기 가져오기
//                    System.out.println("file size : " + fileInfo.getSize());
//                    // 파일 확장자 가져오기
//                    System.out.println("file content type : " + fileInfo.getContentType());
//                    System.out.println("***** end file info *****\n");
//                    System.out.println();
//                }
//            }
//        }
    }

    // 게시판 글 수정
    @Override
    public void updateBoard(BoardDto board) throws Exception {
        // 1. 컨트롤러에서 전달된 데이터 가져오기
        // 2. mapper 를 사용하여 DB에 데이터 등록
        
        // 전달받은 데이터를 매개변수로 사용하여 mybatis mapper의 updateBoard() 메소드 실행
        boardMapper.updateBoard(board);
    }

    @Override
    public void deleteBoard(int boardIdx) throws Exception {
        // 1. 컨트롤러에서 전달된 데이터 가져오기
        // 2. mapper 를 사용하여 DB에 데이터 등록

        // 전달받은 데이터를 매개변수로 사용하여 mybatis mapper의 deleteBoard() 메소드 실행
        boardMapper.deleteBoard(boardIdx);
    }

    @Override
    public BoardFileDto selectBoardFileInfo(int idx, int boardIdx) throws Exception {
        return boardMapper.selectBoardFileInfo(idx, boardIdx);
    }
}
