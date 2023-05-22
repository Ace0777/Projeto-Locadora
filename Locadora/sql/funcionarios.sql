CREATE TABLE locadora.funcionarios
(
    id         INT auto_increment NOT NULL,
    idUsuario  INT      NOT NULL,
    entrada    DATETIME NOT NULL,
    saida      DATETIME NOT NULL,
    salario    DOUBLE   NOT NULL,
    idLocadora INT      NOT NULL,
    CONSTRAINT funcionarios_PK PRIMARY KEY (id),
    CONSTRAINT funcionarios_FK FOREIGN KEY (idLocadora) REFERENCES locadora.locadoras (id),
    CONSTRAINT funcionarios_FK_1 FOREIGN KEY (idUsuario) REFERENCES locadora.usuarios (id)
) ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_0900_ai_ci;
