package com.darian.oopdesignpattern.chain;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Servlet1 extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // + 1
        // + 2

        // save()  ->  Save Node
        // update()  ->  Update  Node (Servlet 2  用到了)
        // delete()   ->  Delete Node

        // servletFilter -> updateFilter  -> Servlet1
        // updateFilter  ->  Servlet2
    }
}
