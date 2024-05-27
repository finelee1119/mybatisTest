package com.example.mybatisTest.controller;

import com.example.mybatisTest.dto.BoardDto;
import com.example.mybatisTest.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BoardController {
    @Autowired
    BoardService boardService;

    @GetMapping("/")
//    @RequestMapping(value = {"/",""}, method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    @GetMapping("/save")
    public String save() {
        return "save";
    }

    @PostMapping("/save")
    public String saveBoard(BoardDto boardDto) {
        System.out.println("boardDto : " + boardDto.toString());
        boardService.save(boardDto);
        return "save";
    }
}
