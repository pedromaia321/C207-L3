-- MySQL Workbench Forward Engineering


-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`Setor_de_peças`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Setor_de_peças` (
  `Direto_Setor_pecas` VARCHAR(45) NOT NULL,
  `Peças_quantidade` INT NULL,
  `Quanti_de_funcio` INT NULL,
  PRIMARY KEY (`Direto_Setor_peças`))
;


-- -----------------------------------------------------
-- Table `mydb`.`Finanças`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Finanças` (
  `Diretor_financeiro` VARCHAR(45) NOT NULL,
  `Contador` VARCHAR(45) NULL,
  `Salarios` INT NULL,
  `Valor_investido_no_carro` INT NULL,
  PRIMARY KEY (`Diretor_financeiro`))
;


-- -----------------------------------------------------
-- Table `mydb`.`Setor_de_motores`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Setor_de_motores` (
  `Direitor_do_setor_de_motores` VARCHAR(45) NOT NULL,
  `Quanti_de_funci` INT NULL,
  `Quanti_para_pesquisa` INT NULL,
  PRIMARY KEY (`Direitor_do_setor_de_motores`))
;


-- -----------------------------------------------------
-- Table `mydb`.`Materias_primas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Materias_primas` (
  `Responsavel` VARCHAR(45) NOT NULL,
  `Materias_primas_adquiridas` VARCHAR(45) NULL,
  `Quantidade` INT NULL,
  PRIMARY KEY (`Responsavel`))
;


-- -----------------------------------------------------
-- Table `mydb`.`Contrucao_do_carro`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Contrucao_do_carro` (
  `Projetista` VARCHAR(45) NOT NULL,
  `Setor_de_peças_Direto_Setor_peças` VARCHAR(45) NOT NULL,
  `Materias_primas_Responsavel` VARCHAR(45) NOT NULL,
  `Setor_de_motores_Direitor_do_setor_de_motores` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`Projetista`),
  CONSTRAINT `fk_Contrucao_do_carro_Setor_de_peças1`
    FOREIGN KEY (`Setor_de_peças_Direto_Setor_peças`)
    REFERENCES `mydb`.`Setor_de_peças` (`Direto_Setor_peças`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Contrucao_do_carro_Materias_primas1`
    FOREIGN KEY (`Materias_primas_Responsavel`)
    REFERENCES `mydb`.`Materias_primas` (`Responsavel`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Contrucao_do_carro_Setor_de_motores1`
    FOREIGN KEY (`Setor_de_motores_Direitor_do_setor_de_motores`)
    REFERENCES `mydb`.`Setor_de_motores` (`Direitor_do_setor_de_motores`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
;


-- -----------------------------------------------------
-- Table `mydb`.`Sede_da_Equipe`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Sede_da_Equipe` (
  `Nome_presidente` VARCHAR(45) NOT NULL,
  `Quantidade_funci` INT NULL,
  `Localização` VARCHAR(45) NULL,
  `Setor_de_peças_Direto_Setor_peças` VARCHAR(45) NOT NULL,
  `Finanças_Diretor_financeiro` VARCHAR(45) NOT NULL,
  `Setor_de_motores_Direitor_do_setor_de_motores` VARCHAR(45) NOT NULL,
  `Contrucao_do_carro_Projetista` VARCHAR(45) NOT NULL,
  `Materias_primas_Responsavel` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`Nome_presidente`),
  CONSTRAINT `fk_Sede_da_Equipe_Setor_de_peças1`
    FOREIGN KEY (`Setor_de_peças_Direto_Setor_peças`)
    REFERENCES `mydb`.`Setor_de_peças` (`Direto_Setor_peças`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Sede_da_Equipe_Finanças1`
    FOREIGN KEY (`Finanças_Diretor_financeiro`)
    REFERENCES `mydb`.`Finanças` (`Diretor_financeiro`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Sede_da_Equipe_Setor_de_motores1`
    FOREIGN KEY (`Setor_de_motores_Direitor_do_setor_de_motores`)
    REFERENCES `mydb`.`Setor_de_motores` (`Direitor_do_setor_de_motores`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Sede_da_Equipe_Contrucao_do_carro1`
    FOREIGN KEY (`Contrucao_do_carro_Projetista`)
    REFERENCES `mydb`.`Contrucao_do_carro` (`Projetista`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Sede_da_Equipe_Materias_primas1`
    FOREIGN KEY (`Materias_primas_Responsavel`)
    REFERENCES `mydb`.`Materias_primas` (`Responsavel`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
;


-- -----------------------------------------------------
-- Table `mydb`.`Pilotos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Pilotos` (
  `idPilotos` INT NOT NULL,
  `nome` VARCHAR(45) NULL,
  `Idade` INT NULL,
  `nível` INT NULL,
  PRIMARY KEY (`idPilotos`))
;
ALTER TABLE `pilotos`
MODIFY COLUMN `idPilotos` INT NOT NULL AUTO_INCREMENT;


-- -----------------------------------------------------
-- Table `mydb`.`Simulacoes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Simulacoes` (
  `Direitor_das_simulaçoes` VARCHAR(45) NOT NULL,
  `Piloto1` VARCHAR(45) NULL,
  `Piloto2` VARCHAR(45) NULL,
  `Pilotos_idPilotos` INT NOT NULL,
  PRIMARY KEY (`Direitor_das_simulaçoes`),
  CONSTRAINT `fk_Simulacoes_Pilotos1`
    FOREIGN KEY (`Pilotos_idPilotos`)
    REFERENCES `mydb`.`Pilotos` (`idPilotos`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
;


-- -----------------------------------------------------
-- Table `mydb`.`Simulacoes_has_Contrucao_do_carro`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Simulacoes_has_Contrucao_do_carro` (
  `Simulacoes_Direitor_das_simulaçoes` VARCHAR(45) NOT NULL,
  `Contrucao_do_carro_Projetista` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`Simulacoes_Direitor_das_simulaçoes`, `Contrucao_do_carro_Projetista`),
  CONSTRAINT `fk_Simulacoes_has_Contrucao_do_carro_Simulacoes1`
    FOREIGN KEY (`Simulacoes_Direitor_das_simulaçoes`)
    REFERENCES `mydb`.`Simulacoes` (`Direitor_das_simulaçoes`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Simulacoes_has_Contrucao_do_carro_Contrucao_do_carro1`
    FOREIGN KEY (`Contrucao_do_carro_Projetista`)
    REFERENCES `mydb`.`Contrucao_do_carro` (`Projetista`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
;


