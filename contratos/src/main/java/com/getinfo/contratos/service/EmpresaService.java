package com.getinfo.contratos.service;

import com.getinfo.contratos.DTOs.EmpresaCreateDTO;
import com.getinfo.contratos.DTOs.EmpresaPublicDTO;
import com.getinfo.contratos.entity.Empresa;
import com.getinfo.contratos.repository.EmpresaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmpresaService {

    @Autowired
    private EmpresaRepository empresaRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<Empresa> listarTodas() {
        return empresaRepository.findAll();
    }
    public List<EmpresaPublicDTO> listAllPublic() {
        List<EmpresaPublicDTO> empresaPublicDTOS = new ArrayList<>();
        for(Empresa empresa: listarTodas()) {
            EmpresaPublicDTO empresaPublicDTO = new EmpresaPublicDTO(empresa);
            empresaPublicDTOS.add(empresaPublicDTO);
        }
        return empresaPublicDTOS;
    }

    public Optional<Empresa> buscarPorId(Long id) {
        return empresaRepository.findById(id);
    }

    public Optional<EmpresaPublicDTO> buscarPorIdPublic(Long id) {
        Optional<Empresa> empresa = buscarPorId(id);
        return empresa.map(EmpresaPublicDTO::new);

    }

    public Empresa salvar(Empresa empresa) {
        return empresaRepository.save(empresa);
    }

    public EmpresaCreateDTO toDTO(Empresa empresa) {
        return modelMapper.map(empresa, EmpresaCreateDTO.class);
    }

    public Empresa toEntity(EmpresaCreateDTO empresaDTO) {
        return modelMapper.map(empresaDTO, Empresa.class);
    }

    public void deletar(Long id) {
        empresaRepository.deleteById(id);
    }




}
