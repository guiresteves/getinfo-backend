package com.getinfo.contratos.mappers;

import com.getinfo.contratos.DTOs.EmpresaCreateDTO;
import com.getinfo.contratos.DTOs.EmpresaExibirDTO;
import com.getinfo.contratos.entity.Empresa;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface EmpresaMapper {
    Empresa createDTOtoEntity(EmpresaCreateDTO empresaCreateDTO);
    EmpresaExibirDTO entityToExibirDTO(Empresa empresa);
}
