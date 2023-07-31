package com.bitc.securityquiz.controller;

import com.bitc.securityquiz.data.dto.AddBoardRequest;
import com.bitc.securityquiz.data.entity.Board;
import com.bitc.securityquiz.data.entity.Member;
import com.bitc.securityquiz.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Controller
public class BoardController {

    private final BoardService boardService;

    @RequestMapping(value = "/boardList", method = RequestMethod.GET)
    public ModelAndView boardList() throws Exception {
        ModelAndView mv = new ModelAndView("boardList");

        List<Board> boardList = boardService.selectBoardList();

        mv.addObject("boardList", boardList);

        return mv;
    }

    @RequestMapping(value = "/boardWrite", method = RequestMethod.GET)
    public String boardWriteView() throws Exception {
        return "boardWrite";
    }

    @RequestMapping(value = "/boardWrite", method = RequestMethod.POST)
    public String boardWriteProcess(AddBoardRequest board, @AuthenticationPrincipal Member member) throws Exception {   // 스프링 시큐리티에서 로그인한 계정의 정보를 가져다 쓸때 사용, 사용시 member.getId() 이런식으로 사용
        boardService.insertBoard(board, member);

        return "redirect:/boardList";
    }

    @RequestMapping(value = "/boardDetail/{num}", method = RequestMethod.GET)
    public ModelAndView boardDetail(@PathVariable int num) throws Exception {
        ModelAndView mv = new ModelAndView("boardDetail");

        Board board = boardService.updateVisitcount(num);   // 호출과 조회수 업뎃 동시

        mv.addObject("board", board);

        return mv;
    }

    @RequestMapping(value = "/boardDelete", method = RequestMethod.POST)
    public String boardDelete(@RequestParam int num) throws Exception {
        boardService.deleteBoard(num);

        return "redirect:/boardList";
    }

    @RequestMapping(value = "/boardEdit", method = RequestMethod.POST)
    public ModelAndView boardEdit(AddBoardRequest boardDto) throws Exception {    // 리퀘스트 파람(일반 타입) 바디(DTO 타입) 차이 보기
        ModelAndView mv = new ModelAndView("boardDetail");
        boardService.updateBoard(boardDto);

        Board board = boardService.selectBoardDetail(boardDto.getNum());

        mv.addObject("board", board);

        return mv;
    }
}
