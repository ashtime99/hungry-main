/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80020
 Source Host           : localhost:3306
 Source Schema         : hungry

 Target Server Type    : MySQL
 Target Server Version : 80020
 File Encoding         : 65001

 Date: 09/01/2021 16:24:38
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `admin_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '管理员id',
  `admin_power_id` int(0) NULL DEFAULT NULL COMMENT '管理员权限id',
  `shop_id` int(0) NULL DEFAULT NULL COMMENT '商铺id',
  `admin_username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '管理员账户',
  `admin_password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '管理员密码',
  `admin_phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '管理员号码',
  `admin_state` char(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '管理员状态',
  `admin_create_time` datetime(0) NULL DEFAULT NULL COMMENT '管理员创建时间',
  `admin_update_time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '管理员最近修改时间',
  `admin_login_time` datetime(0) NULL DEFAULT NULL COMMENT '管理员最近登录时间',
  PRIMARY KEY (`admin_id`) USING BTREE,
  INDEX `admin_power_id`(`admin_power_id`) USING BTREE,
  INDEX `shop_id`(`shop_id`) USING BTREE,
  CONSTRAINT `admin_ibfk_1` FOREIGN KEY (`admin_power_id`) REFERENCES `admin_power` (`admin_power_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `admin_ibfk_2` FOREIGN KEY (`shop_id`) REFERENCES `shop` (`shop_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES (1, 1, NULL, 'root', '123456', '13968299999', '0', '2020-12-15 20:39:40', '2020-12-15 20:39:44', '2020-12-15 20:39:47');
INSERT INTO `admin` VALUES (2, 2, NULL, '老王', '111111', '11111111111', '0', '2020-12-15 20:40:20', '2020-12-15 20:40:23', '2020-12-15 20:40:27');
INSERT INTO `admin` VALUES (3, NULL, NULL, '李白', '000000', NULL, '1', '2020-12-15 21:15:19', '2020-12-16 22:43:53', NULL);
INSERT INTO `admin` VALUES (4, 1, NULL, '李白', '000000', NULL, '1', '2020-12-15 21:18:23', '2020-12-16 21:09:26', NULL);
INSERT INTO `admin` VALUES (5, 2, NULL, '李白3', '000000', NULL, '0', '2020-12-15 22:27:32', NULL, NULL);
INSERT INTO `admin` VALUES (6, 2, NULL, '李白3', '000000', NULL, '0', '2021-01-04 18:24:48', NULL, NULL);

-- ----------------------------
-- Table structure for admin_power
-- ----------------------------
DROP TABLE IF EXISTS `admin_power`;
CREATE TABLE `admin_power`  (
  `admin_power_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '管理员权限id',
  `admin_power_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '管理员权限名',
  PRIMARY KEY (`admin_power_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin_power
-- ----------------------------
INSERT INTO `admin_power` VALUES (1, '主管');
INSERT INTO `admin_power` VALUES (2, '配送员');

-- ----------------------------
-- Table structure for collection
-- ----------------------------
DROP TABLE IF EXISTS `collection`;
CREATE TABLE `collection`  (
  `collection_id` int(0) NOT NULL COMMENT '评价id',
  `user_id` int(0) NULL DEFAULT NULL COMMENT '用户id',
  `commodity_id` int(0) NULL DEFAULT NULL COMMENT '商品id',
  `collection_delete` tinyint(1) UNSIGNED ZEROFILL NULL DEFAULT NULL COMMENT '收藏删除状态',
  `collection_create_time` datetime(0) NULL DEFAULT NULL COMMENT '收藏创建时间',
  `collection_update_time` datetime(0) NULL DEFAULT NULL COMMENT '收藏最近修改时间',
  PRIMARY KEY (`collection_id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  INDEX `commodity_id`(`commodity_id`) USING BTREE,
  CONSTRAINT `collection_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `collection_ibfk_2` FOREIGN KEY (`commodity_id`) REFERENCES `commodity` (`commodity_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of collection
-- ----------------------------

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment`  (
  `comment_id` int(0) NOT NULL COMMENT '评价id',
  `user_id` int(0) NULL DEFAULT NULL COMMENT '用户id',
  `commodity_id` int(0) NULL DEFAULT NULL COMMENT '商品id',
  `comment_score` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '评价分',
  `comment_state` tinyint(1) UNSIGNED ZEROFILL NULL DEFAULT NULL COMMENT '评价状态',
  `comment_content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '评价内容',
  `comment_delete` tinyint(1) UNSIGNED ZEROFILL NULL DEFAULT NULL COMMENT '评价删除状态',
  `comment_create_time` datetime(0) NULL DEFAULT NULL COMMENT '评价创建时间',
  `comment_update_time` datetime(0) NULL DEFAULT NULL COMMENT '评价最近修改时间',
  PRIMARY KEY (`comment_id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  INDEX `commodity_id`(`commodity_id`) USING BTREE,
  CONSTRAINT `comment_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `comment_ibfk_2` FOREIGN KEY (`commodity_id`) REFERENCES `commodity` (`commodity_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of comment
-- ----------------------------

-- ----------------------------
-- Table structure for commodity
-- ----------------------------
DROP TABLE IF EXISTS `commodity`;
CREATE TABLE `commodity`  (
  `commodity_id` int(0) NOT NULL COMMENT '商品id',
  `image_id` int(0) NULL DEFAULT NULL COMMENT '图片id',
  `shop_id` int(0) NULL DEFAULT NULL COMMENT '商铺id',
  `commodity_state` tinyint(1) NULL DEFAULT NULL COMMENT '商品状态（默认0，0-正常，1-冻结）',
  `commodity_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品名称',
  `commodity_stock` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品库存',
  `commodity_price` decimal(10, 2) NULL DEFAULT NULL COMMENT '商品价格 ',
  `commodity_discount` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品折扣',
  `commodity_describe` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品描述',
  `commodity_delete` tinyint(1) UNSIGNED ZEROFILL NULL DEFAULT NULL COMMENT '商品删除状态（默认0，0-正常，1-删除）',
  `commodity_create_time` datetime(0) NULL DEFAULT NULL COMMENT '商品创建时间',
  `commodity_update_time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '商品最近修改时间',
  PRIMARY KEY (`commodity_id`) USING BTREE,
  INDEX `image_id`(`image_id`) USING BTREE,
  INDEX `shop_id`(`shop_id`) USING BTREE,
  CONSTRAINT `commodity_ibfk_1` FOREIGN KEY (`image_id`) REFERENCES `image` (`image_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `commodity_ibfk_2` FOREIGN KEY (`shop_id`) REFERENCES `shop` (`shop_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of commodity
-- ----------------------------

-- ----------------------------
-- Table structure for commodity_category
-- ----------------------------
DROP TABLE IF EXISTS `commodity_category`;
CREATE TABLE `commodity_category`  (
  `commodity_category_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '商品规格id',
  `commodity_id` int(0) NULL DEFAULT NULL COMMENT '商品id',
  `commodity_category_parent_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '父商品规格id',
  `commodity_category_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品规格名称',
  `commodity_category_delete` tinyint(1) UNSIGNED ZEROFILL NULL DEFAULT NULL COMMENT '商品规格删除状态',
  `commodity_category_create_time` datetime(0) NULL DEFAULT NULL COMMENT '商品规格创建时间',
  `commodity_category_update_time` datetime(0) NULL DEFAULT NULL COMMENT '商品规格最近修改时间',
  PRIMARY KEY (`commodity_category_id`) USING BTREE,
  INDEX `commodity_id`(`commodity_id`) USING BTREE,
  CONSTRAINT `commodity_category_ibfk_1` FOREIGN KEY (`commodity_id`) REFERENCES `commodity` (`commodity_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of commodity_category
-- ----------------------------

-- ----------------------------
-- Table structure for image
-- ----------------------------
DROP TABLE IF EXISTS `image`;
CREATE TABLE `image`  (
  `image_id` int(0) NOT NULL COMMENT '图片id',
  `image_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图片地址',
  `image_delete` tinyint(1) UNSIGNED ZEROFILL NULL DEFAULT NULL COMMENT '图片删除状态',
  `image_create_time` datetime(0) NULL DEFAULT NULL COMMENT '图片创建时间',
  `image_update_time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '图片最近修改时间',
  PRIMARY KEY (`image_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of image
-- ----------------------------

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order`  (
  `order_id` bigint(0) NOT NULL,
  `user_id` int(0) NULL DEFAULT NULL COMMENT '用户id',
  `address_id` int(0) NULL DEFAULT NULL COMMENT '地址id',
  `shop_id` int(0) NULL DEFAULT NULL COMMENT '商铺id',
  `order_state` tinyint(1) UNSIGNED ZEROFILL NULL DEFAULT NULL COMMENT '订单状态（0-已取消，1-待支付，2-已支付，3-已接单，4-已配送，5-已完成）',
  `order_total` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '订单总价',
  `order_create_time` datetime(0) NULL DEFAULT NULL COMMENT '订单创建时间',
  `order_update_time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '订单最近修改时间',
  `order_cancellaction_time` datetime(0) NULL DEFAULT NULL COMMENT '订单取消时间',
  `order_paid_time` datetime(0) NULL DEFAULT NULL COMMENT '订单已支付时间',
  `order_received_time` datetime(0) NULL DEFAULT NULL COMMENT '订单已接单时间',
  `order_delivery_time` datetime(0) NULL DEFAULT NULL COMMENT '订单已配送时间',
  `order_completed_time` datetime(0) NULL DEFAULT NULL COMMENT '订单已完成时间',
  PRIMARY KEY (`order_id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  INDEX `address_id`(`address_id`) USING BTREE,
  INDEX `shop_id`(`shop_id`) USING BTREE,
  CONSTRAINT `order_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `order_ibfk_2` FOREIGN KEY (`address_id`) REFERENCES `user_address` (`address_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `order_ibfk_3` FOREIGN KEY (`shop_id`) REFERENCES `shop` (`shop_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order
-- ----------------------------

-- ----------------------------
-- Table structure for order_detailed
-- ----------------------------
DROP TABLE IF EXISTS `order_detailed`;
CREATE TABLE `order_detailed`  (
  `order_detailed_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '订单子id',
  `order_id` bigint(0) NULL DEFAULT NULL COMMENT '订单id',
  `commodity_id` int(0) NULL DEFAULT NULL COMMENT '商品id',
  `commodity_category_id` int(0) NULL DEFAULT NULL COMMENT '订单规格id',
  `order_detailed_num` int(10) UNSIGNED ZEROFILL NULL DEFAULT NULL COMMENT '订单数量',
  `order_detailed_price` decimal(10, 2) NULL DEFAULT NULL COMMENT '订单单价',
  PRIMARY KEY (`order_detailed_id`) USING BTREE,
  INDEX `order_id`(`order_id`) USING BTREE,
  INDEX `commodity_category_id`(`commodity_category_id`) USING BTREE,
  INDEX `commodity_id`(`commodity_id`) USING BTREE,
  CONSTRAINT `order_detailed_ibfk_2` FOREIGN KEY (`commodity_category_id`) REFERENCES `commodity_category` (`commodity_category_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `order_detailed_ibfk_3` FOREIGN KEY (`commodity_id`) REFERENCES `commodity` (`commodity_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `order_detailed_ibfk_4` FOREIGN KEY (`order_id`) REFERENCES `order` (`order_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order_detailed
-- ----------------------------

-- ----------------------------
-- Table structure for shop
-- ----------------------------
DROP TABLE IF EXISTS `shop`;
CREATE TABLE `shop`  (
  `shop_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '商铺id',
  `image_id` int(0) NULL DEFAULT NULL COMMENT '图片id',
  `shop_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商铺名称',
  `shop_content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商铺简介',
  `shop_delete` tinyint(1) NULL DEFAULT NULL COMMENT '商铺删除状态（默认0，0-正常，1-删除）',
  `shop_create_time` datetime(0) NULL DEFAULT NULL COMMENT '商铺创建时间',
  `shop_update_time` datetime(0) NULL DEFAULT NULL COMMENT '商铺最近修改时间',
  PRIMARY KEY (`shop_id`) USING BTREE,
  INDEX `image_id`(`image_id`) USING BTREE,
  CONSTRAINT `shop_ibfk_1` FOREIGN KEY (`image_id`) REFERENCES `image` (`image_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of shop
-- ----------------------------

-- ----------------------------
-- Table structure for shoppingcart
-- ----------------------------
DROP TABLE IF EXISTS `shoppingcart`;
CREATE TABLE `shoppingcart`  (
  `shoppingcart_id` int(0) NOT NULL COMMENT '购物车id',
  `user_id` int(0) NULL DEFAULT NULL COMMENT '用户id',
  `commodity_id` int(0) NULL DEFAULT NULL COMMENT '商品id',
  `shoppingcart_num` int(0) NULL DEFAULT NULL COMMENT '购物车数量',
  `shoppingcart_delete` tinyint(1) UNSIGNED ZEROFILL NULL DEFAULT NULL COMMENT '购物车删除状态',
  `shoppingcart_create_time` datetime(0) NULL DEFAULT NULL COMMENT '购物车创建时间',
  `shoppingcart_update_time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '购物车最近修改时间',
  PRIMARY KEY (`shoppingcart_id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  INDEX `commodity_id`(`commodity_id`) USING BTREE,
  CONSTRAINT `shoppingcart_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `shoppingcart_ibfk_2` FOREIGN KEY (`commodity_id`) REFERENCES `commodity` (`commodity_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of shoppingcart
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `user_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `image_id` int(0) NULL DEFAULT NULL COMMENT '图片id',
  `user_username` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户账户',
  `user_password` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户密码',
  `user_age` int(0) NULL DEFAULT NULL COMMENT '用户年龄',
  `user_phone` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户号码',
  `user_nickname` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户昵称',
  `user_state` tinyint(1) UNSIGNED ZEROFILL NULL DEFAULT NULL COMMENT '用户状态（默认0，0-正常，1-冻结）',
  `user_delete` tinyint(1) UNSIGNED ZEROFILL NULL DEFAULT NULL COMMENT '用户删除状态（默认0，0-正常，1-删除）',
  `user_login_time` datetime(0) NULL DEFAULT NULL COMMENT '用户最近登录时间',
  `user_create_time` datetime(0) NULL DEFAULT NULL COMMENT '用户创建时间',
  `user_update_time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '用户修改时间',
  PRIMARY KEY (`user_id`) USING BTREE,
  INDEX `image_id`(`image_id`) USING BTREE,
  CONSTRAINT `user_ibfk_1` FOREIGN KEY (`image_id`) REFERENCES `image` (`image_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, NULL, '乖乖', '123456', 23, '00000000000', NULL, NULL, NULL, NULL, '2020-12-16 21:28:51', NULL);
INSERT INTO `user` VALUES (2, NULL, '201902250101', '123456', 23, '00000000000', '张三', NULL, NULL, NULL, '2020-12-16 21:31:22', NULL);
INSERT INTO `user` VALUES (3, NULL, '201902250102', '123456', 21, '10000000000', '六六', NULL, NULL, NULL, '2020-12-16 21:32:31', NULL);
INSERT INTO `user` VALUES (4, NULL, '201902250104', '123456', 26, '10000200001', '向东', NULL, NULL, NULL, '2020-12-16 21:34:31', NULL);
INSERT INTO `user` VALUES (5, NULL, '201902250104', '123456', 26, '10000200001', '向六儿', NULL, NULL, NULL, '2020-12-16 21:37:01', NULL);
INSERT INTO `user` VALUES (6, NULL, '201902250104', '123456', 26, '10000200001', '东山', NULL, NULL, NULL, '2020-12-16 21:37:18', NULL);

-- ----------------------------
-- Table structure for user_address
-- ----------------------------
DROP TABLE IF EXISTS `user_address`;
CREATE TABLE `user_address`  (
  `address_id` int(0) NOT NULL COMMENT '地址id',
  `user_id` int(0) NULL DEFAULT NULL COMMENT '用户id',
  `address_describe` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '详细地址',
  `address_delete` tinyint(1) UNSIGNED ZEROFILL NULL DEFAULT NULL COMMENT '地址删除状态（默认0，0-正常，1-删除）',
  `address_create_time` datetime(0) NULL DEFAULT NULL COMMENT '地址创建时间',
  `address_update_time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '地址最近修改时间',
  PRIMARY KEY (`address_id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  CONSTRAINT `user_address_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_address
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
