package com.getinfo.contratos.controller;

import com.getinfo.contratos.entity.Colaborador;
import com.getinfo.contratos.service.ColaboradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/colaboradores")
public class ColaboradorController {

    @Autowired
    private ColaboradorService colaboradorService;

    @GetMapping
    public List<Colaborador> listarTodas() {
        return colaboradorService.listarTodas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Colaborador> buscarPorId(@PathVariable Long id) {
        Optional<Colaborador> funcionario = colaboradorService.buscarPorId(id);
        if (funcionario.isPresent()) {
            return ResponseEntity.ok(funcionario.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Colaborador> salvar(@RequestBody Colaborador colaborador) {
        Colaborador novoColaborador = colaboradorService.salvar(colaborador);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoColaborador);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        Optional<Colaborador> funcionario = colaboradorService.buscarPorId(id);
        if (funcionario.isPresent()) {
            colaboradorService.deletar(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
