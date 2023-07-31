package com.bitc.securityquiz.service;

import com.bitc.securityquiz.data.dto.AddBoardRequest;
import com.bitc.securityquiz.data.entity.Board;
import com.bitc.securityquiz.data.entity.Member;
import org.springframework.security.core.annotation.AuthenticationPrincipal;

import java.util.List;
import java.util.Optional;

public interface BoardService {
    List<Board> selectBoardList() throws Exception;

    Board insertBoard(AddBoardRequest board, @AuthenticationPrincipal Member member) throws Exception;

    Board updateVisitcount(int num) throws Exception;

    Board selectBoardDetail(int num) throws Exception;

    void deleteBoard(int num) throws Exception;

    void updateBoard(AddBoardRequest board) throws Exception;
}
