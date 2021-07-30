package com.codegym.demo_a11.model.entity;

import javax.persistence.*;
import java.util.List;

@Entity(name = "class")
public class ClassStudent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name_class")
    private String nameClass; // -> name_class (trong sql)

    @OneToMany(mappedBy = "classStudent")
    private List<Student> studentList;

    public ClassStudent() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameClass() {
        return nameClass;
    }

    public void setNameClass(String nameClass) {
        this.nameClass = nameClass;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }
}
