package com.hph.rise.repository;


import com.hph.rise.entity.Board;
import com.hph.rise.entity.Paging;
import com.hph.rise.entity.Search;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper
public interface BoardRepository {
    // 조회
    @Autowired
    public List<Board> boardList(Paging page, Search search) throws Exception;

    // 조회수 계산
    public int countBoard(Paging page, Search search);

    // 특정 게기물 조회

    // 게시물 등록

}
