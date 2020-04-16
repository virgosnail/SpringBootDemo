
create database IF NOT EXISTS test;
use test;

CREATE TABLE `device_file_info` (
  `file_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '文件ID',
  `file_name` varchar(128) NOT NULL COMMENT '文件名称',
  `file_type` integer(1) NOT NULL COMMENT '文件类型   1:录像数据 2:GPS信息 3:报警日志信息 4:ACC信息 5:设备状态信息 6:CAN数据信息 7:拨号日志信息 8:GDS信息 9:图片',
  `file_size` bigint(20) NOT NULL COMMENT '文件大小',
  `file_path` varchar(120) NOT NULL COMMENT '文件路径',
  `file_ext` varchar(128) DEFAULT NULL COMMENT '文件扩展类型',
  `ex_info` varchar(120) COMMENT '文件扩展信息',
  `finished` tinyint(1) DEFAULT '0' COMMENT '文件是否传输完成 0：未完成 1：已完成',
  `dev_id` varchar(32) NOT NULL COMMENT '设备ID',
  `chl` bigint(20) DEFAULT NULL COMMENT '通道',
  `stream_type` integer(1) DEFAULT NULL COMMENT '码流类型  1:主码流  2:辅子码流',
  `start_time` datetime DEFAULT NULL COMMENT '视频开始时间',
  `end_time` datetime DEFAULT NULL COMMENT '视频结束时间',
  `source_type` integer(1) DEFAULT NULL COMMENT '文件来源类型',
  `take_at` datetime DEFAULT NULL COMMENT '图片抓拍时间',
  `create_at` datetime DEFAULT NULL COMMENT '记录创建时间',
  `update_at` datetime DEFAULT NULL COMMENT '记录上次更新时间',
  `valid` tinyint(1) DEFAULT '1' COMMENT '记录是否逻辑存在',
  PRIMARY KEY (`file_id`)
) ENGINE=InnoDB AUTO_INCREMENT=800804 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;