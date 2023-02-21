--liquibase formatted sql
--changeset ibrahim:changelogVersion4
INSERT INTO articles (title, description) VALUES ('article 2', 'a long description to insert for article 2');
INSERT INTO articles (title, description) VALUES ('article 3', 'a long description to insert  for article 3');
