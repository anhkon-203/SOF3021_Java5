package com.example.sof3011_java5.controller.admin;

import com.example.sof3011_java5.entities.KhachHang;
import com.example.sof3011_java5.infrastructure.converter.KhachHangConvert;
import com.example.sof3011_java5.models.KhachHangViewModel;
import com.example.sof3011_java5.services.KhachHangService;
import com.example.sof3011_java5.services.impl.KhachHangServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/khach-hang")
public class KhachHangController {
    @Autowired
    private KhachHangService khachHangService = new KhachHangServiceImpl();
    @Autowired
    private KhachHangViewModel khachHangViewModel;
    @Autowired
    private KhachHangConvert khachHangConvert;


    @GetMapping("create")
    public String create(Model model){
        model.addAttribute("action", "/admin/khach-hang/store");
        model.addAttribute("kh", khachHangViewModel);
        model.addAttribute("view", "/views/admin/khach-hang/create.jsp");
        return "admin/layout";
    }
    @GetMapping("index")
    public String index(Model model){
        model.addAttribute("list", khachHangService.findAll());
        model.addAttribute("view", "/views/admin/khach-hang/index.jsp");
        return "admin/layout";
    }
    @GetMapping("edit/{id}")
    public String edit(Model model, @PathVariable("id") KhachHang khachHang){
        khachHangConvert.toModel(khachHang);
        model.addAttribute("action", "/admin/khach-hang/update/"+khachHang.getId());
        model.addAttribute("kh", khachHang);
        model.addAttribute("view", "/views/admin/khach-hang/create.jsp");
        return "admin/layout";
    }
    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") KhachHang khachHang){
        khachHangConvert.toModel(khachHang);
        khachHangService.deleteById(khachHang.getId());
        return "redirect:/admin/khach-hang/index";
    }
    @PostMapping("store")
    public String store(
            @Valid @ModelAttribute("kh") KhachHangViewModel khachHangViewModel, BindingResult result,Model model
    )
    {
        if (khachHangViewModel.getSdt().trim().isEmpty() || khachHangViewModel.getDiaChi().trim().isEmpty()) {
            model.addAttribute("error", "Không được để trống");
            return "admin/khach-hang/create";
        }
        if (result.hasErrors()) {
            return "admin/khach-hang/create";
        }
        khachHangViewModel.setMa(khachHangService.maKHCount());
        khachHangService.saveOrUpdate(khachHangViewModel);
        return "redirect:/admin/khach-hang/index";
    }
    @PostMapping("update/{id}")
    public String update(
            @Valid @ModelAttribute("kh") KhachHangViewModel khachHangViewModel, BindingResult result,Model model
    )
    {
        if (khachHangViewModel.getSdt().trim().isEmpty() || khachHangViewModel.getDiaChi().trim().isEmpty()) {
            model.addAttribute("error", "Không được để trống");
            return "admin/khach-hang/create";
        }
        if (result.hasErrors()) {
            return "admin/khach-hang/create";
        }
        khachHangService.saveOrUpdate(khachHangViewModel);
        return "redirect:/admin/khach-hang/index";
}
}
