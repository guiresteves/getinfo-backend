package com.getinfo.contratos.entity;

import jakarta.persistence.*;
import lombok.Data;

// CREATE TABLE IF NOT EXISTS `contratosdb`.`empresa` (
//     `id_empresa` INT NOT NULL AUTO_INCREMENT,
//     `id_endereco` INT,
//     `id_responsavel` INT,
//     `cnpj` VARCHAR(255),
//     `razao_social` VARCHAR(255),
//     `nome_fantasia` VARCHAR(255),
//     `tipo` SMALLINT,
//     PRIMARY KEY (`id_empresa`)
// );

@Entity
@Data
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEmpresa;

    private Long idEndereco;
    private Long idResponsavel;
    private String cnpj;
    private String razaoSocial;
    private String nomeFantasia;
    private Short tipo;
}
