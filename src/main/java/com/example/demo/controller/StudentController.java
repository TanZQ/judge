package com.example.demo.controller;

import com.example.demo.service.impl.Ruler;
import com.example.demo.service.impl.Writer;
import com.example.demo.service.impl.Regist;
import com.example.demo.service.impl.Login;
import com.example.demo.service.impl.Logoff;
import com.example.demo.entity.Correct;
import com.example.demo.dao.CorrectDao;
import com.example.demo.dao.UserDao;
import com.example.demo.entity.User;
import com.example.demo.service.CorrectService;
import com.example.demo.service.impl.CorrectServiceImpl;
import com.example.demo.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
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
    private UserServiceImpl userServiceImpl;
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
    private Logoff logoff;
    @Autowired
    private UserDao userDao;
    private String judge;
    private List<Correct> Tianlist_writer;
    private List<Correct> Guifanlist_writer;
    private List<User> Writerlist_ruler;
    private List<User> Waitinglist_ruler;

    @RequestMapping(value = "/stu/getAllStudent", method = RequestMethod.GET)
    public String getAllStudent(HttpServletRequest request) {
        User user = new User();
        user.useornot = "yes";
        if (userServiceImpl.select(user).size() != 0)
            logoff.logoff();
        Correct correct1 = new Correct();
        correct1.type = "Tian";
        Tianlist_writer = correctDao.selectT(correct1.type);
        Correct correct2 = new Correct();
        correct2.type = "Guifan";
        Guifanlist_writer = correctDao.selectT(correct2.type);
        User user1 = new User();
        user1.identity = "waiting";
        Waitinglist_ruler = userDao.selectI(user1.identity);
        User user2 = new User();
        user2.identity = "writer";
        Writerlist_ruler = userDao.selectI(user2.identity);
        return "student";
    }

    @RequestMapping(value = "/stu/getAllStudent", method = RequestMethod.POST)
    public String register(HttpServletRequest request) {
        User user = new User();
        user.username = request.getParameter("username");
        user.password = request.getParameter("password");
        user.name = request.getParameter("name");
        user.sex = request.getParameter("sex");
        user.dateofbirth = request.getParameter("dateofbirth");
        user.phoneno = request.getParameter("phoneno");
        user.address = request.getParameter("address");
        user.leader = request.getParameter("leader");
        user.community = request.getParameter("community");
        user.company = request.getParameter("company");
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
    @RequestMapping(value = "/stu/login", method = RequestMethod.GET)
    public String loginRuler(HttpServletRequest request) {
        return "login";
    }

    @RequestMapping(value = "/stu/login", method = RequestMethod.POST)
    public String loginRuler_post(HttpServletRequest request) {
        User user = new User();
        user.username = request.getParameter("username");
        user.password = request.getParameter("userpassword");
        String identity = login.login(user);
        login.recordusinguser();
        if (identity.equals("writer"))
            return "redirect:/stu/writerTian";
        else if (identity.equals("manager"))
            return "redirect:/stu/rulerIDManage";

        return "login";
    }

    @RequestMapping(value = "/stu/writerTian", method = RequestMethod.GET)
    public String writerTian(HttpServletRequest request) {
        //Correct correct=new Correct();
        //correct.type="Tian";
        //List<Correct> list = correctServiceImpl.select(correct);
        //Tianlist_writer = correctDao.selectT(correct.type);
        request.setAttribute("students", Tianlist_writer);
        return "writerTian";
    }

    @RequestMapping(value = "/stu/writerTian", method = RequestMethod.POST)
    public String addTian(HttpServletRequest request) {
        Correct correct2 = new Correct();
        correct2.type = "Tian";
        List<Correct> list = new ArrayList<Correct>();
        List<Correct> list2 = new ArrayList<Correct>();
        String condition = request.getParameter("condition");
        if (request.getParameter("keyword").equals("")) {
            Tianlist_writer = correctDao.selectT(correct2.type);
            return "redirect:/stu/writerTian";
        } else {
            if (condition.equals("Tno")) {
                correct2.Tno = Integer.valueOf(request.getParameter("keyword"));
                list = correctDao.selectNO(correct2.Tno);
            } else if (condition.equals("Tname")) {
                correct2.Tname = request.getParameter("keyword");
                list = correctDao.selectNA(correct2.Tname);
            } else if (condition.equals("author")) {
                correct2.author = request.getParameter("keyword");
                list = correctDao.selectA(correct2.author);
            }
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).type.equals("Tian"))
                list2.add(list.get(i));
        }
        Tianlist_writer = list2;
        return "redirect:/stu/writerTian";
    }

    @RequestMapping(value = "/stu/writerTianAdd", method = RequestMethod.GET)
    public String writerTianAdd(HttpServletRequest request) {
        return "writerTianAdd";
    }

    @RequestMapping(value = "/stu/writerTianAdd", method = RequestMethod.POST)
    public String writerTianAdd_post(HttpServletRequest request) {
        Correct correct = new Correct();
        Correct correct0 = new Correct();
        correct.Tname = request.getParameter("Tname");
        correct.text = request.getParameter("text");
        writer.proposalwriting_Tian(correct);
        Tianlist_writer = correctDao.selectT(correct.type);
        return "redirect:/stu/writerTian";
    }

    @RequestMapping(value = "/stu/writerTian/Info/{id}", method = RequestMethod.GET)
    public String writerTianInfo(HttpServletRequest request, @PathVariable("id") int id) {
        Correct correct = new Correct();
        List<Correct> list = new ArrayList<Correct>();
        correct.Tno = id;
        list = correctServiceImpl.select(correct);
        request.setAttribute("students", list);
        return "writerTianInfo";
    }

    @RequestMapping(value = "/stu/writerGuifan/Info/{id}", method = RequestMethod.GET)
    public String writerGuifanInfo(HttpServletRequest request, @PathVariable("id") int id) {
        Correct correct = new Correct();
        List<Correct> list = new ArrayList<Correct>();
        correct.Tno = id;
        list = correctServiceImpl.select(correct);
        request.setAttribute("students", list);
        return "writerGuifanInfo";
    }

    @RequestMapping(value = "/stu/writerTianChange/Delete/{id}", method = RequestMethod.GET)
    public String writerTianDelete(HttpServletRequest request, @PathVariable("id") int id) {
        Correct correct = new Correct();
        //List<Correct> list = new ArrayList<Correct>();
        correct.Tno = id;
        correctServiceImpl.delete(correct);
        Correct correct1 = new Correct();
        correct1.type = "Tian";
        Tianlist_writer = correctDao.selectT(correct1.type);
        return "redirect:/stu/writerTianChange";
    }

    @RequestMapping(value = "/stu/writerGuifan", method = RequestMethod.GET)
    public String writerGuifan(HttpServletRequest request) {
        //Correct correct=new Correct();
        //correct.type="Tian";
        //List<Correct> list = correctServiceImpl.select(correct);
        //Tianlist_writer = correctDao.selectT(correct.type);
        request.setAttribute("students", Guifanlist_writer);
        return "writerGuifan";
    }

    @RequestMapping(value = "/stu/writerGuifan", method = RequestMethod.POST)
    public String addGuifan(HttpServletRequest request) {
        Correct correct2 = new Correct();
        correct2.type = "Guifan";
        List<Correct> list = new ArrayList<Correct>();
        List<Correct> list2 = new ArrayList<Correct>();
        String condition = request.getParameter("condition");
        if (request.getParameter("keyword").equals("")) {
            Guifanlist_writer = correctDao.selectT(correct2.type);
            return "redirect:/stu/writerGuifan";
        } else {
            if (condition.equals("Tno")) {
                correct2.Tno = Integer.valueOf(request.getParameter("keyword"));
                list = correctDao.selectNO(correct2.Tno);
            } else if (condition.equals("Tname")) {
                correct2.Tname = request.getParameter("keyword");
                list = correctDao.selectNA(correct2.Tname);
            } else if (condition.equals("author")) {
                correct2.author = request.getParameter("keyword");
                list = correctDao.selectA(correct2.author);
            }
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).type.equals("Guifan"))
                list2.add(list.get(i));
        }
        Guifanlist_writer = list2;
        return "redirect:/stu/writerGuifan";
    }

    @RequestMapping(value = "/stu/writerGuifanAdd", method = RequestMethod.GET)
    public String writerGuifanAdd(HttpServletRequest request) {
        return "writerGuifanAdd";
    }

    @RequestMapping(value = "/stu/writerGuifanAdd", method = RequestMethod.POST)
    public String writerGuifanAdd_post(HttpServletRequest request) {
        Correct correct = new Correct();
        Correct correct0 = new Correct();
        correct.Tname = request.getParameter("Tname");
        correct.text = request.getParameter("text");
        writer.proposalwriting_Guifan(correct);
        Guifanlist_writer = correctDao.selectT(correct.type);
        return "redirect:/stu/writerGuifan";
    }

    @RequestMapping(value = "/stu/writerGuifanChange/Delete/{id}", method = RequestMethod.GET)
    public String writerGuifanDelete(HttpServletRequest request, @PathVariable("id") int id) {
        Correct correct = new Correct();
        //List<Correct> list = new ArrayList<Correct>();
        correct.Tno = id;
        correctServiceImpl.delete(correct);
        Correct correct1 = new Correct();
        correct1.type = "Guifan";
        Guifanlist_writer = correctDao.selectT(correct1.type);
        return "redirect:/stu/writerGuifanChange";
    }

    /*
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
    }*/
    @RequestMapping(value = "/stu/writerTianChange", method = RequestMethod.GET)
    public String writerTianChange(HttpServletRequest request) {
        List<Correct> list = writer.showyourTian();
        request.setAttribute("students", list);
        return "writerTianChange";

    }

    @RequestMapping(value = "/stu/writerGuifanChange", method = RequestMethod.GET)
    public String writerGuifanChange(HttpServletRequest request) {
        ;
        List<Correct> list = writer.showyourGuifan();
        request.setAttribute("students", list);
        return "writerGuifanChange";

    }

    @RequestMapping(value = "/stu/writerInfoChange", method = RequestMethod.GET)
    public String writerInfoChange(HttpServletRequest request) {
        return "writerInfoChange";

    }

    @RequestMapping(value = "/stu/rulerIDManage", method = RequestMethod.GET)
    public String rulerIDManage(HttpServletRequest request) {
        //User user = new User();
        //user.identity="waiting";
        //List<Correct> list = correctServiceImpl.select(correct);
        //List<User> list = userDao.selectI(user.identity);
        request.setAttribute("students", Waitinglist_ruler);
        return "rulerIDManage";
    }

    @RequestMapping(value = "/stu/rulerIDManage", method = RequestMethod.POST)
    public String rulerIDManage_search(HttpServletRequest request) {
        User user = new User();
        List<User> list1 = new ArrayList<User>();
        List<User> list2 = new ArrayList<User>();
        user.identity = "waiting";
        if (request.getParameter("keyword").equals("")) {
            Waitinglist_ruler = userDao.selectI(user.identity);
            return "redirect:/stu/rulerIDManage";
        }
        user.name = request.getParameter("keyword");
        list1 = userDao.selectN(user.name);
        for (int i = 0; i < list1.size(); i++) {
            if (list1.get(i).identity.equals("waiting"))
                list2.add(list1.get(i));
        }
        Waitinglist_ruler = list2;
        return "redirect:/stu/rulerIDManage";
    }

    @RequestMapping(value = "/stu/rulerIDManage/Delete/{id}", method = RequestMethod.GET)
    public String rulerIDDelete(HttpServletRequest request, @PathVariable("id") String id) {
        User user = new User();
        //List<Correct> list = new ArrayList<Correct>();
        user.username = id;
        userServiceImpl.delete(user);
        User user1 = new User();
        user1.identity = "waiting";
        Waitinglist_ruler = userDao.selectI(user1.identity);
        return "redirect:/stu/rulerIDManage";
    }

    @RequestMapping(value = "/stu/rulerIDUpAndDel", method = RequestMethod.GET)
    public String rulerIDUpAndDel(HttpServletRequest request) {
        //User user = new User();
        //user.identity="writer";
        //List<Correct> list = correctServiceImpl.select(correct);
        //List<User> list = userDao.selectI(user.identity);
        request.setAttribute("students", Writerlist_ruler);
        return "rulerIDUpAndDel";
    }

    @RequestMapping(value = "/stu/rulerIDUpAndDel", method = RequestMethod.POST)
    public String rulerIDUpAndDel_search(HttpServletRequest request) {
        User user = new User();
        List<User> list1 = new ArrayList<User>();
        List<User> list2 = new ArrayList<User>();
        user.identity = "writer";
        if (request.getParameter("keyword").equals("")) {
            Writerlist_ruler = userDao.selectI(user.identity);
            return "redirect:/stu/rulerIDUpAndDel";
        }
        user.name = request.getParameter("keyword");
        list1 = userDao.selectN(user.name);
        for (int i = 0; i < list1.size(); i++) {
            if (list1.get(i).identity.equals("writer"))
                list2.add(list1.get(i));
        }
        Writerlist_ruler = list2;
        return "redirect:/stu/rulerIDUpAndDel";
    }

    @RequestMapping(value = "/stu/rulerIDUpAndDel/Delete/{id}", method = RequestMethod.GET)
    public String rulerIDUpAndDelete(HttpServletRequest request, @PathVariable("id") String id) {
        User user = new User();
        //List<Correct> list = new ArrayList<Correct>();
        user.username = id;
        userServiceImpl.delete(user);
        User user1 = new User();
        user1.identity = "writer";
        Writerlist_ruler = userDao.selectI(user1.identity);
        return "redirect:/stu/rulerIDUpAndDel";
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
    @RequestMapping(value = "/stu/rulerTianManage", method = RequestMethod.GET)
    public String rulerTianManage(HttpServletRequest request) {
        List<Correct> list = ruler.proposalmanagement_tian_no();
        request.setAttribute("students", list);
        return "rulerTianManage";

    }

    @RequestMapping(value = "/stu/rulerTianManage/Delete/{id}", method = RequestMethod.GET)
    public String rulerTianManageDelete(HttpServletRequest request, @PathVariable("id") int id) {
        Correct correct = new Correct();
        //List<Correct> list = new ArrayList<Correct>();
        correct.Tno = id;
        correctServiceImpl.delete(correct);
        Correct correct1 = new Correct();
        correct1.type = "Tian";
        Tianlist_writer = correctDao.selectT(correct1.type);
        return "redirect:/stu/rulerTianManage";
    }

    @RequestMapping(value = "/stu/rulerTianDel", method = RequestMethod.GET)
    public String rulerTianDel(HttpServletRequest request) {
        List<Correct> list = ruler.proposalmanagement_tian_yes();
        request.setAttribute("students", list);
        return "rulerTianDel";

    }

    @RequestMapping(value = "/stu/rulerTianDel/Delete/{id}", method = RequestMethod.GET)
    public String rulerTianDelDelete(HttpServletRequest request, @PathVariable("id") int id) {
        Correct correct = new Correct();
        //List<Correct> list = new ArrayList<Correct>();
        correct.Tno = id;
        correctServiceImpl.delete(correct);
        Correct correct1 = new Correct();
        correct1.type = "Tian";
        Tianlist_writer = correctDao.selectT(correct1.type);
        return "redirect:/stu/rulerTianDel";
    }

    @RequestMapping(value = "/stu/rulerTianDel", method = RequestMethod.POST)
    public String rulerAddTian(HttpServletRequest request) {
        Correct correct = new Correct();
        correct.Tname = request.getParameter("Tname");
        correct.text = request.getParameter("text");
        ruler.proposalwriting_Tian(correct);
        return "redirect:/stu/rulerTianDel";
    }

    @RequestMapping(value = "/stu/rulerGuifanManage", method = RequestMethod.GET)
    public String rulerGuifanManage(HttpServletRequest request) {
        List<Correct> list = ruler.proposalmanagement_guifan_no();
        request.setAttribute("students", list);
        return "rulerGuifanManage";

    }

    @RequestMapping(value = "/stu/rulerGuifanManage/Delete/{id}", method = RequestMethod.GET)
    public String rulerGuifanManageDelete(HttpServletRequest request, @PathVariable("id") int id) {
        Correct correct = new Correct();
        //List<Correct> list = new ArrayList<Correct>();
        correct.Tno = id;
        correctServiceImpl.delete(correct);
        Correct correct1 = new Correct();
        correct1.type = "Guifan";
        Guifanlist_writer = correctDao.selectT(correct1.type);
        return "redirect:/stu/rulerGuifanManage";
    }

    @RequestMapping(value = "/stu/rulerGuifanDel", method = RequestMethod.GET)
    public String rulerGuifanDel(HttpServletRequest request) {
        List<Correct> list = ruler.proposalmanagement_guifan_yes();
        request.setAttribute("students", list);
        return "rulerGuifanDel";

    }

    @RequestMapping(value = "/stu/rulerGuifanDel", method = RequestMethod.POST)
    public String rulerAddGuifan(HttpServletRequest request) {
        Correct correct = new Correct();
        correct.Tname = request.getParameter("Tname");
        correct.text = request.getParameter("text");
        ruler.proposalwriting_Guifan(correct);
        return "redirect:/stu/rulerGuifanDel";
    }

    @RequestMapping(value = "/stu/rulerGuifanDel/Delete/{id}", method = RequestMethod.GET)
    public String rulerGuifanDelDelete(HttpServletRequest request, @PathVariable("id") int id) {
        Correct correct = new Correct();
        //List<Correct> list = new ArrayList<Correct>();
        correct.Tno = id;
        correctServiceImpl.delete(correct);
        Correct correct1 = new Correct();
        correct1.type = "Guifan";
        Guifanlist_writer = correctDao.selectT(correct1.type);
        return "redirect:/stu/rulerGuifanDel";
    }
}