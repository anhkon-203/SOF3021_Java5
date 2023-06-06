package com.example.sof3011_java5.controller.user;

import com.example.sof3011_java5.infrastructure.converter.KhachHangConvert;
import com.example.sof3011_java5.models.GioHangViewModel;
import com.example.sof3011_java5.models.KhachHangViewModel;
import com.example.sof3011_java5.request.LoginUserRequest;
import com.example.sof3011_java5.services.GioHangService;
import com.example.sof3011_java5.services.KhachHangService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;

@Controller
@RequestMapping("/user")
public class LoginUserController {
    @Autowired
    private HttpSession session;
    @Autowired
    private LoginUserRequest loginUserRequest;
    @Autowired
    private KhachHangViewModel khachHangViewModel;
    @Autowired
    private GioHangService gioHangService;
    @Autowired
    private KhachHangService khachHangService;

    @Autowired
    private KhachHangConvert khachHangConvert;

    @RequestMapping("/login")
    public String home(Model model) {
        model.addAttribute("user", loginUserRequest);
        return "user/dang-nhap/login";
    }

    @PostMapping("/check-login")
    public String login(Model model
            , @ModelAttribute("user") LoginUserRequest loginUserRequest) {
        KhachHangViewModel khachHang = khachHangService.checkLogin(loginUserRequest);
        String email = loginUserRequest.getEmail();
        String password = loginUserRequest.getMatKhau();
        if (email.trim().isEmpty() || password.trim().isEmpty()) {
            model.addAttribute("error", "Vui lòng nhập đầy đủ thông tin");
            return "user/dang-nhap/login";
        }

        if (khachHang != null) {
            session.setAttribute("user", khachHang);
            return "redirect:/user/san-pham";
        } else {
            model.addAttribute("error", "Sai tài khoản hoặc mật khẩu");
            return "user/dang-nhap/login";
        }
    }

    @GetMapping("/logout")
    public String logout() {
        session.removeAttribute("user");
        return "redirect:/user/san-pham";
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("kh", khachHangViewModel);
        return "user/dang-nhap/register";
    }

    @PostMapping("/register")
    public String register(
            @ModelAttribute("kh") KhachHangViewModel khachHangViewModel, GioHangViewModel gioHangViewModel) {
        khachHangViewModel.setMa(khachHangService.maKHCount());
        KhachHangViewModel khachHang = khachHangService.register(khachHangViewModel);
        //
        gioHangViewModel.setKhachHang(khachHangConvert.toEntity(khachHang));
        gioHangViewModel.setMa(khachHang.getMa());
        int year = LocalDate.now().getYear();
        int month = LocalDate.now().getMonthValue();
        int day = LocalDate.now().getDayOfMonth();
        gioHangViewModel.setNgayTao(java.sql.Date.valueOf(LocalDate.of(year, month, day)));
        gioHangViewModel.setTrangThai(0);
        gioHangService.saveOrUpdate(gioHangViewModel);
        return "redirect:/user/login";
    }
}
