package com.darian.reactivewebdemo;


import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.darian.reactivewebdemo.utils.PrintUtils.*;

/***
 * 异步 + 非阻塞的 Servlet
 */
@WebServlet(urlPatterns = "/async",
        asyncSupported = true)
public class AsyncNonBlockingServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 开启 异步的上下文
        AsyncContext asyncContext = request.startAsync();
        println("异步上下文触发开始");
        // 非阻塞回调
        asyncContext.addListener(new AsyncListener() {
            @Override
            public void onComplete(AsyncEvent asyncEvent) throws IOException {
                ServletResponse response = asyncEvent.getSuppliedResponse();

                response.getOutputStream().println("hello, world [1] ");



                println("异步上下文执行完毕");
            }

            @Override
            public void onTimeout(AsyncEvent asyncEvent) throws IOException {
                println("异步上下文执行超时");
            }

            @Override
            public void onError(AsyncEvent asyncEvent) throws IOException {
                println("异步上下文执行错误");
            }

            @Override
            public void onStartAsync(AsyncEvent asyncEvent) throws IOException {
                println("异步上下文执行开始");
            }
        });


        ServletOutputStream outputStream = response.getOutputStream();
        outputStream.setWriteListener(new WriteListener() {
            // 非阻塞 I/O
            @Override
            public void onWritePossible() throws IOException {
                outputStream.println("hello, world [2] ");
                println("异步 + 非阻塞I/O  执行完毕");
            }

            @Override
            public void onError(Throwable throwable) {

            }
        });


        // 完成操作
        asyncContext.start(() -> {
            println("异步上下文触发结束");
            asyncContext.complete();
        });
    }
}
