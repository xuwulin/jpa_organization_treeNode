/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50725
 Source Host           : localhost:3306
 Source Schema         : jpa

 Target Server Type    : MySQL
 Target Server Version : 50725
 File Encoding         : 65001

 Date: 25/03/2019 11:04:22
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_book
-- ----------------------------
DROP TABLE IF EXISTS `t_book`;
CREATE TABLE `t_book`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `author` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `book_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `price` float NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_book
-- ----------------------------
INSERT INTO `t_book` VALUES (2, '曹雪芹', '红楼梦', 90);
INSERT INTO `t_book` VALUES (3, '吴承恩', '西游记', 50);
INSERT INTO `t_book` VALUES (4, '王实甫', '西厢记', 30);
INSERT INTO `t_book` VALUES (5, '汤显祖', '牡丹亭', 30);
INSERT INTO `t_book` VALUES (6, '鲁迅', '呐喊', 23);
INSERT INTO `t_book` VALUES (7, '老子', '道德经', 200);
INSERT INTO `t_book` VALUES (8, '周文王', '易经', 200);
INSERT INTO `t_book` VALUES (9, '鲁迅', '呐喊', 24);
INSERT INTO `t_book` VALUES (10, '老子', '道德经', 200);
INSERT INTO `t_book` VALUES (11, '周文王', '易经', 200);

-- ----------------------------
-- Table structure for t_department
-- ----------------------------
DROP TABLE IF EXISTS `t_department`;
CREATE TABLE `t_department`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `dept_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `dept_no` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `dept_short_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `p_dept_no` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `unit_no` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_department
-- ----------------------------
INSERT INTO `t_department` VALUES ('4028dc8169a3508f0169a35095fc0000', '信息化工作办公室', '0001', '信息办', NULL, '460000');
INSERT INTO `t_department` VALUES ('4028dc8169a3508f0169a350960a0001', '案件管理处', '0002', '案管处', NULL, '460000');
INSERT INTO `t_department` VALUES ('4028dc8169a3508f0169a350960a0002', '统计部门', '0003', '统计', '0002', '460000');
INSERT INTO `t_department` VALUES ('4028dc8169a3508f0169a350960a0003', '侦查处', '0004', '侦查', NULL, '460000');
INSERT INTO `t_department` VALUES ('4028dc8169a3508f0169a350960a0004', '侦查一处', '0005', '侦一处', '0004', '460000');
INSERT INTO `t_department` VALUES ('4028dc8169a3508f0169a350960a0005', '侦查二处', '0006', '侦二处', '0004', '460000');
INSERT INTO `t_department` VALUES ('4028dc8169a35a950169a35a9eab0000', '信息化工作办公室', '0001', '信息办', NULL, '460300');
INSERT INTO `t_department` VALUES ('4028dc8169a35a950169a35a9eb80001', '案件管理处', '0002', '案管处', NULL, '460300');
INSERT INTO `t_department` VALUES ('4028dc8169a35a950169a35a9eb80002', '统计部门', '0003', '统计', '0002', '460300');
INSERT INTO `t_department` VALUES ('4028dc8169a35a950169a35a9eb80003', '侦查处', '0004', '侦查', NULL, '460300');
INSERT INTO `t_department` VALUES ('4028dc8169a35a950169a35a9eb80004', '侦查一处', '0005', '侦一处', '0004', '460300');
INSERT INTO `t_department` VALUES ('4028dc8169a35a950169a35a9eb80005', '侦查二处', '0006', '侦二处', '0004', '460300');
INSERT INTO `t_department` VALUES ('4028dc8169a35b3c0169a35b43780000', '信息化工作办公室', '0001', '信息办', NULL, '460500');
INSERT INTO `t_department` VALUES ('4028dc8169a35b3c0169a35b43800001', '案件管理处', '0002', '案管处', NULL, '460500');
INSERT INTO `t_department` VALUES ('4028dc8169a35b3c0169a35b43800002', '统计部门', '0003', '统计', '0002', '460500');
INSERT INTO `t_department` VALUES ('4028dc8169a35b3c0169a35b43810003', '侦查处', '0004', '侦查', NULL, '460500');
INSERT INTO `t_department` VALUES ('4028dc8169a35b3c0169a35b43810004', '侦查一处', '0005', '侦一处', '0004', '460500');
INSERT INTO `t_department` VALUES ('4028dc8169a35b3c0169a35b43810005', '侦查二处', '0006', '侦二处', '0004', '460500');
INSERT INTO `t_department` VALUES ('4028dc8169a35ba10169a35ba8fa0000', '信息化工作办公室', '0001', '信息办', NULL, '460023');
INSERT INTO `t_department` VALUES ('4028dc8169a35ba10169a35ba9030001', '案件管理处', '0002', '案管处', NULL, '460023');
INSERT INTO `t_department` VALUES ('4028dc8169a35ba10169a35ba9030002', '统计部门', '0003', '统计', '0002', '460023');
INSERT INTO `t_department` VALUES ('4028dc8169a35ba10169a35ba9030003', '侦查处', '0004', '侦查', NULL, '460023');
INSERT INTO `t_department` VALUES ('4028dc8169a35ba10169a35ba9030004', '侦查一处', '0005', '侦一处', '0004', '460023');
INSERT INTO `t_department` VALUES ('4028dc8169a35ba10169a35ba9030005', '侦查二处', '0006', '侦二处', '0004', '460023');
INSERT INTO `t_department` VALUES ('4028dc8169a35c3f0169a35c465d0000', '信息化工作办公室', '0001', '信息办', NULL, '460028');
INSERT INTO `t_department` VALUES ('4028dc8169a35c3f0169a35c466a0001', '案件管理处', '0002', '案管处', NULL, '460028');
INSERT INTO `t_department` VALUES ('4028dc8169a35c3f0169a35c466a0002', '统计部门', '0003', '统计', '0002', '460028');
INSERT INTO `t_department` VALUES ('4028dc8169a35c3f0169a35c466a0003', '侦查处', '0004', '侦查', NULL, '460028');
INSERT INTO `t_department` VALUES ('4028dc8169a35c3f0169a35c466a0004', '侦查一处', '0005', '侦一处', '0004', '460028');
INSERT INTO `t_department` VALUES ('4028dc8169a35c3f0169a35c466a0005', '侦查二处', '0006', '侦二处', '0004', '460028');

-- ----------------------------
-- Table structure for t_role
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `dept_no` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `role_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `unit_no` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `role_no` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_role
-- ----------------------------
INSERT INTO `t_role` VALUES ('4028dc8169a359a80169a359afc00000', '0001', '科长', '460000', '001');
INSERT INTO `t_role` VALUES ('4028dc8169a359a80169a359afcb0001', '0002', '处长', '460000', '001');
INSERT INTO `t_role` VALUES ('4028dc8169a359a80169a359afcb0002', '0002', '副处长', '460000', '002');
INSERT INTO `t_role` VALUES ('4028dc8169a359a80169a359afcb0003', '0003', '统计员', '460000', '001');
INSERT INTO `t_role` VALUES ('4028dc8169a359a80169a359afcb0004', '0004', '处长', '460000', '001');
INSERT INTO `t_role` VALUES ('4028dc8169a359a80169a359afcb0005', '0004', '副处长', '460000', '002');
INSERT INTO `t_role` VALUES ('4028dc8169a359a80169a359afcb0006', '0005', '处长', '460000', '001');
INSERT INTO `t_role` VALUES ('4028dc8169a359a80169a359afcb0007', '0005', '副处长', '460000', '002');
INSERT INTO `t_role` VALUES ('4028dc8169a359a80169a359afcb0008', '0005', '检察官', '460000', '003');
INSERT INTO `t_role` VALUES ('4028dc8169a35ad70169a35ade490000', '0001', '科长', '460300', '001');
INSERT INTO `t_role` VALUES ('4028dc8169a35ad70169a35ade540001', '0002', '处长', '460300', '001');
INSERT INTO `t_role` VALUES ('4028dc8169a35ad70169a35ade540002', '0002', '副处长', '460300', '002');
INSERT INTO `t_role` VALUES ('4028dc8169a35ad70169a35ade540003', '0003', '统计员', '460300', '001');
INSERT INTO `t_role` VALUES ('4028dc8169a35ad70169a35ade540004', '0004', '处长', '460300', '001');
INSERT INTO `t_role` VALUES ('4028dc8169a35ad70169a35ade540005', '0004', '副处长', '460300', '002');
INSERT INTO `t_role` VALUES ('4028dc8169a35ad70169a35ade540006', '0005', '处长', '460300', '001');
INSERT INTO `t_role` VALUES ('4028dc8169a35ad70169a35ade540007', '0005', '副处长', '460300', '002');
INSERT INTO `t_role` VALUES ('4028dc8169a35ad70169a35ade550008', '0005', '检察官', '460300', '003');
INSERT INTO `t_role` VALUES ('4028dc8169a35b7b0169a35b82520000', '0001', '科长', '460500', '001');
INSERT INTO `t_role` VALUES ('4028dc8169a35b7b0169a35b825b0001', '0002', '处长', '460500', '001');
INSERT INTO `t_role` VALUES ('4028dc8169a35b7b0169a35b825b0002', '0002', '副处长', '460500', '002');
INSERT INTO `t_role` VALUES ('4028dc8169a35b7b0169a35b825b0003', '0003', '统计员', '460500', '001');
INSERT INTO `t_role` VALUES ('4028dc8169a35b7b0169a35b825b0004', '0004', '处长', '460500', '001');
INSERT INTO `t_role` VALUES ('4028dc8169a35b7b0169a35b825b0005', '0004', '副处长', '460500', '002');
INSERT INTO `t_role` VALUES ('4028dc8169a35b7b0169a35b825b0006', '0005', '处长', '460500', '001');
INSERT INTO `t_role` VALUES ('4028dc8169a35b7b0169a35b825b0007', '0005', '副处长', '460500', '002');
INSERT INTO `t_role` VALUES ('4028dc8169a35b7b0169a35b825b0008', '0005', '检察官', '460500', '003');
INSERT INTO `t_role` VALUES ('4028dc8169a35bda0169a35be22a0000', '0001', '科长', '460023', '001');
INSERT INTO `t_role` VALUES ('4028dc8169a35bda0169a35be2360001', '0002', '处长', '460023', '001');
INSERT INTO `t_role` VALUES ('4028dc8169a35bda0169a35be2360002', '0002', '副处长', '460023', '002');
INSERT INTO `t_role` VALUES ('4028dc8169a35bda0169a35be2360003', '0003', '统计员', '460023', '001');
INSERT INTO `t_role` VALUES ('4028dc8169a35bda0169a35be2360004', '0004', '处长', '460023', '001');
INSERT INTO `t_role` VALUES ('4028dc8169a35bda0169a35be2360005', '0004', '副处长', '460023', '002');
INSERT INTO `t_role` VALUES ('4028dc8169a35bda0169a35be2360006', '0005', '处长', '460023', '001');
INSERT INTO `t_role` VALUES ('4028dc8169a35bda0169a35be2360007', '0005', '副处长', '460023', '002');
INSERT INTO `t_role` VALUES ('4028dc8169a35bda0169a35be2360008', '0005', '检察官', '460023', '003');
INSERT INTO `t_role` VALUES ('4028dc8169a35c5d0169a35c63d70000', '0001', '科长', '460028', '001');
INSERT INTO `t_role` VALUES ('4028dc8169a35c5d0169a35c63e00001', '0002', '处长', '460028', '001');
INSERT INTO `t_role` VALUES ('4028dc8169a35c5d0169a35c63e00002', '0002', '副处长', '460028', '002');
INSERT INTO `t_role` VALUES ('4028dc8169a35c5d0169a35c63e00003', '0003', '统计员', '460028', '001');
INSERT INTO `t_role` VALUES ('4028dc8169a35c5d0169a35c63e00004', '0004', '处长', '460028', '001');
INSERT INTO `t_role` VALUES ('4028dc8169a35c5d0169a35c63e00005', '0004', '副处长', '460028', '002');
INSERT INTO `t_role` VALUES ('4028dc8169a35c5d0169a35c63e10006', '0005', '处长', '460028', '001');
INSERT INTO `t_role` VALUES ('4028dc8169a35c5d0169a35c63e10007', '0005', '副处长', '460028', '002');
INSERT INTO `t_role` VALUES ('4028dc8169a35c5d0169a35c63e10008', '0005', '检察官', '460028', '003');
INSERT INTO `t_role` VALUES ('4028dc8169b2c8740169b2c87d6a0000', '0006', '处长', '460000', '001');
INSERT INTO `t_role` VALUES ('4028dc8169b2c8740169b2c87d830001', '0006', '副处长', '460000', '002');
INSERT INTO `t_role` VALUES ('4028dc8169b2c8740169b2c87d830002', '0006', '检察官', '460000', '003');

-- ----------------------------
-- Table structure for t_unit
-- ----------------------------
DROP TABLE IF EXISTS `t_unit`;
CREATE TABLE `t_unit`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `p_unit_no` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `unit_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `unit_no` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `unit_short_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_unit
-- ----------------------------
INSERT INTO `t_unit` VALUES ('4028dc8169a33efc0169a33f02c00000', NULL, '最高人民检察院', '100000', '高检');
INSERT INTO `t_unit` VALUES ('4028dc8169a33efc0169a33f02c00001', '100000', '海南省人民检察院', '460000', '琼检');
INSERT INTO `t_unit` VALUES ('4028dc8169a33efc0169a33f02c00002', '460000', '海南省人民检察院第一分院', '460300', '琼检一分');
INSERT INTO `t_unit` VALUES ('4028dc8169a33efc0169a33f02c00003', '460000', '海南省人民检察院第二分院', '460500', '琼检二分');
INSERT INTO `t_unit` VALUES ('4028dc8169a33efc0169a33f02c00004', '460300', '琼海市人民检察院', '460023', '琼海检');
INSERT INTO `t_unit` VALUES ('4028dc8169a33efc0169a33f02c00005', '460500', '临高县人民检察院', '460028', '临检');
INSERT INTO `t_unit` VALUES ('4028dc8169a33efc0169a33f02c00006', '100000', '四川省人民检察院', '510000', '川检');
INSERT INTO `t_unit` VALUES ('4028dc8169a33efc0169a33f02c00007', '510000', '成都市人民检察院', '510010', '成检');

-- ----------------------------
-- Table structure for tbl_user
-- ----------------------------
DROP TABLE IF EXISTS `tbl_user`;
CREATE TABLE `tbl_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `last_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tbl_user
-- ----------------------------
INSERT INTO `tbl_user` VALUES (1, 'aa', 'aa');
INSERT INTO `tbl_user` VALUES (2, 'bb', 'bb');
INSERT INTO `tbl_user` VALUES (3, 'cc', 'cc');
INSERT INTO `tbl_user` VALUES (4, 'dd', 'dd');
INSERT INTO `tbl_user` VALUES (5, 'ee', 'ee');
INSERT INTO `tbl_user` VALUES (6, 'aa', 'aa');

SET FOREIGN_KEY_CHECKS = 1;
