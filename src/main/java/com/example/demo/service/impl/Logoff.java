package com.example.demo.service.impl;

import com.example.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class Logoff {
    @Autowired
    private UserServiceImpl userServiceImpl=new UserServiceImpl();
    public List<User> list;
    public void logoff(){
        User user=new User();
        user.useornot="yes";
        this.list=userServiceImpl.select(user);
        this.list.get(0).useornot="no";

        userServiceImpl.update(list.get(0));
    }
}
