package com.testehan.openliberty.servlet.chpt7.cookie;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;

import java.io.IOException;

public class PageVisitsInCookieServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Cookie [] cookies = req.getCookies();
        String cookieValue = "";
        Cookie existingCookie = null;
        int visits = 0;

        if ( cookies!= null ) {
            for (Cookie c : cookies) {
                if (c.getName().equals("noOfVisits")) {
                    cookieValue = c.getValue();
                    existingCookie = c;
                }
            }
        }

        if (cookieValue.equals("")){
            existingCookie = new Cookie("noOfVisits","0");
        } else {
            visits = Integer.parseInt(cookieValue) + 1;
            existingCookie.setValue(visits+"");
        }

        existingCookie.setMaxAge(60*60*24*365*2);       // 2 years
//        existingCookie.setMaxAge(-1);       // per session cookie, is removed when user closes the window/browser
        existingCookie.setPath("/");

        resp.addCookie(existingCookie);
        resp.getWriter().println(visits);

    }

}
