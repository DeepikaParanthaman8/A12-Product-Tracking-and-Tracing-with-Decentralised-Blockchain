# MySQL-Front 5.1  (Build 1.5)

/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE */;
/*!40101 SET SQL_MODE='STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES */;
/*!40103 SET SQL_NOTES='ON' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS */;
/*!40014 SET FOREIGN_KEY_CHECKS=0 */;


# Host: localhost    Database: dltaguser
# ------------------------------------------------------
# Server version 5.0.24a-community-nt

DROP DATABASE IF EXISTS `dltaguser`;
CREATE DATABASE `dltaguser` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `dltaguser`;

#
# Source for table purchased_products
#

CREATE TABLE `purchased_products` (
  `id` bigint(20) NOT NULL auto_increment,
  `email` varchar(255) default NULL,
  `image` varchar(255) default NULL,
  `productId` varchar(255) default NULL,
  `productName` varchar(255) default NULL,
  `quantity` varchar(255) default NULL,
  `date` varchar(255) default NULL,
  `status` varchar(255) default NULL,
  `distributor` varchar(255) default NULL,
  `price` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;

#
# Dumping data for table purchased_products
#
LOCK TABLES `purchased_products` WRITE;
/*!40000 ALTER TABLE `purchased_products` DISABLE KEYS */;

/*!40000 ALTER TABLE `purchased_products` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table store
#

CREATE TABLE `store` (
  `id` bigint(20) NOT NULL auto_increment,
  `distributor` varchar(255) default NULL,
  `distributorPrice` varchar(255) default NULL,
  `image` varchar(255) default NULL,
  `manufacturer` varchar(255) default NULL,
  `price` varchar(255) default NULL,
  `productId` varchar(255) default NULL,
  `productName` varchar(255) default NULL,
  `status` varchar(255) default NULL,
  `adate` varchar(255) default NULL,
  `qrcode` varchar(255) default NULL,
  `quanity` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;

#
# Dumping data for table store
#
LOCK TABLES `store` WRITE;
/*!40000 ALTER TABLE `store` DISABLE KEYS */;

/*!40000 ALTER TABLE `store` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table user
#

CREATE TABLE `user` (
  `id` bigint(20) NOT NULL auto_increment,
  `name` varchar(255) default NULL,
  `email` varchar(255) default NULL,
  `password` varchar(255) default NULL,
  `mobile` varchar(255) default NULL,
  `address` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;

#
# Dumping data for table user
#
LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;

/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table user_products
#

CREATE TABLE `user_products` (
  `Id` int(11) NOT NULL auto_increment,
  PRIMARY KEY  (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;

#
# Dumping data for table user_products
#
LOCK TABLES `user_products` WRITE;
/*!40000 ALTER TABLE `user_products` DISABLE KEYS */;

/*!40000 ALTER TABLE `user_products` ENABLE KEYS */;
UNLOCK TABLES;

/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
