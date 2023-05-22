CREATE TABLE locadora.usuarios
(
    nome  varchar(100) NOT NULL,
    login varchar(100) NOT NULL,
    senha varchar(100) NOT NULL,
    email varchar(100) NOT NULL,
    id    INT auto_increment NOT NULL,
    CONSTRAINT usuarios_PK PRIMARY KEY (id)
) ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_0900_ai_ci;
