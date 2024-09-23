package com.example.demo.board.ctrl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.board.domain.BoardResponseDTO;
import com.example.demo.board.service.BoardService;

import org.springframework.web.bind.annotation.GetMapping;


@Controller
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private BoardService boardService;
    
    @GetMapping("/list.multicampus")
    public String list(Model model) {
        System.out.println("debug >>> BoardController user endpoint : /board/list.multicampus");
        List<BoardResponseDTO> result = boardService.list();
        System.out.println("debug >>> result size = "+ result.size());
        model.addAttribute("boards", result);
        return "listPage";
    }
}
