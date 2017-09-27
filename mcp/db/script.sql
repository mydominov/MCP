SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `diss` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `diss` ;

-- -----------------------------------------------------
-- Table `diss`.`polynomial`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `diss`.`polynomial` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `function` VARCHAR(45) NOT NULL,
  `length` TINYINT NOT NULL,
  `number` VARCHAR(45) NOT NULL,
  `property` VARCHAR(2) NOT NULL,
  `t` INT NOT NULL,
  `j` SMALLINT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `name_UNIQUE` (`function` ASC))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
