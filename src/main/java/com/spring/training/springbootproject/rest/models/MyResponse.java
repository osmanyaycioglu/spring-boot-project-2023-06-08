package com.spring.training.springbootproject.rest.models;

import lombok.*;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Getter
@Setter
@AllArgsConstructor
@Builder(setterPrefix = "with")
public class MyResponse {
    private String message;
    private String response;
    private Integer code;

    public MyResponse() {
        super();
    }


}
