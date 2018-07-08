package com.example.demo.service.impl;
import com.example.demo.entity.Correct;
import com.example.demo.entity.User;
import java.util.List;
public class Ruler {
    private User waiting=new User();
    private User writer=new User();
    private User user=new User();
    private Correct tian=new Correct();
    private Correct guifan=new Correct();
    private UserServiceImpl userServiceImpl=new UserServiceImpl();
    private CorrectServiceImpl correctServiceImpl=new CorrectServiceImpl();
    private List<Correct> correctlist;
    public List<User> identitymanagement_waiting(){
        List<User> listwaiting;
        this.waiting.identity="waiting";
        listwaiting=userServiceImpl.select(this.waiting);
        return listwaiting;
    }
    public List<User> identitymanagement_writer(){
        List<User> listwriter;
        this.writer.identity="writer";
        listwriter=userServiceImpl.select(this.writer);
        return listwriter;
    }
    public List<Correct> proposalmanagement_tian(){
        List<Correct> listtian;
        this.tian.type="tian";
        listtian=correctServiceImpl.select(this.tian);
        return listtian;
    }
    public List<Correct> proposalmanagement_guifann(){
        List<Correct> listguifan;
        this.guifan.type="guifan";
        listguifan=correctServiceImpl.select(this.guifan);
        return listguifan;
    }
    public boolean update(User user){
        if(user.identity.equals("waiting"))
            user.identity="writer";
        else if(user.identity.equals("writer"))
            user.identity="manager";
        return userServiceImpl.update(user);
    }
    public boolean update(Correct correct){
        User user1=new User();
        List<User> list;
        user1.useornot="yes";
        list=userServiceImpl.select(user1);
        correct.acceptpeople=list.get(0).name;
        return correctServiceImpl.update(correct);
    }
    public boolean delete(User user){
        return userServiceImpl.delete(user);
    }
    public boolean delete(Correct correct){
        return correctServiceImpl.delete(correct);
    }
    public boolean proposalwriting(Correct correct){
        Correct correct1;
        List<User> userlist;
        this.user.useornot="yes";
        userlist=userServiceImpl.select(this.user);
        correct1=correct;
        correct1.acceptornot="no";
        correct1.acceptpeople="noone";
        correct1.author=userlist.get(0).name;
        return correctServiceImpl.insert(correct1);
    }
}
