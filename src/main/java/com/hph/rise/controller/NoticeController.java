package com.hph.rise.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
//@RequestMapping("/notice")
public class NoticeController {

    @GetMapping("/notice/list")
    public String noticeList() {

        return "notice/list";
    }
}
