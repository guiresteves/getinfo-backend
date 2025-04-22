package com.getinfo.contratos.entity;

import jakarta.persistence.*;
import lombok.Data;

// CREATE TABLE IF NOT EXISTS `contratosdb`.`contrato` (
//     `id_contrato` INT NOT NULL,
//     `id_cliente` INT NOT NULL,
//     `id_funcionario` INT NOT NULL,
//     `id_aditivo` INT NOT NULL,
//     `id_entregavel` INT NOT NULL,
//     `valor` FLOAT,
//     `Id_status` INT,
//     `desc` TEXT,
//     `tipo_contrato` TEXT(255),
//     `anexo` BLOB,
//     `prazo` DATETIME,
//     `data_inicio` DATE,
//     `data_final` DATE,
//     `id_responsavel` INT NOT NULL,
//     PRIMARY KEY (`id_contrato`, `tipo_contrato`)
// );

@Entity
@Data
public class Contrato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idContrato;

    private Long idCliente;
    private Long idFuncionario;
    private Long idAditivo;
    private Long idEntregavel;
    private Float valor;
    private Long idStatus;
    private String desc;
    private String tipoContrato;
    @Lob
    private byte[] anexo;
    private String prazo;
    private String dataInicio;
    private String dataFinal;
    private Long idResponsavel;
}
