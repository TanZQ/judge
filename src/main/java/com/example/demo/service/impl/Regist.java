package com.example.demo.service.impl;

import com.example.demo.entity.User;
import com.example.demo.service.impl.UserServiceImpl;
public class Regist {
    public User user=new User();
    public UserServiceImpl userServiceImpl;
    public boolean regist(User user){
        this.user=user;
        this.user.identity="waiting";
        this.user.useornot="no";
        boolean success=userServiceImpl.insert(this.user);
        return success;
    }
}
