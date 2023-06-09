package com.spring.training.springbootproject.properties;

import java.time.LocalDate;

public class ImMain {
    public static void main(String[] args) {
        String sLoc      = "osman";
        String concatLoc = sLoc.concat(" yay")
                               .concat(" dshsd");
        sLoc = sLoc.concat(" yay");
        sLoc += " sdsd";

        StringBuilder builderLoc = new StringBuilder();
        builderLoc.append("osman")
                  .append(" yay")
                  .append(" xyz");

        Integer   integerLoc   = 100;
        LocalDate localDateLoc = LocalDate.now();

        MyProps xyzLoc = MyProps.builder()
                                .withAppName("xyz")
                                .withAppVersion("1.0")
                                .withPort(100)
                                .build();
    }
}
