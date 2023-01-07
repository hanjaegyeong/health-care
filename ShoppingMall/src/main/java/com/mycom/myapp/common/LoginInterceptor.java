package com.mycom.myapp.common;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.mycom.myapp.dto.UserDto;

//핸들러 보내기전에 로그인 된 사용자인지 체크하고 처리-인터셉터
@Component
public class LoginInterceptor implements HandlerInterceptor{
	@Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		
        HttpSession session = request.getSession();     //세션 확인해서
        UserDto userDto = (UserDto) session.getAttribute("userDto"); //Dto값 없으면
        if( userDto == null ) {
        	response.sendRedirect("/login");            //접속거부
        	return false;
        }

        return true;
    }
}
