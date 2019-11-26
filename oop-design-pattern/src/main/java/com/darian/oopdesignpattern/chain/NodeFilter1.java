package com.darian.oopdesignpattern.chain;


import javax.servlet.*;
import java.io.IOException;

/***
 * NodeFilter1 -> Servlet1
 */
public class NodeFilter1 implements javax.servlet.Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        if (true){
            // 条件式的阻断
            return;
        }

        /***
         * Before
         */

        // 执行下一个节点
        filterChain.doFilter(servletRequest,servletResponse);

        /***
         * After
         */
    }

}
