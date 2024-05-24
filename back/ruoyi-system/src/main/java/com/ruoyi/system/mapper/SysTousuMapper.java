package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.SysTousu;
import com.ruoyi.system.domain.SysYuyue;

import java.util.List;

public interface SysTousuMapper {
    public List<SysTousu> selectTousuList(SysTousu tousu);
}
