package com.example.demo.service.impl;

import com.example.demo.dao.UserDao;
import com.example.demo.entity.User;
import com.example.demo.dao.UserDAO;
import java.util.List;
public class Login {
    public User user;
    public List<User> list;
    public UserDao userDAO;
    public String login(User user){
        this.user=user;
        this.list=userDAO.select(this.user);
        return list.get(0).identity;
    }
    public void recordusinguser(){
        list.get(0).useornot="yes";
        userDAO.update(list.get(0));
    }
}
