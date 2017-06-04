package com.swad.service;

import com.swad.enums.ResultEnum;
import com.swad.exception.StudentException;
import com.swad.model.Student;
import com.swad.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by chenlei on 2017/6/4.
 */

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Transactional
    public void insertTwo(){
        Student studentA = new Student();
        studentA.setName("Tomas");
        studentA.setAge(30);
        studentA.setScore("80");
        studentRepository.save(studentA);

        Student studentB = new Student();
        studentB.setName("Haha");
        studentB.setAge(34);
        studentB.setScore("689999");
        studentRepository.save(studentB);
    }


    @Transactional
    public void getAge(Integer id) throws Exception{
        Student student = studentRepository.findOne(id);
        Integer age = student.getAge();
        if(age < 10){
            throw new StudentException(ResultEnum.PRIMARY_STUDENT);
        }else if(age > 10 && age < 16){
            throw new StudentException(ResultEnum.MIDDLE_STUDENT);
        }else {

        }
    }
}
