package com.getinfo.contratos.entity;

import jakarta.persistence.*;
import lombok.Data;

// CREATE TABLE `contrato` (
//     `id_contrato` INT NOT NULL,
//     `id_cliente` INT NOT NULL,
//     `id_funcionario` INT NOT NULL,
//     `valor` FLOAT,
//     `id_status` INT,
//     `descricao` TEXT,
//     `tipo_contrato` TEXT,
//     `anexo` BLOB,
//     `prazo` DATETIME,
//     `data_inicio` DATE,
//     `data_final` DATE,
//     `id_responsavel` INT NOT NULL,
//     PRIMARY KEY (`id_contrato`),
//     FOREIGN KEY (`id_cliente`) REFERENCES `empresa`(`id_empresa`)
//         ON UPDATE CASCADE ON DELETE RESTRICT,
//     FOREIGN KEY (`id_funcionario`) REFERENCES `funcionario`(`id_funcionario`)
//         ON UPDATE CASCADE ON DELETE RESTRICT,
//     FOREIGN KEY (`id_status`) REFERENCES `status`(`id_status`)
//         ON UPDATE CASCADE ON DELETE RESTRICT,
//     FOREIGN KEY (`id_responsavel`) REFERENCES `responsavel`(`id_responsavel`)
//         ON UPDATE CASCADE ON DELETE RESTRICT
// );

@Entity
@Data
public class Contrato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idContrato;

    private Long idCliente;
    private Long idFuncionario;
    private Long idStatus;
    private Long idResponsavel;
    private Float valor;
    private String descricao;
    private String tipoContrato;
    @Lob
    private byte[] anexo;
    private String prazo;
    private String dataInicio;
    private String dataFinal;
}
