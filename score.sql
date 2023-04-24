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

 Date: 24/04/2023 11:36:08
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for score
-- ----------------------------
DROP TABLE IF EXISTS `score`;
CREATE TABLE `score`  (
  `group_id` int(3) NOT NULL,
  `judges_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `score` double(16, 2) NOT NULL,
  `work_score` double(16, 2) NOT NULL,
  `cmt_score` double(16, 2) NOT NULL,
  `ui_score` double(16, 2) NOT NULL,
  `div_score` double(16, 2) NOT NULL,
  `status` int(2) NOT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of score
-- ----------------------------
INSERT INTO `score` VALUES (1, 'zhangsan', 1.00, 1.00, 1.00, 1.00, 1.00, 0);
INSERT INTO `score` VALUES (1, 'lisi', 90.00, 90.00, 90.00, 90.00, 90.00, 1);
INSERT INTO `score` VALUES (1, 'wangwu', 9.00, 9.00, 9.00, 9.00, 9.00, 0);
INSERT INTO `score` VALUES (2, 'zhangru', 100.00, 100.00, 100.00, 100.00, 100.00, 1);
INSERT INTO `score` VALUES (2, 'zhangsan', 0.00, 0.00, 0.00, 0.00, 0.00, 1);
INSERT INTO `score` VALUES (6, 'superZhangsan', 999.00, 999.00, 999.00, 999.00, 999.00, 1);

SET FOREIGN_KEY_CHECKS = 1;
