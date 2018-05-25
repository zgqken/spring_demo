package com.ken.web.config;

import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author：davy(888032)
 * @date：2018/4/23
 * @since
 */
public class TokenAuthenticationProcessFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse
            response, FilterChain filterChain) throws ServletException, IOException {
        System.out.println("do fileter");
        filterChain.doFilter(request, response);
    }

}
