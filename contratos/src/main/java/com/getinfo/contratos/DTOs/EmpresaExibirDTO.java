package com.getinfo.contratos.DTOs;


import com.getinfo.contratos.entity.Empresa;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmpresaExibirDTO {

    private Long id;
    private String razaoSocial;
    private String cnpj;
    private String nomeFantasia;
    private String emailResponsavel;
    private String nomeResponsavel;

    public EmpresaExibirDTO(Empresa empresa) {
        id = empresa.getId();
        razaoSocial = empresa.getRazaoSocial();
        cnpj = empresa.getCnpj();
        nomeFantasia = empresa.getNomeFantasia();
        emailResponsavel = empresa.getEmailResponsavel();
        nomeResponsavel = empresa.getNomeResponsavel(); 
    }


}
