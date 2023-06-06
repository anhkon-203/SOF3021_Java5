package com.example.sof3011_java5.controller.user;

import com.example.sof3011_java5.entities.ChiTietSp;
import com.example.sof3011_java5.models.ChiTietSPViewModel;
import com.example.sof3011_java5.services.ChiTietSanPhamService;
import com.example.sof3011_java5.services.impl.ChiTietSPServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/user")
public class SanPhamUserController {
    @Autowired
    private ChiTietSanPhamService chiTietSanPhamService = new ChiTietSPServiceImpl();

    @GetMapping("/san-pham")
    public String sanPham(
            Model model
                          ) {
        model.addAttribute("list", chiTietSanPhamService.findAll());
        model.addAttribute("view", "/views/user/san-pham/sanPham.jsp");
        return "user/layout";
    }
    @GetMapping("/chi-tiet-san-pham/{id}")
    public String chiTietSanPham(
            Model model,
            @PathVariable("id") UUID id
    ) {
        String tenDongSP = chiTietSanPhamService.findTenDongSP(id);
        List<ChiTietSPViewModel> list = chiTietSanPhamService.findBySanPhamId(id);
        List<ChiTietSPViewModel> listByCategory = chiTietSanPhamService.findByTenDongSP(tenDongSP);
        model.addAttribute("list", list);
        model.addAttribute("listByCategory", listByCategory);
        model.addAttribute("view", "/views/user/san-pham/chiTietSanPham.jsp");
        return "user/layout";
    }
}
