package com.getinfo.contratos.service;

import com.getinfo.contratos.DTOs.ContratoCreateDTO;
import com.getinfo.contratos.DTOs.ContratoExibirDTO;
import com.getinfo.contratos.entity.Contrato;
import com.getinfo.contratos.entity.Empresa;
import com.getinfo.contratos.repository.ContratoRepository;
import com.getinfo.contratos.repository.EmpresaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.Duration;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ContratoService {

    @Autowired
    private ContratoRepository contratoRepository;
    @Autowired
    private EmpresaRepository empresaRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<Contrato> listarTodas() {
        return contratoRepository.findAll();
    }
    public List<ContratoExibirDTO> listarPublic() {
        List<ContratoExibirDTO> contratosExibir = new ArrayList<>();
        for (Contrato contrato: listarTodas()){
            contratosExibir.add(modelMapper.map(contrato, ContratoExibirDTO.class));
        }
        return contratosExibir;
    }


    public ContratoCreateDTO toDTO(Contrato contrato) {
        ContratoCreateDTO contratoDTO = new ContratoCreateDTO(contrato);
        return contratoDTO;
    }
    public Contrato toEntity(ContratoCreateDTO contratoCreateDTO) {
        Empresa empresa = empresaRepository.findById(contratoCreateDTO.getEmpresaId()).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND));
        Contrato contrato = new Contrato();
        contrato.setEmpresaId(empresa);
        contrato.setStatus(contratoCreateDTO.getStatus());
        contrato.setValor(contratoCreateDTO.getValor());
        contrato.setDescricao(contratoCreateDTO.getDescricao());
        contrato.setTipo(contratoCreateDTO.getTipo());
        contrato.setDataInicio(contratoCreateDTO.getDataInicio());
        contrato.setDataFim(contratoCreateDTO.getDataFim());
        return contrato;
    }

    public Optional<Contrato> buscarPorId(Long id) {
        return contratoRepository.findById(id);
    }

    public Contrato salvar(Contrato contrato) {
        return contratoRepository.save(contrato);
    }

    public void deletar(Long id) {
        contratoRepository.deleteById(id);
    }

}
