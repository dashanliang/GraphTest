/*
 Navicat Premium Data Transfer

 Source Server         : 本地数据库
 Source Server Type    : MySQL
 Source Server Version : 80016
 Source Host           : localhost:3306
 Source Schema         : globalconf

 Target Server Type    : MySQL
 Target Server Version : 80016
 File Encoding         : 65001

 Date: 29/05/2019 15:39:57
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for betransfer
-- ----------------------------
DROP TABLE IF EXISTS `betransfer`;
CREATE TABLE `betransfer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fromccy` varchar(255) DEFAULT NULL,
  `tohousename` varchar(255) DEFAULT NULL,
  `toccy` varchar(255) DEFAULT NULL,
  `cost` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for cctransfer
-- ----------------------------
DROP TABLE IF EXISTS `cctransfer`;
CREATE TABLE `cctransfer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fromccy` varchar(255) DEFAULT NULL,
  `tohousename` varchar(255) DEFAULT NULL,
  `toccy` varchar(255) DEFAULT NULL,
  `cost` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of cctransfer
-- ----------------------------
BEGIN;
INSERT INTO `cctransfer` VALUES (1, 'cny', 'cc', 'usd', '0.2');
INSERT INTO `cctransfer` VALUES (2, 'usd', 'lhv', 'usd', '1');
INSERT INTO `cctransfer` VALUES (3, 'cny', 'cc', 'jpy', '0.5');
INSERT INTO `cctransfer` VALUES (4, 'usd', 'cc', 'jpy', '0.1');
INSERT INTO `cctransfer` VALUES (5, 'jpy', 'be', 'jpy', '0.2');
COMMIT;

-- ----------------------------
-- Table structure for houseofmoney
-- ----------------------------
DROP TABLE IF EXISTS `houseofmoney`;
CREATE TABLE `houseofmoney` (
  `houseid` int(255) NOT NULL AUTO_INCREMENT,
  `housename` varchar(255) DEFAULT NULL,
  `houseccy` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`houseid`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of houseofmoney
-- ----------------------------
BEGIN;
INSERT INTO `houseofmoney` VALUES (1, 'lhv', 'usd');
INSERT INTO `houseofmoney` VALUES (2, 'lhv', 'cny');
INSERT INTO `houseofmoney` VALUES (3, 'cc', 'cny');
INSERT INTO `houseofmoney` VALUES (4, 'cc', 'usd');
INSERT INTO `houseofmoney` VALUES (5, 'be', 'jpy');
INSERT INTO `houseofmoney` VALUES (6, 'cc', 'jpy');
COMMIT;

-- ----------------------------
-- Table structure for lhvtransfer
-- ----------------------------
DROP TABLE IF EXISTS `lhvtransfer`;
CREATE TABLE `lhvtransfer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fromccy` varchar(255) DEFAULT NULL,
  `tohousename` varchar(255) DEFAULT NULL,
  `toccy` varchar(255) DEFAULT NULL,
  `cost` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of lhvtransfer
-- ----------------------------
BEGIN;
INSERT INTO `lhvtransfer` VALUES (1, 'cny', 'cc', 'cny', '1');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
