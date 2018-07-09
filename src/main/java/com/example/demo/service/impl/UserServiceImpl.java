package com.example.demo.service.impl;

import com.example.demo.dao.UserDao;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;
    private List<User> L1,L2;

    @Override
    public List<User> getAllUser()
    {
        return userDao.getAllUser();
    }

    @Override
    public List<User> select(User user)
    {
        if(userDao.select(user.username)!=null)
            L1=userDao.select(user.username);
        if(userDao.select(user.password)!=null)
        {
            L2 = userDao.select(user.password);
            L1.retainAll(L2);
            L2=null;
        }
        if(userDao.select(user.name)!=null)
        {
            L2 = userDao.select(user.name);
            L1.retainAll(L2);
            L2=null;
        }
        if(userDao.select(user.sex)!=null)
        {
            L2 = userDao.select(user.sex);
            L1.retainAll(L2);
            L2=null;
        }
        if(userDao.select(user.dateofbirth)!=null)
        {
            L2 = userDao.select(user.dateofbirth);
            L1.retainAll(L2);
            L2=null;
        }
        if(userDao.select(user.phoneno)!=null)
        {
            L2 = userDao.select(user.phoneno);
            L1.retainAll(L2);
            L2=null;
        }
        if(userDao.select(user.leader)!=null)
        {
            L2 = userDao.select(user.leader);
            L1.retainAll(L2);
            L2=null;
        }
        if(userDao.select(user.community)!=null)
        {
            L2 = userDao.select(user.community);
            L1.retainAll(L2);
            L2=null;
        }
        if(userDao.select(user.company)!=null)
        {
            L2 = userDao.select(user.company);
            L1.retainAll(L2);
            L2=null;
        }
        if(userDao.select(user.identity)!=null)
        {
            L2 = userDao.select(user.identity);
            L1.retainAll(L2);
            L2=null;
        }
        if(userDao.select(user.useornot)!=null)
        {
            L2 = userDao.select(user.useornot);
            L1.retainAll(L2);
            L2=null;
        }
        return L1;
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
