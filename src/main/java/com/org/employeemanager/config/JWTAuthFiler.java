package com.org.employeemanager.config;


import com.org.employeemanager.helper.JWTUtilHelper;
import com.org.employeemanager.service.CustomUserdetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JWTAuthFiler extends OncePerRequestFilter {

    @Autowired
    private JWTUtilHelper jwtUtilHelper;

    @Autowired
    private CustomUserdetailsService customUserdetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
            String requestTokeHeader=httpServletRequest.getHeader("Authorization");
            String jwtToken=null;
            if(null!=requestTokeHeader && requestTokeHeader.startsWith("Bearer")){
                jwtToken=requestTokeHeader.substring(7);
                try {
                    String username = jwtUtilHelper.extractUsername(jwtToken);
                    if(username!=null && SecurityContextHolder.getContext().getAuthentication()==null){
                        UserDetails  userDetails =customUserdetailsService.loadUserByUsername(username);
                        UsernamePasswordAuthenticationToken authoToken=new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
                        authoToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));
                        SecurityContextHolder.getContext().setAuthentication(authoToken);
                    }else{

                    }
                }catch (Exception exception){
                        exception.printStackTrace();
                }
            }
            filterChain.doFilter(httpServletRequest,httpServletResponse);
    }
}
