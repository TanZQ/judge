package com.example.demo.service.impl;

import com.example.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Regist {
    public User user=new User();
    @Autowired
    private UserServiceImpl userServiceImpl=new UserServiceImpl();
    public boolean regist(User user){
        this.user=user;
        this.user.identity="waiting";
        this.user.useornot="no";
        System.out.print(1);
        return userServiceImpl.insert(this.user);

    }
}
