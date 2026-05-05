package com.app;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.*;
import java.sql.*;

@WebServlet("/r/*")
public class RedirectServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        String code = request.getPathInfo();

        if (code == null || code.equals("/")) {
            response.sendRedirect("index.jsp");
            return;
        }

        code = code.substring(1);

        try {
            Connection con = DBConnection.getConnection();

            // Get original URL
            PreparedStatement ps = con.prepareStatement(
                    "SELECT original_url FROM urls WHERE short_code=?"
            );
            ps.setString(1, code);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                // 🔥 Update click count
                PreparedStatement update = con.prepareStatement(
                        "UPDATE urls SET click_count = click_count + 1 WHERE short_code=?"
                );
                update.setString(1, code);
                update.executeUpdate();

                String originalUrl = rs.getString("original_url");

                // Redirect
                response.sendRedirect(originalUrl);

            } else {
                response.getWriter().println("<h3>Invalid Short URL</h3>");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}