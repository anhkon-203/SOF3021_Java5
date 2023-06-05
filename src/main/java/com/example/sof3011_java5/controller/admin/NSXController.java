package com.example.sof3011_java5.controller.admin;

import com.example.sof3011_java5.entities.NSX;
import com.example.sof3011_java5.infrastructure.converter.NSXConvert;
import com.example.sof3011_java5.models.NSXViewModel;
import com.example.sof3011_java5.services.NSXService;
import com.example.sof3011_java5.services.impl.NSXServiceImpl;
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
    @Autowired
    public NSXConvert nsxConvert;

    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("list", nsxService.getAll());
        model.addAttribute("view", "/views/admin/nsx/index.jsp");
        return "admin/layout";
    }
    @GetMapping("/create")
    public String create(
            Model model,NSXViewModel nsx
    )
    {
        model.addAttribute("nsx", nsx);
        model.addAttribute("action", "/admin/nsx/store" );
        model.addAttribute("view", "/views/admin/nsx/create.jsp");
        return "admin/layout";
    }
    @PostMapping("/store")
    public String store(
            @Valid @ModelAttribute("nsx") NSXViewModel viewModel, BindingResult result
            )
    {
        if (result.hasErrors()) {
            return "admin/nsx/create";
        }
        viewModel.setMa(nsxService.maNSXCount());
        nsxService.saveOrUpdate(viewModel);
        return "redirect:/admin/nsx/index";
    }
    @GetMapping("/edit/{id}")
    public String edit(
            Model model,@PathVariable("id") NSX nsx
    )
    {
        nsxConvert.toModel(nsx);
        model.addAttribute("nsx", nsx);
        model.addAttribute("action", "/admin/nsx/update/" + nsx.getId());
        model.addAttribute("view", "/views/admin/nsx/create.jsp");
        return "admin/layout";
    }
    @PostMapping("/update/{id}")
    public String update(
            @Valid @ModelAttribute("nsx") NSXViewModel viewModel, BindingResult result
    )
    {
        if (result.hasErrors()) {
            return "admin/nsx/create";
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
