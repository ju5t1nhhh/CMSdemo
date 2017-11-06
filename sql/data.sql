USE `cmsdemo`;

#user表初始数据
INSERT INTO
`user`
VALUES('admin','admin','admin',1,now(),now());

#role表初始数据
INSERT INTO
`role`(`name`,`create_time`,`update_time`)
VALUES
('user',now(),now()),
('admin',now(),now());

#permission表初始数据
INSERT INTO
`permission`(`name`,`url`,`type`,`parent_id`,`create_time`,`update_time`)
VALUES
('管理页面','/manage',1,0,now(),now()),
('学生管理','/student',2,1,now(),now()),
('用户管理','/user',2,1,now(),now()),
('广告管理','/ads',2,1,now(),now()),
('添加学生','/addStudent',3,2,now(),now()),
('更新学生','/updateStudent',3,2,now(),now()),
('删除学生','/delStudent',3,2,now(),now()),
('查找学生','/searchStudent',3,2,now(),now()),
('获取学生','/getStudent',3,2,now(),now()),
('深层查找学生','/selectStudent',3,2,now(),now()),
('添加用户','/addUser',3,3,now(),now()),
('更新用户','/updateUser',3,3,now(),now()),
('删除用户','/delUser',3,3,now(),now()),
('查找用户','/searchUser',3,3,now(),now()),
('获取用户','/getUser',3,3,now(),now()),
('添加广告','/addAds',3,4,now(),now()),
('删除广告','/delAds',3,4,now(),now()),
('查找广告','/searchAds',3,4,now(),now()),
('深层查找广告','/selectAds',3,4,now(),now());

#user_role表初始数据
INSERT INTO
`user_role`
VALUES
('admin',2,now(),now());

#role_permission表初始数据
INSERT INTO
`role_permission`
VALUES
(1,1,now(),now()),(1,2,now(),now()),(1,4,now(),now()),(1,5,now(),now()),(1,6,now(),now()),(1,7,now(),now()),(1,8,now(),now()),
(1,9,now(),now()),(1,16,now(),now()),(1,17,now(),now()),(1,18,now(),now()),(2,1,now(),now()),(2,2,now(),now()),(2,3,now(),now()),
(2,4,now(),now()),(2,5,now(),now()),(2,6,now(),now()),(2,7,now(),now()),(2,8,now(),now()),(2,9,now(),now()),
(2,10,now(),now()),(2,11,now(),now()),(2,12,now(),now()),(2,13,now(),now()),(2,14,now(),now()),(2,15,now(),now()),(2,16,now(),now()),
(2,17,now(),now()),(2,18,now(),now()),(2,19,now(),now());