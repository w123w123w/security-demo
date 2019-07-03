package com.wulianfa.securitydemo.controller;

import com.wulianfa.securitydemo.bean.WebResponse;
import com.wulianfa.securitydemo.entity.UserDO;
import com.wulianfa.securitydemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public WebResponse doRegister(@RequestBody UserDO userDO){
        String encode = new BCryptPasswordEncoder().encode(userDO.getPassword());
        userDO.setPassword(encode);
        userService.insert(userDO);
        return WebResponse.success("注册成功");
    }

}
