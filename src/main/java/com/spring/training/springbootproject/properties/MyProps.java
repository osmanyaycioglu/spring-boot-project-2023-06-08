package com.spring.training.springbootproject.properties;

import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Map;

// @Data

@Component
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder(setterPrefix = "with")
@ConfigurationProperties(prefix = "my.app")
@Validated
public class MyProps {
    @Size(min = 3, max = 10)
    private String     appName;
    private String     appVersion;
    private String     appTestVersion;
    @Max(30000)
    private Integer    port;
    private String     outputHost;
    private Double     amount;
    private String     newProperty;
    @Valid
    private Department defaultDepartment;
    private List<String> testList;
    private List<Department>       departments;
    private Map<String,Department> departmentMap;


}
