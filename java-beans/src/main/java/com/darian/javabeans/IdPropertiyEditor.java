package com.darian.javabeans;

import org.springframework.util.StringUtils;

import java.beans.PropertyEditorSupport;

/***
 * Id 属性的修改器
 * id: Long
 */
public class IdPropertiyEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        if (StringUtils.hasText(text)) {
            long id = Long.parseLong(text);
            setValue(id);
        } else {
            setValue(Long.MIN_VALUE);
        }
    }
}
