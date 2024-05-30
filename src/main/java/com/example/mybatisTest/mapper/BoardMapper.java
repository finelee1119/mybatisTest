package com.example.mybatisTest.mapper;

import com.example.mybatisTest.dto.BoardDto;
import com.example.mybatisTest.dto.BoardFileDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BoardMapper {
    void save(@Param("boardDto") BoardDto boardDto);

    List<BoardDto> findAll();

    BoardDto findById(@Param("id") Long id);

    void boardHitsUpdate(@Param("id") Long id);

    void update(@Param("boardDto") BoardDto boardDto);

    void deleteById(@Param("id") Long id);

    void saveFile(@Param("boardFile") BoardFileDto boardFileDto);

    List<BoardFileDto> findFile(@Param("id") Long id);
}
