package com.getinfo.contratos.controller;

import com.getinfo.contratos.DTOs.EmpresaCreateDTO;
import com.getinfo.contratos.DTOs.EmpresaPublicDTO;
import com.getinfo.contratos.config.ModelMapperConfig;
import com.getinfo.contratos.entity.Empresa;
import com.getinfo.contratos.service.EmpresaService;
import org.modelmapper.ModelMapper;
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

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public List<Empresa> listarTodas() {
        return empresaService.listarTodas();
    }
    @GetMapping("/public")
    public List<EmpresaPublicDTO> listAllPublic() {
        return empresaService.listAllPublic();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmpresaPublicDTO> buscarPorId(@PathVariable Long id) {
        Optional<EmpresaPublicDTO> empresaPublicDTO = empresaService.buscarPorIdPublic(id);
        if (empresaPublicDTO.isPresent()) {
            return ResponseEntity.ok(empresaPublicDTO.get());
        }
        return ResponseEntity.notFound().build();
    }

    //@PostMapping
//    public ResponseEntity<Empresa> salvar(@RequestBody Empresa empresa) {
//        Empresa novaEmpresa = empresaService.salvar(empresa);  // Chama o serviço para salvar a empresa
//        return ResponseEntity.status(HttpStatus.CREATED).body(novaEmpresa);  // Retorna a empresa criada com status 201
//    }

    @PostMapping
    public ResponseEntity<EmpresaPublicDTO> salvar(@RequestBody EmpresaCreateDTO empresaDTO) {
        Empresa empresa = empresaService.toEntity(empresaDTO);
        empresa = empresaService.salvar(empresa);
        EmpresaPublicDTO response = modelMapper.map(empresa, EmpresaPublicDTO.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
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
