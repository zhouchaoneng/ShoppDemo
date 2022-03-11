1:CREATE DATABASE shop CHARACTER SET utf8;
//创建数据库
2:CREATE TABLE Zuser(
	uid INT AUTO_INCREMENT  		COMMENT '用户id',
	username VARCHAR(40) UNIQUE NOT NULL  	COMMENT '用户名',
	salt_value	CHAR(36) 			COMMENT '盐值：加密操作',  
	password CHAR(32)  NOT NULL     COMMENT '密码',
	gender	INT         			COMMENT '性别:0为女:1为男',
	phone	INT					    COMMENT '电话号码',
	is_delete INT					COMMENT '删除:0为删除,1为未删除',
	avatar	VARCHAR(50)				COMMENT '头像',
	email	VARCHAR(50)				COMMENT '邮箱',
	creator	VARCHAR(40)				COMMENT '创建人',
	establish_time	DATETIME		COMMENT '创建时间',
	last_modifier	VARCHAR(40)		COMMENT '最后修改人',
	last_amend_time	DATETIME		COMMENT '最后修改时间:',
							PRIMARY KEY(uid))
	ENGINE=INNODB CHARSET=GBK;
	
	CREATE TABLE address(
	aid INT AUTO_INCREMENT  		COMMENT '主键id',
	uid INT  NOT NULL  	            COMMENT '用户id',
	aName	VARCHAR(50) 			COMMENT '收货人姓名',  
	province  VARCHAR(50)       					COMMENT '省',
	province_code  CHAR(6)     					COMMENT '省-代号',
	city	      VARCHAR(50)    			COMMENT '市',
	city_code	  CHAR(6)       			COMMENT '市-代号',
	area		VARCHAR(50) 				    COMMENT '区',
	area_code	 CHAR(6)        			COMMENT '区-代号',
	zip INT					COMMENT '邮编',
	addres	VARCHAR(100)				COMMENT '详细地址',
	phone	INT			COMMENT '手机',
	g_phone	INT			COMMENT '固定电话',
	teg	VARCHAR(20)				COMMENT '地址类型',
	is_dfull	VARCHAR(40)				COMMENT '是否默认?0默认,1不默认',
	creator	VARCHAR(40)				COMMENT '创建人',
	establish_time	DATETIME		COMMENT '创建时间',
	last_modifier	VARCHAR(40)		COMMENT '最后修改人',
	last_amend_time	DATETIME		COMMENT '最后修改时间:',
							PRIMARY KEY(aid))
	ENGINE=INNODB CHARSET=GBK;




alter table t_goods modify created_user ‘新类型’ first或after;



CREATE TABLE G_shop(
	sid INT AUTO_INCREMENT  		COMMENT '购物车主键id',
	uid INT NOT NULL  	COMMENT 		'用户id',
	gid	INT NOT NULL 			COMMENT '商品id',  
	creator	VARCHAR(40)				COMMENT '创建人',
	establish_time	DATETIME		COMMENT '创建时间',
	last_modifier	VARCHAR(40)		COMMENT '最后修改人',
	last_amend_time	DATETIME		COMMENT '最后修改时间:',
							PRIMARY KEY(sid))
	ENGINE=INNODB CHARSET=utf8;
	

