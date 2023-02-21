--liquibase formatted sql
--changeset ibrahim:changelogVersion1
CREATE TABLE `users` (
                         `id` INT NOT NULL,
                         `first_name` VARCHAR(110) NOT NULL,
                         `last_name` VARCHAR(110) NOT NULL,
                         `age` INT,
                         PRIMARY KEY (`id`)
);
