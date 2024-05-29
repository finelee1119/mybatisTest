package com.example.mybatisTest.service;

import com.example.mybatisTest.dto.BoardDto;
import com.example.mybatisTest.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BoardService {
    @Autowired
    BoardMapper boardMapper;

    public void save(BoardDto boardDto) {
        if(boardDto.getBoardFile().get(0).isEmpty()) {
            // 첨부파일 없음
            boardDto.setFileAttached(0);
            boardMapper.save(boardDto);
        } else {
            // 첨부파일 세팅하기
            boardDto.setFileAttached(1);

            // 게시글 저장 -> 저장된 id값을 활용해 리턴 받기
            Long savedId = boardMapper.save(boardDto);
            BoardDto savedBoard = boardMapper.findById(savedId);
            System.out.println(savedBoard);

            // 파일이름 가져오기

            // 저장용 파일이름 생성

            // BoardDto를 세팅

            // 파일을 내컴퓨터의 저장용 폴더에 저장

            // board_file_table DB테이블에 저장

            boardMapper.save(boardDto);
        }
    }

    public List<BoardDto> findAll() {
        return boardMapper.findAll();
    }

    public BoardDto findById(Long id) {
        return boardMapper.findById(id);
    }

    public void updateHits(Long id) {
        boardMapper.boardHitsUpdate(id);
    }

    public void updateBoard(BoardDto boardDto) {
        boardMapper.update(boardDto);
    }

    public void delete(Long id) {
        boardMapper.deleteById(id);
    }


}
