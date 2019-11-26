package com.darian.javabeans;

import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;

import java.util.Date;

public class MyPropertyEditorRegistrar implements PropertyEditorRegistrar {

    @Override
    public void registerCustomEditors(PropertyEditorRegistry registry) {
        // 将 Date 类型的字段设置成为 PropertyEditor
        registry.registerCustomEditor(Date.class, "date", new DatePropertyEditor());
    }
}
