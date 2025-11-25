package com.afterlife.reservation;


import io.github.bucket4j.Bucket;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class RateLimitingFilter implements Filter {


    private final Bucket bucket;

    @Autowired
    public RateLimitingFilter(Bucket bucket){
        this.bucket = bucket;
    }
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException{
        if(bucket.tryConsume(1)){
            chain.doFilter(request,response);
        }else {
            ((HttpServletResponse) response).setStatus(429); // too many requests
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException{

    }
    @Override
    public void destroy(){

    }

}
