package com.example.mybatisTest.mapper;

import com.example.mybatisTest.dto.BoardDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BoardMapper {
    void save(@Param("boardDto") BoardDto boardDto);

    List<BoardDto> findAll();

    BoardDto findById(@Param("id") int id);

    void boardHitsUpdate(@Param("id") int id);





}
