package com.getinfo.contratos.DTOs;

import org.hibernate.validator.constraints.br.CNPJ;
import com.getinfo.contratos.enums.TipoEmpresa;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmpresaCreateDTO {

    @CNPJ(message = "CNPJ inválido")
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
