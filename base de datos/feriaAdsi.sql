CREATE DATABASE  IF NOT EXISTS `feriaadsi` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `feriaadsi`;
-- MySQL dump 10.13  Distrib 5.6.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: feriaadsi
-- ------------------------------------------------------
-- Server version	5.6.20

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `jugadores`
--

DROP TABLE IF EXISTS `jugadores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `jugadores` (
  `documento` bigint(20) NOT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `apellido` varchar(45) DEFAULT NULL,
  `ficha` bigint(20) DEFAULT NULL,
  `programa` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`documento`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jugadores`
--

LOCK TABLES `jugadores` WRITE;
/*!40000 ALTER TABLE `jugadores` DISABLE KEYS */;
/*!40000 ALTER TABLE `jugadores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jugadores_has_torneos`
--

DROP TABLE IF EXISTS `jugadores_has_torneos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `jugadores_has_torneos` (
  `idjugadores_has_torneos` int(11) NOT NULL AUTO_INCREMENT,
  `jugador` bigint(20) NOT NULL,
  `torneo` int(11) NOT NULL,
  `ganadores` int(11) DEFAULT NULL,
  PRIMARY KEY (`idjugadores_has_torneos`),
  KEY `fk_jugadores_has_torneos_jugadores_idx` (`jugador`),
  KEY `fk_jugadores_has_torneos_torneo1_idx` (`torneo`),
  CONSTRAINT `fk_jugadores_has_torneos_jugadores` FOREIGN KEY (`jugador`) REFERENCES `jugadores` (`documento`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_jugadores_has_torneos_torneo1` FOREIGN KEY (`torneo`) REFERENCES `torneo` (`idtorneo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jugadores_has_torneos`
--

LOCK TABLES `jugadores_has_torneos` WRITE;
/*!40000 ALTER TABLE `jugadores_has_torneos` DISABLE KEYS */;
/*!40000 ALTER TABLE `jugadores_has_torneos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `partidos`
--

DROP TABLE IF EXISTS `partidos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `partidos` (
  `idpartidos` int(11) NOT NULL AUTO_INCREMENT,
  `jugador1` int(11) NOT NULL,
  `resultado1` int(11) DEFAULT NULL,
  `jugador2` int(11) NOT NULL,
  `resultado2` int(11) DEFAULT NULL,
  PRIMARY KEY (`idpartidos`),
  KEY `fk_partidos_jugadores_has_torneos1_idx` (`jugador1`),
  KEY `fk_partidos_jugadores_has_torneos2_idx` (`jugador2`),
  CONSTRAINT `fk_partidos_jugadores_has_torneos1` FOREIGN KEY (`jugador1`) REFERENCES `jugadores_has_torneos` (`idjugadores_has_torneos`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_partidos_jugadores_has_torneos2` FOREIGN KEY (`jugador2`) REFERENCES `jugadores_has_torneos` (`idjugadores_has_torneos`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `partidos`
--

LOCK TABLES `partidos` WRITE;
/*!40000 ALTER TABLE `partidos` DISABLE KEYS */;
/*!40000 ALTER TABLE `partidos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `torneo`
--

DROP TABLE IF EXISTS `torneo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `torneo` (
  `idtorneo` int(11) NOT NULL AUTO_INCREMENT,
  `tipo` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idtorneo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `torneo`
--

LOCK TABLES `torneo` WRITE;
/*!40000 ALTER TABLE `torneo` DISABLE KEYS */;
/*!40000 ALTER TABLE `torneo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'feriaadsi'
--

--
-- Dumping routines for database 'feriaadsi'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-08-22  8:29:46
