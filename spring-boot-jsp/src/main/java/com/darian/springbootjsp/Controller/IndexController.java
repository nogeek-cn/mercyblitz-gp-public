package com.darian.springbootjsp.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Controller
public class IndexController {


    @RequestMapping("/index")
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest,
                                      HttpServletResponse httpServletResponse) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        // 封装模型
        Map<String, Object> model = modelAndView.getModel();
        model.put("1", "aaa");
        // 设置页面
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @GetMapping("index2")
    public String excute(Model model) {
        model.addAttribute("11", "aaa");
        return "index";
    }
}
