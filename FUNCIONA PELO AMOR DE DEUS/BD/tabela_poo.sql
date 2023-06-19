create database sneaker_store;
use sneaker_store;

CREATE TABLE usuario (
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  nome VARCHAR(45) NOT NULL,
  idade INT NOT NULL,
  funcao VARCHAR(45) NULL,
  senha VARCHAR(45) NOT NULL);
  
  CREATE TABLE sneaker (
  id_sneaker INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  nome_sneaker VARCHAR(45) NOT NULL,
  descricao VARCHAR(90) NOT NULL,
  preco DOUBLE NULL,
  criador VARCHAR(45) NOT NULL);
  

SELECT * FROM usuario;
SELECT * FROM sneaker;
drop table usuario;