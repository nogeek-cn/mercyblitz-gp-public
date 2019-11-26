package com.darian.spring.webmvc.auto.annnotation;




import org.springframework.context.annotation.Conditional;

import java.lang.annotation.*;

// 我在方法上面进行操作
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
//
@Conditional(OnClassCondition.class)
public @interface ConditionalOnClass {

    Class<?>[] value();
}
