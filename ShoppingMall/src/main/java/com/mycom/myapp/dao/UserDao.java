package com.mycom.myapp.dao;
import com.mycom.myapp.dto.UserDto;

public interface UserDao {

    int userRegister(UserDto userDto);
    UserDto login(String userEmail);
}