package com.example.demo.service.impl;

import com.example.demo.entity.User;
import java.util.List;
public class Logoff {
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
