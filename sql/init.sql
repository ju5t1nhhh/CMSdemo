#创建数据库
CREATE DATABASE IF NOT EXISTS `cmsdemo` DEFAULT CHARACTER SET utf8;
#切换数据库
USE `cmsdemo`;

#user表
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`(
  `login_id` VARCHAR(20) NOT NULL COMMENT '登录ID',
  `username` VARCHAR(20) NOT NULL COMMENT '用户名',
  `password` VARCHAR(20) NOT NULL COMMENT '密码',
  `create_time` DATETIME NOT NULL,
  `update_time` DATETIME NOT NULL,
  PRIMARY KEY (`login_id`),
  KEY `user_username_INDEX` (`username`),
  KEY `user_create_time_INDEX` (`create_time`),
  KEY `user_update_time_INDEX` (`update_time`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

#role表
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`(
  `id` INT(4) NOT NULL AUTO_INCREMENT COMMENT '角色自增ID',
  `name` VARCHAR(20) NOT NULL COMMENT '角色名',
  `create_time` DATETIME NOT NULL,
  `update_time` DATETIME NOT NULL,
  PRIMARY KEY (`id`),
  KEY `user_create_time_INDEX` (`create_time`),
  KEY `user_update_time_INDEX` (`update_time`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

#permission表
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission`(
  `id` INT(8) NOT NULL AUTO_INCREMENT COMMENT '权限自增ID',
  `name` VARCHAR(20) COMMENT '权限名',
  `url` VARCHAR(100) COMMENT '权限路径 ex:/add',
  `type` INT(4) COMMENT '权限类型',
  `parent_id` INT(8) COMMENT '父权限ID',
  `create_time` DATETIME NOT NULL,
  `update_time` DATETIME NOT NULL,
  PRIMARY KEY (`id`),
  KEY `user_type_INDEX` (`type`),
  KEY `user_parent_id_INDEX` (`parent_id`),
  KEY `user_create_time_INDEX` (`create_time`),
  KEY `user_update_time_INDEX` (`update_time`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

#user_role表
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role`(
  `user_id` VARCHAR(20) NOT NULL COMMENT '用户ID',
  `role_id` INT(4) NOT NULL COMMENT '角色ID',
  `create_time` DATETIME NOT NULL,
  `update_time` DATETIME NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `user_create_time_INDEX` (`create_time`),
  KEY `user_update_time_INDEX` (`update_time`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

#role_permission表
DROP TABLE IF EXISTS `role_permission`;
CREATE TABLE `role_permission`(
  `role_id` INT(4) NOT NULL COMMENT '角色ID',
  `perm_id` INT(8) NOT NULL COMMENT '权限ID',
  `create_time` DATETIME NOT NULL,
  `update_time` DATETIME NOT NULL,
  PRIMARY KEY (`role_id`,`perm_id`),
  KEY `user_create_time_INDEX` (`create_time`),
  KEY `user_update_time_INDEX` (`update_time`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

#advertice表
DROP TABLE IF EXISTS `advertice`;
CREATE TABLE `advertice`(
  `id` INT(12) NOT NULL AUTO_INCREMENT COMMENT 'ad自增ID',
  `user_id` INT(4) NOT NULL COMMENT '角色ID',
  `url` VARCHAR(200) NOT NULL COMMENT '广告URL',
  `create_time` DATETIME NOT NULL,
  `update_time` DATETIME NOT NULL,
  PRIMARY KEY (`id`),
  KEY `user_user_id_INDEX` (`user_id`),
  KEY `user_create_time_INDEX` (`create_time`),
  KEY `user_update_time_INDEX` (`update_time`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

#student表
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`(
  `id` INT(12) NOT NULL AUTO_INCREMENT COMMENT 'ad自增ID',
  `name` INT(4) NOT NULL COMMENT '角色ID',
  `url` VARCHAR(200) NOT NULL COMMENT '广告URL',
  `create_time` DATETIME NOT NULL,
  `update_time` DATETIME NOT NULL,
  PRIMARY KEY (`id`),
  KEY `user_user_id_INDEX` (`user_id`),
  KEY `user_create_time_INDEX` (`create_time`),
  KEY `user_update_time_INDEX` (`update_time`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

