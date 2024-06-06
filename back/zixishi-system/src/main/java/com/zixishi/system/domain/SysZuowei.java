package com.zixishi.system.domain;

import com.zixishi.common.annotation.Excel;
import com.zixishi.common.core.domain.BaseEntity;


public class SysZuowei extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 座位id */
    @Excel(name = "座位id")
    private String zuoweiId;

    /** 预约id */
    @Excel(name = "预约id")
    private Long yuyueId;

    /** 使用数 */
    @Excel(name = "使用数")
    private Long zuoweiNumber;

    /** 状态 */
    @Excel(name = "状态")
    private Integer zuoweiState;

    public void setZuoweiId(String zuoweiId)
    {
        this.zuoweiId = zuoweiId;
    }

    public String getZuoweiId()
    {
        return zuoweiId;
    }

    public void setYuyueId(Long yuyueId)
    {
        this.yuyueId = yuyueId;
    }

    public Long getYuyueId()
    {
        return yuyueId;
    }

    public void setZuoweiNumber(Long zuoweiNumber)
    {
        this.zuoweiNumber = zuoweiNumber;
    }

    public Long getZuoweiNumber()
    {
        return zuoweiNumber;
    }
    public void setZuoweiState(Integer zuoweiState)
    {
        this.zuoweiState = zuoweiState;
    }

    public Integer getZuoweiState()
    {
        return zuoweiState;
    }

}
