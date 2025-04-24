package com.getinfo.contratos.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class MainController {
    @GetMapping
    public String index() {
        return "<html>"+
        "<ul>"+
        "<li><a href='http://localhost:8080/empresas'>Empresas</a></li>"+
        "<li><a href='http://localhost:8080/contratos'>Contratos</a></li>"+
        "<li><a href='http://localhost:8080/funcionarios'>Funcionarios</a></li>"+
        "</ul>"+
        "</html>";
    }
}
