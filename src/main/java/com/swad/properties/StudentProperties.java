package com.swad.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by chenlei on 2017/5/22.
 */

@Component
@ConfigurationProperties(prefix = "student")
public class StudentProperties {

    private String size;

    private Integer age;

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
