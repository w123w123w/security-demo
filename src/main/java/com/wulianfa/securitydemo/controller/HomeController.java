package com.wulianfa.securitydemo.controller;

import com.wulianfa.securitydemo.bean.WebResponse;
import com.wulianfa.securitydemo.entity.UserDO;
import com.wulianfa.securitydemo.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class HomeController {

    private final UserService userService;

    @PostMapping("/register")
    public WebResponse doRegister(@RequestBody UserDO userDO){
        // 此处省略校验逻辑
        userService.insert(userDO);
        return WebResponse.success("注册成功");
    }

}
