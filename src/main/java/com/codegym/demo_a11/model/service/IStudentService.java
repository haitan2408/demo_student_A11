package com.codegym.demo_a11.model.service;

import com.codegym.demo_a11.model.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.List;

public interface IStudentService {
    void save(Student student);
    Page<Student> findAll(Pageable pageable);
    Student findById(Integer id);
}
