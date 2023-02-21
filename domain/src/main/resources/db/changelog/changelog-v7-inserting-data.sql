--liquibase formatted sql
--changeset ibrahim:changelogVersion7
INSERT INTO users (id, first_name, last_name, age)
VALUES (1, 'John', 'Doe', 30),
       (2, 'Jane', 'Smith', 25),
       (3, 'Bob', 'Johnson', 40);

INSERT INTO articles (id, title, description, user_id)
VALUES (1, 'Introduction to SQL', 'This article provides an introduction to SQL.', 1),
       (2, 'Advanced SQL Queries', 'This article covers advanced SQL query techniques.', 1),
       (3, 'Data Modeling', 'This article explains the basics of data modeling.', 2),
       (4, 'Normalization', 'This article covers the process of database normalization.', 2),
       (5, 'Database Design', 'This article explains the principles of database design.', 2),
       (6, 'Database Security', 'This article covers database security best practices.', 3),
       (7, 'Backup and Recovery', 'This article explains the importance of database backup and recovery.', 3),
       (8, 'Replication', 'This article covers database replication techniques.', 3),
       (9, 'Scaling Databases', 'This article covers database scaling techniques.', 3),
       (10, 'NoSQL Databases', 'This article provides an introduction to NoSQL databases.', 3),
       (11, 'Graph Databases', 'This article covers the basics of graph databases.', 3);

INSERT INTO comments (id, content, publishing_date, user_id, article_id)
VALUES (1, 'Great article!', '2023-02-20', 1, 1),
       (2, 'Thanks for writing this!', '2023-02-21', 2, 1),
       (3, 'I learned a lot from this article.', '2023-02-19', 3, 1),
       (4, 'Can you provide an example of a complex SQL query?', '2023-02-18', 1, 2),
       (5, 'This is exactly what I was looking for!', '2023-02-20', 1, 3),
       (6, 'I have a question about data modeling.', '2023-02-19', 2, 3),
       (7, 'I need more information about database normalization.', '2023-02-21', 3, 4),
       (8, 'What are the best practices for database backup?', '2023-02-18', 2, 7);

