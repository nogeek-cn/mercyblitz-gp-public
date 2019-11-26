package com.darian.javabeans;

import org.springframework.util.StringUtils;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DatePropertyEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
       if(StringUtils.hasText(text)){
           SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
           try {
               Date date = dateFormat.parse(text);
               setValue(date);
           } catch (ParseException e) {
               e.printStackTrace();
           }
       }
    }
}
