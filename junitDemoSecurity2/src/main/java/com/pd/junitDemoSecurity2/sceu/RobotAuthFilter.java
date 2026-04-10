package com.pd.junitDemoSecurity2.sceu;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Collections;
import java.util.Objects;

public class RobotAuthFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // 1. decide whether we want  to apply filter

        if (!Collections.list(request.getHeaderNames()).contains("x-robot-secret")){
        filterChain.doFilter(request,response);
        return;
        }

        //2. check credentials and auth
        if(!Objects.equals(request.getHeader("x-robot-secret"), "abc")){
            //reject
            response.setStatus(HttpStatus.FORBIDDEN.value());
            response.getWriter().write("---Not allowed---");
            return;
        }

        var roboAuth = new RobotAuthToken();
        var newContext = SecurityContextHolder.createEmptyContext();
        newContext.setAuthentication(roboAuth);
        SecurityContextHolder.setContext(newContext);


        //3. call next
        filterChain.doFilter(request,response);
    }
}
