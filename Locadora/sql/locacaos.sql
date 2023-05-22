CREATE TABLE locadora.locacaos
(
    id            INT auto_increment NOT NULL,
    idDisco       INT      NOT NULL,
    idFuncionario INT      NOT NULL,
    idCliente     INT      NOT NULL,
    entrega       DATETIME NOT NULL,
    locacao       DATETIME NOT NULL,
    CONSTRAINT locacaos_PK PRIMARY KEY (id),
    CONSTRAINT locacaos_FK FOREIGN KEY (idCliente) REFERENCES locadora.clientes (id),
    CONSTRAINT locacaos_FK_1 FOREIGN KEY (idDisco) REFERENCES locadora.discos (id),
    CONSTRAINT locacaos_FK_2 FOREIGN KEY (idFuncionario) REFERENCES locadora.funcionarios (id)
) ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_0900_ai_ci;
