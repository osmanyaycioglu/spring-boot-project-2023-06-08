package com.spring.training.springbootproject.services.models;

import com.spring.training.springbootproject.validation.ContainsStr;
import com.spring.training.springbootproject.validation.NotContainsStr;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDateTime;

@Data
@Entity
public class PersonDto {
    @Id
    @GeneratedValue
    private Long personId;
    private String name;
    private String email;
    private String password;
    private String phone;
    private Integer weight;
    private Integer height;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
    private String secretId;

    @PrePersist
    public void beforeInsert(){
        createDate = LocalDateTime.now();
        updateDate = LocalDateTime.now();;
    }

    @PreUpdate
    public void beforeUpdate(){
        updateDate = LocalDateTime.now();;
    }

}
