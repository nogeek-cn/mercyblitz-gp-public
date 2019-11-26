package com.darian.javabeans;

import java.beans.*;
import java.lang.reflect.Method;
import java.util.List;
import java.util.stream.Stream;

import static java.lang.System.*;

/***
 * Java Beans 代码
 */
public class JavaBeansDemo {
    public static void main(String[] args) throws IntrospectionException, ClassNotFoundException {
        Class<?> aClass = Class.forName("com.darian.javabeans.User");
        BeanInfo beanInfo1 = Introspector.getBeanInfo(aClass, Object.class);

        // 方法会把父类子类的方法都加载进来，重载方法提供到 Object 类就停止，
        BeanInfo beanInfo = Introspector.getBeanInfo(User.class/*, Object.class*/);
        // Bean描述符（BeanDecriptor）
        // Bean，提供了一个 Java 类文件，还有一个全局的信息
        BeanDescriptor beanDescriptor = beanInfo.getBeanDescriptor();
//        out.println(beanDescriptor);
//         方法描述符（MethodDescriptor）
        MethodDescriptor[] methodDescriptors = beanInfo.getMethodDescriptors();
//        Stream.of(methodDescriptors).forEach(out::println);
        // 属性描述符（PropertyDescriptor）
        // 属性会带方法
        User user = new User();
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        Stream.of(propertyDescriptors).forEach(propertyDescriptor -> {
            String propertyName = propertyDescriptor.getName();
            if ("id".equals(propertyName)) {// 当属性的名称等于 "id" 时
                propertyDescriptor.setPropertyEditorClass(IdPropertiyEditor.class);
                PropertyEditor propertyEditor = propertyDescriptor.createPropertyEditor(user);
                propertyEditor.addPropertyChangeListener(new setPropertyChangeListener(user, propertyDescriptor.getWriteMethod()));
                // 触发事件，同时事件源 PropertyEditor
                propertyEditor.setAsText("1");
            }else if("date".equals(propertyName)){ //  date Date
                propertyDescriptor.setPropertyEditorClass(DatePropertyEditor.class);
                PropertyEditor propertyEditor = propertyDescriptor.createPropertyEditor(user);
                propertyEditor.addPropertyChangeListener(new setPropertyChangeListener(user, propertyDescriptor.getWriteMethod()));
                // 触发事件，同时事件源 PropertyEditor
                propertyEditor.setAsText("2018-11-30");
            }
        });

        out.println(user);

    }

    private static class setPropertyChangeListener implements PropertyChangeListener{
        private final Object bean;
        private final Method setterMethod;

        private  setPropertyChangeListener(Object bean, Method setterMethod) {
            this.bean = bean;
            this.setterMethod = setterMethod;
        }


        @Override
        public void propertyChange(PropertyChangeEvent evt) {
            PropertyEditor source = (PropertyEditor)evt.getSource();
            try {
                setterMethod.invoke(bean, source.getValue());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
