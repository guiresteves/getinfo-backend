package com.getinfo.contratos.controller;

import com.getinfo.contratos.entity.TelefoneEmpresa;
import com.getinfo.contratos.service.TelefoneEmpresaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/telefones_empresa")
public class TelefoneEmpresaController {

    private final TelefoneEmpresaService service;

    public TelefoneEmpresaController(TelefoneEmpresaService service) {
        this.service = service;
    }

    @GetMapping
    public List<TelefoneEmpresa> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TelefoneEmpresa> buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public TelefoneEmpresa criar(@RequestBody TelefoneEmpresa telefoneEmpresa) {
        return service.salvar(telefoneEmpresa);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}

