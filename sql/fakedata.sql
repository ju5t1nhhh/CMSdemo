USE `cmsdemo`;

#user
INSERT INTO
`user`
VALUES
('jackie','3ef7164d1f6167cb9f2658c07d3c2f0a',now(),now()),
('phil','3ef7164d1f6167cb9f2658c07d3c2f0a',now(),now()),
('john','3ef7164d1f6167cb9f2658c07d3c2f0a',now(),now());

#user_role
INSERT INTO
`user_role`
VALUES
('jackie',1),
('phil',1),
('john',1);

#stu_source
INSERT INTO
`stu_source`(`name`)
VALUES
('招聘会'),('上门咨询');

#student
INSERT INTO
`student`(`writer_id`,`name`,`gender`,`age`,`phone`,`qq_wechat`,`email`,`college`,`major`,`walkin_date`,
`interview_note`,`marks`,`intention`,`student_source`,`classification`,`create_time`,`update_time`)
VALUES
('jackie','胡斯庭','M',20,'17812345678','704855911','qd2017hst@163.com','青岛大学','软件工程',now(),'床前明月光，疑是地上霜。',
90,'Java','招聘会','B',now(),now()),
('john','张振','M',23,'17854230489','328472291','qdzz2014@qq.com','青岛大学','软件工程',now(),'举头望明月，低头思故乡。',
80,'Java','招聘会','A',now(),now()),
('jackie','陈奕迅','M',40,'17606643176','27797875','eason2017@gmail.com','海南大学','软件工程',now(),'金拱门欢迎你',
60,'开源','上门咨询','A',now(),now());

#follow_up
INSERT INTO
`follow_up`(`stu_id`,`note`,`classification`,`create_time`,`update_time`)
VALUES
(1,'有点想来','B',now(),now()),
(1,'搞定签约','A',now(),now()),
(2,'有点难搞','C',now(),now());

#advertise
INSERT INTO
`advertise`(`user_id`,`url`,`create_time`,`update_time`)
VALUES
('jackie','www.baidu.com',now(),now()),
('jackie','www.sohu.com',now(),now()),
('john','www.hupu.com',now(),now());

#feedback
INSERT INTO
`feedback`(`stu_id`,`answer1`,`answer2`,`answer3`,`answer4`,`answer5`,`answer6`,`answer7`,`answer8`,`create_time`,`update_time`)
VALUES
(1,'1,2','1','1','3,4','1','1,2','2,4','我觉得ok。。。',now(),now()),
(2,'1,2','2','3','3,4,大数据','2','1,2','3,4','我觉得其实可以。。。',now(),now()),
(3,'3','1','3','3,人工智能','1','1,5','2,4','我真的很严格。。。',now(),now());

#fbquestion
INSERT INTO
`fbquestion`(`location`,`details`,`type`)
VALUES
(1,'您对本次讲座的哪部分内容比较感兴趣？','checkbox'),
(2,'您觉得NIIT的实训课程对您今后职业发展有所帮助吗？','radio'),
(3,'您毕业后的就业方向定位在？','checkbox'),
(4,'您是否愿意参加NIIT实训项目，更愿意参加哪种实训项目？','checkbox'),
(5,'如果您原意参加NIIT实训项目，希望开始的时间是？','checkbox'),
(6,'对于是否参加实训，您目前存在的问题是？','checkbox'),
(7,'对于专业IT实训，您更看重的是哪些方面？','checkbox'),
(8,'您对NIIT的建议和疑问可以写在下方？','text');

#fbanswer
INSERT INTO
`fbanswer`(`location`,`question_id`,`details`)
VALUES
(1,1,'就业指导'),(1,2,'IT前景'),(1,3,'NIIT实训课程'),(1,4,'NIIT人才定制企业'),(1,99,'其他'),
(2,1,'我很需要，非常有帮助'),(2,2,'暂时不需要，无帮助'),(2,3,'根本不需要'),(2,99,'其他'),
(3,1,'IT职位'),(3,2,'非IT职位'),(3,3,'就业方向尚不清晰'),(3,99,'其他'),
(4,1,'愿意'),(4,2,'考虑中'),(4,3,'VR'),(4,4,'Java+Android'),(4,5,'前端'),(4,6,'UI'),(4,7,'不愿意'),(4,99,'其他'),
(5,1,'越快越好'),(5,2,'1个月内'),(5,3,'6个月内'),(5,4,'一年后'),(5,99,'其他'),
(6,1,'计划考研'),(6,2,'自身是否适合职位'),(6,3,'经济压力'),(6,4,'就业担扰'),(6,5,'对IT不感兴趣'),(6,99,'其他'),
(7,1,'师资配备'),(7,2,'实训、住宿环境'),(7,3,'就业安置服务'),(7,4,'课程内容'),(7,5,'获得证书'),(7,99,'其他'),
(8,99,'其他');