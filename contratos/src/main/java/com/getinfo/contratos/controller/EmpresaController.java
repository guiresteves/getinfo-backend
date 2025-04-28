package com.getinfo.contratos.controller;

import com.getinfo.contratos.entity.Empresa;
import com.getinfo.contratos.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/empresas")
public class EmpresaController {

    @Autowired
    private EmpresaService empresaService;

    @GetMapping
    public String listarTodas(Model model) {
        model.addAttribute("empresas", empresaService.listarTodas());
        return "empresa";
    }

    @GetMapping("/{id}")
    public String buscarPorId(@PathVariable Long id, Model model) {
        if (empresaService.buscarPorId(id).isPresent()) {
            model.addAttribute("empresas", empresaService.buscarPorId(id).get());
        }
        return "empresa";
    }

    @PostMapping
    public String criar(@ModelAttribute Empresa empresa) {
        empresaService.salvar(empresa);
        return "redirect:/empresas";
    }

    @RequestMapping(value = "/atualizar", method = RequestMethod.POST)
    public String atualizar(@ModelAttribute Empresa empresa) {
        if (empresaService.buscarPorId(empresa.getIdEmpresa()).isPresent()) {
            empresaService.salvar(empresa);
        }
        return "redirect:/empresas";
    }

    @RequestMapping(value = "/deletar", method = RequestMethod.POST)
    public String deletar(@RequestParam Long idEmpresa) {
        if (empresaService.buscarPorId(idEmpresa).isPresent()) {
            empresaService.deletar(idEmpresa);
        }
        return "redirect:/empresas";
    }
}
