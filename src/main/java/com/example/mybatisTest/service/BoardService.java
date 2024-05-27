package com.example.mybatisTest.service;

import com.example.mybatisTest.dto.BoardDto;
import com.example.mybatisTest.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService {
    @Autowired
    BoardMapper boardMapper;

    public void save(BoardDto boardDto) {
        boardMapper.save(boardDto);
    }
}
