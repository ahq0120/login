package com.example.login.controller;

import com.example.login.service.MemberService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

@Controller
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }

    @GetMapping("/register")
    public String showRegisterPage(){
        return "register";
    }

    @PostMapping("/register")
    public String register(@RequestParam String username,
                           @RequestParam String password,
                           @RequestParam String email){
        memberService.register(username, password, email);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }


    @GetMapping("/home")
    public String home(Model model, Authentication authentication) {
        // authentication.getName() 就是剛剛登入的 username
        String username = authentication.getName();
        model.addAttribute("username", username);
        return "home";
    }
}
