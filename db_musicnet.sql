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

/*Table structure for table `userinfo` */

DROP TABLE IF EXISTS `userinfo`;

CREATE TABLE `userinfo` (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `uname` varchar(100) DEFAULT NULL COMMENT '用户名',
  `email` varchar(100) DEFAULT NULL COMMENT '邮箱',
  `pwd` varchar(100) DEFAULT NULL COMMENT '密码',
  `phone` int(11) DEFAULT NULL COMMENT '手机号',
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='用户信息';

/*Data for the table `userinfo` */

insert  into `userinfo`(`uid`,`uname`,`email`,`pwd`,`phone`) values (1,'chy','1056351524@qq.com','123456',2147483647),(2,'sue','1056351524@qq.com','123456',2147483647);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
