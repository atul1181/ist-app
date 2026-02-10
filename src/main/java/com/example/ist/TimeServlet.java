package com.example.ist;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ist-time")
public class TimeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws IOException {

        response.setContentType("text/html");

        // Time formatter
        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        // IST Time
        ZonedDateTime istTime =
                ZonedDateTime.now(ZoneId.of("Asia/Kolkata"));

        // UTC Time
        ZonedDateTime utcTime =
                ZonedDateTime.now(ZoneId.of("UTC"));

        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head>");
        out.println("<title>World Time</title>");
        out.println("<meta http-equiv='refresh' content='1'>"); // auto refresh every 1 sec
        out.println("</head>");
        out.println("<body style='font-family: Arial; text-align: center;'>");

        out.println("<h1>Current Time</h1>");

        out.println("<h2>🇮🇳 IST (Asia/Kolkata)</h2>");
        out.println("<h3>" + istTime.format(formatter) + "</h3>");

        out.println("<h2>🌍 UTC</h2>");
        out.println("<h3>" + utcTime.format(formatter) + "</h3>");

        out.println("</body>");
        out.println("</html>");
    }
}

