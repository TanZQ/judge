package com.example.demo.service.impl;

import com.example.demo.entity.Correct;
import com.example.demo.service.impl.CorrectServiceImpl;
import com.example.demo.entity.User;
import com.example.demo.service.impl.UserServiceImpl;
import java.util.List;
public class Writer {
    public Correct correct=new Correct();
    public User user=new User();
    public List<Correct> correctlist;
    public List<User> userlist;
    public CorrectServiceImpl correctServiceImpl;
    public UserServiceImpl userServiceImpl;
    public List<Correct> proposalsearching(Correct correct){
        this.correct=correct;
        this.correctlist=correctServiceImpl.select(this.correct);
        return this.correctlist;
    }
    public boolean proposalwriting(Correct correct){
        this.correct=correct;
        this.correct.acceptornot="no";
        this.correct.acceptpeople="noone";
        this.user.useornot="yes";
        this.userlist=userServiceImpl.select(this.user);
        this.correct.author=this.userlist.get(0).name;
        boolean success=correctServiceImpl.insert(this.correct);
        return success;
    }
    public User informationmaintenance(){
        this.user.useornot="yes";
        this.userlist=userServiceImpl.select(this.user);
        return this.userlist.get(0);
    }
    public boolean changeinformation(User user){
        boolean success=userServiceImpl.update(user);
        return success;
    }
}
