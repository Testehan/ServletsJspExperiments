package com.testehan.openliberty.servlet.chpt19;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class DisplayDataInitializedInListenerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        final String custServEmail = (String)getServletContext().getAttribute("custServEmail");
        final int currentYear = (int)getServletContext().getAttribute("currentYear");
        final String productsFilePath = (String)getServletContext().getAttribute("productsPath");

        PrintWriter printWriter = resp.getWriter();
        printWriter.println("custServEmail =" + custServEmail);
        printWriter.println("currentYear =" + currentYear);
        printWriter.println("productsFilePath =" + productsFilePath);
    }
}
