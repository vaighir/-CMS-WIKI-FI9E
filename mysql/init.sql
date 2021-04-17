DROP DATABASE IF EXISTS test_db;

CREATE DATABASE test_db;
use test_db;

CREATE TABLE role (
    id INT AUTO_INCREMENT,
    name VARCHAR(255),
    PRIMARY KEY (id)
);

CREATE TABLE user (
    id INT AUTO_INCREMENT,
    role_id INT,
    name VARCHAR(255),
    email VARCHAR(255),
    password VARCHAR(255),
    PRIMARY KEY (id),
    FOREIGN KEY (role_id)
      REFERENCES role(id)
      ON DELETE CASCADE
);

CREATE TABLE article (
  id INT AUTO_INCREMENT,
  slug VARCHAR(255),
  content TEXT,
  created_at DATETIME,
  updated_at DATETIME,
  PRIMARY KEY (id)
);

INSERT INTO role (name) values ("admin");
INSERT INTO role (name) values ("creator");
INSERT INTO role (name) values ("spectator");

INSERT INTO user (name, email, password) values ("John Smith", "john.smith@mail.com", "$2a$10$o2ItyR7XkJSQb9J5R2JVXery52e7P0EcRCU4D2q.pol77qdW/ghQ6
");
INSERT INTO user (name, email, password) values ("Jane Shepard", "jane.shepard@normandy.gov", "$2a$10$o2ItyR7XkJSQb9J5R2JVXery52e7P0EcRCU4D2q.pol77qdW/ghQ6
");
