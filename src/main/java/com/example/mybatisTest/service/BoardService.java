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
        boardMapper.save(boardDto);
    }

    public List<BoardDto> findAll() {
        return boardMapper.findAll();
    }

    public BoardDto getBoardById(int id) {
        return boardMapper.findById(id);
    }

    @Transactional
    public void incrementBoardHits(int id) {
        boardMapper.boardHitsUpdate(id);
    }
}
