package com.example.demo.service.impl;

import com.example.demo.entity.Correct;
import com.example.demo.entity.User;
import java.util.List;
public class Writer {
    private Correct correct=new Correct();
    private User user=new User();
    private List<User> userlist;
    private CorrectServiceImpl correctServiceImpl=new CorrectServiceImpl();
    private UserServiceImpl userServiceImpl=new UserServiceImpl();
    public List<Correct> proposalsearching(Correct correct){
        List<Correct> correctlist;
        this.correct=correct;
        correctlist=correctServiceImpl.select(this.correct);
        return correctlist;
    }
    public boolean proposalwriting(Correct correct){
        this.correct=correct;
        this.correct.acceptornot="no";
        this.correct.acceptpeople="noone";
        this.user.useornot="yes";
        this.userlist=userServiceImpl.select(this.user);
        this.correct.author=this.userlist.get(0).name;
        return correctServiceImpl.insert(this.correct);
    }
    public User informationmaintenance(){
        this.user.useornot="yes";
        this.userlist=userServiceImpl.select(this.user);
        return this.userlist.get(0);
    }
    public boolean changeinformation(User user){
        return userServiceImpl.update(user);
    }
    public List<Correct> showyourcorrent(){
        Correct correct0=new Correct();
        List<Correct> list0;
        this.user.useornot="yes";
        this.userlist=userServiceImpl.select(this.user);
        correct.author=this.userlist.get(0).name;
        list0=correctServiceImpl.select(correct);
        return list0;
    }
    public boolean update(Correct correct){
        return correctServiceImpl.update(correct);
    }
    public boolean delete(Correct correct){
        return correctServiceImpl.delete(correct);
    }
}
