package com.example.mybatisTest.service;

import com.example.mybatisTest.dto.BoardDto;
import com.example.mybatisTest.dto.BoardFileDto;
import com.example.mybatisTest.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class BoardService {
    @Autowired
    BoardMapper boardMapper;

    public void save(BoardDto boardDto) throws IOException {
        if(boardDto.getBoardFile().get(0).isEmpty()) {
            // 첨부파일 없음
            boardDto.setFileAttached(0);
            boardMapper.save(boardDto);
        } else {
            // 첨부파일 세팅하기
            boardDto.setFileAttached(1);

            // 게시글 저장 -> 저장된 id값을 활용해 리턴 받기
            boardMapper.save(boardDto);
            BoardDto savedBoard = boardMapper.findById(boardDto.getId());
            System.out.println(savedBoard);

            for(MultipartFile boardFile : boardDto.getBoardFile()) {
                // 파일이름 가져오기
                String originalFileName = boardFile.getOriginalFilename();
                System.out.println("originalFilename : " + originalFileName);

                // 저장용 파일이름 생성
                String storedFileName = System.currentTimeMillis() + "-" + originalFileName;
                System.out.println("storedFilename : " + storedFileName);

                // BoardDto를 세팅
                BoardFileDto boardFileDto = new BoardFileDto();
                boardFileDto.setOriginalFileName(originalFileName);
                boardFileDto.setStoredFileName(storedFileName);
                boardFileDto.setBoardId(savedBoard.getId());

                // 파일을 내컴퓨터의 저장용 폴더에 저장
                String savePath = "c:/upload_files/" + storedFileName;
                boardFile.transferTo(new File(savePath));

                // board_file_table DB테이블에 저장
                boardMapper.saveFile(boardFileDto);
            }
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


    public List<BoardFileDto> findFile(Long id) {
        return boardMapper.findFile(id);
    }
}
