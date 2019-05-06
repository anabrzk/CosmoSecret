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
-- Table structure for table `face`
--

DROP TABLE IF EXISTS `face`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `face` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `brand` varchar(45) NOT NULL,
  `price` int(11) NOT NULL,
  `consist` varchar(150) NOT NULL,
  `country` varchar(45) NOT NULL,
  `provider` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `provider_idfk_1_idx` (`provider`),
  CONSTRAINT `provider_idfk_1` FOREIGN KEY (`provider`) REFERENCES `provider` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `face`
--

LOCK TABLES `face` WRITE;
/*!40000 ALTER TABLE `face` DISABLE KEYS */;
INSERT INTO `face` VALUES (1,'Основа','GOSH',97,'AQUA/WATER/EAU, CYCLOPENTASILOXANE, GLYCERIN, C30-35 ALKYL CETEARYL DIMETHICONE COPOLYMER, MALTODEXTRIN','Дания',1),(2,'Праймер','Sleek',33,'Dimethicone Crosspolymer, Silica, Dimethicone, Cyclopentasiloxane, Isononyl Isononanoate, Isododecane, Polymethylmethacrylate','Великобритания',2),(3,'Активатор','PUPA ',110,'Без парабенов','Италия',3),(4,'Основа-пудра','PUВRA ',58,'БЕЗ СОДЕРЖАНИЯ МАСЕЛ','Италия',1),(5,'MattLight','PAESE ',155,'Комплекс витаминов А, С, Е и F','Польша',2),(6,'Корректор','Глория',31,'-','Китай',7),(7,'Румяна','Blush',130,'Высокопигментированные румяна Sleek MakeUP Blush обладают стойкой пудровой текстурой и легко растушевываются, благодаря чему невероятно просты','Великобритания',6),(8,'Палетка','Kit',57,'многофункциональная палетка кремовых корректоров','Китай',2),(9,'Хайлайтер','GLOW',40,'экстракт экзотического цветка Hoya lacunosa','Польша',3),(10,'РассыпчатаяПудра','GOSH ',250,'-','Дания',4);
/*!40000 ALTER TABLE `face` ENABLE KEYS */;
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
