package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.SysTousu;
import com.ruoyi.system.domain.SysYuyue;
import org.apache.ibatis.annotations.Mapper;

import java.math.BigInteger;
import java.util.List;
@Mapper
public interface SysTousuMapper {
    public List<SysTousu> selectTousuList(SysTousu tousu);

    public int insertTousu(SysTousu Tousu);

    public int deleteTousuById(int roleId);

    public List<SysTousu> selectTousuByTousuId(int tousuId);
    public List<SysTousu> selectTousuByUserId(Long userId);

    public int updatetTousu(SysTousu Tousu);
}
