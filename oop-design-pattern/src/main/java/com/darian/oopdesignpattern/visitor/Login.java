package com.darian.oopdesignpattern.visitor;


/***
 * 登陆接口
 */
public interface Login {

    /***
     * 对于登陆业务而言，访问者时被动接受的
     * @param visitor
     */
    void accept(Visitor visitor);
}
