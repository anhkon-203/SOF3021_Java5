package com.example.sof3011_java5.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class LayoutController {
    @GetMapping("/layout")
    public String layout() {
        return "admin/layout";
    }
}
