package com.codegym.demo_a11.valid.inter;

import com.codegym.demo_a11.valid.class_validator.UniqueNameValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = UniqueNameValidator.class)
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueNameConstraint {
    String message() default "Name unique";
    Class<?> [] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
