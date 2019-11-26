package com.darian.javai18ndemo.javaee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.Format;
import java.text.NumberFormat;
import java.util.Locale;

@WebServlet(urlPatterns = "/local")
public class LocaleServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Locale locale = request.getLocale();
        long num = Long.parseLong(request.getParameter("num"));
        Format format = NumberFormat.getNumberInstance(locale);
        response.getWriter().println(format.format(num));
    }
}
