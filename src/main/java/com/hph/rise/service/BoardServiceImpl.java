package com.hph.rise.service;

import com.hph.rise.entity.Board;
import com.hph.rise.entity.Paging;
import com.hph.rise.entity.Search;
import com.hph.rise.repository.BoardRepository;
import com.hph.rise.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    private BoardRepository boardRepository;

    /**
     *
     * @return
     */

    // 게시글 목록
    @Override
    public List<Board> findList(Paging page, Search search) throws Exception{
        List<Board> boardList = boardRepository.boardList(page, search);
        return boardList;
    }

    @Override
    public int countBoard(Paging vo, Search search) throws Exception{

        System.out.println("도착 확인~~~~~~~~~~" + vo + " 확인 2 ::: " + search);

        return boardRepository.countBoard(vo, search);
    }

    // 게시글 등록

    // 지정된 게시글 조회

    // 게시글 수정

    // 게시글 삭제


}
