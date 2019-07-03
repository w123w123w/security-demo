package com.wulianfa.securitydemo.config;

import com.alibaba.fastjson.JSON;
import com.wulianfa.securitydemo.bean.WebResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * 认证入口（未登录状态）
 */
@Slf4j
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        log.info("===>not logged in！");

        httpServletResponse.setStatus(HttpServletResponse.SC_OK);
        httpServletResponse.setContentType(MediaType.APPLICATION_JSON_VALUE);
        httpServletResponse.setCharacterEncoding(StandardCharsets.UTF_8.toString());
        //方式一：返回JSON数据告知未登录
        //WebResponse response = new WebResponse();
        //response.setCode(String.valueOf(HttpServletResponse.SC_UNAUTHORIZED));
        //response.setMessage("authenticate fail!");
        //httpServletResponse.getWriter().write(JSON.toJSONString(response));
        //方式二：重定向登录页
        httpServletResponse.sendRedirect("/login");
    }

}
