package com.wulianfa.securitydemo.service.impl;

import com.wulianfa.securitydemo.entity.UserDO;
import com.wulianfa.securitydemo.repository.UserRepository;
import com.wulianfa.securitydemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BaseUserService implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void insert(UserDO userDO) {
        String username = userDO.getUsername();
        if (exist(username)){
            throw new RuntimeException("用户名已存在！");
        }
       userRepository.save(userDO);
    }

    @Override
    public UserDO getByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    /**
     * 判断用户是否存在
     */
    private boolean exist(String username){
        UserDO userDO = userRepository.findByUsername(username);
        return (userDO != null);
    }

}
