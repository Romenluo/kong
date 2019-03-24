
-- SET FOREIGN_KEY_CHECKS=0;

DROP DATABASE IF EXISTS `kong`;
-- 创建数据库
CREATE DATABASE `kong` CHARACTER SET UTF8 ;

-- 打开数据库
use kong ;
-- 1
drop table if exists t_role ;
-- 角色表
create table t_role (
	id int primary key auto_increment comment '角色编号',
	name varchar(255) comment '角色名称'
);

-- 临时数据
insert into t_role(id,name) VALUES (1,'管理员');
insert into t_role(id,name) VALUES (2,'会员');

-- 2
-- 用户表
DROP TABLE IF EXISTS t_user;

CREATE TABLE t_user(
  id INT PRIMARY KEY AUTO_INCREMENT COMMENT '用户id',
  email VARCHAR(50) NOT NULL  UNIQUE COMMENT '用户邮箱，即登录名称，也作为账号',
  password VARCHAR(32) NOT NULL COMMENT '用户登录密码',
  pet_name VARCHAR(255) COMMENT '用户昵称',
  qq VARCHAR(20) COMMENT '用户qq',
  forbidden char(1) DEFAULT 'N' COMMENT '是否禁用',
  role_id int COMMENT '用户角色id',
  FOREIGN KEY (role_id) REFERENCES t_role(id)
);

-- 3
DROP TABLE IF EXISTS t_category;
-- 分类
CREATE TABLE t_category(
  id int PRIMARY KEY AUTO_INCREMENT COMMENT '分类id',
  name VARCHAR(150) COMMENT '类型名称'
);

INSERT INTO t_category VALUES(1,'旅游景点');
INSERT INTO t_category VALUES(2,'风味小吃');
INSERT INTO t_category VALUES(3,'民族风情');
INSERT INTO t_category VALUES(4,'历史文化');
INSERT INTO t_category VALUES(5,'古茶产品');
INSERT INTO t_category VALUES(6,'古茶文化');
INSERT INTO t_category VALUES(7,'本地特产');

-- 4
DROP TABLE IF EXISTS t_note;
-- 文章表
CREATE TABLE t_note(
  id int PRIMARY KEY AUTO_INCREMENT COMMENT '简介id',
  title VARCHAR(255) NOT NULL COMMENT '标题',
  content TEXT COMMENT '内容',
  up_vote int default 0 comment '赞成' ,
  down_vote int default 0 comment '反对' ,
  category_id int COMMENT '分类id',
  FOREIGN KEY (category_id) REFERENCES t_category(id)
);
-- 5
DROP TABLE IF EXISTS t_images;
-- 图片表
CREATE TABLE t_images(
  id int PRIMARY KEY AUTO_INCREMENT COMMENT '图片id',
  title VARCHAR(255) NOT NULL COMMENT '标题',
  image_url TEXT COMMENT '图片路径',
  note_id int COMMENT '简介id',
  FOREIGN KEY (note_id) REFERENCES t_note(id)
);
-- 6
DROP  TABLE IF EXISTS t_comment;
-- 评论表
CREATE TABLE t_comment(
  id INT PRIMARY KEY AUTO_INCREMENT COMMENT '评论id',
  content VARCHAR(1024) COMMENT '评论的内容',
  user_id int COMMENT '用户id',
  note_id int COMMENT '简介id',
  comment_date DATE COMMENT '评论时间',
  up_vote int default 0 COMMENT '赞成' ,
  down_vote int default 0 COMMENT '反对' ,
  FOREIGN KEY (user_id) REFERENCES t_user(id),
  FOREIGN KEY (note_id) REFERENCES t_note(id)
);

-- 7
DROP  TABLE IF EXISTS t_information;
-- 时日资讯表
CREATE TABLE t_information(
  id int PRIMARY KEY AUTO_INCREMENT COMMENT 'id',
  title VARCHAR(255) NOT NULL COMMENT '标题',
  content TEXT COMMENT '内容',
  up_vote int default 0 COMMENT '赞成' ,
  down_vote int default 0 COMMENT '反对' ,
  info_data DATE COMMENT '实时资讯时间'
);


