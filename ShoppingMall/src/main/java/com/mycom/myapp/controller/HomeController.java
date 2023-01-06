package com.mycom.myapp.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@CrossOrigin( //CORS해결위해
        // localhost:5500 과 127.0.0.1 구분
        origins = "http://127.0.0.1:5500", // allowCredentials = "true" 일 경우, orogins="*" 는 X
        allowCredentials = "true",
        allowedHeaders = "*",
        methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT,RequestMethod.HEAD,RequestMethod.OPTIONS}
)
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

        session.invalidate(); //세션 삭제
        return "/login.html";
    }
}
