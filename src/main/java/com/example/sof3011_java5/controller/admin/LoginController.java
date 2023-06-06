package com.example.sof3011_java5.controller.admin;

import com.example.sof3011_java5.infrastructure.converter.NhanVienConvert;
import com.example.sof3011_java5.models.NhanVienViewModel;
import com.example.sof3011_java5.request.LoginAdminRequest;
import com.example.sof3011_java5.services.NhanVienService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {
    @Autowired
    private NhanVienService nhanVienService;
    @Autowired
    private LoginAdminRequest loginAdminRequest;

    @Autowired
    private HttpSession session;

    @GetMapping("loginAdmin")
    public String index(Model model) {
        model.addAttribute("admin", loginAdminRequest);
        return "admin/loginAdmin";
    }

    @PostMapping("check-loginAdmin")
    public String login( @ModelAttribute("admin") LoginAdminRequest loginAdminRequest,Model model) {
        NhanVienViewModel nhanVien = nhanVienService.checkLogin(loginAdminRequest);
        String email = loginAdminRequest.getEmail();
        String password = loginAdminRequest.getMatKhau();
        if (email.trim().isEmpty() || password.trim().isEmpty()) {
            model.addAttribute("error", "Vui lòng nhập đầy đủ thông tin");
            return "admin/loginAdmin";
        }
        if (nhanVien != null) {
            session.setAttribute("nv", nhanVien);
            return "redirect:/admin/san-pham/index";
        } else {
            model.addAttribute("error", "Sai tài khoản hoặc mật khẩu");
            return "admin/loginAdmin";
        }
    }
}
