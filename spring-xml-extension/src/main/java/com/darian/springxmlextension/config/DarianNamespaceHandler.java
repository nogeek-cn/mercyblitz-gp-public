package com.darian.springxmlextension.config;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

public class DarianNamespaceHandler extends NamespaceHandlerSupport {

    @Override
    public void init() {
        registerBeanDefinitionParser("user", new UserBeanDefinitionparser());
    }

}
