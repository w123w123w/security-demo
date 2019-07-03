package com.wulianfa.securitydemo;

import com.wulianfa.securitydemo.entity.UserDO;
import com.wulianfa.securitydemo.repository.UserRepository;
import com.wulianfa.securitydemo.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SecurityDemoApplicationTests {

    @Autowired
    UserRepository userRepository;
    @Autowired
    UserService userService;

    @Test
    public void contextLoads() {

    }

}
