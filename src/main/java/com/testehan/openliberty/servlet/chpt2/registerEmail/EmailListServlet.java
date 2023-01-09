package com.testehan.openliberty.servlet.chpt2.registerEmail;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class EmailListServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = "/index.html";

        log("I am in post method"); // this will appear in the file messages.log (target/liberty/wlp/usr/servers/defaultServer/logs/messages.log)

        // get current action
        String action = req.getParameter("action");
        if (action == null) {
            action = "join"; // default action
        }

        // perform action and set URL to appropriate page
        if (action.equals("join")) {
            url = "/index.html"; // the "join" page

        } else if (action.equals("add")) {
        // get parameters from the request
            String firstName = req.getParameter("firstName");
            String lastName = req.getParameter("lastName");
            String email = req.getParameter("email");

            // store data in User object and save User object in database
            User user = new User(firstName, lastName, email);
//            UserDB.insert(user);

            // set User object in request object and set URL
            req.setAttribute("user", user);
            url = "jsp/thanks.jsp"; // the "thanks" page

        }

        // forward request and response objects to specified URL
        getServletContext().getRequestDispatcher(url).forward(req, resp);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       doPost(req,resp);
    }
}
