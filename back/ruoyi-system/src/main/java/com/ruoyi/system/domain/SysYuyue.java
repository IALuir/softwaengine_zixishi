package com.ruoyi.system.domain;

import java.sql.Date;
import java.text.SimpleDateFormat;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.annotation.Excel.ColumnType;
import com.ruoyi.common.core.domain.BaseEntity;

public class SysYuyue extends BaseEntity{

    private static final long serialVersionUID = 1L;

    /** 预约记录ID */
    @Excel(name = "预约记录序号")
    private Long yuyueId;

    /** 用户名称 */
    @Excel(name = "用户名称")
    private String userName;

    /** 用户ID */
    @Excel(name = "用户ID")
    private Long userId;

    /** 座位 */
    @Excel(name = "预约座位")
    private String zuoweiId;

    private String yuyueTime;

    private String deTime;

    private String cTime;

    private Date cLeftTime;

    private Date cRightTime;

    private Date yuyueLeftTime;

    private Date yuyueRightTime;

    public Long getYuyueId()
    {
        return yuyueId;
    }

    public void setYuyueId(Long yuyueId)
    {
        this.yuyueId = yuyueId;
    }

    public Long getUserId()
    {
        return userId;
    }

    public void setUserId(Long userId)
    {
        this.userId = userId;
    }

    public String getuserName()
    {
        return userName;
    }

    public void setuserName(String userName)
    {
        this.userName = userName;
    }

    public String getZuoweiId()
    {
        return zuoweiId;
    }

    public void setZuoweiId(String zuoweiId)
    {
        this.zuoweiId = zuoweiId;
    }

    public String getYuyueTime() {return yuyueTime;}

    public void setYuyueTime(String yuyueTime)
    {
        this.yuyueTime = yuyueTime;
    }

    public String getDeTime() {return deTime;}

    public void setDeTime(String deTime)
    {
        this.deTime = deTime;
    }

    public String getcTime()
    {
        return cTime;
    }

    public void setcTime(String cTime)
    {
        this.cTime = cTime;
    }

    public Date getcLeftTime()
    {
        return cLeftTime;
    }

    public void setcLeftTime(Date cLeftTime)
    {
        this.cLeftTime = cLeftTime;
    }

    public Date getcRightTime()
    {
        return cRightTime;
    }

    public void setcRightTime(Date cRightTime)
    {
        this.cRightTime = cRightTime;
    }

    public Date getyuyueLeftTime()
    {
        return yuyueLeftTime;
    }

    public void setyuyueLeftTime(Date yuyueLeftTime)
    {
        this.yuyueLeftTime = yuyueLeftTime;
    }

    public Date getyuyueRightTime()
    {
        return yuyueRightTime;
    }

    public void setyuyueRightTime(Date yuyueRightTime)
    {
        this.yuyueRightTime = yuyueRightTime;
    }

}
