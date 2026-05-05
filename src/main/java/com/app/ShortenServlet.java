package com.app;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.*;
import java.sql.*;
import java.util.UUID;

@WebServlet("/shorten")
public class ShortenServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String url = request.getParameter("url");
        String custom = request.getParameter("custom");

        // Generate short code
        String code = (custom != null && !custom.isEmpty())
                ? custom
                : UUID.randomUUID().toString().substring(0, 6);

        try {
            Connection con = DBConnection.getConnection();

            // Check duplicate
            PreparedStatement check = con.prepareStatement(
                    "SELECT * FROM urls WHERE short_code=?"
            );
            check.setString(1, code);
            ResultSet rs = check.executeQuery();

            if (rs.next()) {
                response.setContentType("text/html");
                response.getWriter().println("<h3>Custom URL already taken!</h3>");
                return;
            }

            // Insert into DB
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO urls(original_url, short_code, click_count) VALUES(?,?,0)"
            );
            ps.setString(1, url);
            ps.setString(2, code);
            ps.executeUpdate();

            // Short URL
            String shortUrl = "http://10.34.101.175:8080/r/" + code;

            // ✅ CORRECT QR PATH (inside webapp/qr)
            String folderPath = getServletContext().getRealPath("/qr");

            File folder = new File(folderPath);
            if (!folder.exists()) {
                folder.mkdirs(); // ensure folder exists
            }

            String qrPath = folderPath + File.separator + code + ".png";

            System.out.println("QR Path: " + qrPath); // debug

            QRUtil.generate(shortUrl, qrPath);

            // Send to JSP
            request.setAttribute("shortUrl", shortUrl);
            request.setAttribute("code", code);

            request.getRequestDispatcher("result.jsp").forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("<h3>Error: " + e.getMessage() + "</h3>");
        }
    }
}