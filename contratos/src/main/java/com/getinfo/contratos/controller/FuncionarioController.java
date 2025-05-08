package com.getinfo.contratos.controller;

import com.getinfo.contratos.entity.Funcionario;
import com.getinfo.contratos.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @GetMapping
    public List<Funcionario> listarTodas() {
        return funcionarioService.listarTodas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Funcionario> buscarPorId(@PathVariable Long id) {
        Optional<Funcionario> funcionario = funcionarioService.buscarPorId(id);
        if (funcionario.isPresent()) {
            return ResponseEntity.ok(funcionario.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Funcionario> salvar(@RequestBody Funcionario funcionario) {
        Funcionario novoFuncionario = funcionarioService.salvar(funcionario);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoFuncionario);

    }

    @DeleteMapping
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        Optional<Funcionario> funcionario = funcionarioService.buscarPorId(id);
        if (funcionario.isPresent()) {
            funcionarioService.deletar(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
