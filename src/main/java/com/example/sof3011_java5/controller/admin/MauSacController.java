package com.example.sof3011_java5.controller.admin;

import com.example.sof3011_java5.entities.MauSac;
import com.example.sof3011_java5.infrastructure.converter.MauSacConvert;
import com.example.sof3011_java5.models.MauSacViewModel;
import com.example.sof3011_java5.services.MauSacService;
import com.example.sof3011_java5.services.impl.MauSacServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/mau-sac")
public class MauSacController {
    @Autowired
    private MauSacConvert mauSacConvert;
    @Autowired
    private MauSacViewModel mauSacViewModel;
    @Autowired
    private MauSacService mauSacService = new MauSacServiceImpl();

    @GetMapping("/create")
    public String create(
            Model model
    ) {
        model.addAttribute("ms", mauSacViewModel);
        model.addAttribute("action", "/admin/mau-sac/store");
        model.addAttribute("view", "/views/admin/mau-sac/create.jsp");
        return "admin/layout";
    }

    @GetMapping("/index")
    public String index(
            Model model
    ) {
        model.addAttribute("list", mauSacService.findAll());
        model.addAttribute("view", "/views/admin/mau-sac/index.jsp");
        return "admin/layout";
    }
    @GetMapping("/edit/{id}")
    public String edit(
            Model model, @PathVariable("id") MauSac mauSac
    ) {
        mauSacConvert.toModel(mauSac);
        model.addAttribute("ms", mauSac);
        model.addAttribute("action", "/admin/mau-sac/update/" + mauSac.getId());
        model.addAttribute("view", "/views/admin/mau-sac/create.jsp");
        return "admin/layout";
    }
    @GetMapping("/delete/{id}")
    public String delete(
            @PathVariable("id") MauSac mauSac
    ) {
        mauSacService.deleteById(mauSac.getId());
        return "redirect:/admin/mau-sac/index";
    }
    @PostMapping("/store")
    public String store(
            @Valid @ModelAttribute("ms") MauSacViewModel mauSacViewModel, BindingResult result
            ) {
        if (result.hasErrors()) {
            return "admin/mau-sac/create";
        }
        mauSacViewModel.setMa(mauSacService.maMSCount());
        mauSacService.saveOrUpdate(mauSacViewModel);
        return "redirect:/admin/mau-sac/index";
    }
    @PostMapping("/update/{id}")
    public String update(
            @Valid @ModelAttribute("ms") MauSacViewModel mauSacViewModel, BindingResult result
            ) {
        if (result.hasErrors()) {
            return "admin/mau-sac/create";
        }
        mauSacService.saveOrUpdate(mauSacViewModel);
        return "redirect:/admin/mau-sac/index";
    }
}
