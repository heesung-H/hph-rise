package com.hph.rise.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.model.IModel;

@Controller
/*@RequestMapping("/board")*/
public class BoardController {

    /* 공통게시판 */
    @GetMapping("/board/list")
    public String boardList(Model model) {
        // 게시판 데이터 불러오기 - Model model

        //model.addAttribute("boardlist", )

        return "board/list" ;
    }


    /* 게시글 등록화면으로 이동 */

    /* 게시글 등록 */
    /* 게시글 수정 */
    /* 게시글 삭제 */




}
