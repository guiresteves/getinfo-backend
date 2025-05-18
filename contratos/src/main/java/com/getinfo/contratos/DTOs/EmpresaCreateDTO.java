package com.getinfo.contratos.DTOs;

import com.getinfo.contratos.enums.TipoEmpresa;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmpresaCreateDTO {

    @NotBlank(message = "CNPJ é obrigatório!")
    @Size(min = 14, max = 14, message = "O campo deve ter exatamente 14 caracteres")
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
