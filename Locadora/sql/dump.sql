-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: locadora
-- ------------------------------------------------------
-- Server version	8.0.33

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `clientes`
--
CREATE DATABASE IF NOT EXISTS locadora;

USE locadora;

DROP TABLE IF EXISTS `clientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `clientes` (
  `id` int NOT NULL AUTO_INCREMENT,
  `documento` varchar(100) NOT NULL,
  `telefone` varchar(100) NOT NULL,
  `idLocadora` int NOT NULL,
  `nome` varchar(100) NOT NULL,
  `login` varchar(100) NOT NULL,
  `senha` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `clientes_FK` (`idLocadora`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clientes`
--

LOCK TABLES `clientes` WRITE;
/*!40000 ALTER TABLE `clientes` DISABLE KEYS */;
INSERT INTO `clientes` VALUES (17,'3213','23123',1,'luis','teste1','123'),(18,'21321','3213',1,'daves','teste2','123');
/*!40000 ALTER TABLE `clientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `discos`
--

DROP TABLE IF EXISTS `discos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `discos` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  `valorDaLocacao` double DEFAULT NULL,
  `dataLancamento` datetime DEFAULT NULL,
  `tipoDisco` enum('filme','musica','jogo') NOT NULL,
  `alugado` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `discos`
--

LOCK TABLES `discos` WRITE;
/*!40000 ALTER TABLE `discos` DISABLE KEYS */;
INSERT INTO `discos` VALUES (35,'disco1',136.29000000000002,'2023-06-30 00:00:00','filme',17),(36,'disco2',123232.43,'2023-06-30 00:00:00','filme',18);
/*!40000 ALTER TABLE `discos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `funcionarios`
--

DROP TABLE IF EXISTS `funcionarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `funcionarios` (
  `id` int NOT NULL AUTO_INCREMENT,
  `entrada` datetime NOT NULL,
  `saida` datetime NOT NULL,
  `salario` double NOT NULL,
  `idLocadora` int NOT NULL,
  `nome` varchar(100) NOT NULL,
  `login` varchar(100) NOT NULL,
  `senha` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `funcionarios_FK` (`idLocadora`),
  CONSTRAINT `funcionarios_FK` FOREIGN KEY (`idLocadora`) REFERENCES `locadoras` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `funcionarios`
--

LOCK TABLES `funcionarios` WRITE;
/*!40000 ALTER TABLE `funcionarios` DISABLE KEYS */;
INSERT INTO `funcionarios` VALUES (1,'2023-06-26 08:13:51','2023-06-26 08:13:51',200,1,'iago','teste','123'),(28,'2023-06-30 06:59:29','2023-06-30 06:59:29',2500,1,'teste2','adsad','asdsad'),(31,'2023-06-29 04:12:14','2023-06-29 04:12:14',2500,1,'mudando','asdsad','asdsad'),(34,'2023-06-30 11:37:29','2023-06-30 11:37:29',2500,1,'cleiton_franguinho123','frango123','123'),(36,'2023-06-30 06:59:40','2023-06-30 06:59:40',2500,1,'321321','123213','123213');
/*!40000 ALTER TABLE `funcionarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `locacaos`
--

DROP TABLE IF EXISTS `locacaos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `locacaos` (
  `id` int NOT NULL AUTO_INCREMENT,
  `idDisco` int NOT NULL,
  `idFuncionario` int NOT NULL,
  `idCliente` int NOT NULL,
  `entrega` datetime NOT NULL,
  `saida` datetime NOT NULL,
  `idLocadora` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `locacaos_FK` (`idCliente`),
  KEY `locacaos_FK_1` (`idDisco`),
  KEY `locacaos_FK_2` (`idFuncionario`),
  KEY `locacaos_FK_3` (`idLocadora`),
  CONSTRAINT `locacaos_FK` FOREIGN KEY (`idCliente`) REFERENCES `clientes` (`id`),
  CONSTRAINT `locacaos_FK_1` FOREIGN KEY (`idDisco`) REFERENCES `discos` (`id`),
  CONSTRAINT `locacaos_FK_2` FOREIGN KEY (`idFuncionario`) REFERENCES `funcionarios` (`id`),
  CONSTRAINT `locacaos_FK_3` FOREIGN KEY (`idLocadora`) REFERENCES `locadoras` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `locacaos`
--

LOCK TABLES `locacaos` WRITE;
/*!40000 ALTER TABLE `locacaos` DISABLE KEYS */;
/*!40000 ALTER TABLE `locacaos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `locadoras`
--

DROP TABLE IF EXISTS `locadoras`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `locadoras` (
  `id` int NOT NULL AUTO_INCREMENT,
  `endereco` varchar(100) NOT NULL,
  `nome` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `locadoras`
--

INSERT INTO `locadoras` VALUES (1,'rua paula lima','Daves');
UNLOCK TABLES;

INSERT INTO locadora.clientes
(documento, telefone, idLocadora, nome, login, senha)
VALUES('020.232.80.9', '32988002696', 1, 'Daves ', 'daves', '123');


INSERT INTO locadora.funcionarios
(entrada, saida, salario, idLocadora, nome, login, senha)
VALUES('2023-06-27 20:17:58', '2023-06-27 20:18:02', 1200.0, 1, 'Luis', 'luis', '123');

--
-- Dumping routines for database 'locadora'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-06-30 21:44:27
