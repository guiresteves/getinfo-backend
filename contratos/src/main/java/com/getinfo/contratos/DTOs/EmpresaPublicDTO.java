package com.getinfo.contratos.DTOs;


import com.getinfo.contratos.entity.Empresa;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmpresaPublicDTO {

    private Long id;
    private String razaoSocial;
    private String cnpj;
    private String nomeFantasia;

    public EmpresaPublicDTO() {
    }

    public EmpresaPublicDTO(Long id, String razaoSocial, String cnpj, String nomeFantasia) {
        this.id = id;
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.nomeFantasia = nomeFantasia;
    }

    public EmpresaPublicDTO(Empresa empresa) {
        id = empresa.getId();
        razaoSocial = empresa.getRazaoSocial();
        cnpj = empresa.getCnpj();
        nomeFantasia = empresa.getNomeFantasia();
    }


}
