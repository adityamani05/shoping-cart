package com.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;


public class TimeOutListener implements HttpSessionListener 
{
	HttpSession session;
 
    public void sessionCreated(HttpSessionEvent se) 
    { 
        session = se.getSession();
        session.setMaxInactiveInterval(150);
    }

    public void sessionDestroyed(HttpSessionEvent se) 
    { 
    	session.invalidate();
    }
	
}
