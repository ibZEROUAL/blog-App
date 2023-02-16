--liquibase formatted sql
--changeset ibrahim:changelogVersion1
CREATE TABLE `users` (`id` INT NOT NULL , `username` VARCHAR(110) NOT NULL , `email` VARCHAR(110) NOT NULL , `password` VARCHAR(110) NOT NULL , `first_name` VARCHAR(110) NOT NULL , `last_name` VARCHAR(110) NOT NULL ) ENGINE = InnoDB;
