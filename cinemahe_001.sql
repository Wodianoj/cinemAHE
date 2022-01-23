-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema cinemahe
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema cinemahe
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `cinemahe` DEFAULT CHARACTER SET utf8 ;
USE `cinemahe` ;

-- -----------------------------------------------------
-- Table `cinemahe`.`cahe_user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cinemahe`.`cahe_user` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(64) NOT NULL,
  `last_name` VARCHAR(64) NOT NULL,
  `mail` VARCHAR(256) NOT NULL,
  `registration_date` DATETIME NOT NULL,
  `phone_number` VARCHAR(15) NULL,
  `password` VARBINARY(64) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  UNIQUE INDEX `mail_UNIQUE` (`mail` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cinemahe`.`cahe_cinema`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cinemahe`.`cahe_cinema` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(64) NOT NULL,
  `address` VARCHAR(256) NOT NULL,
  `contact` VARCHAR(256) NOT NULL,
  `path_to_picture` VARCHAR(256) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `cinema_id_UNIQUE` (`id` ASC),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cinemahe`.`cahe_room`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cinemahe`.`cahe_room` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(32) NOT NULL,
  `cinema_id` BIGINT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  INDEX `FK_room_cinema_id_idx` (`cinema_id` ASC),
  CONSTRAINT `FK_room_cinema_id`
    FOREIGN KEY (`cinema_id`)
    REFERENCES `cinemahe`.`cahe_cinema` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cinemahe`.`cahe_genre`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cinemahe`.`cahe_genre` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `genre_name` VARCHAR(64) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cinemahe`.`cahe_movie`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cinemahe`.`cahe_movie` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(64) NOT NULL,
  `description` VARCHAR(512) NOT NULL,
  `genre_id` BIGINT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  INDEX `FK_movie_genre_id_idx` (`genre_id` ASC),
  CONSTRAINT `FK_movie_genre_id`
    FOREIGN KEY (`genre_id`)
    REFERENCES `cinemahe`.`cahe_genre` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cinemahe`.`cahe_director`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cinemahe`.`cahe_director` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(64) NOT NULL,
  `last_name` VARCHAR(64) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cinemahe`.`cahe_seance`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cinemahe`.`cahe_seance` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `beginning_date_time` DATETIME NOT NULL,
  `ending_date_time` DATETIME NOT NULL,
  `movie_id` BIGINT NOT NULL,
  `room_id` BIGINT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  INDEX `FK_seance_movie_id_idx` (`movie_id` ASC),
  INDEX `FK_seance_room_id_idx` (`room_id` ASC),
  CONSTRAINT `FK_seance_movie_id`
    FOREIGN KEY (`movie_id`)
    REFERENCES `cinemahe`.`cahe_movie` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_seance_room_id`
    FOREIGN KEY (`room_id`)
    REFERENCES `cinemahe`.`cahe_room` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cinemahe`.`cahe_seat`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cinemahe`.`cahe_seat` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `seat_number` INT NOT NULL,
  `row_number` INT NOT NULL,
  `room_id` BIGINT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  INDEX `FK_seat_room_id_idx` (`room_id` ASC),
  CONSTRAINT `FK_seat_room_id`
    FOREIGN KEY (`room_id`)
    REFERENCES `cinemahe`.`cahe_room` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cinemahe`.`cahe_ticket`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cinemahe`.`cahe_ticket` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `selling_date` DATETIME NOT NULL,
  `seance_id` BIGINT NOT NULL,
  `user_id` BIGINT NOT NULL,
  `seat_id` BIGINT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  INDEX `FK_ticket_seance_id_idx` (`seance_id` ASC),
  INDEX `KF_ticket_user_id_idx` (`user_id` ASC),
  INDEX `FK_ticket_seat_id_idx` (`seat_id` ASC),
  CONSTRAINT `FK_ticket_seance_id`
    FOREIGN KEY (`seance_id`)
    REFERENCES `cinemahe`.`cahe_seance` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_ticket_user_id`
    FOREIGN KEY (`user_id`)
    REFERENCES `cinemahe`.`cahe_user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_ticket_seat_id`
    FOREIGN KEY (`seat_id`)
    REFERENCES `cinemahe`.`cahe_seat` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cinemahe`.`cahe_movie_director`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cinemahe`.`cahe_movie_director` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `id_movie` BIGINT NOT NULL,
  `id_director` BIGINT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  INDEX `FK_movie_director_movie_id_idx` (`id_movie` ASC),
  INDEX `FK_movie_director_director_id_idx` (`id_director` ASC),
  CONSTRAINT `FK_movie_director_movie_id`
    FOREIGN KEY (`id_movie`)
    REFERENCES `cinemahe`.`cahe_movie` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_movie_director_director_id`
    FOREIGN KEY (`id_director`)
    REFERENCES `cinemahe`.`cahe_director` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
