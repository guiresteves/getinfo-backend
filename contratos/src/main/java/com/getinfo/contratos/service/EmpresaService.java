package com.getinfo.contratos.service;

import com.getinfo.contratos.DTOs.EmpresaCreateDTO;
import com.getinfo.contratos.DTOs.EmpresaExibirDTO;
import com.getinfo.contratos.entity.Empresa;
import com.getinfo.contratos.repository.EmpresaRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.beans.Transient;
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
    public List<EmpresaExibirDTO> listAllPublic() {
        List<EmpresaExibirDTO> empresaExibirDTOS = new ArrayList<>();
        for(Empresa empresa: listarTodas()) {
            EmpresaExibirDTO empresaExibirDTO = new EmpresaExibirDTO(empresa);
            empresaExibirDTOS.add(empresaExibirDTO);
        }
        return empresaExibirDTOS;
    }

    public Optional<Empresa> buscarPorId(Long id) {
        return empresaRepository.findById(id);
    }

    public Optional<EmpresaExibirDTO> buscarPorIdPublic(Long id) {
        Optional<Empresa> empresa = buscarPorId(id);
        return empresa.map(EmpresaExibirDTO::new);

    }

    @Transactional
    public Empresa atualizarParcial(Long id, EmpresaCreateDTO empresaDTO) {
        Empresa empresaEntidade = empresaRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND));

        if (empresaDTO.getCnpj() != null) {
            empresaEntidade.setCnpj(empresaDTO.getCnpj());
        }

        if (empresaDTO.getRazaoSocial() != null) {
            empresaEntidade.setRazaoSocial(empresaDTO.getRazaoSocial());
        }

        if (empresaDTO.getNomeFantasia() != null) {
            empresaEntidade.setNomeFantasia(empresaDTO.getNomeFantasia());
        }

        if (empresaDTO.getTipo() != null) {
            empresaEntidade.setTipo(empresaDTO.getTipo());
        }

        if (empresaDTO.getCep() != null) {
            empresaEntidade.setCep(empresaDTO.getCep());
        }

        if (empresaDTO.getLogradouro() != null) {
            empresaEntidade.setLogradouro(empresaDTO.getLogradouro());
        }

        if (empresaDTO.getBairro() != null) {
            empresaEntidade.setBairro(empresaDTO.getBairro());
        }

        if (empresaDTO.getNumero() != null) {
            empresaEntidade.setNumero(empresaDTO.getNumero());
        }

        if (empresaDTO.getCidade() != null) {
            empresaEntidade.setCidade(empresaDTO.getCidade());
        }

        if (empresaDTO.getComplemento() != null) {
            empresaEntidade.setComplemento(empresaDTO.getComplemento());
        }

        if (empresaDTO.getEmail() != null) {
            empresaEntidade.setEmail(empresaDTO.getEmail());
        }

        if (empresaDTO.getTelefone() != null) {
            empresaEntidade.setTelefone(empresaDTO.getTelefone());
        }

        if (empresaDTO.getNomeResponsavel() != null) {
            empresaEntidade.setNomeResponsavel(empresaDTO.getNomeResponsavel());
        }

        if (empresaDTO.getEmailResponsavel() != null) {
            empresaEntidade.setEmailResponsavel(empresaDTO.getEmailResponsavel());
        }

        if (empresaDTO.getTelefoneResponsavel() != null) {
            empresaEntidade.setTelefoneResponsavel(empresaDTO.getTelefoneResponsavel());
        }

        if (empresaDTO.getCpfResponsavel() != null) {
            empresaEntidade.setCpfResponsavel(empresaDTO.getCpfResponsavel());
        }

        return empresaRepository.save(empresaEntidade);

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
