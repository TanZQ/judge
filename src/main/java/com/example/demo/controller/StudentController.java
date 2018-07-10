package com.example.demo.controller;

import com.example.demo.service.impl.Ruler;
import com.example.demo.service.impl.Writer;
import com.example.demo.service.impl.Regist;
import com.example.demo.service.impl.Login;
import com.example.demo.entity.Correct;
import com.example.demo.dao.CorrectDao;
import com.example.demo.dao.UserDao;
import com.example.demo.entity.User;
import com.example.demo.service.CorrectService;
import com.example.demo.service.impl.CorrectServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
* @description 
* @author Tim Lin
* @create 2018-07-01 
**/
@Controller
public class StudentController {

    @Autowired
    private CorrectServiceImpl correctServiceImpl;
    @Autowired
    private Writer writer;
    @Autowired
    private Ruler ruler;
    @Autowired
    private Regist regist;
    @Autowired
    private CorrectDao correctDao;
    @Autowired
    private Login login;
    @Autowired
    private UserDao userDao;
    private String judge;

    @RequestMapping(value = "/stu/getAllStudent",method = RequestMethod.GET)
    public String getAllStudent(HttpServletRequest request){
        return "student";
    }
    @RequestMapping(value = "/stu/getAllStudent",method = RequestMethod.POST)
    public String register(HttpServletRequest request){
        User user=new User();
        user.username=request.getParameter("username");
        user.password=request.getParameter("password");
        user.name=request.getParameter("name");
        user.sex=request.getParameter("sex");
        user.dateofbirth=request.getParameter("dateofbirth");
        user.phoneno=request.getParameter("phoneno");
        user.address=request.getParameter("address");
        user.leader=request.getParameter("leader");
        user.community=request.getParameter("community");
        user.company=request.getParameter("company");
        regist.regist(user);
        return "student";
    }
   /* @RequestMapping(value = "/stu/getAllStudent",method = RequestMethod.POST)
    public String login(HttpServletRequest request){
        User user=new User();
        user.username=request.getParameter("uname");
        user.password=request.getParameter("password");
        judge=login.login(user);
        return "stu/judge";
    }*/
    @RequestMapping(value = "/stu/writerTian",method = RequestMethod.GET)
    public String writerTian(HttpServletRequest request){
        Correct correct=new Correct();
        correct.type="Tian";
        //List<Correct> list = correctServiceImpl.select(correct);
        List<Correct> list = correctDao.selectT(correct.type);
        request.setAttribute("students",list);
        return "writerTian";
    }
    @RequestMapping(value = "/stu/writerTian",method = RequestMethod.POST)
    public String addTian(HttpServletRequest request){
        Correct correct = new Correct();
        correct.Tname=request.getParameter("Tname");
        correct.text=request.getParameter("text");
        writer.proposalwriting_Tian(correct);
        return "redirect:/stu/writerTian";
    }
    @RequestMapping(value = "/stu/writerGuifan",method = RequestMethod.GET)
    public String writerGuifan(HttpServletRequest request){
        Correct correct=new Correct();
        correct.type="Guifan";
        List<Correct> list = correctDao.selectT(correct.type);
        request.setAttribute("students",list);
        return "writerGuifan";
    }
    @RequestMapping(value = "/stu/writerGuifan",method = RequestMethod.POST)
    public String addGuifan(HttpServletRequest request){
        Correct correct = new Correct();
        correct.Tname=request.getParameter("Tname");
        correct.text=request.getParameter("text");
        writer.proposalwriting_Guifan(correct);
        return "redirect:/stu/writerGuifan";
    }
    @RequestMapping(value = "/stu/writerTianChange",method = RequestMethod.GET)
    public String writerTianChange(HttpServletRequest request){
        List<Correct> list = writer.showyourTian();
        request.setAttribute("students",list);
        return "writerTianChange";

    }
    @RequestMapping(value = "/stu/writerGuifanChange",method = RequestMethod.GET)
    public String writerGuifanChange(HttpServletRequest request){
        Correct correct=new Correct();
        correct.author="Guifan";
        List<Correct> list = correctServiceImpl.select(correct);
        request.setAttribute("students",list);
        return "writerGuifanChange";

    }
    @RequestMapping(value = "/stu/writerInfoChange",method = RequestMethod.GET)
    public String writerInfoChange(HttpServletRequest request){
        return "writerInfoChange";

    }
    @RequestMapping(value = "/stu/rulerIDManage",method = RequestMethod.GET)
    public String rulerIDManage(HttpServletRequest request){
        User user = new User();
        user.identity="waiting";
        //List<Correct> list = correctServiceImpl.select(correct);
        List<User> list = userDao.selectI(user.identity);
        request.setAttribute("students",list);
        return "rulerIDManage";

    }
    @RequestMapping(value = "/stu/rulerIDUpAndDel",method = RequestMethod.GET)
    public String rulerIDUpAndDel(HttpServletRequest request){
        User user = new User();
        user.identity="writer";
        //List<Correct> list = correctServiceImpl.select(correct);
        List<User> list = userDao.selectI(user.identity);
        request.setAttribute("students",list);
        return "rulerIDUpAndDel";

    }
    /*@RequestMapping(value = "/stu/judge",method = RequestMethod.GET)
    public String judge(HttpServletRequest request){
        if(judge.equals("writer"))
            return "writerTian";
        else if(judge.equals("manager"))
            return "rulerTianManage";
        else
            return "student";
    }*/
    @RequestMapping(value = "/stu/rulerTianManage",method = RequestMethod.GET)
    public String rulerTianManage(HttpServletRequest request){
        List<Correct> list = ruler.proposalmanagement_tian_no();
        request.setAttribute("students",list);
        return "rulerTianManage";

    }
    @RequestMapping(value = "/stu/rulerTianDel",method = RequestMethod.GET)
    public String rulerTianDel(HttpServletRequest request){
        List<Correct> list = ruler.proposalmanagement_tian_yes();
        request.setAttribute("students",list);
        return "rulerTianDel";

    }
    @RequestMapping(value = "/stu/rulerTianDel",method = RequestMethod.POST)
    public String rulerAddTian(HttpServletRequest request){
        Correct correct = new Correct();
        correct.Tname=request.getParameter("Tname");
        correct.text=request.getParameter("text");
        ruler.proposalwriting_Tian(correct);
        return "redirect:/stu/rulerTianDel";
    }
    @RequestMapping(value = "/stu/rulerGuifanManage",method = RequestMethod.GET)
    public String rulerGuifanManage(HttpServletRequest request){
        List<Correct> list = ruler.proposalmanagement_guifan_no();
        request.setAttribute("students",list);
        return "rulerGuifanManage";

    }
    @RequestMapping(value = "/stu/rulerGuifanDel",method = RequestMethod.GET)
    public String rulerGuifanDel(HttpServletRequest request){
        List<Correct> list = ruler.proposalmanagement_guifan_yes();
        request.setAttribute("students",list);
        return "rulerGuifanDel";

    }
    @RequestMapping(value = "/stu/rulerGuifanDel",method = RequestMethod.POST)
    public String rulerAddGuifan(HttpServletRequest request){
        Correct correct = new Correct();
        correct.Tname=request.getParameter("Tname");
        correct.text=request.getParameter("text");
        ruler.proposalwriting_Guifan(correct);
        return "redirect:/stu/rulerGuifanDel";
    }
}
