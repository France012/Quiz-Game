-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: quiz_application_db
-- ------------------------------------------------------
-- Server version	5.7.38-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `argomento`
--

DROP TABLE IF EXISTS `argomento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `argomento` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `codice_id` int(11) NOT NULL,
  `materia_id` int(11) NOT NULL,
  `data` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `materia_argomento_id_idx` (`materia_id`),
  KEY `codice_argomento_id_idx` (`codice_id`),
  CONSTRAINT `codice_argomento_id` FOREIGN KEY (`codice_id`) REFERENCES `codice` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `materia_argomento_id` FOREIGN KEY (`materia_id`) REFERENCES `materia` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `argomento`
--

LOCK TABLES `argomento` WRITE;
/*!40000 ALTER TABLE `argomento` DISABLE KEYS */;
/*!40000 ALTER TABLE `argomento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ass_codice_lingua`
--

DROP TABLE IF EXISTS `ass_codice_lingua`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ass_codice_lingua` (
  `id` int(11) NOT NULL,
  `lingua_id` int(11) NOT NULL,
  `codice_id` int(11) NOT NULL,
  `testo` varchar(45) NOT NULL,
  PRIMARY KEY (`lingua_id`),
  KEY `codice_id` (`codice_id`),
  CONSTRAINT `codice_id` FOREIGN KEY (`codice_id`) REFERENCES `codice` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `lingua_id2` FOREIGN KEY (`lingua_id`) REFERENCES `lingua` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ass_codice_lingua`
--

LOCK TABLES `ass_codice_lingua` WRITE;
/*!40000 ALTER TABLE `ass_codice_lingua` DISABLE KEYS */;
/*!40000 ALTER TABLE `ass_codice_lingua` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ass_ruolo_utente`
--

DROP TABLE IF EXISTS `ass_ruolo_utente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ass_ruolo_utente` (
  `user_id` int(11) NOT NULL,
  `ruolo_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`,`ruolo_id`),
  KEY `ruolo_id` (`ruolo_id`),
  CONSTRAINT `ruolo_id` FOREIGN KEY (`ruolo_id`) REFERENCES `ruolo` (`id`),
  CONSTRAINT `user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ass_ruolo_utente`
--

LOCK TABLES `ass_ruolo_utente` WRITE;
/*!40000 ALTER TABLE `ass_ruolo_utente` DISABLE KEYS */;
/*!40000 ALTER TABLE `ass_ruolo_utente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `codice`
--

DROP TABLE IF EXISTS `codice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `codice` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `data` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `codice`
--

LOCK TABLES `codice` WRITE;
/*!40000 ALTER TABLE `codice` DISABLE KEYS */;
/*!40000 ALTER TABLE `codice` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `domanda`
--

DROP TABLE IF EXISTS `domanda`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `domanda` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `argomento_id` int(11) NOT NULL,
  `codice_id` int(11) NOT NULL,
  `data` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `label_domanda_id_idx` (`codice_id`),
  KEY `argomento_domanda_id_idx` (`argomento_id`),
  CONSTRAINT `argomento_domanda_id` FOREIGN KEY (`argomento_id`) REFERENCES `argomento` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `label_domanda_id` FOREIGN KEY (`codice_id`) REFERENCES `codice` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `domanda`
--

LOCK TABLES `domanda` WRITE;
/*!40000 ALTER TABLE `domanda` DISABLE KEYS */;
/*!40000 ALTER TABLE `domanda` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lingua`
--

DROP TABLE IF EXISTS `lingua`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lingua` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descrizione` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lingua`
--

LOCK TABLES `lingua` WRITE;
/*!40000 ALTER TABLE `lingua` DISABLE KEYS */;
/*!40000 ALTER TABLE `lingua` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `materia`
--

DROP TABLE IF EXISTS `materia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `materia` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `codice_id` int(11) NOT NULL,
  `data` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `label_materia_id_idx` (`codice_id`),
  CONSTRAINT `label_materia_id` FOREIGN KEY (`codice_id`) REFERENCES `codice` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `materia`
--

LOCK TABLES `materia` WRITE;
/*!40000 ALTER TABLE `materia` DISABLE KEYS */;
/*!40000 ALTER TABLE `materia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `risposta`
--

DROP TABLE IF EXISTS `risposta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `risposta` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `codice_id` int(11) NOT NULL,
  `domanda_id` int(11) NOT NULL,
  `is_correct` bit(1) NOT NULL,
  `data` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `label_risposta_id_idx` (`codice_id`),
  KEY `domanda_risposta_id_idx` (`domanda_id`),
  CONSTRAINT `domanda_risposta_id` FOREIGN KEY (`domanda_id`) REFERENCES `domanda` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `label_risposta_id` FOREIGN KEY (`codice_id`) REFERENCES `codice` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `risposta`
--

LOCK TABLES `risposta` WRITE;
/*!40000 ALTER TABLE `risposta` DISABLE KEYS */;
/*!40000 ALTER TABLE `risposta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ruolo`
--

DROP TABLE IF EXISTS `ruolo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ruolo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `codice_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `label_ruolo_id_idx` (`codice_id`),
  CONSTRAINT `label_ruolo_id` FOREIGN KEY (`codice_id`) REFERENCES `codice` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ruolo`
--

LOCK TABLES `ruolo` WRITE;
/*!40000 ALTER TABLE `ruolo` DISABLE KEYS */;
/*!40000 ALTER TABLE `ruolo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shedlock`
--

DROP TABLE IF EXISTS `shedlock`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shedlock` (
  `name` varchar(64) NOT NULL,
  `lock_until` timestamp(3) NULL DEFAULT NULL,
  `locked_at` timestamp(3) NULL DEFAULT NULL,
  `locked_by` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shedlock`
--

LOCK TABLES `shedlock` WRITE;
/*!40000 ALTER TABLE `shedlock` DISABLE KEYS */;
INSERT INTO `shedlock` VALUES ('UNIQUE_KEY_FOR_SHEDLOCK_SCHEDULER','2023-02-03 16:47:13.003','2023-02-03 16:47:08.005','AsusCaccale');
/*!40000 ALTER TABLE `shedlock` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `storico_risposte`
--

DROP TABLE IF EXISTS `storico_risposte`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `storico_risposte` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `risposta_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `risposta_storico_id_idx` (`risposta_id`),
  KEY `user_risposte_id_idx` (`user_id`),
  CONSTRAINT `risposta_storico_id` FOREIGN KEY (`risposta_id`) REFERENCES `risposta` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `user_risposte_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `storico_risposte`
--

LOCK TABLES `storico_risposte` WRITE;
/*!40000 ALTER TABLE `storico_risposte` DISABLE KEYS */;
/*!40000 ALTER TABLE `storico_risposte` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `cognome` varchar(45) NOT NULL,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `data` datetime NOT NULL,
  `lingua_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username_UNIQUE` (`username`),
  KEY `lingua_id_idx` (`lingua_id`),
  CONSTRAINT `lingua_user_id` FOREIGN KEY (`lingua_id`) REFERENCES `lingua` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'Francesco','Caccavale','Francix','12345','2023-01-23 00:00:00',NULL),(2,'Antonio','Boemio','boemio03','abc','2023-01-24 00:00:00',NULL),(7,'Alberto','Marino','Dark','Darkeden1','2023-01-24 15:40:02',NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-02-07 17:08:30
