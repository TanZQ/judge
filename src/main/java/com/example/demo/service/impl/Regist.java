package com.example.demo.service.impl;

import com.example.demo.entity.User;
public class Regist {
    public User user=new User();
    private UserServiceImpl userServiceImpl=new UserServiceImpl();
    public boolean regist(User user){
        this.user=user;
        this.user.identity="waiting";
        this.user.useornot="no";
        return userServiceImpl.insert(this.user);
    }
}
