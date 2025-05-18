package com.getinfo.contratos.service;

import com.getinfo.contratos.DTOs.ColaboradorCreateDTO;
import com.getinfo.contratos.DTOs.ColaboradorExibirDTO;
import com.getinfo.contratos.entity.Colaborador;
import com.getinfo.contratos.mappers.ColaboradorMapper;
import com.getinfo.contratos.repository.ColaboradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ColaboradorService {

    @Autowired
    private ColaboradorRepository colaboradorRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ColaboradorMapper colaboradorMapper;


    public List<Colaborador> listarTodas() {
        return colaboradorRepository.findAll();
    }

    public List<ColaboradorExibirDTO> listarDTOs() {
        List<Colaborador> colaboradores = listarTodas();
        List<ColaboradorExibirDTO> colaboradoresDTO = new ArrayList<>();
        for (Colaborador colaborador: colaboradores) {
            colaboradoresDTO.add(colaboradorMapper.entityToExibirDTO(colaborador));
        }
        return colaboradoresDTO;
    }



    public Optional<Colaborador> buscarPorId(Long id) {
        return colaboradorRepository.findById(id);
    }

    public Colaborador CreateDTOtoEntity(ColaboradorCreateDTO colaboradorDTO) {
        return colaboradorMapper.createDTOtoEntity(colaboradorDTO);
    }
    public Colaborador salvar(Colaborador colaborador) {
        return colaboradorRepository.save(colaborador);
    }

    public void deletar(Long id) {
        colaboradorRepository.deleteById(id);
    }
}
