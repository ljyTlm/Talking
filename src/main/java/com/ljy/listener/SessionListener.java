package com.ljy.listener;

import org.apache.log4j.Logger;
import sun.rmi.runtime.Log;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.ArrayList;
import java.util.List;

public class SessionListener implements HttpSessionListener {

    private static Logger log = Logger.getRootLogger();

    @Override
    public void sessionCreated(HttpSessionEvent event) {
        log.info("session监听器正在工作：session正在创建");
        HttpSession session = event.getSession();
        ServletContext ctx = session.getServletContext( );
        List<HttpSession> list = (List<HttpSession>) ctx.getAttribute("users");
        if (list == null){
            list = new ArrayList<>();
        }
        list.add(session);
        ctx.setAttribute("users", list);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent event) {
        log.info("session监听器正在工作：session正在销毁");
        HttpSession session = event.getSession();
        ServletContext ctx = session.getServletContext( );
        List<String> list = (List<String>) ctx.getAttribute("users");
        if (list == null){
            return;
        }
        list.remove(session);
        ctx.setAttribute("users", list);
    }
}
