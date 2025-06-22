CREATE DATABASE  IF NOT EXISTS `cardealership` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `cardealership`;
-- MySQL dump 10.13  Distrib 8.0.41, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: cardealership
-- ------------------------------------------------------
-- Server version	9.2.0

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
-- Table structure for table `dealerships`
--

DROP TABLE IF EXISTS `dealerships`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dealerships` (
  `dealership_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `phone` varchar(12) DEFAULT NULL,
  PRIMARY KEY (`dealership_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dealerships`
--

LOCK TABLES `dealerships` WRITE;
/*!40000 ALTER TABLE `dealerships` DISABLE KEYS */;
INSERT INTO `dealerships` VALUES (1,'Luxury Autos NYC','123 Main St, New York, NY 10001','212-555-1234'),(2,'West Coast Motors','456 Ocean Ave, Los Angeles, CA 90210','310-555-5678'),(3,'Midwest Cars & Trucks','789 Prairie Ln, Chicago, IL 60601','312-555-9012'),(4,'Southern Star Auto Group','101 Dixie Hwy, Miami, FL 33101','305-555-3456'),(5,'Pacific Northwest Autos','222 Forest Rd, Seattle, WA 98101','206-555-7890'),(6,'Mountain View Motors','333 Peak Dr, Denver, CO 80201','303-555-2109'),(7,'Southwest Desert Dealership','444 Cactus Ct, Phoenix, AZ 85001','602-555-8765'),(8,'Great Lakes Automotive','555 Lake Shore Dr, Cleveland, OH 44101','216-555-4321'),(9,'Northeast Car Emporium','666 Elm St, Boston, MA 02101','617-555-9876'),(10,'Sunshine Auto Center','777 Ocean Blvd, Orlando, FL 32801','407-555-1212'),(11,'Texas Auto Giants','888 Lone Star Rd, Houston, TX 77001','713-555-3434'),(12,'Golden State Dealerships','999 Golden Gate Ave, San Francisco, CA 94101','415-555-5656'),(13,'Atlantic Coast Cars','111 Boardwalk, Atlantic City, NJ 08401','609-555-7878'),(14,'Great Plains Autos','222 Wheatfield Way, Omaha, NE 68101','402-555-9090');
/*!40000 ALTER TABLE `dealerships` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `inventory`
--

DROP TABLE IF EXISTS `inventory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `inventory` (
  `inventory_id` int NOT NULL AUTO_INCREMENT,
  `dealership_id` int DEFAULT NULL,
  `vehicle_id` int DEFAULT NULL,
  PRIMARY KEY (`inventory_id`),
  KEY `fk_inventory_dealership` (`dealership_id`),
  KEY `fk_inventory_vehicle` (`vehicle_id`),
  CONSTRAINT `fk_inventory_dealership` FOREIGN KEY (`dealership_id`) REFERENCES `dealerships` (`dealership_id`),
  CONSTRAINT `fk_inventory_vehicle` FOREIGN KEY (`vehicle_id`) REFERENCES `vehicles` (`vehicle_id`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inventory`
--

LOCK TABLES `inventory` WRITE;
/*!40000 ALTER TABLE `inventory` DISABLE KEYS */;
INSERT INTO `inventory` VALUES (1,1,1),(2,1,3),(3,1,5),(4,1,7),(5,1,9),(6,1,11),(7,1,13),(8,2,2),(9,2,4),(10,2,6),(11,2,8),(12,2,10),(13,2,12),(14,2,14),(15,3,1),(16,3,2),(17,3,3),(18,3,4),(19,3,5),(20,3,6),(21,3,7),(22,3,8),(23,4,9),(24,4,10),(25,4,11),(26,4,12),(27,4,13),(28,4,14),(29,4,1),(30,4,2),(31,5,3),(32,5,4),(33,5,5),(34,5,6),(35,5,7),(36,5,8),(37,5,9),(38,5,10),(39,6,11),(40,6,12),(41,6,13),(42,6,14),(43,6,1),(44,6,2),(45,6,3),(46,6,4);
/*!40000 ALTER TABLE `inventory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lease_contracts`
--

DROP TABLE IF EXISTS `lease_contracts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lease_contracts` (
  `lease_contracts_id` int NOT NULL AUTO_INCREMENT,
  `customer_name` varchar(255) DEFAULT NULL,
  `dealership_id` int DEFAULT NULL,
  `vehicle_id` int DEFAULT NULL,
  `when` datetime DEFAULT NULL,
  `total_price` decimal(10,0) DEFAULT NULL,
  `monthly_payment` decimal(10,0) DEFAULT NULL,
  PRIMARY KEY (`lease_contracts_id`),
  KEY `fk_lease_contract_dealership` (`dealership_id`),
  KEY `fk_lease_contract_vehicle` (`vehicle_id`),
  CONSTRAINT `fk_lease_contract_dealership` FOREIGN KEY (`dealership_id`) REFERENCES `dealerships` (`dealership_id`),
  CONSTRAINT `fk_lease_contract_vehicle` FOREIGN KEY (`vehicle_id`) REFERENCES `vehicles` (`vehicle_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lease_contracts`
--

LOCK TABLES `lease_contracts` WRITE;
/*!40000 ALTER TABLE `lease_contracts` DISABLE KEYS */;
INSERT INTO `lease_contracts` VALUES (1,'Chris Johnson',1,14,NULL,NULL,NULL),(2,'Amanda White',2,13,NULL,NULL,NULL),(3,'Brian Thompson',3,12,NULL,NULL,NULL),(4,'Melissa Harris',4,11,NULL,NULL,NULL),(5,'Paul Clark',5,10,NULL,NULL,NULL),(6,'Nicole Lewis',6,9,NULL,NULL,NULL),(7,'Kevin Robinson',1,8,NULL,NULL,NULL),(8,'Elizabeth Walker',2,7,NULL,NULL,NULL),(9,'Jason Perez',3,6,NULL,NULL,NULL),(10,'Stephanie Hall',4,5,NULL,NULL,NULL),(11,'Matthew Young',5,4,NULL,NULL,NULL),(12,'Megan Allen',6,3,NULL,NULL,NULL),(13,'Joshua Sanchez',1,2,NULL,NULL,NULL),(14,'Samantha Wright',2,1,NULL,NULL,NULL),(15,'Kevin Long',1,2,'2025-06-12 00:00:00',9999,444);
/*!40000 ALTER TABLE `lease_contracts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sales_contracts`
--

DROP TABLE IF EXISTS `sales_contracts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sales_contracts` (
  `sales_contracts_id` int NOT NULL AUTO_INCREMENT,
  `customer_name` varchar(255) DEFAULT NULL,
  `dealership_id` int DEFAULT NULL,
  `vehicle_id` int DEFAULT NULL,
  `when` datetime DEFAULT CURRENT_TIMESTAMP,
  `total_price` decimal(10,0) DEFAULT NULL,
  `monthly_payment` decimal(10,0) DEFAULT NULL,
  PRIMARY KEY (`sales_contracts_id`),
  KEY `fk_sales_contract_dealership` (`dealership_id`),
  KEY `fk_sales_contract_vehicle` (`vehicle_id`),
  CONSTRAINT `fk_sales_contract_dealership` FOREIGN KEY (`dealership_id`) REFERENCES `dealerships` (`dealership_id`),
  CONSTRAINT `fk_sales_contract_vehicle` FOREIGN KEY (`vehicle_id`) REFERENCES `vehicles` (`vehicle_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sales_contracts`
--

LOCK TABLES `sales_contracts` WRITE;
/*!40000 ALTER TABLE `sales_contracts` DISABLE KEYS */;
INSERT INTO `sales_contracts` VALUES (1,'John Smith',1,1,'2025-04-05 15:07:06',NULL,NULL),(2,'Jane Doe',2,2,'2025-05-05 15:07:06',NULL,NULL),(3,'Peter Jones',3,3,'2025-05-05 15:07:06',NULL,NULL),(4,'Mary Williams',4,4,'2025-06-02 15:07:06',NULL,NULL),(5,'David Brown',5,5,'2025-06-03 15:07:06',NULL,NULL),(6,'Laura Miller',6,6,'2025-06-04 15:07:06',NULL,NULL),(7,'Michael Davis',1,7,'2025-06-05 15:07:06',NULL,NULL),(8,'Sarah Garcia',2,8,'2025-06-05 15:07:06',NULL,NULL),(9,'Robert Rodriguez',3,9,'2025-06-05 15:07:06',NULL,NULL),(10,'Jennifer Wilson',4,10,'2025-06-05 15:07:06',NULL,NULL),(11,'William Martinez',5,11,'2025-06-05 15:07:06',NULL,NULL),(12,'Jessica Anderson',6,12,'2025-06-05 15:07:06',NULL,NULL),(13,'Daniel Taylor',1,13,'2025-06-05 15:07:06',NULL,NULL),(14,'Ashley Thomas',2,14,'2025-06-05 15:07:06',NULL,NULL),(15,'Nina Marie',1,1,'2025-06-12 00:00:00',11111,555);
/*!40000 ALTER TABLE `sales_contracts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vehicles`
--

DROP TABLE IF EXISTS `vehicles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vehicles` (
  `vehicle_id` int NOT NULL AUTO_INCREMENT,
  `vin` varchar(17) DEFAULT NULL,
  `make` varchar(25) DEFAULT NULL,
  `model` varchar(25) DEFAULT NULL,
  `year` int DEFAULT NULL,
  `color` varchar(25) DEFAULT NULL,
  `price` varchar(45) NOT NULL DEFAULT '0',
  PRIMARY KEY (`vehicle_id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vehicles`
--

LOCK TABLES `vehicles` WRITE;
/*!40000 ALTER TABLE `vehicles` DISABLE KEYS */;
INSERT INTO `vehicles` VALUES (1,'1FASW7119CY123456','Ford','F-150',2024,'White','0'),(2,'2T3CW1EE4CR010203','Toyota','Camry',2025,'Black','11111'),(3,'3VW1F7HP6FM456789','Volkswagen','Jetta',2024,'Gray','0'),(4,'5J6SK7CA2DM901234','Honda','Civic',2025,'Silver','0'),(5,'JM1GP2F31AR567890','Mazda','CX-5',2024,'Blue','0'),(6,'WDBBF8EB5FM112233','Mercedes-Benz','C-Class',2025,'Red','0'),(7,'1G1FS8F21FL678901','Chevrolet','Equinox',2024,'Brown','0'),(8,'KL8CF1AE3FP234567','Kia','Sorento',2025,'Green','0'),(9,'JTDKN3DP1EM890123','Subaru','Outback',2024,'Beige','0'),(10,'KM8KR7DE9MP456789','Hyundai','Elantra',2025,'Yellow','0'),(11,'WAUPB7FF0FM334455','Audi','A4',2024,'Orange','0'),(12,'ZARAA7AD9FP678901','Alfa Romeo','Giulia',2025,'Purple','0'),(13,'JF1AA7J2XFM112233','Toyota','Corolla',2024,'Black','5555'),(14,'5UXTW7C5XFL456789','BMW','3 Series',2025,'White','0'),(16,'XYZ987','Hyundai','GT',2009,'black','9999.0');
/*!40000 ALTER TABLE `vehicles` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-06-18 14:04:58