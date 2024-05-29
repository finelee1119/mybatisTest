package com.example.mybatisTest.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Getter
@Setter
@ToString
public class BoardFileDto {
    private Long id;
    private Long boardId;
    private String originalFileName;
    private String storedFileName;
}
