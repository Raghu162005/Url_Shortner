
package com.app;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.*;
import java.sql.*;

@WebServlet("/stats")
public class StatsServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String code = request.getParameter("code");

        try {
            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(
                    "SELECT click_count FROM urls WHERE short_code=?"
            );
            ps.setString(1, code);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                int clicks = rs.getInt("click_count");

                request.setAttribute("clicks", clicks);
                request.setAttribute("shortUrl",
                        "http://localhost:8080/url-shortener/r/" + code);

                request.getRequestDispatcher("stats.jsp").forward(request, response);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}