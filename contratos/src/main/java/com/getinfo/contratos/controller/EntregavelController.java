package com.getinfo.contratos.controller;

import com.getinfo.contratos.entity.Entregavel;
import com.getinfo.contratos.service.EntregavelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/entregaveis")
public class EntregavelController {

    @Autowired
    private EntregavelService entregavelService;

    @GetMapping
    public List<Entregavel> listarTodas() {
        return entregavelService.listarTodas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Entregavel> buscarPorId(@PathVariable Long id) {
        Optional<Entregavel> entregavel = entregavelService.buscarPorId(id);
        if (entregavel.isPresent()) {
            return ResponseEntity.ok(entregavel.get());
        }
        return  ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Entregavel> salvar(@RequestBody Entregavel entregavel) {
        Entregavel novoEntregavel = entregavelService.salvar(entregavel);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoEntregavel);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(Long id) {
        Optional<Entregavel> entregavel = entregavelService.buscarPorId(id);
        if (entregavel.isPresent()) {
            entregavelService.deletar(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
