package com.hph.rise.service;

import com.hph.rise.entity.Board;
import com.hph.rise.entity.Paging;
import com.hph.rise.entity.Search;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface BoardService {

    @Autowired
    BoardServiceImpl boardServiceImpl = new BoardServiceImpl();

    // 게시판 목록조회
    List<Board> findList(Paging vo, Search search) throws Exception;

    // 게시판 총수
    int countBoard(Paging vo, Search search) throws Exception;

    // 게시물 등록

    // 상세게시물 조회
}
