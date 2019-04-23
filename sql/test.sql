/*
SQLyog Community v12.4.3 (64 bit)
MySQL - 5.6.12 : Database - kit-test
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`kit-test` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `kit-test`;

/*Table structure for table `detail` */

DROP TABLE IF EXISTS `detail`;

CREATE TABLE `detail` (
  `ID_HEADER` varchar(255) NOT NULL,
  `ID_MASTER` varchar(255) NOT NULL,
  `HARGA` double DEFAULT NULL,
  `JUMLAH` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID_HEADER`,`ID_MASTER`),
  KEY `FK_p8fagipsb866xkfh2w6p9qira` (`ID_HEADER`),
  KEY `FK_5ywku9602bgn1144m5f9bno1e` (`ID_MASTER`),
  CONSTRAINT `FK_5ywku9602bgn1144m5f9bno1e` FOREIGN KEY (`ID_MASTER`) REFERENCES `master` (`ID`),
  CONSTRAINT `FK_p8fagipsb866xkfh2w6p9qira` FOREIGN KEY (`ID_HEADER`) REFERENCES `header` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `detail` */

insert  into `detail`(`ID_HEADER`,`ID_MASTER`,`HARGA`,`JUMLAH`) values 
('HDR3','A',10,3),
('HDR3','B',20,6);

/*Table structure for table `header` */

DROP TABLE IF EXISTS `header`;

CREATE TABLE `header` (
  `ID` varchar(255) NOT NULL,
  `TGL` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `header` */

insert  into `header`(`ID`,`TGL`) values 
('HDR3','2012-02-02 00:00:00');

/*Table structure for table `master` */

DROP TABLE IF EXISTS `master`;

CREATE TABLE `master` (
  `ID` varchar(255) NOT NULL,
  `HARGA` double DEFAULT NULL,
  `TGL` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `master` */

insert  into `master`(`ID`,`HARGA`,`TGL`) values 
('A',10,'2018-03-19 06:17:24'),
('B',20,'2018-03-19 06:17:28');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
