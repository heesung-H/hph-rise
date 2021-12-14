package com.hph.rise.controller;

import com.hph.rise.entity.Board;
import com.hph.rise.entity.Search;
import com.hph.rise.service.BoardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.model.IModel;

import java.util.List;

@Controller
/*@RequestMapping("/board")*/
public class BoardController {

    private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

    @Autowired
    BoardService boardService;

    /* 공통게시판 */
    @GetMapping("/board/list")
    public String boardList(Model model) {
        // 게시판 데이터 불러오기 - Model model

        //model.addAttribute("boardlist", )

        return "board/list" ;
    }

    @GetMapping("/list")
    public String list(Model model, Search search,
                       @RequestParam(value = "searchType", required = false) String searchType, // 검색타입
                       @RequestParam(value = "keyword", required = false) String keyword) // 검색어
            throws Exception {

        logger.info("read");

        if (searchType == null){
            search.setSearchType("all");
        }else if (searchType != null){
            search.setSearchType(searchType);
        }
        if (keyword == null){
            search.setKeyword("");
        }else if (keyword != null){
            search.setKeyword(keyword);
        }

        List<Board> boardList = boardService.findList(search);

        model.addAttribute("search", search);
        model.addAttribute("postList", boardList);

        return "/board/list.html";
    }

    /* 게시글 등록화면으로 이동 */

    /* 게시글 등록 */
    /* 게시글 수정 */
    /* 게시글 삭제 */




}
