package com.darian.springbootjmx.dynamicBean;

public interface Data {
    Long getId();

    String getName();

    Integer getAge();

    void setId(Long id);

    void setName(String naem);

    void setAge(Integer age);

    boolean equals(Object o);

    int hashCode();

    String toString();
}
