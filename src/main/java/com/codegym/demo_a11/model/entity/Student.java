package com.codegym.demo_a11.model.entity;

import com.codegym.demo_a11.valid.inter.UniqueNameConstraint;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity(name = "student") // Tạo entity với tên là student
public class Student implements Validator {

    @Id // Khóa chính
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Tự động tăng.
    private Integer id;
    @NotBlank(message = "tên không được để trống")
    @UniqueNameConstraint
    @Column(name = "name") // Để chỉ đến cái cột nào.
    private String name;
    @Column(name = "date_of_birth", columnDefinition = "DATE") // khai báo columnDefinition: khai báo kiểu dữ liệu trong DB
    private String dateOfBirth;
    // 0: Female, 1: Male
    @Column(name = "gender")
    @NotNull
    private Integer gender;
    @Column(name = "grade")
    @Min(value = 0)
    private Double grade;

    @ManyToOne
    @JoinColumn(name = "class_id", referencedColumnName = "id")
    private ClassStudent classStudent;

    public Student() {    }

    public Student(Integer id, String name, String dateOfBirth, Integer gender, Double grade) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.grade = grade;
    }

    public ClassStudent getClassStudent() {
        return classStudent;
    }

    public void setClassStudent(ClassStudent classStudent) {
        this.classStudent = classStudent;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Double getGrade() {
        return grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }

       @Override
    public boolean supports(Class<?> aClass) {
        return false;
    }

    @Override
    public void validate(Object o, Errors errors) {
        Student student = (Student) o;
        if(!student.name.matches("[A-Za-z]+")) {
            errors.rejectValue("name", "name.invalidFormat");
        }
    }
}
