package com.spring.training.springbootproject.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ContainsStrImpl implements ConstraintValidator<ContainsStr,String> {

    private ContainsStr annotation;

    @Override
    public void initialize(final ContainsStr annotation) {
        this.annotation = annotation;
    }

    @Override
    public boolean isValid(final String value,
                           final ConstraintValidatorContext context) {
        String[] valueLoc = annotation.value();
        for (String sLoc : valueLoc) {
            if (value.contains(sLoc)) {
                return true;
            }
        }
        return false;
    }
}
