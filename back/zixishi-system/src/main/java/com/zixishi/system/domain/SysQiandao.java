package com.zixishi.system.domain;

import com.zixishi.common.annotation.Excel;
import com.zixishi.common.core.domain.BaseEntity;

public class SysQiandao extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Excel(name = "签到记录序号")
    private Long qiandaoId;

    @Excel(name = "预约记录序号")
    private Long yuyueId;

    private String qiandaoTime;

    private String qiantuiTime;

    private int state;

    public Long getQiandaoId()
    {
        return qiandaoId;
    }

    public void setQiandaoId(Long qiandaoId)
    {
        this.qiandaoId = qiandaoId;
    }

    public Long getYuyueId()
    {
        return yuyueId;
    }

    public void setYuyueId(Long yuyueId)
    {
        this.yuyueId = yuyueId;
    }

    public String getQiandaoTime() {return qiandaoTime;}

    public void setQiandaoTime(String qiandaoTime)
    {
        this.qiandaoTime = qiandaoTime;
    }

    public String getQiantuiTime() {return qiantuiTime;}

    public void setQiantuiTime(String qiantuiTime)
    {
        this.qiantuiTime = qiantuiTime;
    }

    public int getState() {return state;}

    public void setState(int state)
    {
        this.state = state;
    }
}
