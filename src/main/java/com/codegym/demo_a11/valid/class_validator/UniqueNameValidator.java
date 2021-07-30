package com.codegym.demo_a11.valid.class_validator;

import com.codegym.demo_a11.model.entity.Student;
import com.codegym.demo_a11.model.repository.IStudentRepository;
import com.codegym.demo_a11.model.service.impl.StudentService;
import com.codegym.demo_a11.valid.inter.UniqueNameConstraint;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueNameValidator implements ConstraintValidator<UniqueNameConstraint, String> {
    @Autowired
    private IStudentRepository iStudentRepository;

    @Override
    public void initialize(UniqueNameConstraint constraintAnnotation) {

    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        Student student = this.iStudentRepository.findByName(s);
        if(student!=null) {
            return true;
        }
        return false;
    }
}
