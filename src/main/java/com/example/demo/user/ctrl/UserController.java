package com.example.demo.user.ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.user.domain.UserRequestDTO;
import com.example.demo.user.domain.UserResponseDTO;
import com.example.demo.user.service.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Map;
import java.util.HashMap;



@Controller
@RequestMapping("/user")
public class UserController {
    
    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/login.multicampus")
    public String login(UserRequestDTO params, HttpSession session) {
        System.out.println("debug >>> UserController user endpoint : /user/login.multicampus");
        System.out.println("debug >>> params : "+ params);
        UserResponseDTO result = userService.login(params);
        System.out.println("debug >>> result : "+result);
        
        if( result != null){
            session.setAttribute("loginUser", result);
            return "landing";
        } else{
            return "redirect:/";
        }
    }

    @GetMapping("/logout.multicampus")
    public String logout(HttpSession session) {
        System.out.println("debug >>> UserController user endpoint : /user/logout.multicampus");
        session.invalidate();
        return "redirect:/";
    }
    
    @GetMapping("/join.multicampus")
    public String joinForm() {
        System.out.println("debug >>> UserController user endpoint get : /user/join.multicampus");
        return "join";
    }
    
    @PostMapping("/join.multicampus")
    public String join(@Valid UserRequestDTO params, BindingResult bindResult, Model model) {
        System.out.println("debug >>> UserController user endpoint post : /user/join.multicampus");
        if(bindResult.hasErrors()){
            System.out.println("debug >>> valid has errors");
            List<ObjectError> list = bindResult.getAllErrors();
            Map<String, String> map = new HashMap<>();
            for(int idx = 0; idx < list.size(); idx++){
                FieldError field = (FieldError)list.get(idx);
                String key = field.getField();
                String msg = field.getDefaultMessage();
                System.out.println(key +"\t"+msg);
                model.addAttribute(key, msg);
            }
            return "join";
        } else {
            System.out.println("debug >>> 유효성 검증 통과");
            // 비밀번호 암호화
            System.out.println("debug >>> 암호화 객체 = " +passwordEncoder);
            System.out.println("debug >>> params = "+ params);
            String encoderPwd = passwordEncoder.encode(params.getPwd());
            System.out.println("encoderPwd = "+encoderPwd);
            params.setPwd(encoderPwd);
            userService.join(params);

            return "redirect:/";

        }
    }
    
}
