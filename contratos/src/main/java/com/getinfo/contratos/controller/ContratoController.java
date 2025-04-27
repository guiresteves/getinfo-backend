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
        return "list_contrato";
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contrato> buscarPorId(@PathVariable Long id) {
        return contratoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public String criar(@ModelAttribute Contrato contrato) {
        contratoService.salvar(contrato);
        return "redirect:/contratos";
    }

    @PutMapping("/{id}")
    public ResponseEntity<Contrato> atualizar(@PathVariable Long id, @RequestBody Contrato contrato) {
        if (!contratoService.buscarPorId(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        contrato.setIdContrato(id);
        return ResponseEntity.ok(contratoService.salvar(contrato));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (!contratoService.buscarPorId(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        contratoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
