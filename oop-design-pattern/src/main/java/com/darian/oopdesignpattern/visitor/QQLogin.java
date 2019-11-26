package com.darian.oopdesignpattern.visitor;

public class QQLogin implements Login {
    @Override
    public void accept(Visitor visitor) {
        System.out.println(visitor.getClass().getSimpleName()
                + "访问者访问 -  QQ登陆");

    }
}
