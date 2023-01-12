/*
 Navicat Premium Data Transfer

 Source Server         : project
 Source Server Type    : MySQL
 Source Server Version : 50562
 Source Host           : localhost:3306
 Source Schema         : teachersystem_db

 Target Server Type    : MySQL
 Target Server Version : 50562
 File Encoding         : 65001

 Date: 24/12/2022 12:31:07
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for class
-- ----------------------------
DROP TABLE IF EXISTS `class`;
CREATE TABLE `class`  (
  `class_no` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `class_name` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`class_no`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of class
-- ----------------------------
INSERT INTO `class` VALUES ('1', '中软一班');
INSERT INTO `class` VALUES ('2', '中软三班');
INSERT INTO `class` VALUES ('3', '河南一班');
INSERT INTO `class` VALUES ('5', '中软二班');

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course`  (
  `course_no` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `course_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `credlit` float(2, 1) NULL DEFAULT NULL,
  PRIMARY KEY (`course_no`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES ('', '', NULL);
INSERT INTO `course` VALUES ('1', 'JAVA', NULL);
INSERT INTO `course` VALUES ('2', 'php', 2.5);
INSERT INTO `course` VALUES ('3', 'ui', 3.5);
INSERT INTO `course` VALUES ('5', 'ios', NULL);

-- ----------------------------
-- Table structure for course_score
-- ----------------------------
DROP TABLE IF EXISTS `course_score`;
CREATE TABLE `course_score`  (
  `student_no` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `course_no` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `score` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`student_no`, `course_no`) USING BTREE,
  INDEX `fk_course_no`(`course_no`) USING BTREE,
  CONSTRAINT `fk_course_no` FOREIGN KEY (`course_no`) REFERENCES `course` (`course_no`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_student_no` FOREIGN KEY (`student_no`) REFERENCES `student` (`student_no`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of course_score
-- ----------------------------
INSERT INTO `course_score` VALUES ('001', '1', 100);
INSERT INTO `course_score` VALUES ('001', '3', 100);
INSERT INTO `course_score` VALUES ('002', '2', 100);
INSERT INTO `course_score` VALUES ('003', '2', 100);

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `student_no` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `student_name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `gender` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `birthday` date NULL DEFAULT NULL,
  `password` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `status` int(1) NOT NULL,
  `class_no` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`student_no`) USING BTREE,
  INDEX `fk_class_no`(`class_no`) USING BTREE,
  CONSTRAINT `fk_class_no` FOREIGN KEY (`class_no`) REFERENCES `class` (`class_no`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('001', '吕牧', '男', '2020-04-27', '1234', 0, '2');
INSERT INTO `student` VALUES ('002', '嘉诚', '男', '2020-04-27', '123456', 1, '5');
INSERT INTO `student` VALUES ('003', '林耀', '男', '2020-04-27', '123456', 1, '1');
INSERT INTO `student` VALUES ('004', '吕云飞', '女', '2020-09-09', '123456', 1, '1');
INSERT INTO `student` VALUES ('005', '刘备', '男', '2020-09-11', '123456', 1, '1');
INSERT INTO `student` VALUES ('006', '张飞', '女', '1999-09-09', '0000', 1, '2');
INSERT INTO `student` VALUES ('008', '云飞', '女', '2020-09-18', '0000', 0, '1');

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher`  (
  `teacher_no` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `teacher_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`teacher_no`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('001', '陈老师', '0000');
INSERT INTO `teacher` VALUES ('002', '白老师', '0000');
INSERT INTO `teacher` VALUES ('003', '黄老师', '0000');

SET FOREIGN_KEY_CHECKS = 1;
