package com.spring.training.springbootproject.error;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
@Builder(setterPrefix = "with")
public class ErrorObj {
    private List<ErrorObj> subErrors;
    private String desc;
    private Integer errorCode;

    public ErrorObj() {
        super();
    }
}
