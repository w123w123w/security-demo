package com.wulianfa.securitydemo.controller;

import com.wulianfa.securitydemo.bean.WebResponse;
import com.wulianfa.securitydemo.entity.UserDO;
import com.wulianfa.securitydemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @Autowired
    private UserService userService;

    @GetMapping("/index")
    @ResponseBody
    public String main(){
        return "这是首页";
    }

    @PostMapping("/register")
    @ResponseBody
    public WebResponse doRegister(@RequestBody UserDO userDO){
        String encode = new BCryptPasswordEncoder().encode(userDO.getPassword());
        userDO.setPassword(encode);
        userService.insert(userDO);
        return WebResponse.success("注册成功");
    }

    @RequestMapping("/loginPage")
    public ModelAndView doLogin(){
        return new ModelAndView("login");
    }

}
