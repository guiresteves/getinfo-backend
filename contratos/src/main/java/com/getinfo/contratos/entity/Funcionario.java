package com.getinfo.contratos.entity;

import jakarta.persistence.*;
import lombok.Data;

// // CREATE TABLE `funcionario` (
//     `id_funcionario` INT NOT NULL,
//     `nome` VARCHAR(255),
//     `ativo` TINYINT(1),
//     `cpf` VARCHAR(255),
//     `contato` VARCHAR(255),
//     `id_cargo` INT,
//     PRIMARY KEY (`id_funcionario`),
//     FOREIGN KEY (`id_cargo`) REFERENCES `cargo`(`id_cargo`)
//         ON UPDATE CASCADE ON DELETE RESTRICT
// );

@Entity
@Data
public class Funcionario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFuncionario;

    private String nome;
    private int ativo;
    private String cpf;
    private String contato;
    private Long idCargo;
}
