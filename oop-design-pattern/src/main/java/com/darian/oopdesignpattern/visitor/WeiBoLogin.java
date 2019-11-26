package com.darian.oopdesignpattern.visitor;

/***
 * 微博登陆
 */
public class WeiBoLogin implements Login {
    @Override
    public void accept(Visitor visitor) {
        System.out.println(visitor.getClass().getSimpleName()
                + "访问者 - 微博登陆");
    }
}
