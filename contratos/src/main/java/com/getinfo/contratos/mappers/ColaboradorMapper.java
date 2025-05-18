package com.getinfo.contratos.mappers;

import com.getinfo.contratos.DTOs.ColaboradorCreateDTO;
import com.getinfo.contratos.DTOs.ColaboradorExibirDTO;
import com.getinfo.contratos.entity.Colaborador;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ColaboradorMapper {
    Colaborador createDTOtoEntity(ColaboradorCreateDTO colaboradorCreateDTO);
    ColaboradorExibirDTO entityToExibirDTO(Colaborador colaborador);
}
