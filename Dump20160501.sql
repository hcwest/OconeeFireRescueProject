-- MySQL dump 10.13  Distrib 5.6.24, for Win32 (x86)
--
-- Host: 127.0.0.1    Database: ocfr
-- ------------------------------------------------------
-- Server version	5.6.25-log

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
-- Table structure for table `certifications`
--

DROP TABLE IF EXISTS `certifications`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `certifications` (
  `certificationName` varchar(40) NOT NULL,
  `expirationPeriod` int(11) DEFAULT NULL,
  `certifyingAgency` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`certificationName`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `certifications`
--

LOCK TABLES `certifications` WRITE;
/*!40000 ALTER TABLE `certifications` DISABLE KEYS */;
INSERT INTO `certifications` VALUES ('0',0,'0'),('CPR',5,'Red Cross'),('EMT-Adv',2,'Emergency Cert Corp'),('EMT-Beg',2,'Emergency Cert Corp'),('EMT-Int',2,'Emergency Cert Corp'),('Firefighter I',3,'Firefighter School'),('Firefighter II',3,'Firefighter School'),('Firefighter III',3,'Firefighter School');
/*!40000 ALTER TABLE `certifications` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `person`
--

DROP TABLE IF EXISTS `person`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `person` (
  `radioNumber` int(11) NOT NULL,
  `firstName` varchar(25) DEFAULT NULL,
  `lastName` varchar(45) DEFAULT NULL,
  `position` varchar(45) DEFAULT NULL,
  `gender` varchar(7) DEFAULT NULL,
  `dateOfBirth` varchar(10) DEFAULT NULL,
  `address` varchar(60) DEFAULT NULL,
  `workPhone` varchar(15) DEFAULT NULL,
  `mobilePhone` varchar(15) DEFAULT NULL,
  `stationNumber` int(11) DEFAULT NULL,
  `isActive` varchar(25) DEFAULT NULL,
  `email` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`radioNumber`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `person`
--

LOCK TABLES `person` WRITE;
/*!40000 ALTER TABLE `person` DISABLE KEYS */;
INSERT INTO `person` VALUES (222,'Reid','Goodfellow','FF','Male','02/21/1991','3940 Eagle Landing','390-023-0202','929-903-9920',6,'true','rgoodfellow@oconeeff.org'),(300,'Jack','Finley','FF','Male','10/05/1988','292 Winter Street','202-985-5670','463-574-9832',6,'true','jfinely@oconeeff.org'),(322,'Abby','Jones','FF','55555','12/22/1987','2008 Springdale Street','203-293-9933','293-894-2933',6,'true','ajones@oconeeff.org'),(422,'Adam','Salway','FF','Male','02/03/1989','293 Pineview Drive','798-911-9123','294-859-9990',5,'true','asalway@oconeeff.org'),(522,'John','Williams','FF','Male','03/19/1990','5890 Red Fern Court','299-484-9299','288-883-1120',5,'true','jwilliams@oconeeff.org'),(622,'Rachel','Matthews','FF','Female','11/22/1985','2922 Longwood Drive','339-282-3933','393-828-4921',5,'true','rmatthews@oconeeff.org'),(722,'Carlos','Martinez','FF','Male','02/29/1988','829 Spinger Street','982-239-3920','289-839-2674',3,'true','cmartinez@oconeeff.org'),(822,'Martin','Smith','FF','Male','08/24/1980','2380 Whopper Drive','678-398-9483','789-523-8382',3,'true','msmith@oconeeff.org');
/*!40000 ALTER TABLE `person` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `person_has_certifications`
--

DROP TABLE IF EXISTS `person_has_certifications`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `person_has_certifications` (
  `id` int(4) NOT NULL,
  `radioNumber` int(11) NOT NULL,
  `certificationName` varchar(40) NOT NULL,
  `isExpired` varchar(10) DEFAULT NULL,
  `earnedDate` varchar(10) DEFAULT NULL,
  `renewalDate` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`,`radioNumber`,`certificationName`),
  KEY `fk_Person_has_Certifications_Certifications1_idx` (`certificationName`),
  KEY `fk_Person_has_Certifications_Person1_idx` (`radioNumber`),
  CONSTRAINT `fk_Person_has_Certifications_Certifications1` FOREIGN KEY (`certificationName`) REFERENCES `certifications` (`certificationName`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Person_has_Certifications_Person1` FOREIGN KEY (`radioNumber`) REFERENCES `person` (`radioNumber`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `person_has_certifications`
--

LOCK TABLES `person_has_certifications` WRITE;
/*!40000 ALTER TABLE `person_has_certifications` DISABLE KEYS */;
INSERT INTO `person_has_certifications` VALUES (1234,622,'CPR','true','09/20/1990','10/11/2010'),(3141,822,'CPR','false','04/29/1988','03/23/2016'),(5161,822,'EMT-Beg','true','01/30/1990','n/a'),(5678,622,'EMT-Int','true','01/22/1989','n/a'),(9101,722,'EMT-Adv','false','07/30/1990','11/13/2015');
/*!40000 ALTER TABLE `person_has_certifications` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `email` varchar(25) NOT NULL,
  `password` varchar(100) NOT NULL,
  PRIMARY KEY (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('blah','i33xQ9kccW7PpfwXMAIva0IbBc7e6P1SsfxlqWAwrVI='),('craig.piercy@gmail.com','XohImNooBHFR0OVvjcYpJ3NgPQ1qq73WKhHvch0VQtg='),('dusty@gmail.com','wfMw0K/zHByHQD8eQ0e8whr/fBeZCHI1NfKzFyNwJSU='),('email@email.com','XohImNooBHFR0OVvjcYpJ3NgPQ1qq73WKhHvch0VQtg=');
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

-- Dump completed on 2016-05-01 21:12:37
