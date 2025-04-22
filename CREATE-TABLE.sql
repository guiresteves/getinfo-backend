-- MySQL database export

START TRANSACTION;

CREATE DATABASE IF NOT EXISTS `contratosdb`;

CREATE TABLE IF NOT EXISTS `contratosdb`.`anexo` (
    `id_anexo` INT NOT NULL,
    `id_contrato` INT NOT NULL,
    `anexo` BLOB,
    PRIMARY KEY (`id_anexo`)
);


CREATE TABLE IF NOT EXISTS `contratosdb`.`repactuacao` (
    `id_contrato` INT NOT NULL,
    `tempo_adit` TIME,
    `data_inicio` DATE,
    `data_final` DATE,
    `anexo` BLOB,
    `desc` TEXT,
    `tipo_contrato` TEXT
);


CREATE TABLE IF NOT EXISTS `contratosdb`.`tel_responsavel` (
    `id_responsavel` INT NOT NULL,
    `numero` VARCHAR(255),
    PRIMARY KEY (`id_responsavel`)
);


CREATE TABLE IF NOT EXISTS `contratosdb`.`cargo` (
    `id_cargo` INT NOT NULL,
    `descricao` VARCHAR(255),
    `ativo` TINYINT(1),
    PRIMARY KEY (`id_cargo`)
);


CREATE TABLE IF NOT EXISTS `contratosdb`.`funcionario` (
    `id_funcionario` INT NOT NULL,
    `nome` VARCHAR(255),
    `ativo` TINYINT(1),
    `cpf` VARCHAR(255),
    `contato` INT,
    PRIMARY KEY (`id_funcionario`)
);


CREATE TABLE IF NOT EXISTS `contratosdb`.`entregavel` (
    `id_entregavel` INT NOT NULL,
    `id_contrato` INT NOT NULL,
    `Id_status` INT,
    `prazo` INT,
    `descricao` TEXT,
    `observaçao` TEXT,
    `just_canc` TEXT,
    `data_canc` DATE,
    `data_final` DATE,
    `data_entrega` DATE,
    PRIMARY KEY (`id_entregavel`)
);


CREATE TABLE IF NOT EXISTS `contratosdb`.`responsavel` (
    `id_responsavel` INT NOT NULL,
    `nome` VARCHAR(255),
    `sobrenome` VARCHAR(255),
    `cpf` VARCHAR(255),
    `email` VARCHAR(255),
    `telefone` VARCHAR(255),
    PRIMARY KEY (`id_responsavel`)
);


CREATE TABLE IF NOT EXISTS `contratosdb`.`status` (
    `id_status` INT NOT NULL,
    `descricao` VARCHAR(255),
    PRIMARY KEY (`id_status`)
);


CREATE TABLE IF NOT EXISTS `contratosdb`.`contrato` (
    `id_contrato` INT NOT NULL,
    `id_cliente` INT NOT NULL,
    `id_funcionario` INT NOT NULL,
    `id_aditivo` INT NOT NULL,
    `id_entregavel` INT NOT NULL,
    `valor` FLOAT,
    `Id_status` INT,
    `desc` TEXT,
    `tipo_contrato` TEXT(255),
    `anexo` BLOB,
    `prazo` DATETIME,
    `data_inicio` DATE,
    `data_final` DATE,
    `id_responsavel` INT NOT NULL,
    PRIMARY KEY (`id_contrato`, `tipo_contrato`)
);


CREATE TABLE IF NOT EXISTS `contratosdb`.`endereco_empresa` (
    `id_endereco` INT NOT NULL,
    `logradouro` VARCHAR(255),
    `cep` VARCHAR(255),
    `numero` BIGINT,
    `bairro` VARCHAR(255),
    `complemento` VARCHAR(255),
    PRIMARY KEY (`id_endereco`)
);


CREATE TABLE IF NOT EXISTS `contratosdb`.`aditivo` (
    `id_aditivo` INT NOT NULL,
    `id_entregavel` INT NOT NULL,
    `tempo_adit` TIME,
    `data_inicio` DATE,
    `data_final` DATE,
    `anexo` BLOB,
    `desc` TEXT,
    `tipo_contrato` TEXT,
    PRIMARY KEY (`id_aditivo`)
);


CREATE TABLE IF NOT EXISTS `contratosdb`.`empresa` (
    `id_empresa` INT NOT NULL,
    `id_endereco` INT,
    `id_responsavel` INT,
    `cnpj` VARCHAR(255),
    `razao_social` VARCHAR(255),
    `nome_fantasia` VARCHAR(255),
    `tipo` SMALLINT,
    PRIMARY KEY (`id_empresa`)
);


CREATE TABLE IF NOT EXISTS `contratosdb`.`tel_empresa` (
    `id_empresa` INT NOT NULL,
    `numero` VARCHAR(255),
    PRIMARY KEY (`id_empresa`)
);


CREATE TABLE IF NOT EXISTS `contratosdb`.`email_empresa` (
    `id_empresa` INT NOT NULL,
    `email` VARCHAR(255),
    PRIMARY KEY (`id_empresa`)
);


-- Foreign key constraints

ALTER TABLE `aditivo`
ADD CONSTRAINT `fk_aditivo_id_aditivo` FOREIGN KEY(`id_aditivo`) REFERENCES `contratosdb`.`contrato`(`id_aditivo`)
ON UPDATE CASCADE ON DELETE RESTRICT;

ALTER TABLE `anexo`
ADD CONSTRAINT `fk_anexo_anexo` FOREIGN KEY(`anexo`) REFERENCES `aditivo`(`anexo`)
ON UPDATE CASCADE ON DELETE RESTRICT;

ALTER TABLE `anexo`
ADD CONSTRAINT `fk_anexo_anexo` FOREIGN KEY(`anexo`) REFERENCES `contratosdb`.`contrato`(`anexo`)
ON UPDATE CASCADE ON DELETE RESTRICT;

ALTER TABLE `anexo`
ADD CONSTRAINT `fk_anexo_id_contrato` FOREIGN KEY(`id_contrato`) REFERENCES `contratosdb`.`contrato`(`id_contrato`)
ON UPDATE CASCADE ON DELETE RESTRICT;

ALTER TABLE `cargo`
ADD CONSTRAINT `fk_cargo_id_cargo` FOREIGN KEY(`id_cargo`) REFERENCES `funcionario`(`id_funcionario`)
ON UPDATE CASCADE ON DELETE RESTRICT;

ALTER TABLE `contratosdb`.`empresa`
ADD CONSTRAINT `fk_empresa_id_empresa` FOREIGN KEY(`id_empresa`) REFERENCES `contratosdb`.`contrato`(`id_cliente`)
ON UPDATE CASCADE ON DELETE RESTRICT;

ALTER TABLE `contratosdb`.`empresa`
ADD CONSTRAINT `fk_empresa_id_empresa` FOREIGN KEY(`id_empresa`) REFERENCES `contratosdb`.`contrato`(`id_cliente`)
ON UPDATE CASCADE ON DELETE RESTRICT;

ALTER TABLE `contratosdb`.`contrato`
ADD CONSTRAINT `fk_contrato_tipo_contrato` FOREIGN KEY(`tipo_contrato`) REFERENCES `aditivo`(`tipo_contrato`)
ON UPDATE CASCADE ON DELETE RESTRICT;

ALTER TABLE `contratosdb`.`contrato`
ADD CONSTRAINT `fk_contrato_tipo_contrato` FOREIGN KEY(`tipo_contrato`) REFERENCES `repactuacao`(`tipo_contrato`)
ON UPDATE CASCADE ON DELETE RESTRICT;

ALTER TABLE `contratosdb`.`empresa`
ADD CONSTRAINT `fk_empresa_id_empresa` FOREIGN KEY(`id_empresa`) REFERENCES `email_empresa`(`id_empresa`)
ON UPDATE CASCADE ON DELETE RESTRICT;

ALTER TABLE `contratosdb`.`empresa`
ADD CONSTRAINT `fk_empresa_id_empresa` FOREIGN KEY(`id_empresa`) REFERENCES `tel_empresa`(`id_empresa`)
ON UPDATE CASCADE ON DELETE RESTRICT;

ALTER TABLE `endereco_empresa`
ADD CONSTRAINT `fk_endereco_empresa_id_endereco` FOREIGN KEY(`id_endereco`) REFERENCES `contratosdb`.`empresa`(`id_endereco`)
ON UPDATE CASCADE ON DELETE RESTRICT;

ALTER TABLE `contratosdb`.`entregavel`
ADD CONSTRAINT `fk_entregavel_id_contrato` FOREIGN KEY(`id_contrato`) REFERENCES `contratosdb`.`contrato`(`id_contrato`)
ON UPDATE CASCADE ON DELETE RESTRICT;

ALTER TABLE `contratosdb`.`entregavel`
ADD CONSTRAINT `fk_entregavel_id_entregavel` FOREIGN KEY(`id_entregavel`) REFERENCES `aditivo`(`id_entregavel`)
ON UPDATE CASCADE ON DELETE RESTRICT;

ALTER TABLE `contratosdb`.`entregavel`
ADD CONSTRAINT `fk_entregavel_id_entregavel` FOREIGN KEY(`id_entregavel`) REFERENCES `contratosdb`.`contrato`(`id_entregavel`)
ON UPDATE CASCADE ON DELETE RESTRICT;

ALTER TABLE `funcionario`
ADD CONSTRAINT `fk_funcionario_id_funcionario` FOREIGN KEY(`id_funcionario`) REFERENCES `contratosdb`.`contrato`(`id_funcionario`)
ON UPDATE CASCADE ON DELETE RESTRICT;

ALTER TABLE `repactuacao`
ADD CONSTRAINT `fk_repactuacao_id_contrato` FOREIGN KEY(`id_contrato`) REFERENCES `contratosdb`.`contrato`(`id_contrato`)
ON UPDATE CASCADE ON DELETE RESTRICT;

ALTER TABLE `repactuacao`
ADD CONSTRAINT `fk_repactuacao_anexo` FOREIGN KEY(`anexo`) REFERENCES `anexo`(`anexo`)
ON UPDATE CASCADE ON DELETE RESTRICT;

ALTER TABLE `responsavel`
ADD CONSTRAINT `fk_responsavel_id_responsavel` FOREIGN KEY(`id_responsavel`) REFERENCES `contratosdb`.`empresa`(`id_responsavel`)
ON UPDATE CASCADE ON DELETE RESTRICT;

ALTER TABLE `status`
ADD CONSTRAINT `fk_status_id_status` FOREIGN KEY(`id_status`) REFERENCES `contratosdb`.`contrato`(`Id_status`)
ON UPDATE CASCADE ON DELETE RESTRICT;

ALTER TABLE `status`
ADD CONSTRAINT `fk_status_id_status` FOREIGN KEY(`id_status`) REFERENCES `contratosdb`.`entregavel`(`Id_status`)
ON UPDATE CASCADE ON DELETE RESTRICT;

ALTER TABLE `tel_responsavel`
ADD CONSTRAINT `fk_tel_responsavel_id_responsavel` FOREIGN KEY(`id_responsavel`) REFERENCES `responsavel`(`id_responsavel`)
ON UPDATE CASCADE ON DELETE RESTRICT;

COMMIT;
