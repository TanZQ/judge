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
drop table if exists 'ser';
CREATE TABLE 'User'(
  'username' varchar(8) character set utf8 default 'admin' comment '用户名',
  'password' varchar(8) character set utf8 default '12345678' comment '密码',
  'name' varchar(100) character set utf8 default '张三' comment '姓名',
  'sex' varchar(8) CHARACTER SET utf8 DEFAULT '男' comment '性别',
  'dateofbirth' varchar(8) character set utf8  default '20000101' comment '出生日期',
  'address' varchar(100) character set utf8 default '空' comment '家庭住址',
  'phoneno' varchar(11) default '17801127082' comment '联系方式',
  'leader' varchar(100) character set utf8 default '空' comment '推荐人',
  'community' varchar(100) default '行业分会1' comment '行业分会',
  'company' varchar(100) default '专委会1' comment '专委会',
  'identity' varchar(100) default 'waiting' comment '权限等级',
  'useornot' varchar(100) default 'no' comment '使用与否',
  primary key ('username')
)engine =InnoDB DEFAULT CHARSET = utf8 comment='用户表';


drop table if exists 'Correct';
CREATE TABLE 'Correct'(
  'Tno' int(8) default '001' comment '提案编号',
  'Tname' varchar(8) character set utf8 default '空' comment '提案名称',
  'author' varchar(100) character set utf8 default '张三' comment '提案人',
  'date' varchar(8) CHARACTER SET utf8 DEFAULT '20000101' comment '日期',
  'acceptornot' varchar(100) character set utf8 default 'no' comment '过审情况',
  'acceptpeople' varchar(100) character set utf8 default '张三' comment '过审人',
  'type' VARCHAR(100) character set utf8 default '提案' comment '类型',
  'text' varchar(500) character set utf8 default '空' comment '文本',
  primary key ('Tno')
)engine =InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET = utf8 comment='规范表';
-- ----------------------------
--  Records of `student`
-- ----------------------------
BEGIN;
INSERT INTO `User` VALUES ('admin', 'admin', '张三', '男','19980711','空','17801127082','空','空','空','manager','no');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
