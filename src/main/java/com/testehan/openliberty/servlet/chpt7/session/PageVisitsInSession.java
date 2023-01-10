package com.testehan.openliberty.servlet.chpt7.session;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Enumeration;

public class PageVisitsInSession extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(); // using session object to pass values to another servlet
        Object visitsObject = session.getAttribute("noOfVisits");
        int visits=0;
        if (visitsObject != null ) {
            visits = (int) visitsObject;
            session.setAttribute("noOfVisits", ++visits);
        } else {
            session.setAttribute("noOfVisits", 0);
            session.setMaxInactiveInterval(200);        // after 200 seconds session is terminated/invalidated
//            session.setMaxInactiveInterval(-1);       only when browser is closed is session terminated/invalidated
        }

        resp.getWriter().println(visits);

        printVariousSessionInformation(session,resp);
    }

    private void printVariousSessionInformation(HttpSession session, HttpServletResponse resp) throws IOException {
        Enumeration<String> names = session.getAttributeNames();
        while (names.hasMoreElements()){
            resp.getWriter().println(names.nextElement());
        }

        resp.getWriter().println("Session id " + session.getId());
    }
}
