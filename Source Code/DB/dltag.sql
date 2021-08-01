# MySQL-Front 5.1  (Build 1.5)

/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE */;
/*!40101 SET SQL_MODE='STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES */;
/*!40103 SET SQL_NOTES='ON' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS */;
/*!40014 SET FOREIGN_KEY_CHECKS=0 */;


# Host: localhost    Database: dltag
# ------------------------------------------------------
# Server version 5.0.24a-community-nt

DROP DATABASE IF EXISTS `dltag`;
CREATE DATABASE `dltag` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `dltag`;

#
# Source for table addproduct
#

CREATE TABLE `addproduct` (
  `image` varchar(255) default NULL,
  `suplier_id` varchar(255) default NULL,
  `productid` varchar(255) NOT NULL default '',
  `name` varchar(255) default NULL,
  `deseription` varchar(255) default NULL,
  `price` varchar(255) default NULL,
  `quanit` varchar(255) default NULL,
  PRIMARY KEY  (`productid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;

#
# Dumping data for table addproduct
#
LOCK TABLES `addproduct` WRITE;
/*!40000 ALTER TABLE `addproduct` DISABLE KEYS */;

/*!40000 ALTER TABLE `addproduct` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table distributor
#

CREATE TABLE `distributor` (
  `name` varchar(255) default NULL,
  `email` varchar(255) default NULL,
  `password` varchar(255) default NULL,
  `mobile` varchar(255) default NULL,
  `did` varchar(255) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;

#
# Dumping data for table distributor
#
LOCK TABLES `distributor` WRITE;
/*!40000 ALTER TABLE `distributor` DISABLE KEYS */;

/*!40000 ALTER TABLE `distributor` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table distributor_requests
#

CREATE TABLE `distributor_requests` (
  `manufacturer` varchar(255) default NULL,
  `distributor` varchar(255) default NULL,
  `product_id` varchar(255) default NULL,
  `product_name` varchar(255) default NULL,
  `date` varchar(255) default NULL,
  `image` varchar(255) default NULL,
  `status` varchar(255) default NULL,
  `price` varchar(255) default NULL,
  `dprice` varchar(255) default NULL,
  `quantity` varchar(255) default NULL,
  `qrcode` varchar(255) default NULL,
  `adate` varchar(255) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;

#
# Dumping data for table distributor_requests
#
LOCK TABLES `distributor_requests` WRITE;
/*!40000 ALTER TABLE `distributor_requests` DISABLE KEYS */;

/*!40000 ALTER TABLE `distributor_requests` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table fakeproduct
#

CREATE TABLE `fakeproduct` (
  `Id` int(11) NOT NULL auto_increment,
  `mname` varchar(255) default NULL,
  `productid` varchar(255) default NULL,
  `productname` varchar(255) default NULL,
  `price` varchar(255) default NULL,
  `image` varchar(255) default NULL,
  PRIMARY KEY  (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Dumping data for table fakeproduct
#
LOCK TABLES `fakeproduct` WRITE;
/*!40000 ALTER TABLE `fakeproduct` DISABLE KEYS */;

/*!40000 ALTER TABLE `fakeproduct` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table manu_product
#

CREATE TABLE `manu_product` (
  `Id` int(11) NOT NULL auto_increment,
  `Productid` varchar(255) NOT NULL default '',
  `Manufacturename` varchar(255) default NULL,
  `Productname` varchar(255) default NULL,
  `Price` varchar(255) default NULL,
  `Imagepath` varchar(255) default NULL,
  `Description` varchar(255) default NULL,
  `numberofproduct` varchar(255) default NULL,
  `assembledate` varchar(255) default NULL,
  PRIMARY KEY  (`Id`,`Productid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;

#
# Dumping data for table manu_product
#
LOCK TABLES `manu_product` WRITE;
/*!40000 ALTER TABLE `manu_product` DISABLE KEYS */;

/*!40000 ALTER TABLE `manu_product` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table manufac_inven
#

CREATE TABLE `manufac_inven` (
  `s_no` int(11) NOT NULL auto_increment,
  `manufacture_name` varchar(255) default NULL,
  `supilerid` varchar(255) default NULL,
  `product_id` varchar(255) NOT NULL default '',
  `quanity` varchar(255) default NULL,
  `pname` varchar(255) default NULL,
  PRIMARY KEY  (`s_no`,`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;

#
# Dumping data for table manufac_inven
#
LOCK TABLES `manufac_inven` WRITE;
/*!40000 ALTER TABLE `manufac_inven` DISABLE KEYS */;

/*!40000 ALTER TABLE `manufac_inven` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table manufacture
#

CREATE TABLE `manufacture` (
  `name` varchar(255) default NULL,
  `email` varchar(255) default NULL,
  `pass` varchar(255) default NULL,
  `mobile` varchar(255) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;

#
# Dumping data for table manufacture
#
LOCK TABLES `manufacture` WRITE;
/*!40000 ALTER TABLE `manufacture` DISABLE KEYS */;

/*!40000 ALTER TABLE `manufacture` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table requestquanity
#

CREATE TABLE `requestquanity` (
  `s_no` int(11) NOT NULL auto_increment,
  `manufacture_name` varchar(255) default NULL,
  `supilerid` varchar(255) default NULL,
  `product_id` varchar(255) default NULL,
  `quanity` varchar(255) default NULL,
  `status` varchar(255) default NULL,
  `reqdate` timestamp NOT NULL default CURRENT_TIMESTAMP,
  `pname` varchar(255) default NULL,
  PRIMARY KEY  (`s_no`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;

#
# Dumping data for table requestquanity
#
LOCK TABLES `requestquanity` WRITE;
/*!40000 ALTER TABLE `requestquanity` DISABLE KEYS */;

/*!40000 ALTER TABLE `requestquanity` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table shipment
#

CREATE TABLE `shipment` (
  `Id` int(11) NOT NULL auto_increment,
  `Productid` varchar(255) NOT NULL default '0',
  `Manufacture` int(11) NOT NULL default '0',
  `Supplier` int(11) NOT NULL default '0',
  `Customer` int(11) NOT NULL default '0',
  `Distributer` int(11) NOT NULL default '0',
  PRIMARY KEY  (`Id`,`Productid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;

#
# Dumping data for table shipment
#
LOCK TABLES `shipment` WRITE;
/*!40000 ALTER TABLE `shipment` DISABLE KEYS */;

/*!40000 ALTER TABLE `shipment` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table suppilerreg
#

CREATE TABLE `suppilerreg` (
  `name` varchar(255) default NULL,
  `producttype` varchar(255) default NULL,
  `email` varchar(255) default NULL,
  `phone` varchar(255) default NULL,
  `address` varchar(255) default NULL,
  `pass` varchar(255) default NULL,
  `sup_id` varchar(255) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;

#
# Dumping data for table suppilerreg
#
LOCK TABLES `suppilerreg` WRITE;
/*!40000 ALTER TABLE `suppilerreg` DISABLE KEYS */;

/*!40000 ALTER TABLE `suppilerreg` ENABLE KEYS */;
UNLOCK TABLES;

/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
