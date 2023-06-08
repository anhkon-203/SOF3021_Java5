package com.example.sof3011_java5.controller.admin;

import com.example.sof3011_java5.entities.ChiTietSp;
import com.example.sof3011_java5.infrastructure.converter.ChiTietSPConvert;
import com.example.sof3011_java5.models.*;
import com.example.sof3011_java5.repositories.ChiTietSPRepository;
import com.example.sof3011_java5.services.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin/ctsp")
public class ChiTietSpController {

    @Autowired
    private ChiTietSanPhamService chiTietSPService;
    @Autowired
    private ChiTietSPRepository chiTietSPRepository;
    @Autowired
    private NSXService nsxService ;
    @Autowired
    private DongSPService dongSPService;
    @Autowired
    private MauSacService mauSacService;
    @Autowired
    private SanPhamService sanPhamService;
    @Autowired
    public ChiTietSPConvert chiTietSPConvert;
    @Autowired
    public ChiTietSPViewModel chiTietSPViewModel;

    @GetMapping("/index")
    public String index(Model model,
                        @RequestParam(defaultValue = "0" ,name = "page") int page

    ) {
        Pageable pageable = PageRequest.of(page, 2);
//        Page<ChiTietSp> list = chiTietSPRepository.findAll(pageable);
        Page<ChiTietSPViewModel> list = chiTietSPService.findAllPage(pageable);
        model.addAttribute("list", list);
        model.addAttribute("view", "/views/admin/ctsp/index.jsp");
        return "admin/layout";
    }

    @GetMapping("/create")
    public String create(
            Model model
    ) {
        List<MauSacViewModel> mauSacList = mauSacService.findAll();
        List<NSXViewModel> nsxList = nsxService.getAll();
        List<DongSPViewModel> dongSPList = dongSPService.getAll();
        List<SanPhamViewModel> sanPhamList = sanPhamService.findAll();
        model.addAttribute("action", "/admin/ctsp/store");
        model.addAttribute("mauSacList", mauSacList);
        model.addAttribute("nsxList", nsxList);
        model.addAttribute("dongSPList", dongSPList);
        model.addAttribute("sanPhamList", sanPhamList);
        model.addAttribute("ctsp", chiTietSPViewModel);
        model.addAttribute("view", "/views/admin/ctsp/create.jsp");
        return "admin/layout";
    }

    @PostMapping("store")
    public String store(@Valid @ModelAttribute("ctsp") ChiTietSPViewModel chiTietSPViewModel, BindingResult bindingResult,Model model
    ) {
        if (bindingResult.hasFieldErrors()) {
            List<MauSacViewModel> mauSacList = mauSacService.findAll();
            List<NSXViewModel> nsxList = nsxService.getAll();
            List<DongSPViewModel> dongSPList = dongSPService.getAll();
            List<SanPhamViewModel> sanPhamList = sanPhamService.findAll();
            model.addAttribute("mauSacList", mauSacList);
            model.addAttribute("nsxList", nsxList);
            model.addAttribute("dongSPList", dongSPList);
            model.addAttribute("sanPhamList", sanPhamList);
            return "admin/ctsp/create";
        }
        try {
            chiTietSPService.saveOrUpdate(chiTietSPViewModel);
            return "redirect:/admin/ctsp/index";
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/edit/{id}")
    public String edit(
            @PathVariable("id") ChiTietSp chiTietSp,
            Model model
    ) {
        chiTietSPConvert.toModel(chiTietSp);
        List<MauSacViewModel> mauSacList = mauSacService.findAll();
        List<NSXViewModel> nsxList = nsxService.getAll();
        List<DongSPViewModel> dongSPList = dongSPService.getAll();
        List<SanPhamViewModel> sanPhamList = sanPhamService.findAll();
        model.addAttribute("mauSacList", mauSacList);
        model.addAttribute("nsxList", nsxList);
        model.addAttribute("dongSPList", dongSPList);
        model.addAttribute("sanPhamList", sanPhamList);
        model.addAttribute("action", "/admin/ctsp/update/" + chiTietSp.getId());
        model.addAttribute("ctsp", chiTietSp);
        model.addAttribute("view", "/views/admin/ctsp/create.jsp");
        return "admin/layout";
    }

    @PostMapping("/update/{id}")
    public String update(
            @Valid @ModelAttribute("ctsp") ChiTietSPViewModel chiTietSPViewModel, BindingResult bindingResult,Model model
    ) {
        if (bindingResult.hasErrors()) {
            List<MauSacViewModel> mauSacList = mauSacService.findAll();
            List<NSXViewModel> nsxList = nsxService.getAll();
            List<DongSPViewModel> dongSPList = dongSPService.getAll();
            List<SanPhamViewModel> sanPhamList = sanPhamService.findAll();
            model.addAttribute("mauSacList", mauSacList);
            model.addAttribute("nsxList", nsxList);
            model.addAttribute("dongSPList", dongSPList);
            model.addAttribute("sanPhamList", sanPhamList);
            return "admin/ctsp/create";
        }
        chiTietSPService.saveOrUpdate(chiTietSPViewModel);
        return "redirect:/admin/ctsp/index";
    }

    @GetMapping("/delete/{id}")
    public String delete(
            @PathVariable("id") ChiTietSp chiTietSp
    ) {
        chiTietSPConvert.toModel(chiTietSp);
        chiTietSPService.deleteById(chiTietSp.getId());
        return "redirect:/admin/ctsp/index";
    }
}
