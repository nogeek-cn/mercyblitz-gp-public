package com.darian.oopdesignpattern.visitor;

/***
 * 访问者接口
 */
public interface Visitor {

    /***
     * 对于访问者而言，登陆时访问的对象。
     * @param login
     */
    void visit(Login login);

}
