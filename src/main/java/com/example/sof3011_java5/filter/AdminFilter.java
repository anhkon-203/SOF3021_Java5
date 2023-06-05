package com.example.sof3011_java5.filter;

import com.example.sof3011_java5.models.NhanVienViewModel;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
public class AdminFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        HttpSession session = httpRequest.getSession();
        NhanVienViewModel nhanVien = (NhanVienViewModel) session.getAttribute("nv");

        if (httpRequest.getRequestURI().equals(httpRequest.getContextPath() + "/login")) {
            chain.doFilter(request, response);
        } else if (nhanVien == null) {
            httpResponse.sendRedirect(httpRequest.getContextPath() + "/login");
        } else {
            chain.doFilter(request, response);
        }
    }
}

