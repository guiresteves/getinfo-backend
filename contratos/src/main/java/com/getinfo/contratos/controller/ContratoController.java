package com.getinfo.contratos.controller;

import com.getinfo.contratos.entity.Contrato;
import com.getinfo.contratos.service.ContratoService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/contratos")
public class ContratoController {

    @Autowired
    private ContratoService contratoService;

    @GetMapping
    public List<Contrato> listarTodas() {
        return contratoService.listarTodas();
    }

    @GetMapping("/{id}")
    public String buscarPorId(@PathVariable Long id, Model model) {
        if (contratoService.buscarPorId(id).isPresent()) {
            model.addAttribute("contratos", contratoService.buscarPorId(id).get());
        }
        return "contrato";
    }


    @PostMapping()
    public ResponseEntity<Contrato> salvar(@RequestBody Contrato contrato) {
        Contrato novoContrato = contratoService.salvar(contrato);
        return ResponseEntity.status(HttpStatus.CREATED).body(contrato);

    }

    @RequestMapping(value = "/deletar", method = RequestMethod.POST)
    public String deletar(@RequestParam Long idContrato) {
        if (contratoService.buscarPorId(idContrato).isPresent()) {
            contratoService.deletar(idContrato);
        }
        return "redirect:/contratos";
    }
}
