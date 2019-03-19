INSERT INTO ssh.admin (id, password, username) VALUES (1, 'E10ADC3949BA59ABBE56E057F20F883E', 'admin');

INSERT INTO ssh.classroom (cla_id, cla_name) VALUES (1, '鹤琴101');
INSERT INTO ssh.classroom (cla_id, cla_name) VALUES (2, '叔愚204');
INSERT INTO ssh.classroom (cla_id, cla_name) VALUES (3, '元培306');
INSERT INTO ssh.classroom (cla_id, cla_name) VALUES (4, '行知楼402');
INSERT INTO ssh.classroom (cla_id, cla_name) VALUES (5, '行知组团B505');
INSERT INTO ssh.classroom (cla_id, cla_name) VALUES (6, '行知组团A100');
INSERT INTO ssh.classroom (cla_id, cla_name) VALUES (7, '行知组团C209');
INSERT INTO ssh.classroom (cla_id, cla_name) VALUES (8, '行知组团D307');
INSERT INTO ssh.classroom (cla_id, cla_name) VALUES (9, '行知组团E208');
INSERT INTO ssh.classroom (cla_id, cla_name) VALUES (10, '行知组团F204');

INSERT INTO ssh.course (course_id, course_hour, course_name, credit, property) VALUES (1, 32, 'SSH开源框架应用', 4, '专业必修');
INSERT INTO ssh.course (course_id, course_hour, course_name, credit, property) VALUES (2, 64, '软件测试', 3, '专业选修');
INSERT INTO ssh.course (course_id, course_hour, course_name, credit, property) VALUES (3, 78, 'Java', 4, '专业必修');
INSERT INTO ssh.course (course_id, course_hour, course_name, credit, property) VALUES (4, 36, '中国传统思想', 2, '专业选修');
INSERT INTO ssh.course (course_id, course_hour, course_name, credit, property) VALUES (5, 64, '文学欣赏', 4, '专业必修');
INSERT INTO ssh.course (course_id, course_hour, course_name, credit, property) VALUES (6, 78, '古代文学', 3, '专业必修');
INSERT INTO ssh.course (course_id, course_hour, course_name, credit, property) VALUES (7, 24, '手工课', 4, '专业必修');
INSERT INTO ssh.course (course_id, course_hour, course_name, credit, property) VALUES (8, 64, '音乐课', 2, '专业选修');
INSERT INTO ssh.course (course_id, course_hour, course_name, credit, property) VALUES (9, 28, '艺术课', 2, '专业选修');
INSERT INTO ssh.course (course_id, course_hour, course_name, credit, property) VALUES (10, 56, '幼儿教育学', 5, '专业必修');
INSERT INTO ssh.course (course_id, course_hour, course_name, credit, property) VALUES (123, 13, '课程', 123, '必修');

INSERT INTO ssh.department (id, department_name) VALUES (1, '信息工程学院');
INSERT INTO ssh.department (id, department_name) VALUES (2, '教师教育学院');
INSERT INTO ssh.department (id, department_name) VALUES (3, '幼儿师范学院');
INSERT INTO ssh.department (id, department_name) VALUES (4, '商学院');
INSERT INTO ssh.department (id, department_name) VALUES (5, '文学院');
INSERT INTO ssh.department (id, department_name) VALUES (6, '旅游与管理学院');
INSERT INTO ssh.department (id, department_name) VALUES (7, '环境科学学院');
INSERT INTO ssh.department (id, department_name) VALUES (8, '食品科学学院');
INSERT INTO ssh.department (id, department_name) VALUES (9, '马克思学院');
INSERT INTO ssh.department (id, department_name) VALUES (10, '外国语学院');
INSERT INTO ssh.department (id, department_name) VALUES (11, '海外教育学院');
INSERT INTO ssh.department (id, department_name) VALUES (12, '电子工程学院');
INSERT INTO ssh.department (id, department_name) VALUES (13, '新闻传播学院');
INSERT INTO ssh.department (id, department_name) VALUES (14, '美术学院');
INSERT INTO ssh.department (id, department_name) VALUES (15, '音乐学院');
INSERT INTO ssh.department (id, department_name) VALUES (16, '体育学院');

INSERT INTO ssh.syscontrol (ifSelect) VALUES (1);

INSERT INTO ssh.class (class_id, class_name, specialty, year, department) VALUES (1, '15汉语言4班1', '汉语言文学1', 2016, 1);
INSERT INTO ssh.class (class_id, class_name, specialty, year, department) VALUES (2, '16软件工程6班', '软件工程', 2016, 1);
INSERT INTO ssh.class (class_id, class_name, specialty, year, department) VALUES (3, '17数学师范2班', '数学师范', 2017, 2);
INSERT INTO ssh.class (class_id, class_name, specialty, year, department) VALUES (4, '14计算机科学与技术3班', '计算机科学与技术', 2014, 1);
INSERT INTO ssh.class (class_id, class_name, specialty, year, department) VALUES (5, '15幼儿教育5班', '幼儿教育', 2015, 3);
INSERT INTO ssh.class (class_id, class_name, specialty, year, department) VALUES (6, '17幼儿心理6班', '幼儿心理', 2017, 3);
INSERT INTO ssh.class (class_id, class_name, specialty, year, department) VALUES (7, '15信息与计算科学1班', '信息与计算科学', 2015, 1);
INSERT INTO ssh.class (class_id, class_name, specialty, year, department) VALUES (8, '16语文师范8班', '语文师范', 2016, 2);
INSERT INTO ssh.class (class_id, class_name, specialty, year, department) VALUES (9, '14幼儿发展1班', '幼儿发展', 2014, 3);
INSERT INTO ssh.class (class_id, class_name, specialty, year, department) VALUES (10, '15大数据6班', '大数据', 2015, 1);

INSERT INTO ssh.student (stu_id, birth_date, card_number, ethnic, password, stu_name, class) VALUES (12345, '2018-05-08', '32223123123', '谢谢', 'E10ADC3949BA59ABBE56E057F20F883E', '学生', 5);

INSERT INTO ssh.teacher (tea_id, password, sex, tea_name, department) VALUES (123456, 'E10ADC3949BA59ABBE56E057F20F883E', '女', '老师', 5);
