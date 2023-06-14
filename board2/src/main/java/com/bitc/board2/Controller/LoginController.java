package com.bitc.board2.Controller;

import com.bitc.board2.dto.UserDto;
import com.bitc.board2.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/login")
public class LoginController {

    // 로그인 내부 로직을 실행할 서비스
    @Autowired
    private UserService userService;

    // 사용자 로그인 페이지, 단순 view 페이지
    @GetMapping("/login.do") // @RequestMapping 사용 해도 됨 @Get/PostMapping 은 메소드 방식을 확실히 보여주기 위함
    public String doLogin() throws Exception {
        return "login/login";
    }

    // 로그인 프로세스, DB와 연결하여 사용자가 입력한 정보가 있는지 확인, 세션을 생성
    // HttpServletRequest 타입을 매개변수로 사용해야 세션 정보를 가져올 수 있음 (브라우저 관리자 모드의 어플리케이션에서 세션 확인 가능)
    @PostMapping("/loginProcess.do")     // @RequestMapping 사용 해도 됨 @Get/PostMapping 은 메소드 방식을 확실히 보여주기 위함
    public String doLoginProcess(@RequestParam("userId") String userId, @RequestParam("userPw") String userPw, HttpServletRequest req) throws Exception {
        // 1. 클라이언트에서 전달된 데이터 가져오기
        // 2. 서비스를 이용하여 DB에 해당 데이터가 있는지 확인
        // 3. 데이터 존재 시 세션 생성
        // 4. 로그인 성공 페이지로 리다이렉트 (데이터가 없으면 로그인 실패 페이지로 리다이렉트)

        // 서비스로직을 이용하여 사용자가 입력한 ID/PW를 사용하는 사용자가 있는지 확인, 1이면 존재함, 1이 아니면 없거나 오류가 발생한 것
        int result = userService.isUserInfo(userId, userPw);

        // 정보가 있으면 세션 생성 후 데이터를 세션에 저장
        if (result == 1) {
            // 현 사용자의 사용자 정보를 DB에서 가져옴
            UserDto userInfo = userService.getUserInfo(userId);

            // 세션 생성
            HttpSession session = req.getSession();
            // 세션에 현 사용자의 정보 저장
            session.setAttribute("userId", userInfo.getUserId());
            session.setAttribute("userName", userInfo.getUserName());
            session.setAttribute("userEmail", userInfo.getUserEmail());
            session.setMaxInactiveInterval(60); // 세션 삭제 시간 설정

            return "redirect:/login/loginOK.do";
        }
        else {  // 정보가 없으면 loginFail.do 페이지로 리다이렉트
            return "redirect:/login/loginFail.do";
        }


    }

    // 로그인 성공 시 접속할 페이지, 사용자 정보와 View 화면을 함께 표시해야하기 때문에 ModelAndView를 리턴 타입으로 설정
    @GetMapping("/loginOK.do")
    public ModelAndView doLoginOK(HttpServletRequest req) throws Exception {
        // 1. 세션 정보 가져오기
        // 2. 세션 정보 화면에 출력

        // ModelAndView 객체 생성, View 화면 설정
        ModelAndView mv = new ModelAndView("login/loginOK");

        // 세션 정보 가져오기
        HttpSession session = req.getSession();

        // 세션에 저장된 정보를 UserDto 클래스 타입의 객체에 저장
        UserDto user = new UserDto();
        user.setUserId((String) session.getAttribute("userId"));
        user.setUserName((String) session.getAttribute("userName"));
        user.setUserEmail((String) session.getAttribute("userEmail"));

        // ModelAndView 객체에 사용자 정보 저장
        mv.addObject("userInfo", user);

        return mv;
    }

    // 로그인 실패 시 페이지(자바스크립트로 3초 후 화면 이동되도록 설정함)
    @GetMapping("/loginFail.do")
    // 로그인 실패 시 접속할 페이지
    public String doLoginFail() throws Exception {
        // 1. 로그인 페이지로 이동

        return "login/loginFail";
    }

    // 로그아웃 프로세스 및 페이지(자바스크립트로 3초 후 화면 이동되도록 설정함)
    @GetMapping("/logout.do")
    public String doLogout(HttpServletRequest req) throws Exception {
        // 1. 세션 정보 가져오기
        // 2. 기존 세션 정보 삭제
        // 3. 로그인 페이지로 이동

        // 세션 정보 가져오기
        HttpSession session = req.getSession();

        // 세션에 저장된 내용 삭제
        session.removeAttribute("userId");
        session.removeAttribute("userName");
        session.removeAttribute("userEmail");

        session.invalidate();   // 세션의 모든 정보 삭제

        return "login/logout";
    }
}
