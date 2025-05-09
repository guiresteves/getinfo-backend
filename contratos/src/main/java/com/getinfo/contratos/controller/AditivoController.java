package com.getinfo.contratos.controller;

import com.getinfo.contratos.entity.Aditivo;
import com.getinfo.contratos.service.AditivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AditivoController {

    @Autowired
    private AditivoService aditivoService;

    @GetMapping
    public List<Aditivo> listarTodas() {
        return aditivoService.listarTodas();
    }



}
