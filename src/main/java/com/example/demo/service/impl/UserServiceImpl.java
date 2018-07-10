package com.example.demo.service.impl;

import com.example.demo.dao.UserDao;
import com.example.demo.entity.Correct;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        List<User> list=new ArrayList<User>();
        L1=list;
        L2=list;
        int a=0;

        if(userDao.selectU(user.username).size()!=0)
        {
            L1 = userDao.selectU(user.username);
            a = 1;
        }

        if(userDao.selectP(user.password).size()!=0)
        {
            if (a==1)
            {
                L2 = userDao.selectP(user.password);
                L1.retainAll(L2);
                L2=null;
            }
            else
            {
                L1=userDao.selectP(user.password);
                a=1;
            }
        }

        if(userDao.selectN(user.name).size()!=0)
        {
            if (a==1)
            {
                L2 = userDao.selectN(user.name);
                L1.retainAll(L2);
                L2 = null;
            }
            else
            {
                L1=userDao.selectN(user.name);
                a=1;
            }
        }

        if(userDao.selectS(user.sex).size()!=0)
        {
            if (a==1)
            {
                L2 = userDao.selectS(user.sex);
                L1.retainAll(L2);
                L2=null;
            }
            else
            {
                L1=userDao.selectS(user.sex);
                a=1;
            }
        }

        if(userDao.selectD(user.dateofbirth).size()!=0)
        {
            if (a==1)
            {
                L2 = userDao.selectD(user.dateofbirth);
                L1.retainAll(L2);
                L2=null;
            }
            else
            {
                L1=userDao.selectD(user.dateofbirth);
                a=1;
            }
        }

        if(userDao.selectA(user.address).size()!=0)
        {
            if (a==1)
            {
                L2 = userDao.selectA(user.address);
                L1.retainAll(L2);
                L2=null;
            }
            else
            {
                L1=userDao.selectA(user.address);
                a=1;
            }
        }

        if(userDao.selectPN(user.phoneno).size()!=0)
        {
            if (a==1)
            {
                L2 = userDao.selectPN(user.phoneno);
                L1.retainAll(L2);
                L2=null;
            }
            else
            {
                L1=userDao.selectPN(user.phoneno);
                a=1;
            }
        }

        if(userDao.selectL(user.leader).size()!=0)
        {
            if (a==1)
            {
                L2 = userDao.selectL(user.leader);
                L1.retainAll(L2);
                L2=null;
            }
            else
            {
                L1=userDao.selectL(user.leader);
                a=1;
            }
        }

        if(userDao.selectC(user.community).size()!=0)
        {
            if (a==1)
            {
                L2 = userDao.selectC(user.community);
                L1.retainAll(L2);
                L2=null;
            }
            else
            {
                L1=userDao.selectC(user.community);
                a=1;
            }
        }

        if(userDao.selectCO(user.company).size()!=0)
        {
            if (a==1)
            {
                L2 = userDao.selectCO(user.company);
                L1.retainAll(L2);
                L2=null;
            }
            else
            {
                L1=userDao.selectCO(user.company);
                a=1;
            }
        }

        if(userDao.selectI(user.identity).size()!=0)
        {
            if (a==1)
            {
                L2 = userDao.selectI(user.identity);
                L1.retainAll(L2);
                L2=null;
            }
            else
            {
                L1=userDao.selectI(user.identity);
                a=1;
            }
        }

        if(userDao.selectUN(user.useornot).size()!=0)
        {
            if (a==1)
            {
                L2 = userDao.selectUN(user.useornot);
                L1.retainAll(L2);
                L2=null;
            }
            else
            {
                L1=userDao.selectUN(user.useornot);
                a=1;
            }
        }
        return L1;
    }

    @Override
    public boolean insert(User user)
    {
        if(userDao.search(user).size()!= 0)
            return false;
        userDao.insert(user);
        return true;
    }

    @Override
    public boolean update(User user)
    {
        if (userDao.search(user).size() ==0)
            return false;
        userDao.update(user);
        return true;
    }

    @Override
    public boolean delete(User user)
    {
        if (userDao.search(user).size() ==0)
            return false;
        userDao.delete(user.username);
        return true;
    }
}
