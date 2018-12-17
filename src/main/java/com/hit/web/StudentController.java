package com.hit.web;

import com.hit.bean.Student;
import com.hit.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author lilj
 * @date 18/07/20
 */
@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private IStudentService studentService;

    @RequestMapping("/list")
    public String get() {
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        List<Student> students = studentService.selectByCondition(new Student());
        String jsonResult = com.alibaba.fastjson.JSON.toJSONString(students);
        return jsonResult;
    }

    @RequestMapping("/save")
    @ResponseBody
    public Student save() {
        Student s = new Student();
        s.setAge(12);
        s.setClassid(6);
        s.setName("jim");
        int id = studentService.insertSelective(s);
        System.out.println("==============" + id);
        return s;
    }

}
