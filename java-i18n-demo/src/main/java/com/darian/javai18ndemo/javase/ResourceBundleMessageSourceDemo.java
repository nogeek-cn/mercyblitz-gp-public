package com.darian.javai18ndemo.javase;

import org.springframework.aop.framework.autoproxy.BeanNameAutoProxyCreator;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;

import java.util.Locale;

/***
 * {@link org.springframework.context.support.ResourceBundleMessageSource} 实例
 */
public class ResourceBundleMessageSourceDemo {
    public static void main(String[] args) {
        String baseName = "static.default";
        // ResourceBundle + MessageFormat > MessageSource
        // ResourceBundleMessageSource 不能重载
        // ReloadableResourceBundleMessageSource
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename(baseName);
        System.out.println(messageSource.getMessage("message",
                new Object[]{"darian"},
                Locale.CHINA));

        ReloadableResourceBundleMessageSource messageSource1 = new ReloadableResourceBundleMessageSource();

        messageSource1.setBasename(baseName);
//        messageSource1.clearCache();
//        messageSource1.setResourceLoader();

    }
}
