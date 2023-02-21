--liquibase formatted sql
--changeset ibrahim:changelogVersion2
CREATE TABLE `articles` (
                          `id` INT NOT NULL AUTO_INCREMENT,
                          `title` VARCHAR(255) NOT NULL,
                          `description` TEXT,
                          PRIMARY KEY (`id`)
);
CREATE TABLE `comments` (
                           `id` INT NOT NULL AUTO_INCREMENT,
                          `content` TEXT,
                          `publishing_date` DATE,
                          PRIMARY KEY (`id`)
);
