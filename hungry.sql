/*
 Navicat Premium Data Transfer

 Source Server         : aliyun
 Source Server Type    : MySQL
 Source Server Version : 80021
 Source Host           : 47.96.225.150:3306
 Source Schema         : hungry

 Target Server Type    : MySQL
 Target Server Version : 80021
 File Encoding         : 65001

 Date: 20/01/2021 16:11:14
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `admin_id` int NOT NULL AUTO_INCREMENT COMMENT '管理员id',
  `shop_id` int NULL DEFAULT NULL COMMENT '商铺id',
  `admin_username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '管理员账户',
  `admin_password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '管理员密码',
  `admin_phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '管理员号码',
  `admin_create_time` datetime NULL DEFAULT NULL COMMENT '管理员创建时间',
  `admin_update_time` datetime NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '管理员最近修改时间',
  `admin_login_time` datetime NULL DEFAULT NULL COMMENT '管理员最近登录时间',
  `enabled` tinyint(1) NULL DEFAULT NULL,
  `locked` tinyint(1) NULL DEFAULT NULL,
  PRIMARY KEY (`admin_id`) USING BTREE,
  INDEX `shop_id`(`shop_id`) USING BTREE,
  CONSTRAINT `admin_ibfk_2` FOREIGN KEY (`shop_id`) REFERENCES `shop` (`shop_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES (1, NULL, 'root', '$2a$10$Q8iZjrUv2dEKP9CcUDaPaOihlAkUcfq7qOkUtmJug42O3dTEg5FKy', '13968299999', '2020-12-15 20:39:40', '2021-01-13 14:29:42', '2020-12-15 20:39:47', 1, 0);
INSERT INTO `admin` VALUES (2, NULL, 'admin', '$2a$10$8qx31kYnnFGyvwPzPj/RzuVJj/qe4/ovzwnkZP84M4zc17YM.NGT2', '11111111111', '2020-12-15 20:40:20', '2021-01-12 17:20:47', '2020-12-15 20:40:27', 1, 0);
INSERT INTO `admin` VALUES (3, NULL, 'op', '$2a$10$heCq9fFZorIse9tzmTAJP.8xt5xzSgHbTNF7o7MS3PYcZRqepG13G', NULL, '2020-12-15 21:15:19', '2021-01-12 17:20:48', NULL, 1, 0);
INSERT INTO `admin` VALUES (4, NULL, 'dr', '$2a$10$PpLP57iluXuLBx3hqMAe5eAfaxN.uIv99f3FpEcoxhV.zkMko3N8S', NULL, '2020-12-15 21:18:23', '2021-01-12 17:20:49', NULL, 1, 0);
INSERT INTO `admin` VALUES (5, NULL, '李白3', '000000', NULL, '2020-12-15 22:27:32', '2021-01-12 17:20:52', NULL, 1, 0);
INSERT INTO `admin` VALUES (6, NULL, '李白3', '000000', NULL, '2021-01-04 18:24:48', '2021-01-12 17:20:50', NULL, 1, 0);

-- ----------------------------
-- Table structure for admin_role
-- ----------------------------
DROP TABLE IF EXISTS `admin_role`;
CREATE TABLE `admin_role`  (
  `id` int NOT NULL,
  `admin_id` int NULL DEFAULT NULL,
  `role_id` int NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `admin_id`(`admin_id`) USING BTREE,
  INDEX `role_id`(`role_id`) USING BTREE,
  CONSTRAINT `admin_role_ibfk_1` FOREIGN KEY (`admin_id`) REFERENCES `admin` (`admin_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `admin_role_ibfk_2` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of admin_role
-- ----------------------------
INSERT INTO `admin_role` VALUES (1, 2, 4);
INSERT INTO `admin_role` VALUES (2, 2, 1);
INSERT INTO `admin_role` VALUES (3, 2, 3);
INSERT INTO `admin_role` VALUES (4, 2, 2);

-- ----------------------------
-- Table structure for collection
-- ----------------------------
DROP TABLE IF EXISTS `collection`;
CREATE TABLE `collection`  (
  `collection_id` int NOT NULL COMMENT '评价id',
  `user_id` int NULL DEFAULT NULL COMMENT '用户id',
  `commodity_id` int NULL DEFAULT NULL COMMENT '商品id',
  `collection_delete` tinyint(1) UNSIGNED ZEROFILL NULL DEFAULT NULL COMMENT '收藏删除状态',
  `collection_create_time` datetime NULL DEFAULT NULL COMMENT '收藏创建时间',
  `collection_update_time` datetime NULL DEFAULT NULL COMMENT '收藏最近修改时间',
  PRIMARY KEY (`collection_id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  INDEX `commodity_id`(`commodity_id`) USING BTREE,
  CONSTRAINT `collection_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `collection_ibfk_2` FOREIGN KEY (`commodity_id`) REFERENCES `commodity` (`commodity_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of collection
-- ----------------------------

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment`  (
  `comment_id` int NOT NULL COMMENT '评价id',
  `user_id` int NULL DEFAULT NULL COMMENT '用户id',
  `commodity_id` int NULL DEFAULT NULL COMMENT '商品id',
  `comment_score` int NULL DEFAULT NULL COMMENT '评价分',
  `comment_state` tinyint(1) UNSIGNED ZEROFILL NULL DEFAULT NULL COMMENT '评价状态',
  `comment_content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '评价内容',
  `comment_delete` tinyint(1) UNSIGNED ZEROFILL NULL DEFAULT NULL COMMENT '评价删除状态',
  `comment_create_time` datetime NULL DEFAULT NULL COMMENT '评价创建时间',
  `comment_update_time` datetime NULL DEFAULT NULL COMMENT '评价最近修改时间',
  PRIMARY KEY (`comment_id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  INDEX `commodity_id`(`commodity_id`) USING BTREE,
  CONSTRAINT `comment_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `comment_ibfk_2` FOREIGN KEY (`commodity_id`) REFERENCES `commodity` (`commodity_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of comment
-- ----------------------------

-- ----------------------------
-- Table structure for commodity
-- ----------------------------
DROP TABLE IF EXISTS `commodity`;
CREATE TABLE `commodity`  (
  `commodity_id` int NOT NULL COMMENT '商品id',
  `commodity_category_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `image_id` int NULL DEFAULT NULL COMMENT '图片id',
  `shop_id` int NULL DEFAULT NULL COMMENT '商铺id',
  `commodity_state` tinyint(1) NULL DEFAULT NULL COMMENT '商品状态（默认0，0-正常，1-冻结）',
  `commodity_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品名称',
  `commodity_stock` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品库存',
  `commodity_price` decimal(10, 2) NULL DEFAULT NULL COMMENT '商品价格 ',
  `commodity_discount` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品折扣',
  `commodity_describe` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品描述',
  `commodity_delete` tinyint(1) UNSIGNED ZEROFILL NULL DEFAULT NULL COMMENT '商品删除状态（默认0，0-正常，1-删除）',
  `commodity_create_time` datetime NULL DEFAULT NULL COMMENT '商品创建时间',
  `commodity_update_time` datetime NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '商品最近修改时间',
  PRIMARY KEY (`commodity_id`) USING BTREE,
  INDEX `image_id`(`image_id`) USING BTREE,
  INDEX `shop_id`(`shop_id`) USING BTREE,
  CONSTRAINT `commodity_ibfk_1` FOREIGN KEY (`image_id`) REFERENCES `image` (`image_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `commodity_ibfk_2` FOREIGN KEY (`shop_id`) REFERENCES `shop` (`shop_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of commodity
-- ----------------------------

-- ----------------------------
-- Table structure for commodity_category
-- ----------------------------
DROP TABLE IF EXISTS `commodity_category`;
CREATE TABLE `commodity_category`  (
  `commodity_category_id` int NOT NULL AUTO_INCREMENT COMMENT '商品规格id',
  `commodity_id` int NULL DEFAULT NULL COMMENT '商品id',
  `commodity_category_parent_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '父商品规格id',
  `commodity_category_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品规格名称',
  `commodity_category_delete` tinyint(1) UNSIGNED ZEROFILL NULL DEFAULT NULL COMMENT '商品规格删除状态',
  `commodity_category_create_time` datetime NULL DEFAULT NULL COMMENT '商品规格创建时间',
  `commodity_category_update_time` datetime NULL DEFAULT NULL COMMENT '商品规格最近修改时间',
  PRIMARY KEY (`commodity_category_id`) USING BTREE,
  INDEX `commodity_id`(`commodity_id`) USING BTREE,
  CONSTRAINT `commodity_category_ibfk_1` FOREIGN KEY (`commodity_id`) REFERENCES `commodity` (`commodity_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of commodity_category
-- ----------------------------

-- ----------------------------
-- Table structure for image
-- ----------------------------
DROP TABLE IF EXISTS `image`;
CREATE TABLE `image`  (
  `image_id` int NOT NULL COMMENT '图片id',
  `image_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图片地址',
  `image_delete` tinyint(1) UNSIGNED ZEROFILL NULL DEFAULT NULL COMMENT '图片删除状态',
  `image_create_time` datetime NULL DEFAULT NULL COMMENT '图片创建时间',
  `image_update_time` datetime NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '图片最近修改时间',
  PRIMARY KEY (`image_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of image
-- ----------------------------

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order`  (
  `order_id` bigint NOT NULL,
  `user_id` int NULL DEFAULT NULL COMMENT '用户id',
  `address_id` int NULL DEFAULT NULL COMMENT '地址id',
  `shop_id` int NULL DEFAULT NULL COMMENT '商铺id',
  `order_state` tinyint(1) UNSIGNED ZEROFILL NULL DEFAULT NULL COMMENT '订单状态（0-已取消，1-待支付，2-已支付，3-已接单，4-已配送，5-已完成）',
  `order_total` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '订单总价',
  `order_create_time` datetime NULL DEFAULT NULL COMMENT '订单创建时间',
  `order_update_time` datetime NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '订单最近修改时间',
  `order_cancel_time` datetime NULL DEFAULT NULL COMMENT '订单取消时间',
  `order_paid_time` datetime NULL DEFAULT NULL COMMENT '订单已支付时间',
  `order_received_time` datetime NULL DEFAULT NULL COMMENT '订单已接单时间',
  `order_delivery_time` datetime NULL DEFAULT NULL COMMENT '订单已配送时间',
  `order_completed_time` datetime NULL DEFAULT NULL COMMENT '订单已完成时间',
  PRIMARY KEY (`order_id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  INDEX `address_id`(`address_id`) USING BTREE,
  INDEX `shop_id`(`shop_id`) USING BTREE,
  CONSTRAINT `order_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `order_ibfk_2` FOREIGN KEY (`address_id`) REFERENCES `user_address` (`address_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `order_ibfk_3` FOREIGN KEY (`shop_id`) REFERENCES `shop` (`shop_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of order
-- ----------------------------

-- ----------------------------
-- Table structure for order_detailed
-- ----------------------------
DROP TABLE IF EXISTS `order_detailed`;
CREATE TABLE `order_detailed`  (
  `order_detailed_id` int NOT NULL AUTO_INCREMENT COMMENT '订单子id',
  `order_id` bigint NULL DEFAULT NULL COMMENT '订单id',
  `commodity_id` int NULL DEFAULT NULL COMMENT '商品id',
  `commodity_category_id` int NULL DEFAULT NULL COMMENT '订单规格id',
  `order_detailed_num` int(10) UNSIGNED ZEROFILL NULL DEFAULT NULL COMMENT '订单数量',
  `order_detailed_price` decimal(10, 2) NULL DEFAULT NULL COMMENT '订单单价',
  PRIMARY KEY (`order_detailed_id`) USING BTREE,
  INDEX `commodity_category_id`(`commodity_category_id`) USING BTREE,
  INDEX `commodity_id`(`commodity_id`) USING BTREE,
  INDEX `order_id`(`order_id`) USING BTREE,
  CONSTRAINT `order_detailed_ibfk_2` FOREIGN KEY (`commodity_category_id`) REFERENCES `commodity_category` (`commodity_category_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `order_detailed_ibfk_3` FOREIGN KEY (`commodity_id`) REFERENCES `commodity` (`commodity_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `order_detailed_ibfk_4` FOREIGN KEY (`order_id`) REFERENCES `order` (`order_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of order_detailed
-- ----------------------------

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `role_id` int NOT NULL AUTO_INCREMENT COMMENT '管理员权限id',
  `role_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '管理员权限名',
  `role_name_zh` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (1, 'ROLE_user', '用户');
INSERT INTO `role` VALUES (2, 'ROLE_driver', '配送员');
INSERT INTO `role` VALUES (3, 'ROLE_operator', '操作员');
INSERT INTO `role` VALUES (4, 'ROLE_admin', '系统管理员');
INSERT INTO `role` VALUES (5, 'ROLE_dba', '数据库管理员');

-- ----------------------------
-- Table structure for shop
-- ----------------------------
DROP TABLE IF EXISTS `shop`;
CREATE TABLE `shop`  (
  `shop_id` int NOT NULL AUTO_INCREMENT COMMENT '商铺id',
  `image_id` int NULL DEFAULT NULL COMMENT '图片id',
  `shop_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商铺名称',
  `shop_content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商铺简介',
  `shop_delete` tinyint(1) NULL DEFAULT NULL COMMENT '商铺删除状态（默认0，0-正常，1-删除）',
  `shop_create_time` datetime NULL DEFAULT NULL COMMENT '商铺创建时间',
  `shop_update_time` datetime NULL DEFAULT NULL COMMENT '商铺最近修改时间',
  PRIMARY KEY (`shop_id`) USING BTREE,
  INDEX `image_id`(`image_id`) USING BTREE,
  CONSTRAINT `shop_ibfk_1` FOREIGN KEY (`image_id`) REFERENCES `image` (`image_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of shop
-- ----------------------------

-- ----------------------------
-- Table structure for shoppingcart
-- ----------------------------
DROP TABLE IF EXISTS `shoppingcart`;
CREATE TABLE `shoppingcart`  (
  `shoppingcart_id` int NOT NULL COMMENT '购物车id',
  `user_id` int NULL DEFAULT NULL COMMENT '用户id',
  `commodity_id` int NULL DEFAULT NULL COMMENT '商品id',
  `shoppingcart_num` int NULL DEFAULT NULL COMMENT '购物车数量',
  `shoppingcart_delete` tinyint(1) UNSIGNED ZEROFILL NULL DEFAULT NULL COMMENT '购物车删除状态',
  `shoppingcart_create_time` datetime NULL DEFAULT NULL COMMENT '购物车创建时间',
  `shoppingcart_update_time` datetime NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '购物车最近修改时间',
  PRIMARY KEY (`shoppingcart_id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  INDEX `commodity_id`(`commodity_id`) USING BTREE,
  CONSTRAINT `shoppingcart_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `shoppingcart_ibfk_2` FOREIGN KEY (`commodity_id`) REFERENCES `commodity` (`commodity_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of shoppingcart
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `user_id` int NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `image_id` int NULL DEFAULT NULL COMMENT '图片id',
  `user_username` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户账户',
  `user_password` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户密码',
  `user_age` int NULL DEFAULT NULL COMMENT '用户年龄',
  `user_phone` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户号码',
  `user_nickname` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户昵称',
  `user_state` tinyint(1) NULL DEFAULT NULL COMMENT '用户状态（默认0，0-正常，1-冻结）',
  `user_delete` tinyint(1) NULL DEFAULT NULL COMMENT '用户删除状态（默认0，0-正常，1-删除）',
  `user_login_time` datetime NULL DEFAULT NULL COMMENT '用户最近登录时间',
  `user_create_time` datetime NULL DEFAULT NULL COMMENT '用户创建时间',
  `user_update_time` datetime NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '用户修改时间',
  PRIMARY KEY (`user_id`) USING BTREE,
  INDEX `image_id`(`image_id`) USING BTREE,
  CONSTRAINT `user_ibfk_1` FOREIGN KEY (`image_id`) REFERENCES `image` (`image_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, NULL, '201902250125', '123456', 23, '00000000000', '小夏', 0, 1, '2021-01-13 22:20:50', '2020-12-16 21:28:51', '2021-01-13 22:20:50');
INSERT INTO `user` VALUES (2, NULL, '201902250101', '123456', 23, '00000000000', '张三', 0, 1, NULL, '2020-12-16 21:31:22', '2021-01-10 19:03:57');
INSERT INTO `user` VALUES (3, NULL, '201902250102', '123456', 21, '10000000000', '六六', 0, 1, NULL, '2020-12-16 21:32:31', '2021-01-10 19:03:59');
INSERT INTO `user` VALUES (4, NULL, '201902250104', '123456', 26, '10000200001', '向东', 0, 1, NULL, '2020-12-16 21:34:31', '2021-01-10 19:04:00');
INSERT INTO `user` VALUES (5, NULL, '201902250104', '123456', 26, '10000200001', '向六儿', 0, 1, NULL, '2020-12-16 21:37:01', '2021-01-10 19:04:02');
INSERT INTO `user` VALUES (6, NULL, '201902250104', '123456', 26, '10000200001', '东山', 0, 1, NULL, '2020-12-16 21:37:18', '2021-01-10 19:12:50');
INSERT INTO `user` VALUES (7, NULL, '201902250105', '123456', NULL, '13511112345', NULL, 0, 0, '2021-01-10 23:09:58', '2021-01-10 18:42:46', '2021-01-10 23:09:58');
INSERT INTO `user` VALUES (8, NULL, '201902250106', '123456', NULL, NULL, NULL, 0, 0, '2021-01-10 18:52:46', '2021-01-10 18:52:46', '2021-01-10 19:03:41');
INSERT INTO `user` VALUES (9, NULL, '201902250107', '123456', NULL, NULL, NULL, 0, 0, '2021-01-10 18:55:41', '2021-01-10 18:55:41', '2021-01-10 18:55:41');
INSERT INTO `user` VALUES (10, NULL, '201902250108', 'e10adc3949ba59abbe56e057f20f883e', NULL, NULL, NULL, 0, 0, '2021-01-14 11:20:47', '2021-01-11 20:06:51', '2021-01-14 11:20:47');
INSERT INTO `user` VALUES (11, NULL, '123', '202cb962ac59075b964b07152d234b70', NULL, NULL, NULL, 0, 0, '2021-01-14 11:27:30', '2021-01-14 11:27:30', '2021-01-14 11:27:30');
INSERT INTO `user` VALUES (12, NULL, '111', '698d51a19d8a121ce581499d7b701668', NULL, NULL, NULL, 0, 0, '2021-01-14 12:01:44', '2021-01-14 12:01:44', '2021-01-14 12:01:44');
INSERT INTO `user` VALUES (13, NULL, '12', 'c20ad4d76fe97759aa27a0c99bff6710', NULL, NULL, NULL, 0, 0, '2021-01-14 12:03:58', '2021-01-14 12:03:58', '2021-01-14 12:03:58');
INSERT INTO `user` VALUES (14, NULL, '333', '310dcbbf4cce62f762a2aaa148d556bd', NULL, NULL, NULL, 0, 0, '2021-01-14 12:04:58', '2021-01-14 12:04:58', '2021-01-14 12:04:58');

-- ----------------------------
-- Table structure for user_address
-- ----------------------------
DROP TABLE IF EXISTS `user_address`;
CREATE TABLE `user_address`  (
  `address_id` int NOT NULL COMMENT '地址id',
  `user_id` int NULL DEFAULT NULL COMMENT '用户id',
  `address_describe` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '详细地址',
  `address_delete` tinyint(1) UNSIGNED ZEROFILL NULL DEFAULT NULL COMMENT '地址删除状态（默认0，0-正常，1-删除）',
  `address_create_time` datetime NULL DEFAULT NULL COMMENT '地址创建时间',
  `address_update_time` datetime NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '地址最近修改时间',
  PRIMARY KEY (`address_id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  CONSTRAINT `user_address_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user_address
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
