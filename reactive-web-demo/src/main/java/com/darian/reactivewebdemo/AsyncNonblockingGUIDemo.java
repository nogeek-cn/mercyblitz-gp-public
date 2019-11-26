package com.darian.reactivewebdemo;


import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import static com.darian.reactivewebdemo.utils.PrintUtils.*;

/***
 * 异步非阻塞 + GUI 实例
 */
public class AsyncNonblockingGUIDemo {
    public static void main(String[] args) {
        // Swing JAVA GUI 类库
        // 创建一个窗口
        JFrame jFrame = new JFrame();
        // 简单的标题
        jFrame.setTitle("简单的 GUI 程序");
        jFrame.setBounds(300, 300, 400, 300);
        // 增加一个窗口关闭事件
        // 线程被切换 main -> AWT-EventQueue *
        // Reactive 这个就是
        jFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                println("销毁当前窗口");
                jFrame.dispose();
            }

            @Override
            public void windowClosed(WindowEvent e) {
                println("窗口被关闭，推出程序！");
                System.exit(0); // JVM 进程退出
            }
        });
        // 增加鼠标的监听
        jFrame.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                println("当前的鼠标的位置：X:[" + e.getX() + "] , Y:[" + e.getY() + "]");
            }
        });
        // 设置可视
        println("启动一个 JFrame 窗口");
        jFrame.setVisible(true);
    }
}
