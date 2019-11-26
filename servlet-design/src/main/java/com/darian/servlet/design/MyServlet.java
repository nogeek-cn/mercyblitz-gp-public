package com.darian.servlet.design;


import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "myServlet", urlPatterns = "/my-servlet",
        loadOnStartup = 1)
public class MyServlet extends HttpServlet {
    private String encoding;

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        encoding = servletConfig.getInitParameter("encoding");
        if (encoding == null) {
            encoding = "UTF-8";
        }
    }

    @Override
    public void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Servlet 规范说了，如果没有的话，默认的话 ISO-8859-1
        String requestEncoding = request.getCharacterEncoding() == null
                ? "ISO-8859-1" : request.getCharacterEncoding();

        response.setCharacterEncoding(encoding);

        String name = request.getParameter("name");
        name = new String(name.getBytes(requestEncoding), encoding);

        PrintWriter writer = response.getWriter();
        response.setContentType("text/plain;charset=" + encoding);
        writer.println(name);
        writer.flush();
    }
}
