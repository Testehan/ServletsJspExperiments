package com.testehan.openliberty.servlet.chpt19;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class AppStartContextListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent event) {

        ServletContext sc = event.getServletContext();

        // initialize the customer service email address
        String custServEmail = sc.getInitParameter("custServEmail");
        sc.setAttribute("custServEmail", custServEmail);

        // initialize the current year
        GregorianCalendar currentDate = new GregorianCalendar();
        int currentYear = currentDate.get(Calendar.YEAR);
        sc.setAttribute("currentYear", currentYear);

        // initialize the path for the products text file
        String productsPath = sc.getRealPath("/WEB-INF/products.txt");
        sc.setAttribute("productsPath", productsPath);

        // initialize the list of products from the file..or read from DB..
//        ArrayList<Product> products = ProductI0O.getProducts(productsPath);
//        sc.setAttribute("products", products);
    }

    public void contextDestroyed(ServletContextEvent event) {
        // no cleanup necessary..you could close DB connections or
    }


}
