package com.darian.springbootjmx.dynamicBean;

import lombok.Data;



@Data
public class DefaultData implements com.darian.springbootjmx.dynamicBean.Data {
    private Long id;
    private String name;
    private Integer age;
}
