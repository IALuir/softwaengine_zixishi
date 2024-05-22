package com.ruoyi.system.domain;

import java.util.Set;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.annotation.Excel.ColumnType;
import com.ruoyi.common.core.domain.BaseEntity;

public class SysYuyue extends BaseEntity{

    private static final long serialVersionUID = 1L;

    /** 预约记录ID */
    @Excel(name = "预约记录序号")
    private Long yuyueId;

    /** 用户ID */
    @Excel(name = "用户名称")
    private String userName;

    /** 用户ID */
    @Excel(name = "预约座位")
    private String zuowei;

    private String yuyueTime;

    private String cTime;

    public Long getYuyueId()
    {
        return yuyueId;
    }

    public void setYuyueId(Long yuyueId)
    {
        this.yuyueId = yuyueId;
    }

    public String getuserName()
    {
        return userName;
    }

    public void setuserName(String userName)
    {
        this.userName = userName;
    }

    public String getZuowei()
    {
        return zuowei;
    }

    public void setZuowei(String zuowei)
    {
        this.zuowei = zuowei;
    }

    public String getYuyueTime()
    {
        return yuyueTime;
    }

    public void setYuyueTime(String yuyueTime)
    {
        this.yuyueTime = yuyueTime;
    }

    public String getcTime()
    {
        return cTime;
    }

    public void setcTime(String cTime)
    {
        this.cTime = cTime;
    }

}
