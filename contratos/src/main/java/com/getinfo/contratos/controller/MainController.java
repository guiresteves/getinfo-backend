package com.getinfo.contratos.controller;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {
    @GetMapping
    public String home(Model model) {
        model.addAttribute("message", "Bem-vindo ao Thymeleaf!");
        return "home";
    }
}
