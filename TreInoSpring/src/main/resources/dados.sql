CREATE TABLE LOGIN (
    ID NUMBER PRIMARY KEY,
    LOGIN VARCHAR(30) NOT NULL,
    SENHA VARCHAR(15) NOT NULL,
    PESO NUMBER(10,2) NOT NULL,
    ALTURA NUMBER(10,2) NOT NULL,
    IMC NUMBER (10,2) NOT NULL
);

INSERT INTO LOGIN (ID, LOGIN, SENHA, PESO, ALTURA, IMC)
VALUES (1, 'joao', 'teste1234', 70.5, 1.75, 23.05);

SELECT  * FROM LOGIN;

SELECT ID, LOGIN, SENHA, PESO, ALTURA FROM LOGIN;

SELECT * FROM LOGIN WHERE ID = 1;

UPDATE LOGIN SET LOGIN = 'Joao Victor', SENHA = '212345', PESO = 86, ALTURA = 1.76
WHERE ID = 1;

DELETE FROM  LOGIN WHERE ID = 1;