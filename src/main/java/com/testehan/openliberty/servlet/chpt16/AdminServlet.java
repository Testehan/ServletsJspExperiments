package com.testehan.openliberty.servlet.chpt16;

import jakarta.inject.Inject;
import jakarta.security.enterprise.SecurityContext;
import jakarta.security.enterprise.authentication.mechanism.http.FormAuthenticationMechanismDefinition;
import jakarta.security.enterprise.authentication.mechanism.http.LoginToContinue;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.HttpConstraint;
import jakarta.servlet.annotation.ServletSecurity;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@FormAuthenticationMechanismDefinition(
        loginToContinue = @LoginToContinue(errorPage = "/error.html",
                loginPage = "/login.html"))
@ServletSecurity(value = @HttpConstraint(rolesAllowed = { "user", "admin" },
        transportGuarantee = ServletSecurity.TransportGuarantee.CONFIDENTIAL))
public class AdminServlet extends HttpServlet {

    @Inject
    private SecurityContext securityContext;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Inside doGet AdminServlet");
        if (securityContext.isCallerInRole("admin")) {
            resp.getWriter().println("You are in admin page");
        }
    }
}
