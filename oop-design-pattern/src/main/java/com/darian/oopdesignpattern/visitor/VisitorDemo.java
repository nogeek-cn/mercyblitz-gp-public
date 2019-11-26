package com.darian.oopdesignpattern.visitor;


public class VisitorDemo {
    public static void main(String[] args) {
        // 创建一个优酷的访问者
        Visitor visitor = new YouKuVisitor();
        // 微博登陆
        Login login = new WeiBoLogin();
        // 优酷访问者 -> 微博登陆
        visitor.visit(login);

        // 创建爱奇艺的访问者
        visitor = new AiQiYiVisitor();
        // 爱奇艺访问者 -> 微博登陆
        visitor.visit(login);

        login = new QQLogin();
        // 爱奇艺访问者 -》 QQ登陆
        visitor.visit(login);
    }
}
