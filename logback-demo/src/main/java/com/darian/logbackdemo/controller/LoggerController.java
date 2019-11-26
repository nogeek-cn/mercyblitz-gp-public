package com.darian.logbackdemo.controller;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoggerController extends BaseController{

    @GetMapping("/log")
    public void log(@RequestParam String message) {
        System.setProperty("path","....");

        if( logger instanceof ch.qos.logback.classic.Logger){
            ch.qos.logback.classic.Logger.class.cast(logger).setLevel(Level.DEBUG);
        }
        logger.debug(message);
    }
}
