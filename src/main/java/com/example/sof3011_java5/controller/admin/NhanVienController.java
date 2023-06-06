package com.example.sof3011_java5.controller.admin;

import com.example.sof3011_java5.entities.NhanVien;
import com.example.sof3011_java5.infrastructure.converter.NhanVienConvert;
import com.example.sof3011_java5.models.ChucVuViewModel;
import com.example.sof3011_java5.models.CuaHangViewModel;
import com.example.sof3011_java5.models.NhanVienViewModel;
import com.example.sof3011_java5.services.ChucVuService;
import com.example.sof3011_java5.services.CuaHangService;
import com.example.sof3011_java5.services.NhanVienService;
import com.example.sof3011_java5.services.impl.ChucVuServiceImpl;
import com.example.sof3011_java5.services.impl.CuaHangServiceImpl;
import com.example.sof3011_java5.services.impl.NhanVienServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin/nhan-vien")
public class NhanVienController {

    @Autowired
    private NhanVienService nhanVienService = new NhanVienServiceImpl();
    @Autowired
    private ChucVuService chucVuService = new ChucVuServiceImpl();
    @Autowired
    public CuaHangService cuaHangService = new CuaHangServiceImpl();
    @Autowired
    public NhanVienConvert nhanVienConvert;
    @Autowired
    public NhanVienViewModel nhanVienViewModel;

    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("list", nhanVienService.findAll());
        model.addAttribute("view", "/views/admin/nhan-vien/index.jsp");
        return "admin/layout";
    }
    @GetMapping("/create")
    public String create(
            Model model
    )
    {
        List<ChucVuViewModel> chucVuList = chucVuService.findAll();
        List<CuaHangViewModel> cuaHangList = cuaHangService.findAll();
        model.addAttribute("action","/admin/nhan-vien/store");
        model.addAttribute("cuaHangList",cuaHangList);
        model.addAttribute("chucVuList",chucVuList);
        model.addAttribute("nv",nhanVienViewModel);
        model.addAttribute("view", "/views/admin/nhan-vien/create.jsp");
        return "admin/layout";
    }

    @PostMapping("/store")
    public String store(
    @Valid @ModelAttribute("nv") NhanVienViewModel nhanVienViewModel,BindingResult bindingResult,Model model
            )
    {
        if (bindingResult.hasErrors()) {
            List<ChucVuViewModel> chucVuList = chucVuService.findAll();
            List<CuaHangViewModel> cuaHangList = cuaHangService.findAll();
            model.addAttribute("cuaHangList",cuaHangList);
            model.addAttribute("chucVuList",chucVuList);
            return "admin/nhan-vien/create";
        }

        nhanVienViewModel.setMa(nhanVienService.maNVCount());
        nhanVienService.saveOrUpdate(nhanVienViewModel);
        return "redirect:/admin/nhan-vien/index";
    }
    @GetMapping("/edit/{id}")
    public String edit(
            @PathVariable("id") NhanVien nhanVien,
            Model model
    )
    {
        nhanVienConvert.toModel(nhanVien);
        model.addAttribute("action","/admin/nhan-vien/update/"+nhanVien.getId());
        List<ChucVuViewModel> chucVuList = chucVuService.findAll();
        List<CuaHangViewModel> cuaHangList = cuaHangService.findAll();
        model.addAttribute("cuaHangList",cuaHangList);
        model.addAttribute("chucVuList",chucVuList);
        model.addAttribute("nv",nhanVienConvert.toModel(nhanVien));
        model.addAttribute("view", "/views/admin/nhan-vien/create.jsp");
        return "admin/layout";
    }
    @PostMapping("/update/{id}")
    public String update(
        @Valid @ModelAttribute("nv") NhanVienViewModel nhanVienViewModel,BindingResult bindingResult
    )
    {
        if (bindingResult.hasErrors()) {
            return "admin/nhan-vien/create";
        }
         nhanVienService.saveOrUpdate(nhanVienViewModel);
        return "redirect:/admin/nhan-vien/index";
    }
    @GetMapping("/delete/{id}")
    public String delete(
            @PathVariable("id") NhanVien nhanVien
    )
    {
        nhanVienService.deleteById(nhanVien.getId());
        return "redirect:/admin/nhan-vien/index";
    }
}
