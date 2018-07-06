package com.example.demo.service.impl;

import com.example.demo.entity.User;
import com.example.demo.dao.UserDAO;
public class Regist {
    public User user;
    public UserDAO userDAO;
    public boolean regist(User user){
        this.user=user;
        this.user.identity="waiting";
        boolean success=userDAO.insert(this.user);
        return success;
    }
}
