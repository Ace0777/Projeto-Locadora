-- locadora.discos definition

CREATE TABLE `discos` (
                          `id` int NOT NULL AUTO_INCREMENT,
                          `nome` varchar(100) NOT NULL,
                          `valorDaLocacao` double DEFAULT NULL,
                          `dataLancamento` datetime DEFAULT NULL,
                          `tipoDisco` int DEFAULT NULL,
                          PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;