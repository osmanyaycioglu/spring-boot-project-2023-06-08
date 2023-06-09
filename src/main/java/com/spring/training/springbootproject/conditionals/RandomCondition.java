package com.spring.training.springbootproject.conditionals;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.security.SecureRandom;
import java.util.Random;

public class RandomCondition implements Condition {
    @Override
    public boolean matches(final ConditionContext context,
                           final AnnotatedTypeMetadata metadata) {
        Random randomLoc = new SecureRandom();
        int    iLoc      = randomLoc.nextInt();
        if (iLoc % 2 == 0) {
            return true;
        }
        return false;
    }
}
