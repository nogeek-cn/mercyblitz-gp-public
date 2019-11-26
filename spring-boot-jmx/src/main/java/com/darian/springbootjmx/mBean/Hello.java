package com.darian.springbootjmx.mBean;

public class Hello implements HelloMBean {
    private String value;

    @Override
    public String greeting() {
        return "Hello, World。";
    }

    @Override
    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return this.value;
    }
}
