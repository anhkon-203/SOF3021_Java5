package com.example.sof3011_java5.controller.admin;

import com.example.sof3011_java5.entities.SanPham;
import com.example.sof3011_java5.infrastructure.converter.SanPhamConvert;
import com.example.sof3011_java5.models.SanPhamViewModel;
import com.example.sof3011_java5.repositories.SanPhamRepository;
import com.example.sof3011_java5.service.SanPhamService;
import com.example.sof3011_java5.service.impl.SanPhamServiceImpl;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.Part;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


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
        return "admin/san-pham/index";
    }

    @GetMapping("/create")
    public String create(Model model, SanPhamViewModel sanPhamViewModel) {
        model.addAttribute("sp", sanPhamViewModel);
        model.addAttribute("action", "/admin/san-pham/store");
        return "admin/san-pham/create";
    }

    @PostMapping("/store")
    public String store(@ModelAttribute("sp") @Valid SanPhamViewModel sanPhamViewModel,
                        @RequestParam("srcImage") MultipartFile file) throws IOException {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        String uploadDir = "/../images/";
        Path uploadPath = Paths.get(uploadDir);
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        Path filePath = uploadPath.resolve(fileName);
        Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
        sanPhamViewModel.setMa(sanPhamService.maSPcount());
        sanPhamService.saveOrUpdate(sanPhamViewModel, filePath);
        return "redirect:/admin/san-pham/index";
    }
}


