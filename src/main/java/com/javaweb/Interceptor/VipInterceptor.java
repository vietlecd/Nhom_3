package com.javaweb.Interceptor;

import com.javaweb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class VipInterceptor extends HandlerInterceptorAdapter {
    @Autowired
    UserRepository userRepository;
}
