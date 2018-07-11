package com.example.demo.service.impl;

import com.example.demo.entity.User;
import com.example.demo.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class Login {
    public User user=new User();
    @Autowired
    UserDao userDao;
    public List<User> list;
    @Autowired
    private UserServiceImpl userServiceImpl=new UserServiceImpl();
    public String login(User user){
        this.user=user;
        this.list=userDao.selectU(this.user.username);
        if(this.list.isEmpty()){
            return "notfound";}
        else if(this.list.get(0).password.equals(this.user.password)){
            return this.list.get(0).identity;}
        else
            return"wrong";
    }
    public void recordusinguser(){
        if(!this.list.isEmpty()){
            list.get(0).useornot="yes";
            userServiceImpl.update(list.get(0));
        }
    }
}
