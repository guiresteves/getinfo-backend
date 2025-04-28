package com.getinfo.contratos.controller;

import com.getinfo.contratos.entity.Contrato;
import com.getinfo.contratos.service.ContratoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/contratos")
public class ContratoController {

    @Autowired
    private ContratoService contratoService;

    @GetMapping
    public String listarTodas(Model model) {
        model.addAttribute("contratos", contratoService.listarTodas());
        return "contrato";
    }

    @GetMapping("/{id}")
    public String buscarPorId(@PathVariable Long id, Model model) {
        if (contratoService.buscarPorId(id).isPresent()) {
            model.addAttribute("contratos", contratoService.buscarPorId(id).get());
        }
        return "contrato";
    }

    @PostMapping
    public String criar(@ModelAttribute Contrato contrato) {
        // TODO: Implementar a lógica de criação do contrato
        // contratoService.salvar(contrato);
        return "redirect:/contratos";
    }

    @RequestMapping(value = "/atualizar", method = RequestMethod.POST)
    public String atualizar(@ModelAttribute Contrato contrato) {
        if (contratoService.buscarPorId(contrato.getIdContrato()).isPresent()) {
            contratoService.salvar(contrato);
        }
        return "redirect:/contratos";
    }

    @RequestMapping(value = "/deletar", method = RequestMethod.POST)
    public String deletar(@RequestParam Long idContrato) {
        if (contratoService.buscarPorId(idContrato).isPresent()) {
            contratoService.deletar(idContrato);
        }
        return "redirect:/contratos";
    }
}
