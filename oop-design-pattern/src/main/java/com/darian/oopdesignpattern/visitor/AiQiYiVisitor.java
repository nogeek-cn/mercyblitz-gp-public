package com.darian.oopdesignpattern.visitor;

/***
 * 爱奇艺登陆
 */
public class AiQiYiVisitor implements Visitor {
    @Override
    public void visit(Login login) {
        System.out.println("爱奇艺访问者：");
        login.accept(this);
    }

}
