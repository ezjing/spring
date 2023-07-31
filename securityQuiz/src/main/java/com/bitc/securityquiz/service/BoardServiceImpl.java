package com.bitc.securityquiz.service;

import com.bitc.securityquiz.data.dto.AddBoardRequest;
import com.bitc.securityquiz.data.entity.Board;
import com.bitc.securityquiz.data.entity.Member;
import com.bitc.securityquiz.data.repository.BoardRepository;
import com.bitc.securityquiz.data.repository.MemberRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@SpringBootApplication
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardRepository;
    private final MemberRepository memberRepository;

    @Override
    public List<Board> selectBoardList() {
        return boardRepository.findAllByOrderByNumDesc();
    }

    @Override
    public Board insertBoard(AddBoardRequest board, @AuthenticationPrincipal Member member) {   // @AuthenticationPrincipal Member member 를 사용하여 springboot security에서 로그인한 계정의 정보에 접근 가능. member.getId()... 이런 식
        Member memberId = memberRepository.findById(member.getId()).get();  // Member 타입의 Id를 입력해주기 위한 과정
        return boardRepository.save(Board.builder()
                .num(board.getNum())
                .title(board.getTitle())
                .content(board.getContent())
                .id(memberId)   // Memeber 타입의 Id 입력
                .postdate(board.getPostdate())
                .visitcount(board.getVisitcount())
                .build());
    }

    @Override
    @Transactional
    public Board updateVisitcount(int num) throws Exception {    // save를 이해하려면 https://jessyt.tistory.com/35 참고, 업데이트랑 디테일이랑 동시에 나와야함
        Board board = boardRepository.findByNum(num);   // DTO를 불러낸 다음

        board.setVisitcount(board.getVisitcount() + 1); // DTO에 조회수 업데이트

        return board;
    }

    @Override
    public Board selectBoardDetail(int num) throws Exception {
        return boardRepository.findByNum(num);
    }

    @Override
    @Transactional  // @Transactional : delete 쿼리 메소드가 실행되는 메소드에 사용되는 어노테이션, update 시에도 쓰이는듯..?(변경감지)
    public void deleteBoard(int num) throws Exception {
        boardRepository.deleteByNum(num);
    }

    @Override
    @Transactional
    public void updateBoard(AddBoardRequest board) throws Exception {
        boardRepository.boardEdit(board);
//        boardRepository.boardEdit(board.getTitle(), board.getId(), board.getContent(), "2023-07-31 11:45:00", board.getNum());
    }
}
