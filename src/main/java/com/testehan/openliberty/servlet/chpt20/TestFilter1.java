package com.testehan.openliberty.servlet.chpt20;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class TestFilter1 implements Filter {
    private FilterConfig filterConfig = null;

    @Override
    public void init(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
    }


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException, IOException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        ServletContext sc = filterConfig.getServletContext();

        String filterName = filterConfig.getFilterName();
        String servletPath = "Servlet path: " + httpRequest.getServletPath();

        sc.log(filterName + " | " + servletPath + " | before request");
        System.out.println(filterName + " | " + servletPath + " | before request");

        chain.doFilter(httpRequest, httpResponse);

        sc.log(filterName + " | " + servletPath + " | after request");
        System.out.println(filterName + " | " + servletPath + " | after request");
    }

    @Override
    public void destroy() {
        filterConfig = null;
    }
}
