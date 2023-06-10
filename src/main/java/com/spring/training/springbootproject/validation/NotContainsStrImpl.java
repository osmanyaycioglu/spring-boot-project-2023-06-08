package com.spring.training.springbootproject.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NotContainsStrImpl implements ConstraintValidator<NotContainsStr,String> {

    private NotContainsStr annotation;

    @Override
    public void initialize(final NotContainsStr annotation) {
        this.annotation = annotation;
    }

    @Override
    public boolean isValid(final String value,
                           final ConstraintValidatorContext context) {
        String[] valueLoc = annotation.value();
        for (String sLoc : valueLoc) {
            if (value.contains(sLoc)) {
                return false;
            }
        }
        return true;
    }
}
