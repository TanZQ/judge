package com.example.demo.service.impl;
import com.example.demo.entity.Correct;
import com.example.demo.service.impl.CorrectServiceImpl;
import com.example.demo.entity.User;
import com.example.demo.service.impl.UserServiceImpl;
import java.util.List;
public class Ruler {
    public User waiting=new User();
    public User writer=new User();
    public Correct tian=new Correct();
    public Correct guifan=new Correct();
    public UserServiceImpl userServiceImpl;
    public CorrectServiceImpl correctServiceImpl;
    List<User> listwaiting;
    List<User> listwriter;
    List<Correct> listtian;
    List<Correct> listguifan;
    public List<User> identitymanagement_waiting(){
        this.waiting.identity="waiting";
        this.listwaiting=userServiceImpl.select(this.waiting);
        return this.listwaiting;
    }
    public List<User> identitymanagement_writer(){
        this.writer.identity="writer";
        this.listwriter=userServiceImpl.select(this.writer);
        return this.listwriter;
    }
    public List<Correct> proposalmanagement_tian(){
        this.tian.type="tian";
        this.listtian=correctServiceImpl.select(this.tian);
        return this.listtian;
    }
    public List<Correct> proposalmanagement_guifann(){
        this.guifan.type="guifan";
        this.listguifan=correctServiceImpl.select(this.guifan);
        return this.listguifan;
    }
    public boolean update(User user){
        if(user.identity=="waiting")
            user.identity="writer";
        else if(user.identity=="writer")
            user.identity="manager";
        boolean success=userServiceImpl.update(user);
        return success;
    }
    public boolean update(Correct correct){
        User user1=new User();
        List<User> list;
        user1.useornot="yes";
        list=userServiceImpl.select(user1);
        correct.acceptpeople=list.get(0).name;
        boolean success=correctServiceImpl.update(correct);
        return success;
    }
    public boolean delete(User user){
        boolean success=userServiceImpl.delete(user);
        return success;
    }
    public boolean delete(Correct correct){
        boolean success=correctServiceImpl.delete(correct);
        return success;
    }
}
