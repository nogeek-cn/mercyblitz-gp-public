package com.darian.oopdesignpattern.visitor;

/***
 * 微信登陆
 */
public class WeChatLogin implements Login {
    @Override
    public void accept(Visitor visitor) {
        System.out.println(visitor.getClass().getSimpleName()
                + "访问者访问 -  微信登陆");
    }
}
