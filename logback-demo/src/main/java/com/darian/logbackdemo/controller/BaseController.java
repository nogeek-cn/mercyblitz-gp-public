package com.darian.logbackdemo.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class BaseController  {
    protected final Logger logger = LoggerFactory.getLogger(BaseController.class);

}
