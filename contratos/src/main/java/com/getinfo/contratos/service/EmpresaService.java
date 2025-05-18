package com.getinfo.contratos.service;

import com.getinfo.contratos.DTOs.EmpresaCreateDTO;
import com.getinfo.contratos.DTOs.EmpresaExibirDTO;
import com.getinfo.contratos.entity.Empresa;
import com.getinfo.contratos.mappers.EmpresaMapper;
import com.getinfo.contratos.repository.EmpresaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmpresaService {

    @Autowired
    private EmpresaRepository empresaRepository;

    @Autowired
    private EmpresaMapper empresaMapper;

    public List<Empresa> listarTodas() {
        return empresaRepository.findAll();
    }

    public List<EmpresaExibirDTO> listAllPublic() {
        List<EmpresaExibirDTO> empresaExibirDTOS = new ArrayList<>();
        for(Empresa empresa: listarTodas()) {
            empresaExibirDTOS.add(empresaMapper.entityToExibirDTO(empresa));

        }
        return empresaExibirDTOS;
    }

    public Optional<Empresa> buscarPorId(Long id) {
        return empresaRepository.findById(id);
    }

//    public Optional<EmpresaExibirDTO> buscarPorIdPublic(Long id) {
//        Optional<Empresa> empresa = buscarPorId(id);
//        return empresa.map(EmpresaExibirDTO::new);
//
//    }

//    @Transactional
//    public Empresa atualizarParcial(Long id, EmpresaCreateDTO empresaDTO) {
//        Empresa empresaEntidade = empresaRepository.findById(id).orElseThrow(() ->
//                new ResponseStatusException(HttpStatus.NOT_FOUND));
//
//        return empresaRepository.save(empresaEntidade);
//
//    }

    public Empresa salvar(Empresa empresa) {
        return empresaRepository.save(empresa);
    }

    public Empresa toEntity(EmpresaCreateDTO empresaDTO) {
        return empresaMapper.createDTOtoEntity(empresaDTO);
    }

    public void deletar(Long id) {
        empresaRepository.deleteById(id);
    }




}
