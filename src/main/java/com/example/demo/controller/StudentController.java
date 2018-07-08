package com.example.demo.controller;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;
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
    private StudentService studentService;


    @RequestMapping(value = "/stu/getAllStudent",method = RequestMethod.GET)
    public String getAllStudent(HttpServletRequest request){
        List<Student> list = studentService.getAllStudent();
        request.setAttribute("students",list);
        // aaaaaa
        return "student";

    }
    @RequestMapping(value = "/stu/writerTian",method = RequestMethod.GET)
    public String writerTian(HttpServletRequest request){
        List<Student> list = studentService.getAllStudent();
        request.setAttribute("students",list);
        // aaaaaa
        return "writerTian";

    }
    @RequestMapping(value = "/stu/writerGuifan",method = RequestMethod.GET)
    public String writerGuifan(HttpServletRequest request){
        List<Student> list = studentService.getAllStudent();
        request.setAttribute("students",list);
        // aaaaaa
        return "writerGuifan";

    }
    @RequestMapping(value = "/stu/writerTianChange",method = RequestMethod.GET)
    public String writerTianChange(HttpServletRequest request){
        List<Student> list = studentService.getAllStudent();
        request.setAttribute("students",list);
        // aaaaaa
        return "writerTianChange";

    }
    @RequestMapping(value = "/stu/writerGuifanChange",method = RequestMethod.GET)
    public String writerGuifanChange(HttpServletRequest request){
        List<Student> list = studentService.getAllStudent();
        request.setAttribute("students",list);
        // aaaaaa
        return "writerGuifanChange";

    }
    @RequestMapping(value = "/stu/writerInfoChange",method = RequestMethod.GET)
    public String writerInfoChange(HttpServletRequest request){
        List<Student> list = studentService.getAllStudent();
        request.setAttribute("students",list);
        // aaaaaa
        return "writerInfoChange";

    }
    @RequestMapping(value = "/stu/rulerIDManage",method = RequestMethod.GET)
    public String rulerIDManage(HttpServletRequest request){
        List<Student> list = studentService.getAllStudent();
        request.setAttribute("students",list);
        // aaaaaa
        return "rulerIDManage";

    }
    @RequestMapping(value = "/stu/rulerIDUpAndDel",method = RequestMethod.GET)
    public String rulerIDUpAndDel(HttpServletRequest request){
        List<Student> list = studentService.getAllStudent();
        request.setAttribute("students",list);
        // aaaaaa
        return "rulerIDUpAndDel";

    }
    @RequestMapping(value = "/stu/rulerTianManage",method = RequestMethod.GET)
    public String rulerTianManage(HttpServletRequest request){
        List<Student> list = studentService.getAllStudent();
        request.setAttribute("students",list);
        // aaaaaa
        return "rulerTianManage";

    }
    @RequestMapping(value = "/stu/rulerTianDel",method = RequestMethod.GET)
    public String rulerTianDel(HttpServletRequest request){
        List<Student> list = studentService.getAllStudent();
        request.setAttribute("students",list);
        // aaaaaa
        return "rulerTianDel";

    }
    @RequestMapping(value = "/stu/rulerGuifanManage",method = RequestMethod.GET)
    public String rulerGuifanManage(HttpServletRequest request){
        List<Student> list = studentService.getAllStudent();
        request.setAttribute("students",list);
        // aaaaaa
        return "rulerGuifanManage";

    }
    @RequestMapping(value = "/stu/rulerGuifanDel",method = RequestMethod.GET)
    public String rulerGuifanDel(HttpServletRequest request){
        List<Student> list = studentService.getAllStudent();
        request.setAttribute("students",list);
        // aaaaaa
        return "rulerGuifanDel";

    }
}
