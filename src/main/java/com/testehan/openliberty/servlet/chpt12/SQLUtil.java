package com.testehan.openliberty.servlet.chpt12;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class SQLUtil {
    public static String getHtmlTable(ResultSet resultSet) throws SQLException {
        StringBuilder htmlTable = new StringBuilder();
        ResultSetMetaData metaData = resultSet.getMetaData();
        int columnCount = metaData.getColumnCount();

        htmlTable.append("<table>");

        // add header row
        htmlTable.append("<tr>");
        for (int i = 1; i <= columnCount; i++) {
            htmlTable.append("<th>");
            htmlTable.append (metaData.getColumnName(i));
            htmlTable.append("</th>");
        }
        htmlTable.append ("</tr>");

        // add all other rows
        while (resultSet.next()) {
            htmlTable.append("<tr>");
            for (int i = 1; i <= columnCount; i++) {
                htmlTable.append ("<td>");
                htmlTable.append(resultSet.getString(i));
                htmlTable.append("</td>");
            }
            htmlTable.append ("</tr>");
        }

        htmlTable.append ("</table>");
        return htmlTable.toString();

    }
}
