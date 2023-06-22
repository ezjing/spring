-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: testdb
-- ------------------------------------------------------
-- Server version	8.0.33

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
-- Table structure for table `spring_board_ljw`
--

DROP TABLE IF EXISTS `spring_board_ljw`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `spring_board_ljw` (
  `idx` int NOT NULL AUTO_INCREMENT,
  `title` varchar(45) NOT NULL,
  `contents` varchar(500) NOT NULL,
  `create_id` varchar(45) NOT NULL,
  `create_dt` date NOT NULL,
  `update_id` varchar(45) DEFAULT NULL,
  `update_dt` date DEFAULT NULL,
  `visit_count` int NOT NULL DEFAULT '0',
  `deleted_yn` varchar(45) NOT NULL DEFAULT 'N',
  PRIMARY KEY (`idx`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='게시판 리스트';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `spring_board_ljw`
--

LOCK TABLES `spring_board_ljw` WRITE;
/*!40000 ALTER TABLE `spring_board_ljw` DISABLE KEYS */;
INSERT INTO `spring_board_ljw` VALUES (1,'editTitle','editContents','testUser1','2023-06-21','updateUser','2023-06-21',1,'N'),(2,'testTitle2','testContents2','testUser2','2023-06-21',NULL,NULL,0,'N'),(3,'testTitle3','testContents3','testUser3','2023-06-21',NULL,NULL,0,'N'),(4,'testTitle4','testContents4','testUser4','2023-06-21',NULL,NULL,0,'N'),(5,'testTitle5','testContents5','testUser5','2023-06-21',NULL,NULL,0,'N'),(6,'testTitle6','testContents6','testUser6','2023-06-21',NULL,NULL,0,'N'),(7,'testTitle7','testContents7','testUser7','2023-06-21',NULL,NULL,0,'N'),(8,'testTitle8','testContents8','testUser8','2023-06-21',NULL,NULL,1,'N'),(9,'testTitle9','testContents9','testUser9','2023-06-21',NULL,NULL,0,'N'),(10,'testTitle10','testContents10','testUser10','2023-06-21',NULL,NULL,0,'N'),(11,'testTitle11','testContents11','testUser11','2023-06-21',NULL,NULL,0,'N'),(12,'testTitle12','testContents12','testUser12','2023-06-21',NULL,NULL,0,'N'),(13,'testTitle13','testContents13','testUser13','2023-06-21',NULL,NULL,0,'N'),(14,'testTitle14','testContents14','testUser14','2023-06-21',NULL,NULL,0,'N'),(15,'testTitle15','testContents15','testUser15','2023-06-21',NULL,NULL,1,'N'),(16,'testTitle16','testContents16','testUser16','2023-06-21',NULL,NULL,0,'N'),(17,'바로 상세페이지도 될까','되나된다!!!','testUser17','2023-06-21','흠','2023-06-21',4,'N'),(18,'testTitle18','testContents18','testUser18','2023-06-21',NULL,NULL,1,'Y'),(19,'testTitle19','testContents19','testUser19','2023-06-21',NULL,NULL,14,'Y'),(20,'testTitle20','testContents20','testUser20','2023-06-21',NULL,NULL,6,'Y'),(21,'수정해보아요','이이잉Contents21','testUser21','2023-06-21','수정아~~!','2023-06-21',60,'N'),(22,'editTitle22','editContents22','testUser22','2023-06-21','editUser22','2023-06-21',14,'N'),(23,'경아에게','안녕 바보야','이지징','2023-06-21',NULL,NULL,0,'N'),(24,'경아에게2','사실은 바보 아니다','이지징','2023-06-21',NULL,NULL,1,'N');
/*!40000 ALTER TABLE `spring_board_ljw` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-06-21 19:38:07
