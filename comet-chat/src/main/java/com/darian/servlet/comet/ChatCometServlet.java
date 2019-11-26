package com.darian.servlet.comet;

import org.apache.catalina.comet.CometEvent;
import org.apache.catalina.comet.CometProcessor;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingQueue;

import static org.apache.catalina.comet.CometEvent.*;

@WebServlet("/chat/comet")
public class ChatCometServlet extends HttpServlet
        implements CometProcessor {
    private List<Writer> streams;
    private BlockingQueue<String> messages;

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        // Servlet 是线程不安全的，我要并发，
        // 所有的用户的连接
        streams = new CopyOnWriteArrayList<>();
        messages = new LinkedBlockingQueue<>();

        ServletContext servletContext = servletConfig.getServletContext();
        servletContext.setAttribute("messages", messages);
        // 我需要异步的通知所有的用户
        Thread thread = new Thread(() -> {
            try {
                // 获取最新的消息
                final String message = messages.take();

                // 广播所有的客户端
                streams.forEach(writer -> {
                    try {
                        writer.write("<script>parent.appendMsg('" + message + "'</script>");
                        writer.flush();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
            } catch (InterruptedException e) {
                // 标记个状态，让线程停止。
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }, "聊天广播线程");

        thread.start();
    }

    public void event(CometEvent cometEvent) throws IOException, ServletException {
        EventType eventType = cometEvent.getEventType();
        switch (eventType) {
            // Reactor 模式
            case BEGIN:
                onBegin(cometEvent);
                break;
            case READ:
                onRead(cometEvent);
                break;
            case END:
                onEnd(cometEvent);
                break;
            case ERROR:
                onError(cometEvent);
                break;
            default:
                break;
        }
    }

    private void onBegin(CometEvent cometEvent)
            throws IOException, ServletException {
        HttpServletResponse response = cometEvent.getHttpServletResponse();
        PrintWriter writer = response.getWriter();
        // 增加一个用户
        streams.add(writer);
        System.out.println("当前在线的用户的数量：" + streams.size());
    }

    private void onRead(CometEvent cometEvent)
            throws IOException, ServletException {

    }

    private void onEnd(CometEvent cometEvent)
            throws IOException, ServletException {
        HttpServletResponse response = cometEvent.getHttpServletResponse();
        PrintWriter writer = response.getWriter();
        // 完成的时候移除
        streams.remove(writer);
        System.out.println("当前在线的用户的数量：" + streams.size());
    }

    private void onError(CometEvent cometEvent)
            throws IOException, ServletException {
        // 错误的时候也要移除
        onEnd(cometEvent);
    }
}
