-- MySQL dump 10.13  Distrib 8.0.13, for Win64 (x86_64)
--
-- Host: localhost    Database: berezykkrivitskaya
-- ------------------------------------------------------
-- Server version	8.0.13

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `lips`
--

DROP TABLE IF EXISTS `lips`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `lips` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `brand` varchar(45) NOT NULL,
  `consist` varchar(150) NOT NULL,
  `price` int(11) NOT NULL,
  `country` varchar(45) NOT NULL,
  `claps` varchar(45) NOT NULL,
  `provider` int(11) NOT NULL,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `provider_idfk_2_idx` (`provider`),
  CONSTRAINT `provider_idfk_2` FOREIGN KEY (`provider`) REFERENCES `provider` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lips`
--

LOCK TABLES `lips` WRITE;
/*!40000 ALTER TABLE `lips` DISABLE KEYS */;
INSERT INTO `lips` VALUES (1,'luxvisage','Матовая помада',10,'Беларусь','-',2,'pip-up'),(2,'Essense','Увлажняющая помада с разными вкусами',66,'Китай','-',7,'beauty'),(3,'Catrice','-',100,'Польша','-',3,'CTR'),(4,'Rimmel','Жидкие матовые помады в различных оттенках',199,'Великобритания','-',2,'Stay'),(5,'Eveline','Жидкий блеск',25,'Россия','-',5,'Evl'),(6,'MDS','Увлажняющий бальзам для губ',111,'Италия','-',3,'balm'),(7,'Maybelline','Стойкий оттеночный бальзам для губ',183,'Америка','-',5,'powderMatte'),(8,'M.A.C','создает абсолютно матовое покрытие.',300,'Америка','-',7,'mac');
/*!40000 ALTER TABLE `lips` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-05-01 17:01:08
