package com.example.sof3011_java5.filter;

import com.example.sof3011_java5.models.KhachHangViewModel;
import com.example.sof3011_java5.models.NhanVienViewModel;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class UserFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        HttpSession session = httpRequest.getSession();
        KhachHangViewModel khachHangViewModel = (KhachHangViewModel) session.getAttribute("user");

        if (httpRequest.getRequestURI().equals(httpRequest.getContextPath() + "/user/login")) {
            chain.doFilter(request, response);
        } else if (khachHangViewModel == null) {
            httpResponse.sendRedirect(httpRequest.getContextPath() + "/user/login");
        } else {
            chain.doFilter(request, response);
        }
    }
    }


