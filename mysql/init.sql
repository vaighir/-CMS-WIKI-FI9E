DROP DATABASE IF EXISTS test_db;

CREATE DATABASE test_db;
use test_db;

CREATE TABLE user (
    id INT AUTO_INCREMENT,
    name VARCHAR(255),
    email VARCHAR(255),
    password VARCHAR(255),
    PRIMARY KEY (id)
);

INSERT INTO user (name, email, password) values ("John Smith", "john.smith@mail.com", "passwtr");
INSERT INTO user (name, email, password) values ("Jane Shepard", "jane.shepard@normandy.gov", "pwt");
