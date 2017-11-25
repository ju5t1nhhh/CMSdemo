USE `cmsdemo`;

#user表初始数据
INSERT INTO
`user`
VALUES('admin','3ef7164d1f6167cb9f2658c07d3c2f0a',now(),now());

#role表初始数据
INSERT INTO
`role`(`name`)
VALUES
('user'),
('admin');

#permission表初始数据
INSERT INTO
`permission`(`name`,`url`,`type`,`parent_id`)
VALUES


('管理页面','/manage',1,0),
('学生管理','/student',2,1),
('用户管理','/user',2,1),
('广告管理','/ads',2,1),
('反馈表管理','/table',2,1),
('添加学生','/addStudent',3,2),
('更新学生','/updateStudent',3,2),
('删除学生','/delStudent',3,2),
('查找学生','/searchStudent',3,2),
('获取学生','/getStudent',3,2),
('深层查找学生','/selectStudent',3,2),
('添加生源','/addStuSource',3,2),
('获取生源','/getStuSource',3,2),
('检查工作','/searchCount',3,2),
('添加跟进','/addFollowUp',3,2),
('删除跟进','/delFollowUp',3,2),
('更新跟进','/updateFollowUp',3,2),
('获取跟进','/searchFollowUp',3,2),
('更新反馈表','/updateFeedback',3,2),
('获取反馈表','/getFeedback',3,2),
('导出学生','/studentExcel',3,2),
('添加用户','/addUser',3,3),
('更新用户','/updateUser',3,3),
('删除用户','/delUser',3,3),
('查找用户','/searchUser',3,3),
('获取用户','/getUser',3,3),
('添加广告','/addAds',3,4),
('删除广告','/delAds',3,4),
('查找广告','/searchAds',3,4),
('深层查找广告','/selectAds',3,4),
('导出广告','/taskExcel',3,4),
('添加问题','/addQuestion',3,5),
('删除问题','/delQuestion',3,5),
('更新问题','/updateQuestion',3,5),
('添加答案','/addAnswer',3,5),
('删除答案','/delAnswer',3,5),
('更新答案','/updateAnswer',3,5),
('获取反馈表','/getTable',3,5);

#user_role表初始数据
INSERT INTO
`user_role`
VALUES
('admin',2);

#role_permission表初始数据
INSERT INTO
`role_permission`
VALUES
(1,1),(1,2),(1,4),(1,6),(1,7),(1,8),(1,9),(1,10),(1,12),(1,13),(1,15),(1,16),(1,17),(1,18),(1,19),(1,20),(1,21),
(1,27),(1,28),(1,29),(1,31),(1,38),
(2,1),(2,2),(2,3),(2,4),(2,5),(2,6),(2,7),(2,8),(2,9),(2,10),(2,11),(2,12),(2,13),(2,14),(2,15),(2,16),(2,17),
(2,18),(2,19),(2,20),(2,21),(2,22),(2,23),(2,24),(2,25),(2,26),(2,27),(2,28),(2,29),(2,30),(2,31),(2,32),(2,33),
(2,34),(2,35),(2,36),(2,37),(2,38);