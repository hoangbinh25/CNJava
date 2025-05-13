package com.example;

import java.io.IOException;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.*;

@WebFilter("/count")
public class InputFilter implements Filter {
    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        String input = request.getParameter("inputString");
        if (input == null || input.trim().isEmpty()) {
            request.setAttribute("error", "Vui lòng nhập chuỗi trước khi đếm.");
            request.getRequestDispatcher("/count.jsp").forward(request, res);
        } else {
            chain.doFilter(req, res);
        }
    }
}
