package com.swad.repository;

import com.swad.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by chenlei on 2017/5/22.
 */
public interface StudentRepository extends JpaRepository<Student, Integer>{

    //按年龄查询
    public List<Student> findByAge(Integer age);
}
