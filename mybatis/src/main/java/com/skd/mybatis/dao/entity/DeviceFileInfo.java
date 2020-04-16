package com.skd.mybatis.dao.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableLogic;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;

import java.util.Date;

@Data
@TableName("device_file_info")
public class DeviceFileInfo {
    /**
     * 文件ID
     */
    @TableId(value = "file_id",type = IdType.AUTO)
    private Long fileId;
    /**
     * 文件类型
     */
    @TableField("file_type")
    private Integer fileType;
    /**
     * 文件大小
     */
    @TableField("file_size")
    private Long fileSize;
    /**
     * 文件名称
     */
    @TableField("file_name")
    private String fileName;
    /**
     * 文件扩展类型
     */
    @TableField("file_ext")
    private String fileExt;
    /**
     * 文件路径
     */
    @TableField("file_path")
    private String filePath;
    /**
     * 文件传输完成状态
     */
    @TableField("finished")
    private Integer finished;
    /**
     * 文件扩展信息
     */
    @TableField("ex_info")
    private String exInfo;
    /**
     * 设备ID
     */
    @TableField("dev_id")
    private String devId;
    /**
     * 通道号
     */
    @TableField("chl")
    private Long chl;
    /**
     * 码流类型
     */
    @TableField("stream_type")
    private Integer streamType;
    /**
     * 文件来源类型
     */
    @TableField("source_type")
    private Integer sourceType;
    /**
     * 文件起始时间
     */
    @TableField("start_time")
    private Date startTime;
    /**
     * 文件结束时间
     */
    @TableField("end_time")
    private Date endTime;
    /**
     * 图片拍摄时间
     */
    @TableField("take_at")
    private Date takeAt;

    /**
     * 记录创建时间
     */
    @TableField("create_at")
    private Date createAt;
    /**
     * 记录更新时间
     */
    @TableField("update_at")
    private Date updateAt;
    /**
     * 记录逻辑存在状态
     */
    @TableLogic(value = "1",delval = "0")
    private Integer valid;


}