package com.codegym.demo_a11.model.repository;

import com.codegym.demo_a11.model.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IStudentRepository extends JpaRepository<Student, Integer> {
    @Query(value = "select * from student", nativeQuery = true)
    Page<Student> findAll(Pageable pageable);

    Student findByName(String name);

    //where name like ="%name%
    List<Student> findAllByNameContaining(String name);

    @Query(value = "select * from student where name like %?1% and date_of_birth = ?2" , nativeQuery = true)
    List<Student> searchNameAnDate(String name, String date);
}
