package com.swad.controller;

import com.swad.model.Student;
import com.swad.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by chenlei on 2017/5/22.
 */

@RestController
public class StudentController {

    @Autowired
    public StudentRepository studentRepository;

    /**
     * 查询所有学生列表
     * @return
     */
    @GetMapping(value = "/students")
    public List<Student> studentList(){
        return studentRepository.findAll();
    }

    /**
     * 添加一个学生
     * @param age
     * @param name
     * @param score
     * @return
     */
    @PostMapping
    public Student studentsAdd(@RequestParam("age") Integer age,
                              @RequestParam("name") String name,
                              @RequestParam("score") String score){
        Student student = new Student();
        student.setAge(age);
        student.setName(name);
        student.setScore(score);

        return studentRepository.save(student);
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
}
