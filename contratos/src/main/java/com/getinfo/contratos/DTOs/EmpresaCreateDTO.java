package com.getinfo.contratos.DTOs;

import com.getinfo.contratos.enums.TipoEmpresa;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmpresaCreateDTO {

    private String cnpj;
    private String razaoSocial;
    private String nomeFantasia;
    private TipoEmpresa tipo;
    private String cep;
    private String logradouro;
    private String bairro;
    private String numero;
    private String cidade;
    private String complemento;
    private String email;
    private String telefone;
    private String nomeResponsavel;
    private String emailResponsavel;
    private String telefoneResponsavel;
    private String cpfResponsavel;

}
