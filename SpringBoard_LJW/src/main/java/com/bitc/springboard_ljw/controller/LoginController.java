package com.bitc.springboard_ljw.controller;

import com.bitc.springboard_ljw.dto.LoginDto;
import com.bitc.springboard_ljw.service.LoginService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.PrintWriter;

@RequestMapping("/login")
@Controller
public class LoginController {
    @Autowired
    private LoginService loginService;

    @GetMapping("/login")
    public String loginView() throws Exception {
        return "login/login";
    }
    
    // 로그인 성공시 보드리스트로
    @PostMapping("/login")
    public String loginSuccess( String userId,  String userPw, HttpServletRequest req, HttpServletResponse resp) throws Exception { // @RequestParam은 생략 가능 name 지정해주고 싶을때 사용
        int result = loginService.loginCheck(userId, userPw);

        if (result == 1) {
            LoginDto login = loginService.getUser(userId, userPw);  // 유저 한명의 정보만 가져오는 것이므로 배열로 받아옴, 배열로 받아와야 getUserXX 사용 가능

            HttpSession session = req.getSession();

            session.setAttribute("userNo", login.getUserNo());
            session.setAttribute("userId", login.getUserId());
            session.setAttribute("userPw", login.getUserPw());
            session.setAttribute("userName", login.getUserName());

            return "redirect:/board/boardList";
        }
        else {
            // 데이터만 전달하는 String이라서 경고창이 출력되지 않는듯..
            resp.setContentType("text/html;charset=UTF-8");
            PrintWriter writer = resp.getWriter();

            String js = "<script>";
            js += "alert('회원 정보가 맞지 않습니다.');";
            js += "</script>";

            writer.println(js);

            return "redirect:/login/login";
        }


    }
    
    // 회원가입 뷰
    @GetMapping("/joinUser")
    public String joinUserView(LoginDto login) throws Exception {

        return "login/joinUser";
    }

    @PostMapping("/joinUser")
    public String joinUserProcess(LoginDto login) throws Exception {
        loginService.joinUser(login);

        return "redirect:/login/login";
    }
}

// @RequestParam : 외부에서 받아온 매개변수 값
// @Param : 매개변수의 이름 등을 확실하게 해주려고 사용