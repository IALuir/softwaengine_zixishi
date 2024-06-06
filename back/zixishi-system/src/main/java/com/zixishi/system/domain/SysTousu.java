package com.zixishi.system.domain;

import com.zixishi.common.annotation.Excel;
import com.zixishi.common.core.domain.BaseEntity;

import java.sql.Date;

import static com.zixishi.common.utils.SecurityUtils.getLoginUser;

public class SysTousu extends BaseEntity {
    @Excel(name = "投诉ID")
    private int tousuId;
    @Excel(name = "投诉类型")
    private String tousuType;
    @Excel(name = "用户ID")
    private Long userId;
    @Excel(name = "投诉标题")
    private String tousuTitle;
    @Excel(name = "投诉状态")
    private String tousuState;
    @Excel(name = "投诉时间")
    private Date tousuCreatetime;
    @Excel(name = "投诉内容")
    private String tousuMain;

    @Excel(name = "创建者")
    public String createBy;

    @Excel(name = "投诉反馈")
    public String tousuReply;

    public int getTousuId()
    {
        return tousuId;
    }
    public void setTousuId(int tousuId)
    {
        this.tousuId = tousuId;
    }

    public String getTousuTitle(){ return tousuTitle; }
    public void setTousuTitle(String tousuTitle)
    {
        this.tousuTitle = tousuTitle;
    }


    public String getTousuType(){ return tousuType; }
    public void setTousuType(String tousuType)
    {
        this.tousuType = tousuType;
    }


    public String getTousuMain(){ return tousuMain; }
    public void setTousuMain(String tousuMain)
    {
        this.tousuMain = tousuMain;
    }


    public String getTousuState(){ return tousuState; }
    public void setTousuState(String tousuState)
    {
        this.tousuState = tousuState;
    }

    public String getCreateBy(){ return createBy; }
    public void setCreateBy(String createBy) { this.createBy = createBy; }

    public Date getTousuCreatetime(){ return tousuCreatetime; }
    public void setTousuCreatetime(Date tousuCreatetime)
    {
        this.tousuCreatetime = tousuCreatetime;
    }

    public String getTousuReply(){ return tousuReply; }
    public void setTousuReply(String tousuReply)
    {
        this.tousuReply = tousuReply;
    }

}
