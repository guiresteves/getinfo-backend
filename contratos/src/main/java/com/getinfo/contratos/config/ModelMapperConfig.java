package com.getinfo.contratos.config;


import com.getinfo.contratos.DTOs.ContratoCreateDTO;
import com.getinfo.contratos.entity.Contrato;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ui.Model;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        modelMapper.createTypeMap(ContratoCreateDTO.class, Contrato.class)
                .addMappings(mapper -> {
                    mapper.skip(Contrato::setId);});
        return modelMapper;
    }
}
