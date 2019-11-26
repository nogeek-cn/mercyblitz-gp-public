package com.darian.servlet.comet;


import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;

@WebServlet("/chat/ajax")
public class ChatAjaxServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /***
     * 1 个服务器，对应多个客户端
     */
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("userName");
        String message = request.getParameter("message");

        String content = "User : [" + userName + "]::--" + message;
        // 通过上下文去传递

        ServletContext servletContext = request.getServletContext();
        BlockingQueue<String> messages = (BlockingQueue<String>) servletContext.getAttribute("messages");
        messages.offer(content);
    }
}
