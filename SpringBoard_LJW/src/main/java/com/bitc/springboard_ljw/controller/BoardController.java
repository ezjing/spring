package com.bitc.springboard_ljw.controller;

import com.bitc.springboard_ljw.dto.BoardDto;
import com.bitc.springboard_ljw.dto.LoginDto;
import com.bitc.springboard_ljw.service.BoardService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RequestMapping("/board")
@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;

    // 게시물 글 목록
    @GetMapping("/boardList")
    public ModelAndView boardList(HttpServletRequest req) throws Exception {
        ModelAndView mv = new ModelAndView("board/boardList");

        List<BoardDto> boardList = boardService.selectBoardList();

        mv.addObject("boardList", boardList);

        // 세션 데이터 가져오기(jsp처럼 뷰 파일에서 직접적으로 세션 출력은 안되는거같음, ModelAndView에서 setter 값을 줘야함)
        HttpSession session = req.getSession();

        LoginDto login = new LoginDto();

        login.setUserName((String) session.getAttribute("userName"));

        mv.addObject("session", login);

        return mv;
    }

    // 상세 글 보기(조회수 +1)
    @GetMapping("/boardDetail/idx={idx}")
    public ModelAndView boardDetail(@PathVariable int idx) throws Exception {
        ModelAndView mv = new ModelAndView("board/boardDetail");

        BoardDto board = boardService.selectBoardDetail(idx);

        mv.addObject("board", board);

        return mv;
    }

    // 수정
    @PutMapping("/boardDetail/idx={idx}")
    public String boardEdit(BoardDto board) throws Exception {
        boardService.updateBoardEdit(board);

        return "redirect:/board/boardDetail/idx={idx}"; // 즉시 수정내용 반영
//        return "redirect:/board/boardList"; // 리턴값에도 메소드를 지정할수 있을까?
    }

    // 삭제
    @DeleteMapping("/boardDetail/idx={idx}")
    public String boardDelete(@PathVariable int idx) throws Exception {
        boardService.updateBoardDelete(idx);

        return "redirect:/board/boardList";
    }

    // 글쓰기(뷰)
    @GetMapping("/boardWrite")
    public ModelAndView boardWriteView() throws Exception {
        ModelAndView mv = new ModelAndView("board/boardWrite");

        return mv;
    }

    // 글쓰기 (프로세스)
    @PostMapping("/boardWrite")
    public String boardWriteProcess(BoardDto board) throws Exception {
        boardService.insertBoard(board);

        return "redirect:/board/boardList";
    }
}
