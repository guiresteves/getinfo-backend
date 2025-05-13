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

    public EmpresaExibirDTO() {
    }

    public EmpresaExibirDTO(Long id, String razaoSocial, String cnpj, String nomeFantasia) {
        this.id = id;
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.nomeFantasia = nomeFantasia;
    }

    public EmpresaExibirDTO(Empresa empresa) {
        id = empresa.getId();
        razaoSocial = empresa.getRazaoSocial();
        cnpj = empresa.getCnpj();
        nomeFantasia = empresa.getNomeFantasia();
    }


}
