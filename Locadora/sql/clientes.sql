CREATE TABLE locadora.clientes
(
    id        INT auto_increment NOT NULL,
    idUsuario INT          NOT NULL,
    documento varchar(100) NOT NULL,
    telefone  varchar(100) NOT NULL,
    CONSTRAINT clientes_PK PRIMARY KEY (id),
    CONSTRAINT clientes_FK FOREIGN KEY (idUsuario) REFERENCES locadora.usuarios (id)
) ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_0900_ai_ci;
