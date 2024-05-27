package com.example.mybatisTest.controller;

import com.example.mybatisTest.dto.BoardDto;
import com.example.mybatisTest.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        return "redirect:/list";
    }

    @GetMapping("/list")
    public String findAll(Model model) {
        List<BoardDto> boardDtoList = boardService.findAll();
        model.addAttribute("boardList", boardDtoList);
        return "list";
    }

    @GetMapping("/board/{id}")
    public String viewBoard(@PathVariable("id") int id, Model model) {
        // 조회수 증가
        boardService.incrementBoardHits(id);

        // 게시글 상세 정보 조회
        BoardDto board = boardService.getBoardById(id);
        model.addAttribute("board", board);

        return "board/view";
    }
}
