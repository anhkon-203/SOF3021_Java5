package com.example.sof3011_java5.controller.admin;

import com.example.sof3011_java5.entities.ChiTietSp;
import com.example.sof3011_java5.entities.MauSac;
import com.example.sof3011_java5.entities.NhanVien;
import com.example.sof3011_java5.infrastructure.converter.ChiTietSPConvert;
import com.example.sof3011_java5.infrastructure.converter.NhanVienConvert;
import com.example.sof3011_java5.models.*;
import com.example.sof3011_java5.service.*;
import com.example.sof3011_java5.service.impl.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin/ctsp")
public class ChiTietSpController {

    @Autowired
    private ChiTietSanPhamService chiTietSPService = new ChiTietSPServiceImpl();
    @Autowired
    private NSXService nsxService = new NSXServiceImpl();
    @Autowired
    private DongSPService dongSPService = new DongSPServiceImpl();
    @Autowired
    private MauSacService mauSacService = new MauSacServiceImpl();
    @Autowired
    private SanPhamService sanPhamService = new SanPhamServiceImpl();
    @Autowired
    public ChiTietSPConvert chiTietSPConvert;
    @Autowired
    public ChiTietSPViewModel chiTietSPViewModel;

    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("list", chiTietSPService.findAll());
        return "admin/ctsp/index";
    }
    @GetMapping("/create")
    public String create(
            Model model
    )
    {
        List<MauSacViewModel> mauSacList = mauSacService.findAll();
        List<NSXViewModel> nsxList = nsxService.getAll();
        List<DongSPViewModel> dongSPList = dongSPService.getAll();
        List<SanPhamViewModel> sanPhamList = sanPhamService.findAll();
        model.addAttribute("action","/admin/ctsp/store");
        model.addAttribute("mauSacList",mauSacList);
        model.addAttribute("nsxList",nsxList);
        model.addAttribute("dongSPList",dongSPList);
        model.addAttribute("sanPhamList",sanPhamList);
        model.addAttribute("ctsp", chiTietSPViewModel);
        return "admin/ctsp/create";
    }

    @PostMapping("/store")
    public String store(
    @Valid @ModelAttribute("nv") ChiTietSPViewModel chiTietSPViewModel,BindingResult bindingResult
            )
    {
        if (bindingResult.hasErrors()) {
            return "admin/ctsp/create";
        }
        chiTietSPService.saveOrUpdate(chiTietSPViewModel);
        return "redirect:/admin/ctsp/index";
    }
    @GetMapping("/edit/{id}")
    public String edit(
            @PathVariable("id") ChiTietSp chiTietSp,
            Model model
    )

    {
        chiTietSPConvert.toModel(chiTietSp);
        List<MauSacViewModel> mauSacList = mauSacService.findAll();
        List<NSXViewModel> nsxList = nsxService.getAll();
        List<DongSPViewModel> dongSPList = dongSPService.getAll();
        List<SanPhamViewModel> sanPhamList = sanPhamService.findAll();
        model.addAttribute("mauSacList",mauSacList);
        model.addAttribute("nsxList",nsxList);
        model.addAttribute("dongSPList",dongSPList);
        model.addAttribute("sanPhamList",sanPhamList);
        model.addAttribute("action","/admin/ctsp/update/"+chiTietSp.getId());
        model.addAttribute("ctsp",chiTietSp);
        return "admin/ctsp/create";
    }
    @PostMapping("/update/{id}")
    public String update(
        @Valid @ModelAttribute("ctsp") ChiTietSPViewModel chiTietSPViewModel,BindingResult bindingResult
    )
    {
        if (bindingResult.hasErrors()) {
            return "admin/ctsp/create";
        }
        chiTietSPService.saveOrUpdate(chiTietSPViewModel);
        return "redirect:/admin/ctsp/index";
    }
    @GetMapping("/delete/{id}")
    public String delete(
            @PathVariable("id") ChiTietSp chiTietSp
    )
    {
        chiTietSPConvert.toModel(chiTietSp);
        chiTietSPService.deleteById(chiTietSp.getId());
        return "redirect:/admin/ctsp/index";
    }
}
