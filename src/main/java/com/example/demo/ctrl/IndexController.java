package com.example.demo.ctrl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class IndexController {
    
    /*
    필요에 따라서 메서드가 파라미터값을 전달 받을 때
    @PathVariable
    @RequestParam
    XXXXDTO
    full-browsing; json 받을 일이 없음
     */
    @GetMapping("/index.multicampus")
    public String index() {
        System.out.println("debug >>> IndexContorller user endpoint");
        return "index";
    }
    
}
