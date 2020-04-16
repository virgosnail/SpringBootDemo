create database IF NOT EXISTS test;

use test;

create TABLE IF NOT EXISTS employee (
   `id` bigint(20) NOT NULL AUTO_INCREMENT,
   `name` varchar(20) DEFAULT NULL COMMENT '姓名',
   `sex` tinyint(1) DEFAULT NULL COMMENT '1: 男  2：女',
   `age` tinyint(3) DEFAULT NULL COMMENT '年龄',
   `salary` int(10) DEFAULT NULL  COMMENT '薪水',
   `comment` varchar(120) DEFAULT NULL  COMMENT '其他信息',
   `create_at` datetime DEFAULT NULL COMMENT '记录创建时间',
   `update_at` datetime DEFAULT NULL COMMENT '记录更新时间',
   `exist` tinyint(1) DEFAULT 1 COMMENT '1:逻辑存在 0:逻辑删除',
	 PRIMARY KEY (`id`)
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic COMMENT '员工表';