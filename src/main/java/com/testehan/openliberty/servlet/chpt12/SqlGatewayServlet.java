package com.testehan.openliberty.servlet.chpt12;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.*;

public class SqlGatewayServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String sqlStatement = request.getParameter("sqlStatement");
        String sqlResult = "";

        // connection details
        final String dbURL = "jdbc:postgresql://localhost/danteshte";
        final String username = "postgres";
        final String password = " postgres";

        try (Connection connection = DriverManager.getConnection(dbURL, username, password);
             Statement statement = connection.createStatement()) {

            // parse the SQL string
            sqlStatement = sqlStatement.trim();
            if (sqlStatement.length() >= 6) {
                String sqlType = sqlStatement.substring(0, 6);
                if (sqlType.equalsIgnoreCase("select")) {
                    // create the HTML for the result set
                    ResultSet resultSet = statement.executeQuery(sqlStatement);
                    sqlResult = SQLUtil.getHtmlTable(resultSet);
                    resultSet.close();
                } else {
                    int i = statement.executeUpdate(sqlStatement);
                    if (i == 0) { // a DDL statement
                        sqlResult = "<p > The statement executed successfully.< / p > ";
                    } else { // an INSERT, UPDATE, or DELETE statement
                        sqlResult = "<p > The statement executed successfully.<br> "
                                + i + " row(s) affected.</p>";
                    }
                }
            }

        } catch (SQLException e) {
            sqlResult = "<p>Error executing the SQL statement: <br>" + e.getMessage() + "</p>";
        }

        HttpSession session = request.getSession();
        session.setAttribute("sqlResult", sqlResult);
        session.setAttribute("sqlstatement", sqlStatement);

        String url = "/jsp/sqlgateway.jsp";
        getServletContext().getRequestDispatcher(url).forward(request, response);
    }
}
