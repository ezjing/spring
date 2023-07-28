package com.bitc.securityquiz.controller;

import com.bitc.securityquiz.data.dto.AddBoardRequest;
import com.bitc.securityquiz.data.entity.Board;
import com.bitc.securityquiz.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

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
}
