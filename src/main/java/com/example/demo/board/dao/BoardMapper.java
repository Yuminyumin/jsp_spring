package com.example.demo.board.dao;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.board.domain.BoardResponseDTO;

import java.util.List;

@Mapper
public interface BoardMapper {

    public List<BoardResponseDTO> listRow();
}
