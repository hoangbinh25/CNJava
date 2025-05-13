package com.example;

import java.io.IOException;
import jakarta.*;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/count")
public class CountServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String input = request.getParameter("inputString");
        HttpSession session = request.getSession();
        session.setAttribute("inputString", input);

        int count = (input == null ? 0 : input.length());
        request.setAttribute("count", count);
        request.setAttribute("value", input);

        RequestDispatcher rd = request.getRequestDispatcher("/count.jsp");
        rd.forward(request, response);
    }
}