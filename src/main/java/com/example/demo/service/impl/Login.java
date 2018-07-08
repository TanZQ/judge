package com.example.demo.service.impl;

import com.example.demo.entity.User;
import java.util.List;
public class Login {
    public User user=new User();
    public List<User> list;
    private UserServiceImpl userServiceImpl=new UserServiceImpl();
    public String login(User user){
        this.user=user;
        this.list=userServiceImpl.select(this.user);
        if(this.list.get(0)==null)
            return "notfound";
        return list.get(0).identity;
    }
    public void recordusinguser(){
        list.get(0).useornot="yes";
        userServiceImpl.update(list.get(0));
    }
}
