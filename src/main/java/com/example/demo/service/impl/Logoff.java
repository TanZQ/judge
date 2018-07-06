package com.example.demo.service.impl;

import com.example.demo.entity.User;
import com.example.demo.dao.UserDAO;
import java.util.List;
public class Logoff {
    public UserDAO userDAO;
    public List<User> list;
    public void logoff(){
        User user=new User();
        user.useornot="yes";
        list=userDAO.select(user);
        list.get(0).useornot="no";

        userDAO.update(list.get(0));
    }
}
