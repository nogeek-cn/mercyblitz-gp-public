package com.darian.spring.webmvc.auto.annnotation;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.util.MultiValueMap;

import javax.security.auth.callback.Callback;
import java.util.List;


/***
 * 当指定的某个类存在时，满足条件
 */
public class OnClassCondition implements Condition {
    public boolean matches(ConditionContext context,
                           AnnotatedTypeMetadata metadata) {
        boolean matchecd = false;
        // 获取所有 ConditionOnClass 中的属性方法
        MultiValueMap<String, Object> attributes = metadata.getAllAnnotationAttributes(ConditionalOnClass.class.getName());
        // 获取 value() 方法中配置的值。
        List<Object> classes = attributes.get("value");

        try {
            for (Object klass : classes) {
                // 如果异常的话，说明 class 不存在
                Class<?> type = (Class<?>) klass;
                matchecd = true;
            }
        } catch (Throwable e) {
            matchecd= false;
        }

        System.err.println("OnClassCondition 是否匹配：" + matchecd);

        return matchecd;
    }
}
