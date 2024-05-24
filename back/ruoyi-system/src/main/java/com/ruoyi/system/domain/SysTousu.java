package com.ruoyi.system.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import java.sql.Date;

public class SysTousu extends BaseEntity {
    @Excel(name = "投诉ID")
    private Long tousuId;
    @Excel(name = "投诉类型")
    private String tousuType;
    @Excel(name = "用户ID")
    private Long tousuUserId;
    @Excel(name = "投诉标题")
    private String tousuTitle;
    @Excel(name = "投诉状态")
    private String tousuState;
    @Excel(name = "投诉时间")
    private String tousuCreatetime;
    @Excel(name = "投诉内容")
    private String tousumain;

}
