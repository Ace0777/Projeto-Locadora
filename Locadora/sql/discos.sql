CREATE TABLE locadora.discos
(
    id             INT auto_increment NOT NULL,
    nome           varchar(100) NOT NULL,
    valorDaLocacao DOUBLE,
    dataLancamento DATETIME,
    tipoDisco      INT,
    CONSTRAINT discos_PK PRIMARY KEY (id)
) ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_0900_ai_ci;
