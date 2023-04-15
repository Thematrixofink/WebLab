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

 Date: 13/04/2023 20:23:17
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for result
-- ----------------------------
DROP TABLE IF EXISTS `result`;
CREATE TABLE `result`  (
  `group_id` int(3) NOT NULL,
  `judges_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `score` double(16, 2) NOT NULL,
  `work_score` double(16, 2) NOT NULL,
  `cmt_score` double(16, 2) NOT NULL,
  `ui_score` double(16, 2) NOT NULL,
  `div_score` double(16, 2) NOT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of result
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
