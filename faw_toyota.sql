/*
 Navicat Premium Data Transfer

 Source Server         : sa_test
 Source Server Type    : MySQL
 Source Server Version : 50650
 Source Host           : 47.97.0.123:3306
 Source Schema         : faw_toyota

 Target Server Type    : MySQL
 Target Server Version : 50650
 File Encoding         : 65001

 Date: 22/03/2021 10:07:56
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for activity_plan
-- ----------------------------
DROP TABLE IF EXISTS `activity_plan`;
CREATE TABLE `activity_plan`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '活动名称',
  `image_url` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '图片地址',
  `detail_image_url` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '活动详情图片URL',
  `start_time` datetime(0) NULL DEFAULT NULL COMMENT '活动开始时间',
  `end_time` datetime(0) NULL DEFAULT NULL COMMENT '活动结束时间',
  `status` smallint(6) NOT NULL DEFAULT 0 COMMENT '状态，1=正常，0=下架，2=过期 ,默认状态为下架',
  `activity_sort` smallint(6) NOT NULL COMMENT '活动排序',
  `activity_type` smallint(6) NOT NULL COMMENT '活动类型 1.车主端首页顶部广告位 2.车主端首页底部左侧广告位',
  `remark` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '活动描述',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 37 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Table structure for advert
-- ----------------------------
DROP TABLE IF EXISTS `advert`;
CREATE TABLE `advert`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `advert_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '广告名称',
  `advert_content` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '广告内容',
  `advert_start_time` datetime(0) NOT NULL COMMENT '开始时间',
  `advert_end_time` datetime(0) NOT NULL COMMENT '结束时间',
  `advert_images` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '广告图片:(1,2,3)',
  `advert_status` smallint(6) NOT NULL DEFAULT 0 COMMENT '状态：1=发布，0=下架，2=过期',
  `create_user` bigint(20) NOT NULL DEFAULT 0 COMMENT '创建人',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Table structure for china_distritct
-- ----------------------------
DROP TABLE IF EXISTS `china_distritct`;
CREATE TABLE `china_distritct`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `code` bigint(20) NOT NULL COMMENT '编码',
  `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '名称',
  `parent_code` bigint(20) NOT NULL COMMENT '父级编码',
  `level` tinyint(4) NOT NULL COMMENT '级别',
  `short_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '短名称',
  `merge_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '全称',
  `area_code` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '区号',
  `zip_code` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮编',
  `pinyin` varchar(129) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '拼音',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `CODEINDEX`(`code`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3222 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Table structure for config
-- ----------------------------
DROP TABLE IF EXISTS `config`;
CREATE TABLE `config`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(24) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '名称',
  `content` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '内容',
  `type` smallint(6) NOT NULL DEFAULT 1 COMMENT '类型：默认1',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Table structure for faw_car_info
-- ----------------------------
DROP TABLE IF EXISTS `faw_car_info`;
CREATE TABLE `faw_car_info`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `car_code` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '汽车编码',
  `car_name` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '汽车名称',
  `create_user` bigint(20) NOT NULL DEFAULT 0 COMMENT '创建人',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 33 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Table structure for faw_commodity
-- ----------------------------
DROP TABLE IF EXISTS `faw_commodity`;
CREATE TABLE `faw_commodity`  (
  `id` bigint(20) NOT NULL COMMENT '商品编号',
  `name` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商品名称',
  `imgurl` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品图片',
  `score` int(11) NOT NULL COMMENT '兑换积分',
  `validity_start_time` timestamp(0) NULL DEFAULT NULL COMMENT '有效期开始时间',
  `validity_end_time` timestamp(0) NULL DEFAULT NULL COMMENT '有效期结束时间',
  `status` int(11) NOT NULL DEFAULT 0 COMMENT '商品状态 0未上架,1已上架',
  `type` int(11) NULL DEFAULT 1 COMMENT '类型，1默认类型',
  `isdel` tinyint(4) NULL DEFAULT 0 COMMENT '是否删除，0正常，1删除',
  `create_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `total_count` int(11) NULL DEFAULT NULL COMMENT '总数量',
  `remain_count` int(11) NULL DEFAULT NULL COMMENT '剩余数量',
  `user_max_count` int(11) NULL DEFAULT NULL COMMENT '单用户兑换最大数量',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `name_index`(`name`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '积分兑换商品表' ROW_FORMAT = COMPACT;

-- ----------------------------
-- Table structure for faw_commodity_order
-- ----------------------------
DROP TABLE IF EXISTS `faw_commodity_order`;
CREATE TABLE `faw_commodity_order`  (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `order_no` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '兑换订单编号',
  `commodity_id` bigint(20) NOT NULL COMMENT '商品编号',
  `user_id` bigint(20) NOT NULL COMMENT '用户id',
  `number` int(11) NULL DEFAULT NULL COMMENT '兑换数量',
  `snapshot_score` int(11) NULL DEFAULT NULL COMMENT '快照积分，兑换时的商品单个积分',
  `total_score` int(11) NULL DEFAULT NULL COMMENT '订单兑换总积分',
  `remark` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `status` int(11) NULL DEFAULT 1 COMMENT '状态默认1',
  `type` int(11) NULL DEFAULT 1 COMMENT '类型默认1',
  `isdel` tinyint(4) NULL DEFAULT 0 COMMENT '是否删除，0正常，1删除',
  `create_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '兑换时间',
  `update_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `order_no_index`(`order_no`) USING BTREE,
  INDEX `create_time_index`(`create_time`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '积分兑换订单表' ROW_FORMAT = COMPACT;

-- ----------------------------
-- Table structure for faw_coupon
-- ----------------------------
DROP TABLE IF EXISTS `faw_coupon`;
CREATE TABLE `faw_coupon`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(24) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '卡券名称',
  `brief_desc` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `short_name` varchar(24) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '关联规则时使用的简称',
  `status` tinyint(4) NOT NULL COMMENT '卡券状态：1=正常,0=停用,-1=删除',
  `type` tinyint(4) NOT NULL COMMENT '卡券类型：1=丰享汇,2=非丰享汇',
  `file_id` bigint(20) NOT NULL COMMENT '图片主键',
  `remark` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '说明',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 86 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Table structure for faw_coupon_record
-- ----------------------------
DROP TABLE IF EXISTS `faw_coupon_record`;
CREATE TABLE `faw_coupon_record`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `order_id` bigint(20) NULL DEFAULT NULL COMMENT '订单id',
  `coupon_id` bigint(20) NOT NULL COMMENT '卡券id',
  `coupon_rule_id` bigint(20) NOT NULL COMMENT '卡券规则id',
  `user_id` bigint(20) NOT NULL COMMENT '用户id',
  `grant_order_no` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '发放关联订单号',
  `receive_order_no` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '领取关联订单号',
  `receive_time` datetime(0) NULL DEFAULT NULL COMMENT '领取时间',
  `status` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT 'CREATE' COMMENT '状态：CREATE=待领取,RECEIVE=已领取,OVERDUE=已过期',
  `can_reveive` tinyint(4) NOT NULL DEFAULT 0 COMMENT '可领取：-1=禁用,0=即将到来,1=可领取',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `unique_userId_ruleId_orderNo`(`order_id`, `coupon_rule_id`, `user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 416905 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Table structure for faw_coupon_rule
-- ----------------------------
DROP TABLE IF EXISTS `faw_coupon_rule`;
CREATE TABLE `faw_coupon_rule`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `rule_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '卡券规则名称',
  `coupon_id` bigint(20) NOT NULL COMMENT '卡券ID',
  `grant_start_time` datetime(0) NOT NULL COMMENT '卡券发放开始时间',
  `grant_end_time` datetime(0) NOT NULL COMMENT '卡券发放结束时间',
  `grant_type` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '发放类型：CU=客户',
  `grant_count` int(11) NOT NULL DEFAULT 0 COMMENT '已发放张数',
  `grant_condition` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '发放条件枚举',
  `grant_status` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '卡券发放状态：CREATE=未开始,PROCESSING=进行中,END=结束',
  `grant_max_count` int(11) NULL DEFAULT -1 COMMENT '最大发放张数',
  `receive_start_time` datetime(0) NOT NULL COMMENT '卡券领取开始时间',
  `receive_end_time` datetime(0) NOT NULL COMMENT '卡券领取结束时间',
  `receive_count` int(11) NOT NULL DEFAULT 0 COMMENT '领取张数',
  `receive_condition` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '领取条件枚举',
  `receive_status` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '卡券领取状态：CREATE=未开始,PROCESSING=进行中,END=结束',
  `rule_status` tinyint(4) NOT NULL DEFAULT 1 COMMENT '规则状态：1=启用,0=停用,-1=删除',
  `show_time_flag` tinyint(1) NOT NULL COMMENT '显示规则时间：1=显示,0=不显示',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 88 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Table structure for faw_distributor
-- ----------------------------
DROP TABLE IF EXISTS `faw_distributor`;
CREATE TABLE `faw_distributor`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `code` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '经销商编码',
  `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '经销商名称',
  `status` tinyint(4) NOT NULL DEFAULT 1 COMMENT '状态：1=正常,0=停用',
  `area` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '经销店所在大区',
  `province` bigint(20) NULL DEFAULT NULL COMMENT '省',
  `city` bigint(20) NULL DEFAULT NULL COMMENT '市',
  `address` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '详细地址',
  `service_hotline` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '服务热线',
  `shop_chief_status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '店总状态：1=正常，0=冻结',
  `service_advisor_status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '服务顾问：1=正常，0=冻结',
  `assessment_consultant_status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '评估顾问：1=正常，0=冻结',
  `sales_consultant_status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '销售顾问：1=正常，0=冻结',
  `integral_switch` tinyint(4) NOT NULL COMMENT '经销店下方SA角色用户是否加积分的开关  1=开(加/减积分操作) 0=关(不进行加减积分操作)',
  `effect_time` timestamp(0) NULL DEFAULT NULL COMMENT '积分开的生效时间',
  `failure_time` timestamp(0) NULL DEFAULT NULL COMMENT '积分开的失效时间',
  `dd_name` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '地担姓名',
  `open_time` timestamp(0) NULL DEFAULT NULL COMMENT '经销店开业日期',
  `create_user` bigint(20) NOT NULL COMMENT '创建人',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `province_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `city_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`, `code`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 612 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Table structure for faw_distributor_user_mapping
-- ----------------------------
DROP TABLE IF EXISTS `faw_distributor_user_mapping`;
CREATE TABLE `faw_distributor_user_mapping`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` bigint(20) NOT NULL COMMENT '用户id',
  `distributor_id` bigint(20) NOT NULL COMMENT '经销商id',
  `depart_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '部门名称',
  `position_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '职位角色名称',
  `check_status` tinyint(4) NULL DEFAULT NULL COMMENT '审核状态：-1初始状态，未提交审核 0=提交至店总，待审核，1=审核通过，2=驳回重新填写 -9 模板账号',
  `check_user` bigint(20) NULL DEFAULT NULL COMMENT '审核人id',
  `work_start` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '工作开始时间',
  `check_reason` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '审核备注',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `USERIDINDEX`(`distributor_id`, `user_id`, `depart_name`, `position_name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 70854 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Table structure for faw_message_board
-- ----------------------------
DROP TABLE IF EXISTS `faw_message_board`;
CREATE TABLE `faw_message_board`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `type` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '问题类别：参数表id',
  `sub_type` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '问题类型：参数表id',
  `feedback_user_id` bigint(20) NOT NULL COMMENT '反馈人id',
  `dis_id` bigint(20) NOT NULL COMMENT '反馈人所属经销店id',
  `area` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '所属大区',
  `feedback_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '反馈时间',
  `feedback_content` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '反馈内容',
  `handle_user_id` bigint(20) NULL DEFAULT NULL COMMENT '处理人id',
  `handle_time` timestamp(0) NULL DEFAULT NULL COMMENT '处理时间',
  `handle_content` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '处理内容',
  `status` tinyint(20) NOT NULL DEFAULT 0 COMMENT '状态：0=未处理,1=已处理',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 181 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Table structure for faw_order
-- ----------------------------
DROP TABLE IF EXISTS `faw_order`;
CREATE TABLE `faw_order`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `order_no` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '订单号',
  `order_type` tinyint(4) NOT NULL COMMENT '订单类型：1=评估、2=置换、3=新购、4=转介绍',
  `order_result` tinyint(4) NULL DEFAULT NULL COMMENT '订单结果：1=成功，0=失败',
  `order_result_reason` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '失败原因',
  `order_status` tinyint(4) NOT NULL COMMENT '订单状态：申请=1，受理=2，完成=3',
  `order_effectiveness` tinyint(4) NULL DEFAULT NULL COMMENT '订单有效性：1为有效，0为无效',
  `distributor_id` bigint(20) NOT NULL COMMENT '经销商ID',
  `evaluation_status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '评价状态：1=已评价，0=未评价',
  `sa_id` bigint(20) NOT NULL COMMENT '服务顾问ID',
  `completion_time` datetime(0) NULL DEFAULT NULL COMMENT '订单完成时间',
  `process_status` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '流程处理状态：',
  `timeout_flag` tinyint(4) NOT NULL DEFAULT 0 COMMENT '超时标记,1=超时，0=未超时',
  `test_drive_flag` tinyint(4) NULL DEFAULT NULL COMMENT '车主试驾：1=已试驾，0=未试驾',
  `create_user` bigint(20) NOT NULL DEFAULT 0 COMMENT '创建人',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `ORDERSACREATEINDEX`(`create_user`, `sa_id`) USING BTREE,
  INDEX `index3`(`sa_id`, `create_time`, `order_type`) USING BTREE,
  INDEX `index4`(`create_time`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 120785 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Table structure for faw_order_evaluation
-- ----------------------------
DROP TABLE IF EXISTS `faw_order_evaluation`;
CREATE TABLE `faw_order_evaluation`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `order_id` bigint(20) NOT NULL COMMENT '订单主键',
  `user_id` bigint(20) NULL DEFAULT NULL COMMENT '服务经理，评估经理等id',
  `distributor_id` bigint(20) NULL DEFAULT NULL COMMENT '经销商id',
  `result` tinyint(4) NOT NULL DEFAULT 0 COMMENT '评价结果：服务经理-1,5,10  经销商-1,2,3,4,5',
  `type` tinyint(4) NOT NULL DEFAULT 0 COMMENT '1=服务经理，2=经销商',
  `score` int(11) NULL DEFAULT NULL COMMENT '评价分数',
  `remark` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注-评论',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4217 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Table structure for faw_order_forward
-- ----------------------------
DROP TABLE IF EXISTS `faw_order_forward`;
CREATE TABLE `faw_order_forward`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `order_id` bigint(20) NOT NULL COMMENT '订单id',
  `distributor_id` bigint(20) NULL DEFAULT NULL COMMENT '经销店id',
  `from_user_id` bigint(20) NOT NULL COMMENT '转发人ID',
  `to_user_id` bigint(20) NOT NULL COMMENT '被转发顾问id',
  `position_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '职位名称',
  `forward_time` datetime(0) NOT NULL COMMENT '转发时间',
  `accept_status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '处理状态：2=完成，1=已受理，0=未受理',
  `accept_time` datetime(0) NULL DEFAULT NULL COMMENT '受理时间',
  `completion_time` datetime(0) NULL DEFAULT NULL COMMENT '完成时间',
  `timeout_flag` tinyint(4) NOT NULL DEFAULT 0 COMMENT '超时状态：1=超时，0=未超时',
  `timeout_reason` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '超时原因',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_order_id_user_id`(`order_id`, `to_user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 239634 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Table structure for faw_order_item
-- ----------------------------
DROP TABLE IF EXISTS `faw_order_item`;
CREATE TABLE `faw_order_item`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `order_id` bigint(20) NOT NULL COMMENT '订单id',
  `user_car_mp_id` bigint(20) NULL DEFAULT NULL COMMENT '评估-车主车辆关系id',
  `intention_car_id` bigint(20) NULL DEFAULT NULL COMMENT '新购-意向车型',
  `real_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '转介绍-用户姓名',
  `phone` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '转介绍-手机号码',
  `pre_order_id` bigint(20) NULL DEFAULT NULL COMMENT '置换单对应评估单id',
  `file_ids` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '订单上传文件ids',
  `file_a_card_ids` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '置换-新购-A卡照片',
  `file_c_card_ids` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '置换-新购-C卡照片',
  `file_c_upload_time` datetime(0) NULL DEFAULT NULL COMMENT '置换-新购-C卡照片上传时间',
  `file_ids_ht` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '订单上传文件ids后台',
  `file_a_card_ids_ht` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '置换-新购-A卡照片后台',
  `file_c_card_ids_ht` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '置换-新购-C卡照片后台',
  `test_drive` tinyint(4) NULL DEFAULT NULL COMMENT '试驾：已试驾=1，未试驾=0',
  `check_phone` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'C卡上传被校验手机号码',
  `vin_code` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'C卡上传VIN码',
  `driving_license_content` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '行驶证信息',
  `vehicle_license_upload_time` datetime(0) NULL DEFAULT NULL COMMENT '行驶证上传时间',
  `vehicle_license_img_id` bigint(20) NULL DEFAULT NULL COMMENT '行驶证对应图片文件id',
  `release_date` datetime(0) NULL DEFAULT NULL COMMENT '发证日期/上牌日期',
  `buy_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '购车人姓名',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `index2`(`order_id`, `user_car_mp_id`, `intention_car_id`, `pre_order_id`) USING BTREE,
  INDEX `PREORDERIDINDEX`(`pre_order_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 120772 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Table structure for faw_order_statistics
-- ----------------------------
DROP TABLE IF EXISTS `faw_order_statistics`;
CREATE TABLE `faw_order_statistics`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `distributor_id` bigint(20) NOT NULL COMMENT '经销商主键',
  `order_type` tinyint(4) NOT NULL COMMENT '订单类型',
  `order_timeout_total` int(11) NOT NULL DEFAULT 0 COMMENT '订单超时总数',
  `order_finish_total` int(11) NOT NULL COMMENT '订单完成总数',
  `order_total` int(11) NOT NULL DEFAULT 0 COMMENT '订单总数',
  `order_deal_count` int(11) NOT NULL DEFAULT 0 COMMENT '订单未超时成交数',
  `order_timeout_deal_count` int(11) NOT NULL DEFAULT 0 COMMENT '订单超时成交数',
  `order_timeout_no_deal_count` int(11) NULL DEFAULT 0 COMMENT '订单超时未成交数',
  `order_deal_total` int(11) NOT NULL DEFAULT 0 COMMENT '订单成交总数',
  `order_date` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '订单日期',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 584147146 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Table structure for faw_reward_rules
-- ----------------------------
DROP TABLE IF EXISTS `faw_reward_rules`;
CREATE TABLE `faw_reward_rules`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '奖励流水Id',
  `reward_code` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '奖励规则编码',
  `reward_name` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '奖励规则名称',
  `reward_remark` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '奖励规则备注',
  `reward_point` int(11) NOT NULL COMMENT '奖励积分',
  `reward_type` smallint(6) NOT NULL COMMENT '奖励规则类型 1.SA奖励规则，2为车主奖励规则',
  `reward_state` smallint(6) NOT NULL DEFAULT 1 COMMENT '奖励规则状态 1.启用，0.停用',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `create_user` bigint(20) NULL DEFAULT NULL COMMENT '创建用户ID',
  `update_user` bigint(20) NULL DEFAULT NULL COMMENT '更新用户ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 23 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '奖励规则信息表' ROW_FORMAT = COMPACT;

-- ----------------------------
-- Table structure for faw_user_car_mapping
-- ----------------------------
DROP TABLE IF EXISTS `faw_user_car_mapping`;
CREATE TABLE `faw_user_car_mapping`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` bigint(20) NOT NULL COMMENT '用户id',
  `car_id` bigint(32) NOT NULL COMMENT '车型ID',
  `buy_time` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '购买时间',
  `vin_code` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'vin码',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 62384 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Table structure for faw_user_integral
-- ----------------------------
DROP TABLE IF EXISTS `faw_user_integral`;
CREATE TABLE `faw_user_integral`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` bigint(20) NOT NULL COMMENT '服务经理，评估经理等id',
  `integral` int(11) NOT NULL COMMENT '积分',
  `direction` tinyint(4) NOT NULL COMMENT '计分方向：1加，0减',
  `order_id` bigint(20) NULL DEFAULT NULL COMMENT '订单主键',
  `order_no` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '订单编号',
  `reward_rules_id` bigint(20) NOT NULL COMMENT '规则表id',
  `reward_rules_code` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 218663 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '积分记录表' ROW_FORMAT = COMPACT;

-- ----------------------------
-- Table structure for faw_user_integral_bak200401
-- ----------------------------
DROP TABLE IF EXISTS `faw_user_integral_bak200401`;
CREATE TABLE `faw_user_integral_bak200401`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` bigint(20) NOT NULL COMMENT '服务经理，评估经理等id',
  `integral` int(11) NOT NULL COMMENT '积分',
  `direction` tinyint(4) NOT NULL COMMENT '计分方向：1加，0减',
  `order_id` bigint(20) NULL DEFAULT NULL COMMENT '订单主键',
  `order_no` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '订单编号',
  `reward_rules_id` bigint(20) NOT NULL COMMENT '规则表id',
  `reward_rules_code` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7092 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '积分记录表' ROW_FORMAT = COMPACT;

-- ----------------------------
-- Table structure for faw_user_integral_bak200601
-- ----------------------------
DROP TABLE IF EXISTS `faw_user_integral_bak200601`;
CREATE TABLE `faw_user_integral_bak200601`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` bigint(20) NOT NULL COMMENT '服务经理，评估经理等id',
  `integral` int(11) NOT NULL COMMENT '积分',
  `direction` tinyint(4) NOT NULL COMMENT '计分方向：1加，0减',
  `order_id` bigint(20) NULL DEFAULT NULL COMMENT '订单主键',
  `order_no` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '订单编号',
  `reward_rules_id` bigint(20) NOT NULL COMMENT '规则表id',
  `reward_rules_code` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 22820 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '积分记录表' ROW_FORMAT = COMPACT;

-- ----------------------------
-- Table structure for faw_user_sa_mapping
-- ----------------------------
DROP TABLE IF EXISTS `faw_user_sa_mapping`;
CREATE TABLE `faw_user_sa_mapping`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` bigint(20) NOT NULL COMMENT '用户id',
  `sa_id` bigint(20) NOT NULL COMMENT 'SAid',
  `type` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '车主与顾问的类型：SA,ESC,XS',
  `bind_status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '绑定状态：1=已绑定,0=未绑定',
  `bind_time` timestamp(0) NULL DEFAULT NULL COMMENT 'sa同意绑定车主时间',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `SAUSERINDEX`(`sa_id`, `user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 142426 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Table structure for files
-- ----------------------------
DROP TABLE IF EXISTS `files`;
CREATE TABLE `files`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `file_name` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '文件名称(test.txt)',
  `file_url` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '文件地址',
  `file_redirect_url` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '重定向地址',
  `file_remark` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '文件描述',
  `create_user` bigint(20) NOT NULL DEFAULT 0 COMMENT '创建人',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 104728 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `menu_code` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单编码',
  `menu_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '菜单名称',
  `menu_url` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单地址',
  `menu_type` smallint(6) NOT NULL DEFAULT 1 COMMENT '类型：1=后台，2=前台',
  `parent_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '父菜单id',
  `menu_status` smallint(6) NOT NULL DEFAULT 1 COMMENT '状态：0=停用，1=正常',
  `menu_order` smallint(6) UNSIGNED ZEROFILL NOT NULL DEFAULT 000000 COMMENT '菜单序号',
  `icon` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图标',
  `power_ids` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限信息',
  `create_user` bigint(20) NOT NULL DEFAULT 0 COMMENT '创建人',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 100 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Table structure for param
-- ----------------------------
DROP TABLE IF EXISTS `param`;
CREATE TABLE `param`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `param_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '参数名称',
  `param_value` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '参数值',
  `param_depth` tinyint(1) NOT NULL DEFAULT 1 COMMENT '参数级别',
  `param_type_value` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '参数类型编码',
  `parent_param_value` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '0' COMMENT '父参数值 0代表根',
  `param_status` smallint(6) NOT NULL DEFAULT 1 COMMENT '参数类型状态，1=正常，0=停用',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `PARAMINDEX01`(`param_type_value`, `param_value`, `parent_param_value`, `param_name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 145 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Table structure for param_type
-- ----------------------------
DROP TABLE IF EXISTS `param_type`;
CREATE TABLE `param_type`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `param_type_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '参数类型名称',
  `param_type_value` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '参数类型值',
  `param_type_status` smallint(6) NOT NULL DEFAULT 1 COMMENT '参数类型状态，1=正常，0=停用',
  `type` smallint(6) NOT NULL DEFAULT 1 COMMENT '类型：1=系统参数，2=业务参数',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 20 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Table structure for power
-- ----------------------------
DROP TABLE IF EXISTS `power`;
CREATE TABLE `power`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `power_code` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '权限编码',
  `power_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '权限名称',
  `power_path` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '权限地址',
  `power_type` smallint(6) NOT NULL DEFAULT 1 COMMENT '权限类型，默认=1',
  `power_status` smallint(6) NOT NULL DEFAULT 1 COMMENT '状态：0=停用，1=正常',
  `power_alias` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '权限别名',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 128 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `role_code` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色编码',
  `role_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色名称',
  `role_type` smallint(6) NOT NULL DEFAULT 1 COMMENT '类型：默认1',
  `role_status` smallint(6) NOT NULL DEFAULT 1 COMMENT '状态：0=停用，1=正常',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `create_user` bigint(20) NOT NULL DEFAULT 0 COMMENT '创建人',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `role_name`(`role_name`) USING BTREE COMMENT '角色名称唯一'
) ENGINE = InnoDB AUTO_INCREMENT = 495 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Table structure for role_area_mapping
-- ----------------------------
DROP TABLE IF EXISTS `role_area_mapping`;
CREATE TABLE `role_area_mapping`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `role_id` bigint(20) NOT NULL COMMENT '角色id',
  `area_id` bigint(20) NOT NULL COMMENT '大区id（参数表）',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1587 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Table structure for role_business_permission_mapping
-- ----------------------------
DROP TABLE IF EXISTS `role_business_permission_mapping`;
CREATE TABLE `role_business_permission_mapping`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '流水主键',
  `role_id` bigint(20) NOT NULL COMMENT '角色id',
  `type` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用于区分业务权限类型  100001=经销店id',
  `value` varchar(4096) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '业务权限所存储的值',
  `status` tinyint(4) NOT NULL DEFAULT 1 COMMENT '状态，1=生效 0=失效',
  `remark` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `reserved1` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '预留字段',
  `create_user_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '创建人',
  `update_user_id` bigint(20) NULL DEFAULT 0 COMMENT '更新人',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 468 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '业务权限与角色映射表' ROW_FORMAT = COMPACT;

-- ----------------------------
-- Table structure for role_menu_mapping
-- ----------------------------
DROP TABLE IF EXISTS `role_menu_mapping`;
CREATE TABLE `role_menu_mapping`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `role_id` bigint(20) NOT NULL COMMENT '角色id',
  `menu_id` bigint(20) NOT NULL COMMENT '用户id',
  `power_ids` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限ids(1,2,3)',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6298 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Table structure for sms_record
-- ----------------------------
DROP TABLE IF EXISTS `sms_record`;
CREATE TABLE `sms_record`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `req_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '请求标识id',
  `receive` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '接收号（手机或邮箱）',
  `content` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '消息内容',
  `type` tinyint(4) NOT NULL DEFAULT 1 COMMENT '类型：1=短信,2=邮件',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `result` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '发送结果',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 413738 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Table structure for sys_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_log`;
CREATE TABLE `sys_log`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作名称',
  `type` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作类型',
  `user_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作人名称',
  `userId` bigint(20) NOT NULL COMMENT '操作人',
  `describe` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作描述',
  `detail` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作详情',
  `ip` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'ip',
  `op_result` tinyint(1) NULL DEFAULT NULL COMMENT '执行结果',
  `err_code` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '错误异常码',
  `class_name` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '类名称',
  `method_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '方法名称',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '操作时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6708 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '操作日志记录,记录重要的操作信息' ROW_FORMAT = COMPACT;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `open_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'wx用户id',
  `union_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '关联id',
  `real_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '真实姓名',
  `user_name` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '登录账号',
  `nick_name` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户昵称(微信)',
  `password` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号码',
  `email` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `avatar_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户头像地址',
  `gender` smallint(6) NULL DEFAULT NULL COMMENT '用户的性别，值为1时是男性，值为2时是女性，值为0时是未知',
  `birthday` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '生日',
  `address` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '详细地址',
  `city` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户所在城市',
  `province` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户所在省份',
  `ip` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'ip地址',
  `country` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户所在国家',
  `language` varchar(24) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户的语言，简体中文为zh_CN',
  `type` varchar(24) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户类型,1=后台，2=前台，3=模板账号,CU=车主，FW=服务顾问，XS=销售顾问，ESC=二手车评估顾问，DZ=店总',
  `hobby` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '爱好',
  `score` int(11) NULL DEFAULT 0 COMMENT '积分值',
  `test_drive_flag` smallint(6) NULL DEFAULT NULL,
  `last_login_time` datetime(0) NULL DEFAULT NULL COMMENT '最后登录时间',
  `last_login_ip` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '最后登录ip',
  `user_status` smallint(6) NOT NULL DEFAULT 1 COMMENT '状态：0=停用，1=正常，真删除不用-1',
  `agree_privacy_time` timestamp(0) NULL DEFAULT NULL COMMENT '同意隐私时间',
  `create_user` bigint(20) NOT NULL DEFAULT 0 COMMENT '创建人',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `user_name`(`user_name`) USING BTREE COMMENT '用户账户唯一',
  INDEX `create_time`(`create_time`) USING BTREE,
  INDEX `TYPE`(`type`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 80826 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Table structure for user_bak200401
-- ----------------------------
DROP TABLE IF EXISTS `user_bak200401`;
CREATE TABLE `user_bak200401`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `open_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'wx用户id',
  `union_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '关联id',
  `real_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '真实姓名',
  `user_name` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '登录账号',
  `nick_name` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户昵称(微信)',
  `password` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号码',
  `email` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `avatar_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户头像地址',
  `gender` smallint(6) NULL DEFAULT NULL COMMENT '用户的性别，值为1时是男性，值为2时是女性，值为0时是未知',
  `birthday` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '生日',
  `address` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '详细地址',
  `city` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户所在城市',
  `province` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户所在省份',
  `ip` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'ip地址',
  `country` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户所在国家',
  `language` varchar(24) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户的语言，简体中文为zh_CN',
  `type` varchar(24) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户类型,1=后台，2=前台，3=模板账号,CU=车主，FW=服务顾问，XS=销售顾问，ESC=二手车评估顾问，DZ=店总',
  `hobby` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '爱好',
  `score` int(11) NULL DEFAULT 0 COMMENT '积分值',
  `test_drive_flag` smallint(6) NULL DEFAULT NULL,
  `last_login_time` datetime(0) NULL DEFAULT NULL COMMENT '最后登录时间',
  `last_login_ip` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '最后登录ip',
  `user_status` smallint(6) NOT NULL DEFAULT 1 COMMENT '状态：0=停用，1=正常，真删除不用-1',
  `create_user` bigint(20) NOT NULL DEFAULT 0 COMMENT '创建人',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `user_name`(`user_name`) USING BTREE COMMENT '用户账户唯一',
  INDEX `create_time`(`create_time`) USING BTREE,
  INDEX `TYPE`(`type`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7709 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Table structure for user_role_mapping
-- ----------------------------
DROP TABLE IF EXISTS `user_role_mapping`;
CREATE TABLE `user_role_mapping`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` bigint(20) NOT NULL COMMENT '用户id',
  `role_id` bigint(20) NOT NULL COMMENT '角色id',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1138 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = COMPACT;

SET FOREIGN_KEY_CHECKS = 1;
