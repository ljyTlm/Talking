package com.ljy.controller;

import javax.servlet.http.HttpServletRequest;

public class BaseAction {
    /*
        省的每次强行转化了
     */
    public <T> T getParm(HttpServletRequest rq, String key){
        return (T)rq.getParameter (key);
    }

    public <T> void setAttr(HttpServletRequest rq, String key, T value){
        rq.setAttribute(key, value);
    }

    public <T> T getAttr(HttpServletRequest rq, String key){
        return (T)rq.getAttribute(key);
    }

    public <T> void setSession(HttpServletRequest rq, String key, T value){
        rq.getSession().setAttribute(key, value);
    }

    public <T> T getSession(HttpServletRequest rq, String key){
        return (T)rq.getSession().getAttribute(key);
    }

}
