package com.darian.asyncweb.servlet;


import javax.servlet.AsyncContext;
import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/***
 * 访问 "/simple/async"
 */
@WebServlet(value = "/simple/async", asyncSupported = true)
public class SimpleAsyncServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        // 启动异步上下文
        AsyncContext asyncContext = request.startAsync();
        PrintWriter writer = response.getWriter();
        writer.println("[" + Thread.currentThread().getName() + "]:当前的线程开始执行....\n");

        asyncContext.addListener(new AsyncListener() {
            @Override
            public void onComplete(AsyncEvent asyncEvent) throws IOException {
                writer.println("[" + Thread.currentThread().getName() + "]:请求完成了！\n");
            }

            @Override
            public void onTimeout(AsyncEvent asyncEvent) throws IOException {
                writer.println("[" + Thread.currentThread().getName() + "]:请求超时了！\n");
            }

            @Override
            public void onError(AsyncEvent asyncEvent) throws IOException {
                writer.println("[" + Thread.currentThread().getName() + "]:请求错误了！\n");
            }

            @Override
            public void onStartAsync(AsyncEvent asyncEvent) throws IOException {
                writer.println("[" + Thread.currentThread().getName() + "]:异步请求开始了！\n");
            }
        });
        // 同步调用
//        asyncContext.complete();
        // 异步调用
        asyncContext.start(() -> {
            writer.println("[" + Thread.currentThread().getName() + "]:执行中！....\n");
            // 异步调用完成仍然需要通知
            asyncContext.complete();
        });
    }
}
