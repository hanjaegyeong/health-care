package com.mycom.myapp.controller;

import com.mycom.myapp.dto.UserDto;
import com.mycom.myapp.dto.UserResultDto;
import com.mycom.myapp.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping(value="/register")
    public Map<String, String> register(UserDto dto){

        UserResultDto userResultDto = userService.userRegister(dto);

        Map<String, String> map = new HashMap<>();
        if( userResultDto.getResult() == 1 ) {
            map.put("result", "success");
        }else {
            map.put("result", "fail");
        }

        return map;
    }

    @PostMapping(value="/login")
    public Map<String, String> login(UserDto dto, HttpSession session){

        UserDto userDto = userService.login(dto);
        Map<String, String> map = new HashMap<>();
        if( userDto != null ) {
            session.setAttribute("userDto", userDto);
            map.put("userName", userDto.getUserName());
            map.put("userProfileImageUrl", userDto.getUserProfileImageUrl());
            map.put("result", "success");
        }else {
            map.put("result", "fail");
        }

        return map;
    }

}