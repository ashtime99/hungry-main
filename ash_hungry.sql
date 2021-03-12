/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80022
 Source Host           : localhost:3306
 Source Schema         : ash_hungry

 Target Server Type    : MySQL
 Target Server Version : 80022
 File Encoding         : 65001

 Date: 12/03/2021 13:08:35
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for h_admin
-- ----------------------------
DROP TABLE IF EXISTS `h_admin`;
CREATE TABLE `h_admin`  (
  `admin_id` int NOT NULL AUTO_INCREMENT COMMENT '管理员id',
  `admin_username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '管理员账户',
  `admin_password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '管理员密码',
  `admin_face` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '管理员头像',
  `admin_phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '管理员联系号码',
  `admin_create_time` datetime NULL DEFAULT NULL COMMENT '管理员创建时间',
  `admin_update_time` datetime NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '管理员最近修改时间',
  `admin_login_time` datetime NULL DEFAULT NULL COMMENT '管理员最近登录时间',
  `admin_enabled` tinyint(1) NULL DEFAULT NULL COMMENT '管理员是否被删除',
  `admin_locked` tinyint(1) NULL DEFAULT NULL COMMENT '管理员是否被冻结',
  PRIMARY KEY (`admin_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of h_admin
-- ----------------------------
INSERT INTO `h_admin` VALUES (1, 'root', '$2a$10$Q8iZjrUv2dEKP9CcUDaPaOihlAkUcfq7qOkUtmJug42O3dTEg5FKy', 'http://127.0.0.1:8081/images/123.jpg', '13968299999', '2020-12-15 20:39:40', '2021-03-04 21:04:03', '2020-12-15 20:39:47', 1, 0);
INSERT INTO `h_admin` VALUES (2, 'admin', '$2a$10$8qx31kYnnFGyvwPzPj/RzuVJj/qe4/ovzwnkZP84M4zc17YM.NGT2', NULL, '11111111111', '2020-12-15 20:40:20', '2021-01-12 17:20:47', '2020-12-15 20:40:27', 1, 0);
INSERT INTO `h_admin` VALUES (3, 'op1', '$2a$10$heCq9fFZorIse9tzmTAJP.8xt5xzSgHbTNF7o7MS3PYcZRqepG13G', NULL, NULL, '2020-12-15 21:15:19', '2021-01-12 17:20:48', NULL, 1, 0);
INSERT INTO `h_admin` VALUES (4, 'dr', '$2a$10$PpLP57iluXuLBx3hqMAe5eAfaxN.uIv99f3FpEcoxhV.zkMko3N8S', NULL, NULL, '2020-12-15 21:18:23', '2021-01-12 17:20:49', NULL, 1, 0);

-- ----------------------------
-- Table structure for h_admin_role
-- ----------------------------
DROP TABLE IF EXISTS `h_admin_role`;
CREATE TABLE `h_admin_role`  (
  `admin_role_id` int NOT NULL AUTO_INCREMENT,
  `admin_id` int NULL DEFAULT NULL,
  `role_id` int NULL DEFAULT NULL,
  PRIMARY KEY (`admin_role_id`) USING BTREE,
  INDEX `admin_id`(`admin_id`) USING BTREE,
  INDEX `role_id`(`role_id`) USING BTREE,
  CONSTRAINT `h_admin_role_ibfk_1` FOREIGN KEY (`admin_id`) REFERENCES `h_admin` (`admin_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `h_admin_role_ibfk_2` FOREIGN KEY (`role_id`) REFERENCES `h_role` (`role_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of h_admin_role
-- ----------------------------
INSERT INTO `h_admin_role` VALUES (1, 1, 1);
INSERT INTO `h_admin_role` VALUES (8, 3, 3);
INSERT INTO `h_admin_role` VALUES (9, 4, 4);
INSERT INTO `h_admin_role` VALUES (10, 2, 3);
INSERT INTO `h_admin_role` VALUES (11, 2, 4);

-- ----------------------------
-- Table structure for h_collection
-- ----------------------------
DROP TABLE IF EXISTS `h_collection`;
CREATE TABLE `h_collection`  (
  `collection_id` int NOT NULL COMMENT '评价id',
  `user_id` int NULL DEFAULT NULL COMMENT '用户id',
  `commodity_id` int NULL DEFAULT NULL COMMENT '商品id',
  `collection_delete` tinyint(1) UNSIGNED ZEROFILL NULL DEFAULT NULL COMMENT '收藏删除状态',
  `collection_create_time` datetime NULL DEFAULT NULL COMMENT '收藏创建时间',
  `collection_update_time` datetime NULL DEFAULT NULL COMMENT '收藏最近修改时间',
  PRIMARY KEY (`collection_id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  INDEX `commodity_id`(`commodity_id`) USING BTREE,
  CONSTRAINT `h_collection_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `h_user` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `h_collection_ibfk_2` FOREIGN KEY (`commodity_id`) REFERENCES `h_commodity` (`commodity_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of h_collection
-- ----------------------------

-- ----------------------------
-- Table structure for h_comment
-- ----------------------------
DROP TABLE IF EXISTS `h_comment`;
CREATE TABLE `h_comment`  (
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
  CONSTRAINT `h_comment_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `h_user` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `h_comment_ibfk_2` FOREIGN KEY (`commodity_id`) REFERENCES `h_commodity` (`commodity_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of h_comment
-- ----------------------------

-- ----------------------------
-- Table structure for h_commodity
-- ----------------------------
DROP TABLE IF EXISTS `h_commodity`;
CREATE TABLE `h_commodity`  (
  `commodity_id` int NOT NULL COMMENT '商品id',
  `commodity_category_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品分类id',
  `commodity_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品名称',
  `commodity_stock` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品库存',
  `commodity_price` decimal(10, 2) NULL DEFAULT NULL COMMENT '商品价格 ',
  `commodity_discount` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品折扣',
  `commodity_describe` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品描述',
  `commodity_locked` tinyint(1) NULL DEFAULT NULL COMMENT '商品冻结状态（默认0，0-正常，1-冻结）',
  `commodity_enable` tinyint(1) UNSIGNED ZEROFILL NULL DEFAULT NULL COMMENT '商品删除状态（默认0，0-正常，1-删除）',
  `commodity_create_time` datetime NULL DEFAULT NULL COMMENT '商品创建时间',
  `commodity_update_time` datetime NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '商品最近修改时间',
  PRIMARY KEY (`commodity_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of h_commodity
-- ----------------------------

-- ----------------------------
-- Table structure for h_commodity_category
-- ----------------------------
DROP TABLE IF EXISTS `h_commodity_category`;
CREATE TABLE `h_commodity_category`  (
  `commodity_category_id` int NOT NULL AUTO_INCREMENT COMMENT '商品规格id',
  `commodity_id` int NULL DEFAULT NULL COMMENT '商品id',
  `commodity_category_parent_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '父商品规格id',
  `commodity_category_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品规格名称',
  `commodity_category_delete` tinyint(1) UNSIGNED ZEROFILL NULL DEFAULT NULL COMMENT '商品规格删除状态',
  `commodity_category_create_time` datetime NULL DEFAULT NULL COMMENT '商品规格创建时间',
  `commodity_category_update_time` datetime NULL DEFAULT NULL COMMENT '商品规格最近修改时间',
  PRIMARY KEY (`commodity_category_id`) USING BTREE,
  INDEX `commodity_id`(`commodity_id`) USING BTREE,
  CONSTRAINT `h_commodity_category_ibfk_1` FOREIGN KEY (`commodity_id`) REFERENCES `h_commodity` (`commodity_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of h_commodity_category
-- ----------------------------

-- ----------------------------
-- Table structure for h_image
-- ----------------------------
DROP TABLE IF EXISTS `h_image`;
CREATE TABLE `h_image`  (
  `image_id` int NOT NULL COMMENT '图片id',
  `image_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图片地址',
  `image_delete` tinyint(1) UNSIGNED ZEROFILL NULL DEFAULT NULL COMMENT '图片删除状态',
  `image_create_time` datetime NULL DEFAULT NULL COMMENT '图片创建时间',
  `image_update_time` datetime NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '图片最近修改时间',
  PRIMARY KEY (`image_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of h_image
-- ----------------------------

-- ----------------------------
-- Table structure for h_menu
-- ----------------------------
DROP TABLE IF EXISTS `h_menu`;
CREATE TABLE `h_menu`  (
  `menu_id` int NOT NULL AUTO_INCREMENT COMMENT '菜单id',
  `menu_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单url',
  `menu_path` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单path',
  `menu_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单名字',
  `menu_component` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单组件',
  `menu_icon` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单图标',
  `menu_enable` tinyint NULL DEFAULT NULL COMMENT '菜单是否启用',
  `menu_locked` tinyint NULL DEFAULT NULL COMMENT '菜单是否冻结',
  `menu_parent_id` int NULL DEFAULT NULL COMMENT '菜单父id',
  PRIMARY KEY (`menu_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 23 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of h_menu
-- ----------------------------
INSERT INTO `h_menu` VALUES (1, '/', NULL, '所有', NULL, NULL, 1, 0, NULL);
INSERT INTO `h_menu` VALUES (2, '/', '/home', '订单管理', 'Home', 'fa fa-file', 1, 0, 1);
INSERT INTO `h_menu` VALUES (3, '/', '/home', '人员管理', 'Home', 'fa fa-user-circle', 1, 0, 1);
INSERT INTO `h_menu` VALUES (4, '/', '/home', '统计管理', 'Home', 'fa fa-line-chart', 1, 0, 1);
INSERT INTO `h_menu` VALUES (5, '/', '/home', '系统管理', 'Home', 'fa fa-database', 1, 0, 1);
INSERT INTO `h_menu` VALUES (6, '/order/all', '/ord/all', '所有订单', 'OrdAll', NULL, 1, 0, 2);
INSERT INTO `h_menu` VALUES (7, '/order/beReceived/**', '/ord/beReceived', '待接收的订单', 'OrdbeReceived', NULL, 1, 0, 2);
INSERT INTO `h_menu` VALUES (8, '/order/beDelivered/**', '/ord/beDelivered', '待配送的订单', 'OrdbeDelivered', NULL, 1, 0, 2);
INSERT INTO `h_menu` VALUES (9, '/order/pending/**', '/ord/pending', '待处理的订单', 'OrdPending', NULL, 1, 0, 2);
INSERT INTO `h_menu` VALUES (10, '/emp/dr/**', '/emp/dr', '配送员管理', 'EmpDr', NULL, 1, 0, 3);
INSERT INTO `h_menu` VALUES (13, '/statistics/all', '/sta/all', '综合数据统计', 'StaAll', NULL, 1, 0, 4);
INSERT INTO `h_menu` VALUES (15, '/emp/op/**', '/emp/op', '操作员管理', 'EmpOp', NULL, 1, 0, 3);
INSERT INTO `h_menu` VALUES (16, '/system/data', '/sys/data', '备份数据库', 'SysData', NULL, 1, 0, 5);
INSERT INTO `h_menu` VALUES (17, '/system/admin', '/sys/admin', '管理员管理', 'SysAdmin', NULL, 1, 0, 5);
INSERT INTO `h_menu` VALUES (18, '/system/log', '/sys/log', '操作日志管理', 'SysLog', NULL, 1, 0, 5);
INSERT INTO `h_menu` VALUES (19, '/system/basic', '/sys/basic', '基础信息设置', 'SysBasic', NULL, 1, 0, 5);
INSERT INTO `h_menu` VALUES (20, '/system/config', '/sys/config', '系统管理', 'SysConfig', NULL, 1, 0, 5);
INSERT INTO `h_menu` VALUES (21, '/system/init', '/sys/init', '初始化数据库', 'SysInit', NULL, 1, 0, 5);

-- ----------------------------
-- Table structure for h_menu_role
-- ----------------------------
DROP TABLE IF EXISTS `h_menu_role`;
CREATE TABLE `h_menu_role`  (
  `menu_role_id` int NOT NULL AUTO_INCREMENT,
  `menu_id` int NULL DEFAULT NULL,
  `role_id` int NULL DEFAULT NULL,
  PRIMARY KEY (`menu_role_id`) USING BTREE,
  INDEX `menu_id`(`menu_id`) USING BTREE,
  INDEX `role_id`(`role_id`) USING BTREE,
  CONSTRAINT `h_menu_role_ibfk_1` FOREIGN KEY (`menu_id`) REFERENCES `h_menu` (`menu_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `h_menu_role_ibfk_2` FOREIGN KEY (`role_id`) REFERENCES `h_role` (`role_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 66 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of h_menu_role
-- ----------------------------
INSERT INTO `h_menu_role` VALUES (11, 7, 3);
INSERT INTO `h_menu_role` VALUES (12, 8, 4);
INSERT INTO `h_menu_role` VALUES (29, 3, 2);
INSERT INTO `h_menu_role` VALUES (30, 10, 2);
INSERT INTO `h_menu_role` VALUES (31, 15, 2);
INSERT INTO `h_menu_role` VALUES (32, 4, 2);
INSERT INTO `h_menu_role` VALUES (33, 13, 2);
INSERT INTO `h_menu_role` VALUES (34, 16, 2);
INSERT INTO `h_menu_role` VALUES (35, 17, 2);
INSERT INTO `h_menu_role` VALUES (36, 18, 2);
INSERT INTO `h_menu_role` VALUES (37, 19, 2);
INSERT INTO `h_menu_role` VALUES (48, 1, 1);
INSERT INTO `h_menu_role` VALUES (49, 2, 1);
INSERT INTO `h_menu_role` VALUES (50, 6, 1);
INSERT INTO `h_menu_role` VALUES (51, 7, 1);
INSERT INTO `h_menu_role` VALUES (52, 8, 1);
INSERT INTO `h_menu_role` VALUES (53, 9, 1);
INSERT INTO `h_menu_role` VALUES (54, 3, 1);
INSERT INTO `h_menu_role` VALUES (55, 10, 1);
INSERT INTO `h_menu_role` VALUES (56, 15, 1);
INSERT INTO `h_menu_role` VALUES (57, 4, 1);
INSERT INTO `h_menu_role` VALUES (58, 13, 1);
INSERT INTO `h_menu_role` VALUES (59, 5, 1);
INSERT INTO `h_menu_role` VALUES (60, 16, 1);
INSERT INTO `h_menu_role` VALUES (61, 17, 1);
INSERT INTO `h_menu_role` VALUES (62, 18, 1);
INSERT INTO `h_menu_role` VALUES (63, 19, 1);
INSERT INTO `h_menu_role` VALUES (64, 20, 1);
INSERT INTO `h_menu_role` VALUES (65, 21, 1);

-- ----------------------------
-- Table structure for h_order
-- ----------------------------
DROP TABLE IF EXISTS `h_order`;
CREATE TABLE `h_order`  (
  `order_id` bigint NOT NULL COMMENT '订单id',
  `order_status_id` int NULL DEFAULT NULL COMMENT '订单状态',
  `user_id` int NULL DEFAULT NULL COMMENT '用户id',
  `address_id` int NULL DEFAULT NULL COMMENT '地址id',
  `operator_id` int NULL DEFAULT NULL COMMENT '操作员id',
  `order_delivery` tinyint(1) NULL DEFAULT NULL COMMENT '是否配送',
  `driver_id` int NULL DEFAULT NULL COMMENT '配送员id',
  `order_total` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '订单总价',
  `order_create_time` datetime NULL DEFAULT NULL COMMENT '订单创建时间',
  `order_update_time` datetime NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '订单最近修改时间',
  `order_cancel_time` datetime NULL DEFAULT NULL COMMENT '订单取消时间',
  `order_paid_time` datetime NULL DEFAULT NULL COMMENT '订单已支付时间',
  `order_received_time` datetime NULL DEFAULT NULL COMMENT '订单已接单时间',
  `order_delivery_time` datetime NULL DEFAULT NULL COMMENT '订单已配送时间',
  `order_completed_time` datetime NULL DEFAULT NULL COMMENT '订单已完成时间',
  `order_dining_style` tinyint(1) NULL DEFAULT NULL COMMENT '就餐方式',
  `order_remarks` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '订单备注',
  PRIMARY KEY (`order_id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  INDEX `address_id`(`address_id`) USING BTREE,
  INDEX `order_status_id`(`order_status_id`) USING BTREE,
  CONSTRAINT `h_order_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `h_user` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `h_order_ibfk_2` FOREIGN KEY (`address_id`) REFERENCES `h_user_address` (`address_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `h_order_ibfk_3` FOREIGN KEY (`order_status_id`) REFERENCES `h_order_status` (`order_status_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of h_order
-- ----------------------------

-- ----------------------------
-- Table structure for h_order_detailed
-- ----------------------------
DROP TABLE IF EXISTS `h_order_detailed`;
CREATE TABLE `h_order_detailed`  (
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
  CONSTRAINT `h_order_detailed_ibfk_1` FOREIGN KEY (`commodity_category_id`) REFERENCES `h_commodity_category` (`commodity_category_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `h_order_detailed_ibfk_2` FOREIGN KEY (`commodity_id`) REFERENCES `h_commodity` (`commodity_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `h_order_detailed_ibfk_3` FOREIGN KEY (`order_id`) REFERENCES `h_order` (`order_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of h_order_detailed
-- ----------------------------

-- ----------------------------
-- Table structure for h_order_status
-- ----------------------------
DROP TABLE IF EXISTS `h_order_status`;
CREATE TABLE `h_order_status`  (
  `order_status_id` int NOT NULL,
  `order_status_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`order_status_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of h_order_status
-- ----------------------------

-- ----------------------------
-- Table structure for h_role
-- ----------------------------
DROP TABLE IF EXISTS `h_role`;
CREATE TABLE `h_role`  (
  `role_id` int NOT NULL AUTO_INCREMENT COMMENT '管理员权限id',
  `role_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '管理员权限名',
  `role_name_zh` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of h_role
-- ----------------------------
INSERT INTO `h_role` VALUES (1, 'ROLE_dba', '数据库管理员');
INSERT INTO `h_role` VALUES (2, 'ROLE_admin', '系统管理员');
INSERT INTO `h_role` VALUES (3, 'ROLE_operator', '操作员');
INSERT INTO `h_role` VALUES (4, 'ROLE_driver', '配送员');

-- ----------------------------
-- Table structure for h_shoppingcart
-- ----------------------------
DROP TABLE IF EXISTS `h_shoppingcart`;
CREATE TABLE `h_shoppingcart`  (
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
  CONSTRAINT `h_shoppingcart_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `h_user` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `h_shoppingcart_ibfk_2` FOREIGN KEY (`commodity_id`) REFERENCES `h_commodity` (`commodity_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of h_shoppingcart
-- ----------------------------

-- ----------------------------
-- Table structure for h_user
-- ----------------------------
DROP TABLE IF EXISTS `h_user`;
CREATE TABLE `h_user`  (
  `user_id` int NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `user_username` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户账户',
  `user_password` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户密码',
  `user_age` int NULL DEFAULT NULL COMMENT '用户年龄',
  `user_phone` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户号码',
  `user_nickname` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户昵称',
  `user_locked` tinyint(1) NULL DEFAULT NULL COMMENT '用户冻结状态',
  `user_enabled` tinyint(1) NULL DEFAULT NULL COMMENT '用户删除状态',
  `user_login_time` datetime NULL DEFAULT NULL COMMENT '用户最近登录时间',
  `user_create_time` datetime NULL DEFAULT NULL COMMENT '用户创建时间',
  `user_update_time` datetime NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '用户修改时间',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 19 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of h_user
-- ----------------------------
INSERT INTO `h_user` VALUES (1, '201902250125', '123456', 23, '00000000000', '小夏', 0, 1, '2021-01-13 22:20:50', '2020-12-16 21:28:51', '2021-01-13 22:20:50');
INSERT INTO `h_user` VALUES (2, '201902250101', '123456', 23, '00000000000', '张三', 0, 1, NULL, '2020-12-16 21:31:22', '2021-01-10 19:03:57');
INSERT INTO `h_user` VALUES (3, '201902250102', '123456', 21, '10000000000', '六六', 0, 1, NULL, '2020-12-16 21:32:31', '2021-01-10 19:03:59');
INSERT INTO `h_user` VALUES (4, '201902250104', '123456', 26, '10000200001', '向东', 0, 1, NULL, '2020-12-16 21:34:31', '2021-01-10 19:04:00');
INSERT INTO `h_user` VALUES (5, '201902250104', '123456', 26, '10000200001', '向六儿', 0, 1, NULL, '2020-12-16 21:37:01', '2021-01-10 19:04:02');
INSERT INTO `h_user` VALUES (6, '201902250104', '123456', 26, '10000200001', '东山', 0, 1, NULL, '2020-12-16 21:37:18', '2021-01-10 19:12:50');
INSERT INTO `h_user` VALUES (7, '201902250105', '123456', NULL, '13511112345', NULL, 0, 1, '2021-01-10 23:09:58', '2021-01-10 18:42:46', '2021-01-26 19:52:58');
INSERT INTO `h_user` VALUES (8, '201902250106', '123456', NULL, NULL, NULL, 0, 1, '2021-01-10 18:52:46', '2021-01-10 18:52:46', '2021-01-26 19:52:59');
INSERT INTO `h_user` VALUES (9, '201902250107', '123456', NULL, NULL, NULL, 0, 1, '2021-01-10 18:55:41', '2021-01-10 18:55:41', '2021-01-26 19:53:00');
INSERT INTO `h_user` VALUES (10, '201902250108', 'e10adc3949ba59abbe56e057f20f883e', NULL, NULL, NULL, 0, 1, '2021-01-14 11:20:47', '2021-01-11 20:06:51', '2021-01-26 19:53:01');
INSERT INTO `h_user` VALUES (11, '123', '202cb962ac59075b964b07152d234b70', NULL, NULL, NULL, 0, 1, '2021-01-14 11:27:30', '2021-01-14 11:27:30', '2021-01-26 19:53:02');
INSERT INTO `h_user` VALUES (12, '111', '698d51a19d8a121ce581499d7b701668', NULL, NULL, NULL, 0, 1, '2021-01-14 12:01:44', '2021-01-14 12:01:44', '2021-01-26 19:53:03');
INSERT INTO `h_user` VALUES (13, '12', 'c20ad4d76fe97759aa27a0c99bff6710', NULL, NULL, NULL, 0, 1, '2021-01-14 12:03:58', '2021-01-14 12:03:58', '2021-01-26 19:53:05');
INSERT INTO `h_user` VALUES (19, '201902250135', '123', 0, '', '123', 0, 1, NULL, '2021-02-10 16:27:09', NULL);

-- ----------------------------
-- Table structure for h_user_address
-- ----------------------------
DROP TABLE IF EXISTS `h_user_address`;
CREATE TABLE `h_user_address`  (
  `address_id` int NOT NULL COMMENT '地址id',
  `user_id` int NULL DEFAULT NULL COMMENT '用户id',
  `address_describe` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '详细地址',
  `address_delete` tinyint(1) UNSIGNED ZEROFILL NULL DEFAULT NULL COMMENT '地址删除状态（默认0，0-正常，1-删除）',
  `address_create_time` datetime NULL DEFAULT NULL COMMENT '地址创建时间',
  `address_update_time` datetime NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '地址最近修改时间',
  PRIMARY KEY (`address_id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  CONSTRAINT `h_user_address_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `h_user` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of h_user_address
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
