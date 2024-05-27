package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 座位管理对象 sys_zuowei
 * 
 * @author ww
 * @date 2024-05-25
 */
public class SysZuowei extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 座位id */
    @Excel(name = "座位id")
    private String zuoweiId;

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

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("zuoweiId", getZuoweiId())
            .append("zuoweiNumber", getZuoweiNumber())
            .append("zuoweiState", getZuoweiState())
            .toString();
    }
}
