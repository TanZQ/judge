package com.example.demo.service.impl;

import com.example.demo.entity.Correct;
import com.example.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.dao.CorrectDao;
import javax.swing.plaf.synth.SynthEditorPaneUI;
import java.util.ArrayList;
import java.util.Date;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.List;
@Service
public class Writer {
    private Correct correct=new Correct();
    private User user=new User();
    private List<User> userlist;
    @Autowired
    private CorrectServiceImpl correctServiceImpl=new CorrectServiceImpl();
    @Autowired
    private UserServiceImpl userServiceImpl=new UserServiceImpl();
    @Autowired
    private CorrectDao correctDao;
    public List<Correct> proposalsearching(Correct correct){
        List<Correct> correctlist;
        this.correct=correct;
        correctlist=correctServiceImpl.select(this.correct);
        return correctlist;
    }
    public boolean proposalwriting_Tian(Correct correct){
        Date now = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String hehe = dateFormat.format( now );
        this.correct=correct;
        this.correct.date=hehe;
        this.correct.acceptornot="no";
        this.correct.acceptpeople="noone";
        this.user.useornot="yes";
        this.correct.type="Tian";
        this.userlist=userServiceImpl.select(this.user);
        this.correct.author=this.userlist.get(0).name;
        return correctServiceImpl.insert(this.correct);
    }
    public boolean proposalwriting_Guifan(Correct correct){
        Date now = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String hehe = dateFormat.format( now );
        this.correct=correct;
        this.correct.date=hehe;
        this.correct.acceptornot="no";
        this.correct.acceptpeople="noone";
        this.user.useornot="yes";
        this.correct.type="Guifan";
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
    public List<Correct> showyourTian(){
        Correct correct0=new Correct();
        List<Correct> list0=new ArrayList<Correct>();
        List<Correct> list1=new ArrayList<Correct>();
        List<Correct> list2=new ArrayList<Correct>();
        this.user.useornot="yes";
        this.userlist=userServiceImpl.select(this.user);
        correct0.author=this.userlist.get(0).name;
        correct0.type="Tian";
        list1=correctDao.selectA(correct0.author);
        for(int i=0;i<list1.size();i++) {
            if(list1.get(i).type.equals("Tian"))
                list2.add(list1.get(i));
        }
        list0=list2;
        return list0;
    }
    public List<Correct> showyourGuifan(){
        Correct correct0=new Correct();
        List<Correct> list0=new ArrayList<Correct>();
        List<Correct> list1=new ArrayList<Correct>();
        List<Correct> list2=new ArrayList<Correct>();
        this.user.useornot="yes";
        this.userlist=userServiceImpl.select(this.user);
        correct0.author=this.userlist.get(0).name;
        correct0.type="Guifan";
        list1=correctDao.selectA(correct0.author);
        for(int i=0;i<list1.size();i++) {
            if(list1.get(i).type.equals("Guifan"))
                list2.add(list1.get(i));
        }
        list0=list2;
        return list0;
    }
    public boolean update(Correct correct){
        return correctServiceImpl.update(correct);
    }
    public boolean delete(Correct correct){
        return correctServiceImpl.delete(correct);
    }
}
