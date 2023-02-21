--liquibase formatted sql
--changeset ibrahim:changelogVersion6
CREATE TABLE users (
                       id INT NOT NULL PRIMARY KEY,
                       first_name VARCHAR(255) NOT NULL,
                       last_name VARCHAR(255) NOT NULL,
                       age INT NOT NULL
);

CREATE TABLE articles (
                          id INT NOT NULL PRIMARY KEY,
                          title VARCHAR(255) NOT NULL,
                          description VARCHAR(255) NOT NULL,
                          user_id INT NOT NULL,
                          FOREIGN KEY (user_id) REFERENCES users (id)
);

CREATE TABLE comments (
                          id INT NOT NULL PRIMARY KEY,
                          content VARCHAR(255) NOT NULL,
                          publishing_date DATE NOT NULL,
                          user_id INT NOT NULL,
                          article_id INT NOT NULL,
                          FOREIGN KEY (user_id) REFERENCES users (id),
                          FOREIGN KEY (article_id) REFERENCES articles (id)
);
