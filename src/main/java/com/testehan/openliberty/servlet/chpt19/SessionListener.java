package com.testehan.openliberty.servlet.chpt19;

import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

public class SessionListener implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("A new user accesed the app. It's new session id is :" + se.getSession().getId());
    }
}
