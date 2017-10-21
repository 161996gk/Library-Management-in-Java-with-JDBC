-- MySQL dump 10.13  Distrib 5.7.12, for Win32 (AMD64)
--
-- Host: localhost    Database: library
-- ------------------------------------------------------
-- Server version	5.6.17

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
-- Table structure for table `bca`
--

DROP TABLE IF EXISTS `bca`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bca` (
  `BookName` varchar(30) DEFAULT NULL,
  `BookAuthorName` varchar(30) DEFAULT NULL,
  `Subject` varchar(30) DEFAULT NULL,
  `Semester` int(2) DEFAULT NULL,
  `Year` int(2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bca`
--

LOCK TABLES `bca` WRITE;
/*!40000 ALTER TABLE `bca` DISABLE KEYS */;
/*!40000 ALTER TABLE `bca` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `btech`
--

DROP TABLE IF EXISTS `btech`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `btech` (
  `BookName` varchar(30) DEFAULT NULL,
  `BookAuthorName` varchar(30) DEFAULT NULL,
  `Subject` varchar(30) DEFAULT NULL,
  `Stream` varchar(5) DEFAULT NULL,
  `Semester` int(2) DEFAULT NULL,
  `Year` int(2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `btech`
--

LOCK TABLES `btech` WRITE;
/*!40000 ALTER TABLE `btech` DISABLE KEYS */;
INSERT INTO `btech` VALUES ('Let Us C','Yashwant K','C','CSE',2,1),('Operating System','Galvin','OS','CSE',3,2);
/*!40000 ALTER TABLE `btech` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `issuedbca`
--

DROP TABLE IF EXISTS `issuedbca`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `issuedbca` (
  `RollNo` int(10) DEFAULT NULL,
  `BookName` varchar(30) DEFAULT NULL,
  `DateOfIssue` date DEFAULT NULL,
  `Fine` int(5) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `issuedbca`
--

LOCK TABLES `issuedbca` WRITE;
/*!40000 ALTER TABLE `issuedbca` DISABLE KEYS */;
/*!40000 ALTER TABLE `issuedbca` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `issuedbtech`
--

DROP TABLE IF EXISTS `issuedbtech`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `issuedbtech` (
  `RollNo` int(10) DEFAULT NULL,
  `BookName` varchar(30) DEFAULT NULL,
  `DateOfIssue` date DEFAULT NULL,
  `Fine` int(5) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `issuedbtech`
--

LOCK TABLES `issuedbtech` WRITE;
/*!40000 ALTER TABLE `issuedbtech` DISABLE KEYS */;
INSERT INTO `issuedbtech` VALUES (11142548,'Let Us C','2016-07-02',0),(11142529,'Let Us C','2016-06-12',21);
/*!40000 ALTER TABLE `issuedbtech` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `issuedmca`
--

DROP TABLE IF EXISTS `issuedmca`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `issuedmca` (
  `RollNo` int(10) DEFAULT NULL,
  `BookName` varchar(30) DEFAULT NULL,
  `DateOfIssue` date DEFAULT NULL,
  `Fine` int(5) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `issuedmca`
--

LOCK TABLES `issuedmca` WRITE;
/*!40000 ALTER TABLE `issuedmca` DISABLE KEYS */;
/*!40000 ALTER TABLE `issuedmca` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mca`
--

DROP TABLE IF EXISTS `mca`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mca` (
  `BookName` varchar(30) DEFAULT NULL,
  `BookAuthorName` varchar(30) DEFAULT NULL,
  `Subject` varchar(30) DEFAULT NULL,
  `Semester` int(2) DEFAULT NULL,
  `Year` int(2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mca`
--

LOCK TABLES `mca` WRITE;
/*!40000 ALTER TABLE `mca` DISABLE KEYS */;
/*!40000 ALTER TABLE `mca` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-07-07  0:45:05
