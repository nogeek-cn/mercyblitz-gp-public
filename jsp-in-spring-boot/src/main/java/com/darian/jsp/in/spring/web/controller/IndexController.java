package com.darian.jsp.in.spring.web.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/***
 * Index Controller (Application Controller)
 */
@Controller
public class IndexController {

    @GetMapping("/")
    public String index(@RequestParam(required = false) String message,
                        Model model) {
        model.addAttribute("message", message);

        return "index";
    }
}