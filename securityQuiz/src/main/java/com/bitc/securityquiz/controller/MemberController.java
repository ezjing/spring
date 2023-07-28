package com.bitc.securityquiz.controller;

import com.bitc.securityquiz.data.dto.AddMemberRequest;
import com.bitc.securityquiz.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequiredArgsConstructor
@Controller
public class MemberController {

    private final MemberService memberService;

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public String signup(AddMemberRequest request) throws Exception {
        memberService.save(request);
        return "redirect:/login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() throws Exception {
        return "login";
    }

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String signup() throws Exception {
        return "signup";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        new SecurityContextLogoutHandler().logout(req, resp, SecurityContextHolder.getContext().getAuthentication());
        return "redirect:/logout";
    }
}
