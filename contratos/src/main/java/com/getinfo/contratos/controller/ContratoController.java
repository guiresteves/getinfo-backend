package com.getinfo.contratos.controller;

import com.getinfo.contratos.DTOs.ContratoCreateDTO;
import com.getinfo.contratos.DTOs.ContratoExibirDTO;
import com.getinfo.contratos.entity.Contrato;
import com.getinfo.contratos.service.ContratoService;
import org.apache.coyote.Response;
import org.modelmapper.ModelMapper;
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

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public List<ContratoExibirDTO> listarPublic() {
        return contratoService.listarPublic();
    }


    @PostMapping()
    public ResponseEntity<ContratoCreateDTO> salvar(@RequestBody ContratoCreateDTO contratoCreateDTO) {
        Contrato contrato = contratoService.toEntity(contratoCreateDTO);
        contratoService.salvar(contrato);
        return ResponseEntity.status(HttpStatus.CREATED).body(contratoCreateDTO);

    }

}
