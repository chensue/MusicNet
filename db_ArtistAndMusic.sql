/*
SQLyog Ultimate v8.32 
MySQL - 5.5.28 : Database - musicnet
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`musicnet` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `musicnet`;

/*Table structure for table `artistinfo` */

DROP TABLE IF EXISTS `artistinfo`;

CREATE TABLE `artistinfo` (
  `artistId` int(11) NOT NULL AUTO_INCREMENT COMMENT '歌手id',
  `artistname` varchar(50) DEFAULT NULL COMMENT '歌手名称',
  `sex` int(1) DEFAULT '0' COMMENT '0男歌手，1女歌手',
  `photo` longblob COMMENT '歌手头像',
  PRIMARY KEY (`artistId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `artistinfo` */

/*Table structure for table `musicinfo` */

DROP TABLE IF EXISTS `musicinfo`;

CREATE TABLE `musicinfo` (
  `mid` int(11) NOT NULL AUTO_INCREMENT,
  `musicname` varchar(500) NOT NULL COMMENT '歌曲名',
  `musicpath` varchar(500) NOT NULL COMMENT '歌曲路径',
  `duration` varchar(20) DEFAULT NULL COMMENT '歌曲时长',
  `artistId` int(11) NOT NULL COMMENT '歌手id',
  PRIMARY KEY (`mid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `musicinfo` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
