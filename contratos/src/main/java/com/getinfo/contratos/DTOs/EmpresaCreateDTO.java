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
    
    @NotBlank(message = "O CNPJ é obrigatório")
    @CNPJ(message = "CNPJ inválido")
    private String cnpj;
    @NotBlank(message = "A razão social é obrigatória")
    @Size(min = 2, max = 60, message = "A razão social deve entrer 2 e 60 caracteres")
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
