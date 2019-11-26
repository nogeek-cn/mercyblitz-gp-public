package com.darian.springbootvelocity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

    @RequestMapping("/index")
    public ModelAndView index(@RequestParam(required = false) String message){
        // 模（mu）板渲染
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.getModel().put("message", message);
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @RequestMapping("/index2")
    public String index1(@RequestParam(required = false) String message,
                         Model model){
        model.addAttribute("message", message);
        return "index";
    }
}
