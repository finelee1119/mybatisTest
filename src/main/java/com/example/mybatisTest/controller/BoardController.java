package com.example.mybatisTest.controller;

import com.example.mybatisTest.dto.BoardDto;
import com.example.mybatisTest.dto.BoardFileDto;
import com.example.mybatisTest.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
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
    public String saveBoard(BoardDto boardDto) throws IOException {
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

    @GetMapping("/{id}")
    public String findById(@PathVariable("id")Long id, Model model) {
        //조회수 처리
        boardService.updateHits(id);

        //상세내용 가져오기
        BoardDto boardDto = boardService.findById(id);
        model.addAttribute("board", boardDto);

        //첨부파일 가져오기
        if(boardDto.getFileAttached() == 1) {
            List<BoardFileDto> boardFileDtoList = boardService.findFile(id);
            model.addAttribute("boardFileList", boardFileDtoList);
        }
        return "detail";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable("id")Long id, Model model) {
        BoardDto boardDto = boardService.findById(id);
        model.addAttribute("board", boardDto);
        return "update";
    }

    @PostMapping("/update/{id}")
    public String update(BoardDto boardDto) {
        boardService.updateBoard(boardDto);
        boardService.findById(boardDto.getId());
        return "redirect:/" + boardDto.getId();
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id")Long id) {
        boardService.delete(id);
        return "redirect:/list";
    }
}
