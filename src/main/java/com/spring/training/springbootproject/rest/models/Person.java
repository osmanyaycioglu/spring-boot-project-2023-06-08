package com.spring.training.springbootproject.rest.models;

import com.spring.training.springbootproject.validation.ContainsStr;
import com.spring.training.springbootproject.validation.NotContainsStr;
import lombok.Data;

import javax.validation.constraints.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDate;

@XmlRootElement
@Data
public class Person {
    @Size(min = 2,max = 20)
    @NotContainsStr({".com", ".net", ".org"})
    private String name;
    @Email
    @ContainsStr({".com",".net",".org"})
    private String email;
    @NotEmpty
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$")
    @NotContainsStr({"qwerty", "asd", "123456"})
    private String password;
    @NotEmpty
    private String phone;
    @Min(10)
    @Max(500)
    private Integer weight;
    @Min(50)
    @Max(300)
    private Integer height;
}
