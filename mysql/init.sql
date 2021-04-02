DROP DATABASE IF EXISTS test_db;

CREATE DATABASE test_db;
use test_db;

CREATE TABLE real_message (
    id INT AUTO_INCREMENT,
    message LONGTEXT,
    author VARCHAR(255),
    server VARCHAR(255),
    channel VARCHAR(255),
    PRIMARY KEY (id)
);

CREATE TABLE dictionary (
    id INT AUTO_INCREMENT,
    author VARCHAR(255),
    dictionary JSON,
    PRIMARY KEY (id)
);

INSERT INTO real_message (author, message, channel, server) values ("bassaf", "asfsadf", "awrge", "rwgfv");
INSERT INTO real_message (author, message, channel, server) values ("user2", "hello", "say-hi", "darknet");
