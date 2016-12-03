-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: lms
-- ------------------------------------------------------
-- Server version	5.7.16-log

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
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `account` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `password` varchar(30) NOT NULL,
  `status` tinyint(4) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `student_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `link_account_to_student_idx` (`student_id`),
  KEY `link_account_to_user_idx` (`user_id`),
  CONSTRAINT `link_account_to_student` FOREIGN KEY (`student_id`) REFERENCES `student` (`student_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `link_account_to_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES (9,'huynh','huynh@mail','huynh',0,1,1),(10,'huynh','huynh@mail','huynh',0,1,NULL),(11,'huynh1999','huynh1@mail.com','huynh1',0,5,NULL),(12,'huynh1999','huynh1@mail.com','huynh1',0,6,NULL),(13,'huynh1999','huynh1@mail.com','huynh1',0,7,NULL),(14,'huynh1999','huynh1@mail.com','huynh1',0,8,NULL),(15,'huynhhhh','huynhhhh','1234564',0,NULL,1),(16,'huynh13995','huynh13995','huynhhh',0,NULL,1),(17,'huynh19999','huynh19999','huynh1',0,NULL,1),(18,'huynhhhhh','huynhhhhh','12345678',0,NULL,2),(19,'huynh123456','huynh123456','1111111',0,NULL,3),(20,'nguyenthuchuynh','huynh1995@gmail.com','12345678',0,9,NULL),(22,'test','abc@mail.com','abcdef',0,9,NULL),(23,'test','abc@mail.com','abcdef',0,9,NULL),(24,'hhhhhhhhhhhhhhhhh','h@m.c','huynh1',0,12,NULL);
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `book`
--

DROP TABLE IF EXISTS `book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `book` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `authors` varchar(100) DEFAULT NULL,
  `title` varchar(45) DEFAULT NULL,
  `publisher` varchar(45) DEFAULT NULL,
  `isbn` varchar(45) DEFAULT NULL,
  `cate_id` int(11) DEFAULT NULL,
  `book_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `link_book_to_category_idx` (`cate_id`),
  CONSTRAINT `link_book_to_category` FOREIGN KEY (`cate_id`) REFERENCES `category` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book`
--

LOCK TABLES `book` WRITE;
/*!40000 ALTER TABLE `book` DISABLE KEYS */;
/*!40000 ALTER TABLE `book` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `book_copy`
--

DROP TABLE IF EXISTS `book_copy`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `book_copy` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `book_id` int(11) NOT NULL,
  `seq` int(11) NOT NULL,
  `type` tinyint(4) NOT NULL,
  `price` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `link_book_copy_to_book_idx` (`book_id`),
  CONSTRAINT `link_book_copy_to_book` FOREIGN KEY (`book_id`) REFERENCES `book` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book_copy`
--

LOCK TABLES `book_copy` WRITE;
/*!40000 ALTER TABLE `book_copy` DISABLE KEYS */;
/*!40000 ALTER TABLE `book_copy` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `borrow`
--

DROP TABLE IF EXISTS `borrow`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `borrow` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `card_id` int(11) DEFAULT NULL,
  `lent_date` datetime DEFAULT NULL,
  `expired_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `link_borrow_to_borrow_card_idx` (`card_id`),
  CONSTRAINT `link_borrow_to_borrow_card` FOREIGN KEY (`card_id`) REFERENCES `borrower_card` (`card_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `borrow`
--

LOCK TABLES `borrow` WRITE;
/*!40000 ALTER TABLE `borrow` DISABLE KEYS */;
/*!40000 ALTER TABLE `borrow` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `borrow_book_copy`
--

DROP TABLE IF EXISTS `borrow_book_copy`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `borrow_book_copy` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `borrow_id` int(11) NOT NULL,
  `copy_id` int(11) NOT NULL,
  `status` tinyint(4) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `link1_borrow_book_copy_idx` (`copy_id`),
  KEY `link2_borrow_book_copy_idx` (`borrow_id`),
  CONSTRAINT `link1_borrow_book_copy` FOREIGN KEY (`copy_id`) REFERENCES `book_copy` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `link2_borrow_book_copy` FOREIGN KEY (`borrow_id`) REFERENCES `borrow` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `borrow_book_copy`
--

LOCK TABLES `borrow_book_copy` WRITE;
/*!40000 ALTER TABLE `borrow_book_copy` DISABLE KEYS */;
/*!40000 ALTER TABLE `borrow_book_copy` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `borrower_card`
--

DROP TABLE IF EXISTS `borrower_card`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `borrower_card` (
  `card_id` int(11) NOT NULL,
  `account_id` int(11) NOT NULL,
  `activate_code` varchar(20) NOT NULL,
  `release_date` date NOT NULL,
  `expired_date` date NOT NULL,
  PRIMARY KEY (`card_id`),
  KEY `link_borrower_card_to_account_idx` (`account_id`),
  CONSTRAINT `link_borrower_card_to_account` FOREIGN KEY (`account_id`) REFERENCES `account` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `borrower_card`
--

LOCK TABLES `borrower_card` WRITE;
/*!40000 ALTER TABLE `borrower_card` DISABLE KEYS */;
/*!40000 ALTER TABLE `borrower_card` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cate_code` varchar(10) NOT NULL,
  `cate_name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `manager_account`
--

DROP TABLE IF EXISTS `manager_account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `manager_account` (
  `account_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `username` varchar(45) NOT NULL,
  `password` varchar(30) NOT NULL,
  `email` varchar(45) NOT NULL,
  `address` varchar(60) DEFAULT NULL,
  `gender` tinyint(4) DEFAULT NULL,
  `phone` varchar(15) DEFAULT NULL,
  `role` tinyint(4) NOT NULL,
  `identification` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`account_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `manager_account`
--

LOCK TABLES `manager_account` WRITE;
/*!40000 ALTER TABLE `manager_account` DISABLE KEYS */;
/*!40000 ALTER TABLE `manager_account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `register_borrow`
--

DROP TABLE IF EXISTS `register_borrow`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `register_borrow` (
  `register_id` int(11) NOT NULL AUTO_INCREMENT,
  `card_id` int(11) DEFAULT NULL,
  `register_date` datetime DEFAULT NULL,
  PRIMARY KEY (`register_id`),
  KEY `link_register_borrow_to_borrower_card_idx` (`card_id`),
  CONSTRAINT `link_register_borrow_to_borrower_card` FOREIGN KEY (`card_id`) REFERENCES `borrower_card` (`card_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `register_borrow`
--

LOCK TABLES `register_borrow` WRITE;
/*!40000 ALTER TABLE `register_borrow` DISABLE KEYS */;
/*!40000 ALTER TABLE `register_borrow` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `register_borrow_book_copy`
--

DROP TABLE IF EXISTS `register_borrow_book_copy`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `register_borrow_book_copy` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `register_id` int(11) NOT NULL,
  `copy_id` int(11) NOT NULL,
  `status` tinyint(4) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `link1_register_borrow_book_copy_idx` (`register_id`),
  KEY `link2_register_borrow_book_copy_idx` (`copy_id`),
  CONSTRAINT `link1_register_borrow_book_copy` FOREIGN KEY (`register_id`) REFERENCES `register_borrow` (`register_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `link2_register_borrow_book_copy` FOREIGN KEY (`copy_id`) REFERENCES `book_copy` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `register_borrow_book_copy`
--

LOCK TABLES `register_borrow_book_copy` WRITE;
/*!40000 ALTER TABLE `register_borrow_book_copy` DISABLE KEYS */;
/*!40000 ALTER TABLE `register_borrow_book_copy` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `return`
--

DROP TABLE IF EXISTS `return`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `return` (
  `return_id` int(11) NOT NULL AUTO_INCREMENT,
  `borrow_id` int(11) NOT NULL,
  `return_date` datetime NOT NULL,
  PRIMARY KEY (`return_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `return`
--

LOCK TABLES `return` WRITE;
/*!40000 ALTER TABLE `return` DISABLE KEYS */;
/*!40000 ALTER TABLE `return` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `return_book_copy`
--

DROP TABLE IF EXISTS `return_book_copy`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `return_book_copy` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `return_id` int(11) NOT NULL,
  `copy_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `link1_return_book_book_copy_idx` (`return_id`),
  KEY `link2_return_book_book_copy_idx` (`copy_id`),
  CONSTRAINT `link1_return_book_book_copy` FOREIGN KEY (`return_id`) REFERENCES `return` (`return_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `link2_return_book_book_copy` FOREIGN KEY (`copy_id`) REFERENCES `book_copy` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `return_book_copy`
--

LOCK TABLES `return_book_copy` WRITE;
/*!40000 ALTER TABLE `return_book_copy` DISABLE KEYS */;
/*!40000 ALTER TABLE `return_book_copy` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student` (
  `student_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `begin_date` date NOT NULL,
  `end_date` date NOT NULL,
  `address` varchar(45) NOT NULL,
  `gender` tinyint(4) NOT NULL,
  `birthday` date NOT NULL,
  `order` int(11) NOT NULL,
  PRIMARY KEY (`student_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES (1,'Nguyễn Thúc Huynh','2013-09-01','2013-05-18','Hiệp Hòa- Kinh Môn- Hải Dương',1,'1995-09-06',1),(2,'HUYNH','2013-09-01','2018-05-18','HH- KM- HD',1,'1995-09-06',2),(3,'HUYNH','2013-09-01','2018-05-18','HH- KM- HD',1,'1995-09-06',3),(4,'HUYNH','2013-09-01','2018-05-18','HH- KM- HD',1,'1995-09-06',4),(5,'HUYNH','2013-09-01','2018-05-18','HH- KM- HD',1,'1995-09-06',5),(6,'HUYNH','2013-09-01','2018-05-18','HH- KM- HD',1,'1995-09-06',6),(7,'HUYNH','2013-09-01','2018-05-18','HH- KM- HD',1,'1995-09-06',7),(8,'HUYNH','2013-09-01','2018-05-18','HH- KM- HD',1,'1995-09-06',8),(9,'HUYNH','2013-09-01','2018-05-18','HH- KM- HD',1,'1995-09-06',9);
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `address` varchar(45) DEFAULT NULL,
  `gender` tinyint(4) NOT NULL,
  `phone_number` varchar(15) DEFAULT NULL,
  `birthday` date NOT NULL,
  `identification` varchar(45) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'huynh','hhkmhd',1,'1234567890','1995-03-10','123456789'),(2,'huynh','hhkmhd',1,'123213','1995-09-06','12345656'),(3,'huynh','hhkmhd',1,'123213','1995-09-06','12345656'),(4,'huynh','hhkmhd',1,'123213','1995-09-06','12345656'),(5,'huynh','hhkmhd',1,'123213','1995-09-06','12345656'),(6,'huynh','hhkmhd',1,'123213','1995-09-06','12345656'),(7,'huynh','hhkmhd',1,'123213','1995-09-06','12345656'),(8,'huynh','hhkmhd',1,'123213','1995-09-06','12345656'),(9,'nguyen thuc huynh','hh km hd',1,'1234567890','2016-12-03','1234567890'),(10,'hhhhhhhhhhhhh','hhhhhhhhhhhhhhhh',1,'1234567890','2016-12-03','1234567890'),(11,'huynhhhhhhhhh','hhhhhhhhhhhhhhhh',1,'1234567890','2016-12-03','1234567890'),(12,'hhhhhhhhhhhhhhhhh','hhhhhhhhhhhhh',1,'1234567890','2016-12-03','12345677890');
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

-- Dump completed on 2016-12-03 10:42:01
