package com.codegym.demo_a11.model.service.impl;

import com.codegym.demo_a11.model.entity.ClassStudent;
import com.codegym.demo_a11.model.repository.IClassStudentRepository;
import com.codegym.demo_a11.model.service.IClassStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassStudentService implements IClassStudentService {
    @Autowired
    private IClassStudentRepository iClassStudentRepository;


    @Override
    public List<ClassStudent> findAll() {
        return iClassStudentRepository.findAll();
    }
}
