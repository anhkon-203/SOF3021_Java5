package com.example.sof3011_java5.controller.admin;

import com.example.sof3011_java5.entities.CuaHang;
import com.example.sof3011_java5.infrastructure.converter.CuaHangConvert;
import com.example.sof3011_java5.models.CuaHangViewModel;
import com.example.sof3011_java5.service.CuaHangService;
import com.example.sof3011_java5.service.impl.CuaHangServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/cua-hang")
public class CuaHangController {
    @Autowired
    private CuaHangService cuaHangService = new CuaHangServiceImpl();

    @Autowired
    private CuaHangViewModel cuaHangViewModel;

    @Autowired
    private CuaHangConvert cuaHangConvert;

    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("list", cuaHangService.findAll());
        return "/admin/cua-hang/index";
    }
    @GetMapping("/create")
    public String create(Model model, CuaHangViewModel cuaHangViewModel) {
        model.addAttribute("action", "/admin/cua-hang/store");
        model.addAttribute("cuaHang", cuaHangViewModel);
        return "/admin/cua-hang/create";
    }
    @GetMapping("/edit/{id}")
    public String edit(Model model,@PathVariable("id") CuaHang cuaHang) {
        cuaHangConvert.toModel(cuaHang);
        model.addAttribute("action", "/admin/cua-hang/update/" + cuaHang.getId());
        model.addAttribute("cuaHang", cuaHang);
        return "/admin/cua-hang/create";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") CuaHang cuaHang) {
        cuaHangConvert.toModel(cuaHang);
        cuaHangService.deleteById(cuaHang.getId());
        return "redirect:/admin/cua-hang/index";
    }

    @PostMapping("/store")
    public String store(
            @Valid @ModelAttribute("cuaHang") CuaHangViewModel cuaHangViewModel, BindingResult result
            ){
        if (result.hasErrors()) {
            return "admin/cua-hang/create";
        }
        cuaHangViewModel.setMa(cuaHangService.maCHCount());
        cuaHangService.saveOrUpdate(cuaHangViewModel);
        return "redirect:/admin/cua-hang/index";
    }
    @PostMapping("/update/{id}")
    public String update(
            @Valid @ModelAttribute("cuaHang") CuaHangViewModel cuaHangViewModel, BindingResult result
    ){
        if (result.hasErrors()) {
            return "admin/cua-hang/create";
        }
        cuaHangService.saveOrUpdate(cuaHangViewModel);
        return "redirect:/admin/cua-hang/index";
    }
}
