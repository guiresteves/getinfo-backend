package com.getinfo.contratos.controller;

import com.getinfo.contratos.entity.Funcionario;
import com.getinfo.contratos.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @GetMapping
    public String listarTodas(Model model) {
        model.addAttribute("funcionarios", funcionarioService.listarTodas());
        return "funcionario";
    }

    @GetMapping("/{id}")
    public String buscarPorId(@PathVariable Long id, Model model) {
        if (funcionarioService.buscarPorId(id).isPresent()) {
            model.addAttribute("funcionarios", funcionarioService.buscarPorId(id).get());
        }
        return "funcionario";
    }

    @PostMapping
    public String criar(@ModelAttribute Funcionario funcionario) {
        funcionarioService.salvar(funcionario);
        return "redirect:/funcionarios";
    }

    @RequestMapping(value = "/atualizar", method = RequestMethod.POST)
    public String atualizar(@ModelAttribute Funcionario funcionario) {
        if (funcionarioService.buscarPorId(funcionario.getIdFuncionario()).isPresent()) {
            funcionarioService.salvar(funcionario);
        }
        return "redirect:/funcionarios";
    }

    @RequestMapping(value = "/deletar", method = RequestMethod.POST)
    public String deletar(@RequestParam Long idFuncionario) {
        if (funcionarioService.buscarPorId(idFuncionario).isPresent()) {
            funcionarioService.deletar(idFuncionario);
        }
        return "redirect:/funcionarios";
    }
}
