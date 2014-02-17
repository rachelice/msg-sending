package com.sunshineroad.system.security.service.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

/**
 * omplatformNew
 * com.sunshineroad.system.security.service.impl
 * @{#} AuthenticationHandler.java Create on  2013-6-13 上午5:10:30
 * 
 * Copyright (c) 2013 by 阳光道路.
 * @author <a href="mailto:371917461@qq.com">张光明</a>
 * @version 1.0
 * 功能说明：用户登陆状态验证
 *
 */

public class AuthenticationHandler implements AuthenticationSuccessHandler, AuthenticationFailureHandler
{

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication auth) throws IOException, ServletException
    {
        response.getWriter().println("{\"success\" : true}");
        clearAuthenticationAttributes(request);
    }

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException auth) throws IOException, ServletException
    {
        response.getWriter().println("{\"success\" : false, \"msg\" : \"" + auth.getMessage() + "\"}");
        System.out.println(auth.getMessage());
    }
   
    /*
     * Removes temporary authentication-related data which may have been stored in the session
     * during the authentication process.
     */
    
    protected final void clearAuthenticationAttributes(HttpServletRequest request)
    {
        HttpSession session = request.getSession(false);

        if(session == null)
        {
            return;
        }

        session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
    }

}
