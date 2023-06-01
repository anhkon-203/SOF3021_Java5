package com.example.sof3011_java5.controller.admin;

import com.example.sof3011_java5.entities.ChucVu;
import com.example.sof3011_java5.infrastructure.converter.ChucVuConvert;
import com.example.sof3011_java5.models.ChucVuViewModel;
import com.example.sof3011_java5.service.ChucVuService;
import com.example.sof3011_java5.service.impl.ChucVuServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/admin/chuc-vu")
public class ChucVuController {

    @Autowired
    private ChucVuService chucVuService = new ChucVuServiceImpl();
    @Autowired
    public ChucVuViewModel chucVuViewModel;
    @Autowired
    public ChucVuConvert chucVuConvert;

    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("list", chucVuService.findAll());
        return "admin/chuc-vu/index";
    }
    @GetMapping("/create")
    public String create(
            Model model
    )
    {
        model.addAttribute("action","/admin/chuc-vu/store");
        model.addAttribute("chucVu",chucVuViewModel);
        return "admin/chuc-vu/create";
    }

    @PostMapping("/store")
    public String store(
@Valid @ModelAttribute("chucVu") ChucVuViewModel chucVuViewModel,BindingResult bindingResult
            )
    {
        if (bindingResult.hasErrors()) {
            return "admin/chuc-vu/create";
        }
        chucVuViewModel.setMa(chucVuService.maCVCount());
        chucVuService.saveOrUpdate(chucVuViewModel);
        return "redirect:/admin/chuc-vu/index";
    }
    @GetMapping("/edit/{id}")
    public String edit(
            @PathVariable("id")ChucVu chucVu,
            Model model
    )
    {
        model.addAttribute("action","/admin/chuc-vu/update/"+chucVu.getId());
        model.addAttribute("chucVu",chucVuConvert.toModel(chucVu));
        return "admin/chuc-vu/create";
    }
    @PostMapping("/update/{id}")
    public String update(
        @Valid @ModelAttribute("chucVu") ChucVuViewModel chucVuViewModel,BindingResult bindingResult
    )
    {
        if (bindingResult.hasErrors()) {
            return "admin/chuc-vu/create";
        }
        chucVuService.saveOrUpdate(chucVuViewModel);
        return "redirect:/admin/chuc-vu/index";
    }
    @GetMapping("/delete/{id}")
    public String delete(
            @PathVariable("id") ChucVu chucVu
    )
    {
        chucVuService.deleteById(chucVuConvert.toModel(chucVu).getId());
        return "redirect:/admin/chuc-vu/index";
    }
}
