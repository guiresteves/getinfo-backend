package com.getinfo.contratos.controller;

import com.getinfo.contratos.entity.Empresa;
import com.getinfo.contratos.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
        return "list_empresa";
    }

    @GetMapping("/{id}")
    public ResponseEntity<Empresa> buscarPorId(@PathVariable Long id) {
        return empresaService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public String criar() {
        return "list_empresa";
    }
    public Empresa criar(@RequestBody Empresa empresa) {
        return empresaService.salvar(empresa);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Empresa> atualizar(@PathVariable Long id, @RequestBody Empresa empresa) {
        if (!empresaService.buscarPorId(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        empresa.setIdEmpresa(id);
        return ResponseEntity.ok(empresaService.salvar(empresa));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (!empresaService.buscarPorId(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        empresaService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
