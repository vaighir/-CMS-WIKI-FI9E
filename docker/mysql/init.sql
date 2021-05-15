DROP DATABASE IF EXISTS test_db;

CREATE DATABASE test_db;
use test_db;

CREATE TABLE role (
    id INT AUTO_INCREMENT,
    name VARCHAR(255),
    PRIMARY KEY (id)
);

CREATE TABLE category (
    id INT AUTO_INCREMENT,
    name VARCHAR(255),
    description VARCHAR(255),
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
  category_id INT,
  name VARCHAR(255),
  slug VARCHAR(255),
  content TEXT,
  created_at DATETIME,
  updated_at DATETIME,
  PRIMARY KEY (id),
  FOREIGN KEY (category_id)
    REFERENCES category(id)
    ON DELETE CASCADE
);

INSERT INTO role (name) values ("admin");
INSERT INTO role (name) values ("creator");
INSERT INTO role (name) values ("spectator");

INSERT INTO category (name, description) values ("LF1", "Der Betrieb und sein Umfeld");
INSERT INTO category (name, description) values ("LF2", "Geschäftsprozesse und betriebliche Organisation");
INSERT INTO category (name, description) values ("LF3", "Informationsquellen und Arbeitsmethoden");
INSERT INTO category (name, description) values ("LF4", "Einfache IT-Systeme");
INSERT INTO category (name, description) values ("LF5", "Fachliches Englisch");
INSERT INTO category (name, description) values ("LF6", "Entwickeln und Bereitstellen von Anwendungssystemen");
INSERT INTO category (name, description) values ("LF7", "Vernetzte IT-Systeme");
INSERT INTO category (name, description) values ("LF8", "Markt und Kundenbeziehungen");
INSERT INTO category (name, description) values ("LF9", "Öffentliche Netze, Dienste");
INSERT INTO category (name, description) values ("LF10", "Betreuung von IT-Systemen");
INSERT INTO category (name, description) values ("LF11", "Rechnungswesen und Controlling");
INSERT INTO category (name, description) values ("PoWi", "Politik und Wirtschaft");
INSERT INTO category (name, description) values ("DE", "Deutsch");

INSERT INTO article (name, category_id) values ("testarticle", 1);
INSERT INTO article (name, category_id) values ("testarticle2", 2);
INSERT INTO article (name, category_id) values ("testarticle3", 2);

INSERT INTO article (name, category_id) values ("testarticle", 1);
INSERT INTO article (name, category_id) values ("testarticle2", 2);
INSERT INTO article (name, category_id) values ("testarticle3", 2);

INSERT INTO user (name, email, password) values ("John Smith", "john.smith@mail.com", "$2a$10$o2ItyR7XkJSQb9J5R2JVXery52e7P0EcRCU4D2q.pol77qdW/ghQ6");
INSERT INTO user (name, email, password) values ("Jane Shepard", "jane.shepard@normandy.gov", "$2a$10$o2ItyR7XkJSQb9J5R2JVXery52e7P0EcRCU4D2q.pol77qdW/ghQ6");
