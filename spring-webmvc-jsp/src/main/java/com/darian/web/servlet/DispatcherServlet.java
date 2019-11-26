package com.darian.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DispatcherServlet extends HttpServlet {

    public void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // message 渲染上下文
        request.setAttribute("message", "hello, world");
        String path = request.getParameter("path");
        // forword -> index.jsp
        request.getRequestDispatcher(path)
                .forward(request, response);
    }
}
