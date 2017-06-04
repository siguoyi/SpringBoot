package com.swad.controller;

import com.swad.model.Result;
import com.swad.model.Student;
import com.swad.repository.StudentRepository;
import com.swad.service.StudentService;
import com.swad.util.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by chenlei on 2017/5/22.
 */

@RestController
public class StudentController {

    private final static Logger LOGGER = LoggerFactory.getLogger(StudentController.class);

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentService studentService;

    /**
     * 查询所有学生列表
     * @return
     */
    @GetMapping(value = "/students")
    public List<Student> studentList(){
        LOGGER.info("student list");
        return studentRepository.findAll();
    }

    /**
     * 添加一个学生
     * @return
     */
    @PostMapping(value = "/students/add")
    public Result<Student> studentsAdd(@Valid Student student, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return ResultUtil.error(1, bindingResult.getFieldError().getDefaultMessage());
        }
        student.setAge(student.getAge());
        student.setName(student.getName());
        student.setScore(student.getScore());
        return ResultUtil.success(studentRepository.save(student));
    }

    /**
     * 通过id查询对应学生
     * @param id
     * @return
     */
    @GetMapping(value = "/students/{id}")
    public Student queryStudent(@PathVariable("id") Integer id){
        return studentRepository.findOne(id);
    }

    /**
     * 更新学生信息
     * @param id
     * @param age
     * @param name
     * @param score
     * @return
     */
    @PutMapping(value = "/students/{id}")
    public Student updateStudent(@PathVariable("id") Integer id,
                              @RequestParam("age") Integer age,
                              @RequestParam("name") String name,
                              @RequestParam("score") String score){
        Student student = new Student();
        student.setId(id);
        student.setAge(age);
        student.setName(name);
        student.setScore(score);

        return studentRepository.save(student);
    }

    /**
     * 删除某id学生信息
     * @param id
     */
    @DeleteMapping(value = "/students/{id}")
    public void deleteStudent(@PathVariable Integer id){
        studentRepository.delete(id);
    }

    /**
     * 通过年龄查询学生信息
     * @param age
     * @return
     */
    @GetMapping(value = "/students/age/{age}")
    public List<Student> studentByAge(@PathVariable("age") Integer age){
        return studentRepository.findByAge(age);
    }

    @PostMapping(value = "/students/two")
    public void insertTwo(){
        studentService.insertTwo();
    }

    @GetMapping(value = "/students/getAge/{id}")
    public void getAge(@PathVariable Integer id) throws Exception{
        studentService.getAge(id);
    }
}
