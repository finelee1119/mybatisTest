package com.example.mybatisTest.mapper;

import com.example.mybatisTest.dto.BoardDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BoardMapper {
    Long save(@Param("boardDto") BoardDto boardDto);

    List<BoardDto> findAll();

    BoardDto findById(@Param("id") Long id);

    void boardHitsUpdate(@Param("id") Long id);

    void update(@Param("boardDto") BoardDto boardDto);

    void deleteById(@Param("id") Long id);

}
