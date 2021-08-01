# MySQL-Front 5.1  (Build 1.5)

/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE */;
/*!40101 SET SQL_MODE='STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES */;
/*!40103 SET SQL_NOTES='ON' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS */;
/*!40014 SET FOREIGN_KEY_CHECKS=0 */;


# Host: localhost    Database: bankadmindb
# ------------------------------------------------------
# Server version 5.0.24a-community-nt

DROP DATABASE IF EXISTS `bankadmindb`;
CREATE DATABASE `bankadmindb` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `bankadmindb`;

#
# Source for table useraccountinfo
#

CREATE TABLE `useraccountinfo` (
  `accountno` varchar(500) NOT NULL default '',
  `pinpass` varchar(10) default NULL,
  `amount` varchar(50) default NULL,
  `opass` varchar(10) default NULL,
  `transferamount` varchar(255) default NULL,
  PRIMARY KEY  (`accountno`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Dumping data for table useraccountinfo
#
LOCK TABLES `useraccountinfo` WRITE;
/*!40000 ALTER TABLE `useraccountinfo` DISABLE KEYS */;

/*!40000 ALTER TABLE `useraccountinfo` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table userinfo
#

CREATE TABLE `userinfo` (
  `accountno` varchar(500) NOT NULL default '',
  `accountholdername` varchar(500) default NULL,
  `mobilenumber` varchar(255) default NULL,
  `mailid` varchar(255) default NULL,
  `Address` varchar(255) default NULL,
  `city` varchar(255) default NULL,
  `pincode` varchar(10) default NULL,
  `state` varchar(255) default NULL,
  PRIMARY KEY  (`accountno`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Dumping data for table userinfo
#
LOCK TABLES `userinfo` WRITE;
/*!40000 ALTER TABLE `userinfo` DISABLE KEYS */;

/*!40000 ALTER TABLE `userinfo` ENABLE KEYS */;
UNLOCK TABLES;

/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
