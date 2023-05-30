package com.example.sof3011_java5.controller.admin;

import com.example.sof3011_java5.entities.NSX;
import com.example.sof3011_java5.models.NSXViewModel;
import com.example.sof3011_java5.service.NSXService;
import com.example.sof3011_java5.service.impl.NSXServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/admin/nsx")
public class NSXController {

    @Autowired
    private NSXService nsxService = new NSXServiceImpl();
    @Autowired
    public NSXViewModel nsxViewModel;

    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("list", nsxService.getAll());
        return "admin/nsx/index";
    }
    @GetMapping("/create")
    public String create(
            Model model
    )
    {
        model.addAttribute("nsx", nsxViewModel);
        return "admin/nsx/create";
    }
    @PostMapping("/store")
    public String store(
            @Valid @ModelAttribute("nsx") NSXViewModel viewModel, BindingResult result
            )
    {
        if (result.hasErrors()) {
            return "admin/nsx/create";
        }
       if (nsxService.getByMa(viewModel.getMa()) != null) {
            result.rejectValue("ma", "error.ma", "Mã nhà sản xuất đã tồn tại");
            return "admin/nsx/create";
        }
        nsxService.saveOrUpdate(viewModel);
        return "redirect:/admin/nsx/index";
    }
    @GetMapping("/edit/{id}")
    public String edit(
            Model model,@PathVariable("id") UUID id
    )
    {
        model.addAttribute("nsx", nsxService.getById(id));
        return "admin/nsx/edit";
    }
    @PostMapping("/update/{id}")
    public String update(
            @Valid @ModelAttribute("nsx") NSXViewModel viewModel, BindingResult result
    )
    {
        if (result.hasErrors()) {
            return "admin/nsx/edit";
        }

        nsxService.saveOrUpdate(viewModel);
        return "redirect:/admin/nsx/index";
    }
    @GetMapping("/delete/{id}")
    public String delete(
            @PathVariable("id") UUID id
    )
    {
        nsxService.deleteById(id);
        return "redirect:/admin/nsx/index";
    }
}
