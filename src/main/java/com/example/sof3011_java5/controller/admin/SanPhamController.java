package com.example.sof3011_java5.controller.admin;

import com.example.sof3011_java5.entities.SanPham;
import com.example.sof3011_java5.infrastructure.converter.SanPhamConvert;
import com.example.sof3011_java5.models.SanPhamViewModel;
import com.example.sof3011_java5.repositories.SanPhamRepository;
import com.example.sof3011_java5.services.SanPhamService;
import com.example.sof3011_java5.services.impl.SanPhamServiceImpl;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import javax.naming.Binding;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;


@Controller
@RequestMapping("/admin/san-pham")
public class SanPhamController {
    @Autowired
    private SanPhamService sanPhamService = new SanPhamServiceImpl();
    @Autowired
    private SanPhamViewModel sanPhamViewModel;

    @Autowired
    private SanPhamRepository sanPhamRepository;
    @Autowired
    private SanPhamConvert sanPhamConvert;
    @Autowired
    ServletContext context;

    @Autowired
    HttpServletRequest request;

    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("list", sanPhamRepository.findAll());
        model.addAttribute("view", "/views/admin/san-pham/index.jsp");
        return "admin/layout";
    }

    @GetMapping("/create")
    public String create(Model model, SanPhamViewModel sanPhamViewModel) {
        model.addAttribute("sp", sanPhamViewModel);
        model.addAttribute("action", "/admin/san-pham/store");
        model.addAttribute("view", "/views/admin/san-pham/create.jsp");
        return "admin/layout";
    }

    @PostMapping("/store")
    public String store(@ModelAttribute("sp") @Valid SanPhamViewModel sanPhamViewModel,
                        @RequestParam("srcImage") MultipartFile file
            , BindingResult result, Model model
    ) throws IOException {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        String uploadDir = "/../images/";
        Path uploadPath = Paths.get(uploadDir);
        if (result.hasErrors()) {
            model.addAttribute("action", "/admin/san-pham/store");
            model.addAttribute("view", "/views/admin/san-pham/create.jsp");
            return "admin/layout";
        }
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }
        if (sanPhamViewModel.getTen().trim().isEmpty() || sanPhamViewModel.getSrcImage().isEmpty()) {
            model.addAttribute("error", "Không được để trống");
            model.addAttribute("action", "/admin/san-pham/store");
            model.addAttribute("view", "/views/admin/san-pham/create.jsp");
            return "admin/layout";
        }

        Path filePath = uploadPath.resolve(fileName);
        Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
        sanPhamViewModel.setMa(sanPhamService.maSPcount());
        sanPhamService.saveOrUpdate(sanPhamViewModel, filePath);
        return "redirect:/admin/san-pham/index";
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable("id") SanPham sanPham) {
        sanPhamConvert.toModel(sanPham);
        model.addAttribute("sp", sanPham);
        model.addAttribute("action", "/admin/san-pham/update/" + sanPham.getId());
        model.addAttribute("view", "/views/admin/san-pham/create.jsp");
        return "admin/layout";
    }

    @PostMapping("/update/{id}")
    public String update(@ModelAttribute("sp") @Valid SanPhamViewModel sanPhamViewModel,
                         @RequestParam("srcImage") MultipartFile file) throws IOException {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        String uploadDir = "/../images/";
        Path uploadPath = Paths.get(uploadDir);
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        Path filePath = uploadPath.resolve(fileName);
        Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
        sanPhamService.saveOrUpdate(sanPhamViewModel, filePath);
        return "redirect:/admin/san-pham/index";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") UUID id, RedirectAttributes redirectAttributes) {
        try {
            sanPhamService.deleteById(id);
            redirectAttributes.addFlashAttribute("successMessage", "Xóa sản phẩm thành công.");
        } catch (DataIntegrityViolationException e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Không thể xóa sản phẩm do có bản ghi liên quan trong bảng ChiTietSP.");
        }
        return "redirect:/admin/san-pham/index";
    }
}


