#创建数据库
CREATE DATABASE IF NOT EXISTS `cmsdemo` DEFAULT CHARACTER SET utf8;
#切换数据库
USE `cmsdemo`;

#user表
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`(
  `login_id` VARCHAR(20) NOT NULL COMMENT '登录ID',
  `role` VARCHAR(10) NOT NULL COMMENT '角色',
  `password` VARCHAR(100) NOT NULL COMMENT '密码',
  `create_time` DATETIME NOT NULL,
  `update_time` DATETIME NOT NULL,
  PRIMARY KEY (`login_id`),
  KEY `user_create_time_INDEX` (`create_time`),
  KEY `user_update_time_INDEX` (`update_time`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

#role表
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`(
  `id` INT(4) NOT NULL AUTO_INCREMENT COMMENT '角色自增ID',
  `name` VARCHAR(20) NOT NULL COMMENT '角色名',
  PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

#permission表
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission`(
  `id` INT(8) NOT NULL AUTO_INCREMENT COMMENT '权限自增ID',
  `name` VARCHAR(20) COMMENT '权限名',
  `url` VARCHAR(100) COMMENT '权限路径 ex:/add',
  `type` INT(4) COMMENT '权限类型 1页面 2菜单 3按钮',
  `parent_id` INT(8) COMMENT '父权限ID',
  PRIMARY KEY (`id`),
  KEY `permission_type_INDEX` (`type`),
  KEY `permission_parent_id_INDEX` (`parent_id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

#role_permission表
DROP TABLE IF EXISTS `role_permission`;
CREATE TABLE `role_permission`(
  `role_id` INT(4) NOT NULL COMMENT '角色ID',
  `perm_id` INT(8) NOT NULL COMMENT '权限ID',
  PRIMARY KEY (`role_id`,`perm_id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

#advertise表
DROP TABLE IF EXISTS `advertise`;
CREATE TABLE `advertise`(
  `id` INT(12) NOT NULL AUTO_INCREMENT COMMENT 'ad自增ID',
  `user_id` VARCHAR(20) NOT NULL COMMENT '用户ID',
  `url` VARCHAR(200) NOT NULL COMMENT '广告URL',
  `create_time` DATETIME NOT NULL,
  `update_time` DATETIME NOT NULL,
  PRIMARY KEY (`id`),
  KEY `advertise_user_id_INDEX` (`user_id`),
  KEY `advertise_create_time_INDEX` (`create_time`),
  KEY `advertise_update_time_INDEX` (`update_time`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

#student表
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`(
  `id` INT(12) NOT NULL AUTO_INCREMENT COMMENT '学生自增ID',
  `writer_id` VARCHAR(20) NOT NULL COMMENT '录入人ID',
  `name` VARCHAR(20) NOT NULL COMMENT '学生姓名',
  `gender` CHAR COMMENT '性别',
  `age` INT(4) COMMENT '年龄',
  `phone` VARCHAR(15) COMMENT '电话号码',
  `qq_wechat` VARCHAR(30) COMMENT 'QQ微信',
  `email` VARCHAR(30) COMMENT '邮箱',
  `college` VARCHAR(30) COMMENT '大学',
  `major` VARCHAR(30) COMMENT '专业',
  `walkin_date` DATETIME COMMENT '面试日期',
  `interview_note` TEXT COMMENT '面试记录',
  `marks` INT(4) COMMENT '笔试成绩',
  `intention` VARCHAR(100) COMMENT '学习意愿',
  `student_source` VARCHAR(100) COMMENT '学生来源',
  `classification` CHAR COMMENT '学生初面分类 A,B,C',
  `create_time` DATETIME NOT NULL,
  `update_time` DATETIME NOT NULL,
  PRIMARY KEY (`id`),
  KEY `student_writer_id_INDEX` (`writer_id`),
  KEY `student_name_INDEX` (`name`),
  KEY `student_age_INDEX` (`age`),
  KEY `student_college_INDEX` (`college`),
  KEY `student_major_INDEX` (`major`),
  KEY `student_walkin_date_INDEX` (`walkin_date`),
  KEY `student_marks_INDEX` (`marks`),
  KEY `student_student_source_INDEX` (`student_source`),
  KEY `student_classification_INDEX` (`classification`),
  KEY `student_create_time_INDEX` (`create_time`),
  KEY `student_update_time_INDEX` (`update_time`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

#follow_up表
DROP TABLE IF EXISTS `follow_up`;
CREATE TABLE `follow_up`(
  `id` INT(12) NOT NULL AUTO_INCREMENT COMMENT '跟进ID',
  `stu_id` INT(12) NOT NULL COMMENT '学生ID',
  `note` TEXT COMMENT '记录',
  `classification` CHAR COMMENT '跟进状态分类',
  `create_time` DATETIME NOT NULL,
  `update_time` DATETIME NOT NULL,
  PRIMARY KEY (`id`),
  KEY `follow_up_stu_id_INDEX` (`stu_id`),
  KEY `follow_up_classification_INDEX` (`classification`),
  KEY `follow_up_create_time_INDEX` (`create_time`),
  KEY `follow_up_update_time_INDEX` (`update_time`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

#stu_source表
DROP TABLE IF EXISTS `stu_source`;
CREATE TABLE `stu_source`(
  `id` INT(4) NOT NULL AUTO_INCREMENT COMMENT '生源自增ID',
  `name` VARCHAR(20) NOT NULL COMMENT '生源描述',
  PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

#feedback表
DROP TABLE IF EXISTS `feedback`;
CREATE TABLE `feedback`(
  `stu_id` INT(8) NOT NULL COMMENT '学生id',
  `answer1` TEXT COMMENT '回答1',
  `answer2` TEXT COMMENT '回答2',
  `answer3` TEXT COMMENT '回答3',
  `answer4` TEXT COMMENT '回答4',
  `answer5` TEXT COMMENT '回答5',
  `answer6` TEXT COMMENT '回答6',
  `answer7` TEXT COMMENT '回答7',
  `answer8` TEXT COMMENT '回答8',
  `answer9` TEXT COMMENT '回答9',
  `answer10` TEXT COMMENT '回答10',
  `answer11` TEXT COMMENT '回答11',
  `answer12` TEXT COMMENT '回答12',
  `answer13` TEXT COMMENT '回答13',
  `answer14` TEXT COMMENT '回答14',
  `answer15` TEXT COMMENT '回答15',
  `answer16` TEXT COMMENT '回答16',
  `answer17` TEXT COMMENT '回答17',
  `answer18` TEXT COMMENT '回答18',
  `answer19` TEXT COMMENT '回答19',
  `answer20` TEXT COMMENT '回答20',
  `answer21` TEXT COMMENT '回答21',
  `create_time` DATETIME NOT NULL,
  `update_time` DATETIME NOT NULL,
  PRIMARY KEY (`stu_id`),
  KEY `feedback_create_time_INDEX` (`create_time`),
  KEY `feedback_update_time_INDEX` (`update_time`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

#question表
DROP TABLE IF EXISTS `fbquestion`;
CREATE TABLE `fbquestion`(
  `id` INT(4) NOT NULL AUTO_INCREMENT COMMENT '问题自增ID',
  `location` INT(4) COMMENT '位置',
  `details` VARCHAR(200) COMMENT '问题描述',
  `type` VARCHAR(10) COMMENT '类型 checkbox radio',
  PRIMARY KEY (`id`),
  KEY `fbquestion_location_INDEX` (`location`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

#answer表
DROP TABLE IF EXISTS `fbanswer`;
CREATE TABLE `fbanswer`(
  `id` INT(4) NOT NULL AUTO_INCREMENT COMMENT '答案自增ID',
  `question_id` INT(4) COMMENT '问题id',
  `location` INT(4) COMMENT '位置',
  `details` VARCHAR(200) COMMENT '答案描述',
  PRIMARY KEY (`id`),
  KEY `fbanswer_location_INDEX` (`location`),
  KEY `fbanswer_question_id_INDEX` (`question_id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;