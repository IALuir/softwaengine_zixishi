package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.SysTousu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface SysTousuMapper {
    public List<SysTousu> selectTousuList(SysTousu tousu);
}
