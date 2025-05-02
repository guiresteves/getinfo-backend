package com.getinfo.contratos.controller;

import com.getinfo.contratos.entity.Empresa;
import com.getinfo.contratos.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/empresas")
public class EmpresaController {

    @Autowired
    private EmpresaService empresaService;

    @GetMapping
    public List<Empresa> listarTodas() {
        return empresaService.listarTodas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Empresa> buscarPorId(@PathVariable Long id) {
        Optional<Empresa> empresa = empresaService.buscarPorId(id);
        if (empresa.isPresent()) {
            return ResponseEntity.ok(empresa.get()); // Retorna a empresa encontrada
        } else {
            return ResponseEntity.notFound().build(); // Retorna 404 se a empresa não for encontrada
        }
    }

    @PostMapping
    public ResponseEntity<Empresa> salvar(@RequestBody Empresa empresa) {
        Empresa novaEmpresa = empresaService.salvar(empresa);  // Chama o serviço para salvar a empresa
        return ResponseEntity.status(HttpStatus.CREATED).body(novaEmpresa);  // Retorna a empresa criada com status 201
    }

    @PutMapping("/{id}")
    public ResponseEntity<Empresa> atualizar(@PathVariable Long id, @RequestBody Empresa empresaAtualizada) {
        return empresaService.atualizar(id, empresaAtualizada)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        Optional<Empresa> empresa = empresaService.buscarPorId(id);
        if (empresa.isPresent()) {
            empresaService.deletar(id);  // Chama o serviço para deletar a empresa
            return ResponseEntity.noContent().build();  // Retorna 204 No Content se a empresa for deletada com sucesso
        } else {
            return ResponseEntity.notFound().build();  // Retorna 404 Not Found se a empresa não for encontrada
        }
    }









}
