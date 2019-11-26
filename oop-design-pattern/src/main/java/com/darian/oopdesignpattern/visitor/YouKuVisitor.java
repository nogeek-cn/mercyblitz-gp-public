package com.darian.oopdesignpattern.visitor;

/***
 * 优酷的访问者
 */
public class YouKuVisitor implements Visitor {
    @Override
    public void visit(Login login) {
        System.out.println("优酷访问者：");
        login.accept(this);
    }


}
