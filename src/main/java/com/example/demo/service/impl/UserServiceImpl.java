package com.example.demo.service.impl;

import com.example.demo.dao.UserDao;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> getAllUser()
    {
        return userDao.getAllUser();
    }

    @Override
    public List<User> select(User user)
    {
        return userDao.select(user);
    }

    @Override
    public boolean insert(User user)
    {
        if(userDao.search(user)!= null)
            return false;
        userDao.insert(user);
        return true;
    }

    @Override
    public boolean update(User user)
    {
        if (userDao.search(user) ==null)
            return false;
        userDao.update(user);
        return true;
    }

    @Override
    public boolean delete(User user)
    {
        if (userDao.search(user) ==null)
            return false;
        userDao.delete(user);
        return true;
    }
}
