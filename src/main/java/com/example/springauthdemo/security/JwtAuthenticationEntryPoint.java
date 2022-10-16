package com.example.springauthdemo.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

//This class is used to return a 401 unauthorized error to clients that try to access a protected resource 
//without proper authentication. It implements Spring Security’s AuthenticationEntryPoint interface.

@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {

    private static final Logger logger = LoggerFactory.getLogger(JwtAuthenticationEntryPoint.class);

    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
            AuthenticationException authException) throws IOException, ServletException {
        logger.error("Responding with unauthorized error. Message - {}", authException.getMessage());
        httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED, authException.getMessage());

    }

}
