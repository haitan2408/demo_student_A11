package com.codegym.demo_a11.model.repository;

import com.codegym.demo_a11.model.entity.ClassStudent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClassStudentRepository extends JpaRepository<ClassStudent, Integer> {
}
