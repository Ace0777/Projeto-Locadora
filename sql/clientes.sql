-- locadora.Clientes definition

CREATE TABLE `Clientes`
(
    `idCLiente` int          NOT NULL AUTO_INCREMENT,
    `nome`      varchar(100) NOT NULL,
    `login`     varchar(100) NOT NULL,
    `senha`     varchar(100) NOT NULL,
    `email`     varchar(100) NOT NULL,
    PRIMARY KEY (`idCLiente`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;