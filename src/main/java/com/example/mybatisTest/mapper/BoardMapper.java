package com.example.mybatisTest.mapper;

import com.example.mybatisTest.dto.BoardDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface BoardMapper {
    void save(@Param("boardDto") BoardDto boardDto);
}
