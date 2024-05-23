package com.ruoyi.system.domain;
import java.sql.Date;
import java.text.SimpleDateFormat;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

public class SysZuowei extends BaseEntity{
    private static final long serialVersionUID = 1L;

    @Excel(name = "座位ID")
    private String zuoweiId;

    @Excel(name = "预约记录序号")
    private Long yuyueId;

    @Excel(name = "被预约次数")
    private Long zuoweiYuyueNumber;

    @Excel(name = "座位状态")
    private boolean zuoweiState;

    public String getZuoweiId()
    {
        return zuoweiId;
    }

    public void setZuoweiId(String zuoweiId)
    {
        this.zuoweiId = zuoweiId;
    }

    public Long getYuyueId()
    {
        return yuyueId;
    }

    public void setYuyueId(Long yuyueId)
    {
        this.yuyueId = yuyueId;
    }

    public Long getZuoweiYuyueNumber()
    {
        return zuoweiYuyueNumber;
    }

    public void setZuoweiYuyueNumber(Long zuoweiYuyueNumber)
    {
        this.zuoweiYuyueNumber = zuoweiYuyueNumber;
    }

    public boolean getZuoweiState()
    {
        return zuoweiState;
    }

    public void setZuoweiState(boolean zuoweiState)
    {
        this.zuoweiState = zuoweiState;
    }
}
