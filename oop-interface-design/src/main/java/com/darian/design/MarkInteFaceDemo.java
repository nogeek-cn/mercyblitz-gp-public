package com.darian.design;

import java.io.Serializable;

/***
 * 标记(类属) 接口
 */
public class MarkInteFaceDemo {
    public static void main(String[] args) {
        // 序列化
//        Serializable
        // Hibernate Session / JPA
        // 实体（Entity） 实现序列化 Serializable
        // PK(Primary Key) 实现序列化 Serializable
        // PK(Primary Key) 的类型
        // 数值（Long、Integer、short、Double、Float）
        // 字符类型（String）
        Serializable value = new Long(1L);
        value = new Integer(1);
        value = new Short((short) 1);
        value = new Double(1);
        value =new Float(1);
        value = new String("Hello, World");

        save(1);
        save(1L);
        save("Hello, world");
    }

    public static void save(Serializable value){
        System.out.println("save:" + value);
    }

    // 多态对同一个行为有不同的派生，是对方法而言的。
}
