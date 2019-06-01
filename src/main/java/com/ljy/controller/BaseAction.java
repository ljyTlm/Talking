package com.ljy.controller;

import javax.servlet.http.HttpServletRequest;

public class BaseAction {
    /*
        省的每次强行转化了
     */
    public <T> T getParm(HttpServletRequest rq, String key, Class<T> type){
        return (T)rq.getParameter (key);
    }

}
