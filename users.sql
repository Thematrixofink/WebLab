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

 Date: 13/04/2023 20:23:23
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
  `user_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `real_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `status` int(1) NULL DEFAULT NULL,
  `if_judges` int(1) NULL DEFAULT NULL,
  `group_id` int(2) NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('2021112345', 'Angela Cruz', 'kKLKyUjxez', 0, 0, 1);
INSERT INTO `users` VALUES ('2021115644', 'Ku Hui Mei', 'VYxx8O2Z4q', 0, 0, 2);
INSERT INTO `users` VALUES ('2021113453', 'Ku Sze Kwan', 'x55ZZTMlym', 0, 0, 3);
INSERT INTO `users` VALUES ('woshipingwei1', 'Randy Cole', 'tLyP0aLxtV', 1, 1, NULL);
INSERT INTO `users` VALUES ('woshipingwei2', 'Edwin Martinez', 'kW8HI6nOXj', 1, 1, NULL);

SET FOREIGN_KEY_CHECKS = 1;
