package com.hph.rise.controller;

import com.hph.rise.entity.Board;
import com.hph.rise.entity.Paging;
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

    /**
     * <p>게시판 목록</p>
     * @param vo 페이징 정보
     * @param model
     * @param search 검색
     * @param orderBy 정렬종류
     * @param orderType 정렬타입
     * @param searchType 검색타입
     * @param keyword 검색키워드
     * @param nowPage 현재페이지 번호
     * @param cntPerPage 노출목록수
     * @return 목록으로 이동
     * @throws Exception
     */
    @GetMapping("/list")
    public String list(Paging vo, Model model, Search search,
                       @RequestParam(value = "orderBy", required = false) String orderBy,
                       @RequestParam(value = "orderType", required = false) String orderType,
                       @RequestParam(value = "searchType", required = false) String searchType,
                       @RequestParam(value = "keyword", required = false) String keyword,
                       @RequestParam(value = "nowPage", required = false) String nowPage,
                       @RequestParam(value = "cntPerPage", required = false) String cntPerPage) throws Exception {

        logger.info("read");

        // 게시판 목록의 정렬순
        if (orderBy == null ){
            search.setOrderBy("id");
        }
        if (orderType == null){
            search.setOrderType("DESC");
        }
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
        /* search.setKeyword(keyword);*/

        // 오름차순 내림차순은 추후 진행
        /*if (orderType == "DESC"){

        }*/

        /*System.out.println("요청값 확인 getOrderBy :::" +  search.getOrderBy());
        System.out.println("요청값 확인 getOrderType :::" +  search.getOrderType());
        System.out.println("요청값 확인 searchType :::" +  search.getSearchType());
        System.out.println("요청값 확인 keyword :::" +  search.getKeyword());*/

        // 초기 페이징값 설정
        if (nowPage == null && cntPerPage == null) {
            nowPage = "1";
            cntPerPage = "5";
        } else if (nowPage == null) {
            nowPage = "1";
        } else if (cntPerPage == null) {
            cntPerPage = "5";
        }
        int total = 0;

        vo = new Paging(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage));

        // 게시글수 조회
        total = boardService.countBoard(vo, search);

        vo = new Paging(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage));

        List<Board> boardList = boardService.findList(vo, search);

        model.addAttribute("paging", vo);
        model.addAttribute("search", search);
        model.addAttribute("total", total);
        model.addAttribute("postList", boardList);

        return "/board/list.html";
    }

    /* 게시글 등록화면으로 이동 */

    /* 게시글 등록 */
    /* 게시글 수정 */
    /* 게시글 삭제 */




}
