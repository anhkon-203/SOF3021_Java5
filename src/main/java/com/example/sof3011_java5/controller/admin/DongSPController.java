package com.example.sof3011_java5.controller.admin;

import com.example.sof3011_java5.entities.DongSp;
import com.example.sof3011_java5.infrastructure.converter.DongSPConvert;
import com.example.sof3011_java5.models.DongSPViewModel;
import com.example.sof3011_java5.services.DongSPService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/admin/dong-sp")
public class DongSPController {

    @Autowired
    private DongSPService dongSPService;
    @Autowired
    public DongSPViewModel dongSPViewModel;
    @Autowired
    public DongSPConvert dongSPConvert;
    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("list", dongSPService.getAll());
        model.addAttribute("view", "/views/admin/dong-sp/index.jsp");
        return "admin/layout";
    }
    @GetMapping("/create")
    public String create(
            Model model,DongSPViewModel dongSPViewModel
    )
    {
        model.addAttribute("dsp", dongSPViewModel);
        model.addAttribute("action", "/admin/dong-sp/store");
        model.addAttribute("view", "/views/admin/dong-sp/create.jsp");
        return "admin/layout";
    }
    @PostMapping("/store")
    public String store(
            @Valid @ModelAttribute("dsp") DongSPViewModel dongSPViewModel, BindingResult result
            )
    {
        if (result.hasErrors()) {
            return "admin/dong-sp/create";
        }
        dongSPViewModel.setMa(dongSPService.maDSPCount());
        dongSPService.saveOrUpdate(dongSPViewModel);
        return "redirect:/admin/dong-sp/index";
    }
    @GetMapping("/edit/{id}")
    public String edit(
            Model model,@PathVariable("id") DongSp dongSp
    )
    {
        dongSPConvert.toModel(dongSp);
        model.addAttribute("dsp", dongSp);
        model.addAttribute("action", "/admin/dong-sp/update/" + dongSp.getId());
        model.addAttribute("view", "/views/admin/dong-sp/create.jsp");
        return "admin/layout";
    }
    @PostMapping("/update/{id}")
    public String update(
            @Valid @ModelAttribute("dsp") DongSPViewModel viewModel, BindingResult result
    )
    {
        if (result.hasErrors()) {
            return "admin/dong-sp/create";
        }

        dongSPService.saveOrUpdate(viewModel);
        return "redirect:/admin/dong-sp/index";
    }
    @GetMapping("/delete/{id}")
    public String delete(
            @PathVariable("id") DongSp dongSp
    )
    {
        dongSPService.deleteById(dongSp.getId());
        return "redirect:/admin/dong-sp/index";
    }
}
