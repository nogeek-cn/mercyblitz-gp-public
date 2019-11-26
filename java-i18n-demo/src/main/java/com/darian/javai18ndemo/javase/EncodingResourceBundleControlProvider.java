package com.darian.javai18ndemo.javase;

import java.util.ResourceBundle;
import java.util.spi.ResourceBundleControlProvider;

public class EncodingResourceBundleControlProvider implements ResourceBundleControlProvider {

    @Override
    public ResourceBundle.Control getControl(String baseName) {
        return new CustomerResourceBundleDemo.EncodedControl();
    }
}
