package com.mycom.myapp.dao;
import com.mycom.myapp.dto.UserDto;
import org.springframework.stereotype.Repository;


public interface UserDao {

    int userRegister(UserDto userDto);
    UserDto login(String userEmail);
}