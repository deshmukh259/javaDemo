package com.pd.junitDemoSecurity2.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Objects;

public class ProhabitFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        System.out.println("Heelllo fitler world");

        if (Objects.equals(request.getHeader("x-prohibido"), "si")){
            response.setStatus(HttpStatus.FORBIDDEN.value());
            response.getWriter().write("---PROHABITED---");
        return;
        }

        filterChain.doFilter(request,response);

    }
}
