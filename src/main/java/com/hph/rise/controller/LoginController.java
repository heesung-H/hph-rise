package com.hph.rise.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
@RequestMapping(value = "/login")
public class LoginController {

    private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

    //@Autowired
    //LoginService loginService;

    /**
     * <p>로그인 화면으로</p>
     * @return
     */
    @GetMapping("/")
    public String login(){
        return "login/login";
    }

    /**
     * <p>회원가입 화면으로</p>
     * @return
     */
    @GetMapping("/signUp")
    public String signUp() { return "login/signUp";}

    //로그인 처리


    // 로그아웃 처리

    // id찾기 화면으로

    // pw찾기 화면으로

}
