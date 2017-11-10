USE `cmsdemo`;

#user
INSERT INTO
`user`
VALUES
('jackie233','justin','123456',1,now(),now()),
('phil233','phil','123456',1,now(),now()),
('john233','john','123456',1,now(),now());

#user_role
INSERT INTO
`user_role`
VALUES
('jackie233',1,now(),now()),
('phil233',1,now(),now()),
('john233',1,now(),now());

#stu_source
INSERT INTO
`stu_source`(`name`,`type`,`parent_id`,`create_time`,`update_time`)
VALUES
('Seminar',2,0,now(),now()),
('Job Market',2,0,now(),now()),
('Web',1,0,now(),now()),
('Job Site',2,3,now(),now()),
('NIIT WebSite',2,3,now(),now()),
('College',2,3,now(),now()),
('B2B',2,0,now(),now());

#student
INSERT INTO
`student`(`name`,`gender`,`age`,`phone`,`create_time`,`update_time`)
VALUES
('Apple','M',20,'17812345678',now(),now()),
('Banana','M',21,'17812345678',now(),now()),
('Orange','F',22,'17812345678',now(),now());

#user_student
INSERT INTO
`user_student`
VALUES
('jackie233',1,now(),now()),
('jackie233',2,now(),now()),
('phil233',3,now(),now());

#follow_up
INSERT INTO
`follow_up`(`stu_id`,`note`,`create_time`,`update_time`)
VALUES
(1,'Too young too navie',now(),now()),
(1,'Too Old too navie',now(),now()),
(2,'Rahahrha',now(),now());

#advertise
INSERT INTO
`advertise`(`user_id`,`url`,`create_time`,`update_time`)
VALUES
('jackie233','www.baidu.com',now(),now()),
('jackie233','www.sohu.com',now(),now()),
('jackie233','www.hupu.com',now(),now());

#feedback
INSERT INTO
`feedback`(`stu_id`,`answer`,`create_time`,`update_time`)
VALUES
(1,'A,B,C;A,B,C,asdasdasd;',now(),now());
