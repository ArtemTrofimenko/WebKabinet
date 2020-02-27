-- Mon Feb  3 15:05:57 2020
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema wk_db
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema wk_db
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `wk_db` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `wk_db` ;

-- -----------------------------------------------------
-- Table `wk_db`.`carrier`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `wk_db`.`carrier` (
  `id` VARCHAR(255) NOT NULL,
  `carrier_name` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `wk_db`.`contragent`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `wk_db`.`contragent` (
  `id` VARCHAR(255) NOT NULL,
  `contragent_id` VARCHAR(255) NULL DEFAULT NULL,
  `contragent_name` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `wk_db`.`driver`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `wk_db`.`driver` (
  `id` VARCHAR(255) NOT NULL,
  `driver_license` VARCHAR(255) NULL DEFAULT NULL,
  `name` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

-- -----------------------------------------------------
-- Table `wk_db`.`flyway_schema_history`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `wk_db`.`flyway_schema_history` (
  `installed_rank` INT(11) NOT NULL,
  `version` VARCHAR(50) NULL DEFAULT NULL,
  `description` VARCHAR(200) NOT NULL,
  `type` VARCHAR(20) NOT NULL,
  `script` VARCHAR(1000) NOT NULL,
  `checksum` INT(11) NULL DEFAULT NULL,
  `installed_by` VARCHAR(100) NOT NULL,
  `installed_on` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `execution_time` INT(11) NOT NULL,
  `success` TINYINT(1) NOT NULL,
  PRIMARY KEY (`installed_rank`),
  INDEX `flyway_schema_history_s_idx` (`success` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `wk_db`.`hibernate_sequence`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `wk_db`.`hibernate_sequence` (
  `next_val` BIGINT(20) NULL DEFAULT NULL)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `wk_db`.`hibernate_sequences`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `wk_db`.`hibernate_sequences` (
  `sequence_name` VARCHAR(255) NOT NULL,
  `next_val` BIGINT(20) NULL DEFAULT NULL,
  PRIMARY KEY (`sequence_name`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `wk_db`.`nomenclature`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `wk_db`.`nomenclature` (
  `id` VARCHAR(255) NOT NULL,
  `name` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `wk_db`.`usr`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `wk_db`.`usr` (
  `id` VARCHAR(255) NOT NULL,
  `active` BIT(1) NOT NULL,
  `fullname` VARCHAR(255) NULL DEFAULT NULL,
  `password` VARCHAR(255) NULL DEFAULT NULL,
  `user_email` VARCHAR(255) NULL DEFAULT NULL,
  `user_phone_number` INT(11) NULL DEFAULT NULL,
  `username` VARCHAR(255) NULL DEFAULT NULL,
  `contragent_id` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `wk_db`.`vehicle`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `wk_db`.`vehicle` (
  `id` VARCHAR(255) NOT NULL,
  `car_model` VARCHAR(255) NULL DEFAULT NULL,
  `car_number` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `wk_db`.`ttn`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `wk_db`.`ttn` (
  `id` VARCHAR(255) NOT NULL,
  `author_id` VARCHAR(255) NULL DEFAULT NULL,
  `carrier_id` VARCHAR(255) NULL DEFAULT NULL,
  `contragent_id` VARCHAR(255) NULL DEFAULT NULL,
  `driver_id` VARCHAR(255) NULL DEFAULT NULL,
  `nomenclature_id` VARCHAR(255) NULL DEFAULT NULL,
  `vehicle_id` VARCHAR(255) NULL DEFAULT NULL,
  `num` BIGINT(20) NULL DEFAULT NULL,
  `ttn_number` VARCHAR(255) NULL DEFAULT NULL,
  `index_of_number` VARCHAR(255) NULL DEFAULT NULL,
  `ttn_time` DATETIME,
  `weight` FLOAT(2) default 0,
   `humidity` Float(2) default 0,
   `rubbish` Float(2) default 0,
   `percent_by_humidity` FLOAT(2) default 0,
   `percent_by_rubbish` FLOAT(2) default 0,
  PRIMARY KEY (`id`),
  INDEX `user_fk` (`author_id` ASC),
  INDEX `contragent_fk` (`contragent_id` ASC),
  INDEX `carrier_fk` (`carrier_id` ASC),
  INDEX `driver_fk` (`driver_id` ASC),

  INDEX `nomenclature_fk` (`nomenclature_id` ASC),
  INDEX `vehicle_fk` (`vehicle_id` ASC),
  CONSTRAINT `carrier_fk`
    FOREIGN KEY (`carrier_id`)
    REFERENCES `wk_db`.`carrier` (`id`),
  CONSTRAINT `contragent_fk`
    FOREIGN KEY (`contragent_id`)
    REFERENCES `wk_db`.`contragent` (`id`),
  CONSTRAINT `driver_fk`
    FOREIGN KEY (`driver_id`)
    REFERENCES `wk_db`.`driver` (`id`),
  CONSTRAINT `nomenclature_fk`
    FOREIGN KEY (`nomenclature_id`)
    REFERENCES `wk_db`.`nomenclature` (`id`),
  CONSTRAINT `user_fk`
    FOREIGN KEY (`author_id`)
    REFERENCES `wk_db`.`usr` (`id`),
  CONSTRAINT `vehicle_fk`
    FOREIGN KEY (`vehicle_id`)
    REFERENCES `wk_db`.`vehicle` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `wk_db`.`user_role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `wk_db`.`user_role` (
  `user_id` VARCHAR(255) NOT NULL,
  `roles` VARCHAR(255) NULL DEFAULT NULL,
  INDEX `user_role_fk` (`user_id` ASC),
  CONSTRAINT `user_role_fk`
    FOREIGN KEY (`user_id`)
    REFERENCES `wk_db`.`usr` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

insert into usr (id, username, password, active)
    values (1, 'admin', '123', true);

insert into user_role (user_id, roles)
    values (1, 'USER'), (1, 'ADMIN');