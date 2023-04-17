/*
 Navicat Premium Data Transfer

 Source Server         : 本机MySql
 Source Server Type    : MySQL
 Source Server Version : 50740
 Source Host           : localhost:3306
 Source Schema         : hit

 Target Server Type    : MySQL
 Target Server Version : 50740
 File Encoding         : 65001

 Date: 17/04/2023 16:15:42
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for url
-- ----------------------------
DROP TABLE IF EXISTS `url`;
CREATE TABLE `url`  (
  `group_id` int(10) UNSIGNED NOT NULL,
  `web_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `video_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`group_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
