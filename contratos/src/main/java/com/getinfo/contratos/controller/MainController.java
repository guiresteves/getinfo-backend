package com.getinfo.contratos.controller;

import com.getinfo.contratos.entity.Contrato;
import com.getinfo.contratos.service.ContratoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class MainController {

    @Autowired
    private ContratoService contratoService;

    @GetMapping
    public String index() {
        return "<html>"+
        "<ul>"+
        "<li><a href='http://localhost:8080/empresas'>Empresas</a></li>"+
        "<li><a href='http://localhost:8080/contratos'>Contratos</a></li>"+
        "</ul>"+
        "</html>";
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contrato> buscarPorId(@PathVariable Long id) {
        return contratoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Contrato criar(@RequestBody Contrato contrato) {
        return contratoService.salvar(contrato);
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
