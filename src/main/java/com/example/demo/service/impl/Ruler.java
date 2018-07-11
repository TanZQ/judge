package com.example.demo.service.impl;
import com.example.demo.entity.Correct;
import com.example.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.dao.UserDao;
import com.example.demo.dao.CorrectDao;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Service
public class Ruler {
    private User waiting=new User();
    private User writer=new User();
    private User user=new User();
    private Correct tian=new Correct();
    private Correct guifan=new Correct();
    @Autowired
    private UserServiceImpl userServiceImpl=new UserServiceImpl();
    @Autowired
    private CorrectServiceImpl correctServiceImpl=new CorrectServiceImpl();
    @Autowired
    UserDao userDao;
    @Autowired
    CorrectDao correctDao;
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
    public List<Correct> proposalmanagement_tian_yes(){
        List<Correct> listtian=new ArrayList<Correct>();
        List<Correct> listtian2=new ArrayList<Correct>();
        this.tian.type="Tian";
        this.tian.acceptornot="yes";
        listtian=correctDao.selectT(this.tian.type);
        for(int i=0;i<listtian.size();i++){ ;
            if(listtian.get(i).acceptornot.equals(this.tian.acceptornot)) {
                listtian2.add(listtian.get(i));
            }
        }
        return listtian2;
    }
    public List<Correct> proposalmanagement_tian_no(){
        List<Correct> listtian=new ArrayList<Correct>();
        List<Correct> listtian2=new ArrayList<Correct>();
        this.tian.type="Tian";
        this.tian.acceptornot="no";
        listtian=correctDao.selectT(this.tian.type);
        for(int i=0;i<listtian.size();i++){
            if(listtian.get(i).acceptornot.equals(this.tian.acceptornot)){
                listtian2.add(listtian.get(i));
            }
        }
        return listtian2;
    }
    public List<Correct> proposalmanagement_guifan_no(){
        List<Correct> listguifan=new ArrayList<Correct>();
        List<Correct> listguifan2=new ArrayList<Correct>();
        this.guifan.type="Guifan";
        this.guifan.acceptornot="no";
        listguifan=correctDao.selectT(this.guifan.type);
        for(int i=0;i<listguifan.size();i++){
            if(listguifan.get(i).acceptornot.equals(this.guifan.acceptornot)){
                listguifan2.add(listguifan.get(i));
            }

        }
        return listguifan2;
    }
    public List<Correct> proposalmanagement_guifan_yes(){
        List<Correct> listguifan=new ArrayList<Correct>();
        List<Correct> listguifan2=new ArrayList<Correct>();
        this.guifan.type="Guifan";
        this.guifan.acceptornot="yes";
        listguifan=correctDao.selectT(this.guifan.type);
        for(int i=0;i<listguifan.size();i++){
            if(listguifan.get(i).acceptornot.equals(this.guifan.acceptornot)){
                listguifan2.add(listguifan.get(i));
            }

        }
        return listguifan2;
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
    public boolean proposalwriting_Tian(Correct correct){
        Date now = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String hehe = dateFormat.format( now );
        List<User> userlist;
        this.user.useornot="yes";
        userlist=userDao.selectUN(this.user.useornot);
        Correct correct1;
        correct1=correct;
        correct1.date=hehe;
        correct1.acceptornot="yes";
        correct1.acceptpeople=userlist.get(0).name;
        correct1.type="Tian";
        correct1.author=userlist.get(0).name;
        return correctServiceImpl.insert(correct1);
    }
    public boolean proposalwriting_Guifan(Correct correct){
        Date now = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String hehe = dateFormat.format( now );
        List<User> userlist;
        this.user.useornot="yes";
        userlist=userDao.selectUN(this.user.useornot);
        Correct correct1;
        correct1=correct;
        correct1.date=hehe;
        correct1.acceptornot="yes";
        correct1.acceptpeople=userlist.get(0).name;
        correct1.type="Guifan";
        correct1.author=userlist.get(0).name;
        return correctServiceImpl.insert(correct1);
    }
}
