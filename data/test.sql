/*
 Navicat Premium Data Transfer

 Source Server         : LocalHost
 Source Server Type    : MySQL
 Source Server Version : 50621
 Source Host           : localhost
 Source Database       : test

 Target Server Type    : MySQL
 Target Server Version : 50621
 File Encoding         : utf-8

 Date: 07/01/2018 21:28:02 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `student`
-- ----------------------------
DROP TABLE IF EXISTS `User`;

CREATE TABLE `User`(
  `id` INT(100)  NOT NULL default 001 comment 'ID',
  `username` varchar(100) character set utf8 default 'admin' comment '用户名',
  `password` varchar(100) character set utf8 default '12345678' comment '密码',
  `name` varchar(100) character set utf8 default '张三' comment '姓名',
  `sex` varchar(100) CHARACTER SET utf8 DEFAULT '男' comment '性别',
  `dateofbirth` varchar(100) character set utf8  default '20000101' comment '出生日期',
  `address` varchar(100) character set utf8 default '空' comment '家庭住址',
  `phoneno` varchar(100) default '17801127082' comment '联系方式',
  `leader` varchar(100) character set utf8 default '空' comment '推荐人',
  `community` varchar(100) default '行业分会1' comment '行业分会',
  `company` varchar(100) default '专委会1' comment '专委会',
  `identity` varchar(100) default 'waiting' comment '权限等级',
  `useornot` varchar(100) default 'no' comment '使用与否',
  primary key (`id`)
)engine =InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET = utf8 comment='用户表';


drop table if exists `Correct`;
CREATE TABLE `Correct`(
  `Tno` INT(8) NOT NULL AUTO_INCREMENT comment '提案编号',
  `Tname` varchar(100) character set utf8 default '空' comment '提案名称',
  `author` varchar(100) character set utf8 default '张三' comment '提案人',
  `date` varchar(100) CHARACTER SET utf8 DEFAULT '20000101' comment '日期',
  `acceptornot` varchar(100) character set utf8 default 'no' comment '过审情况',
  `acceptpeople` varchar(100) character set utf8 default '张三' comment '过审人',
  `type` VARCHAR(100) character set utf8 default '提案' comment '类型',
  `text` varchar(500) character set utf8 default '空' comment '文本',
  primary key (`Tno`)
)engine =InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET = utf8 comment='规范表';

DROP TABLE IF EXISTS `Suggest`;

CREATE TABLE `Suggest`(
  `id` INT(100)  NOT NULL AUTO_INCREMENT comment 'ID',
  `suggestpeople` varchar(100) character set utf8 default 'admin' comment '推荐人',
  `reason` varchar(100) character set utf8 default 'sssss' comment '推荐原因',
  `besuggested` varchar(100) character set utf8 default '张三' comment '被推荐人',
  primary key (`id`)
)engine =InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET = utf8 comment='推荐表';
-- ----------------------------
--  Records of `student`
-- ----------------------------
BEGIN;
INSERT INTO `user` VALUES ('1','222', 'admin', '张三', '男','19980711','空','17801127082','空','空','空','waiting','no');
INSERT INTO `user` VALUES ('2','admin', '123', 'lisi', '男','19980711','空','17801127082','空','空','空','manager','no');
INSERT INTO `user` VALUES ('3','333', '234', '23444', '男','19980711','空','17801127082','空','空','空','writer','no');
INSERT INTO `user` VALUES ('4','444', '345', 'hhhh', '男','19980711','空','17801127082','空','空','空','waiting','no');
INSERT INTO `Correct` VALUES ('001', '提案1', '张三', '2018-3-2','no','空','Tian','空');
INSERT INTO `Correct` VALUES ('002', '规范1', 'admin', '2018-3-2','yes','空','Guifan','空');
INSERT INTO `Correct` VALUES ('003', '提案3', 'admin', '2018-3-2','yes','空','Tian','空');
INSERT INTO `Correct` VALUES ('004', '规范2', 'admin', '2018-3-2','no','空','Guifan','空');
INSERT INTO `Suggest` VALUES ('001', 'admin', 'ssss', '3333');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
