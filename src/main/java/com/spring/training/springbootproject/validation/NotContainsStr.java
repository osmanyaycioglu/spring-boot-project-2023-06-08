package com.spring.training.springbootproject.validation;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { NotContainsStrImpl.class })
public @interface NotContainsStr {

    String[] value();

    String message() default "{javax.validation.constraints.NotContainsStr.message}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

}
