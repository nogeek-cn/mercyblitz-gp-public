package com.darian.springbootjmx.mBean;

public interface HelloMBean {

    public String greeting();

    public void setValue(String value);

    public String getValue();
}
