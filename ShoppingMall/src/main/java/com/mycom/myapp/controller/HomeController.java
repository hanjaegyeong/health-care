package com.mycom.myapp.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
    @GetMapping(value = "/")
    private String index() {
        return "/index.html";
    }

    @GetMapping(value = "/login")
    private String login() {
        return "/login.html";
    }

    @GetMapping(value = "/register")
    private String register() {
        return "/register.html";
    }

    @GetMapping(value = "/product")
    private String home() {
        return "/product.html";
    }

    @GetMapping(value = "/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "/login.html";
    }
}