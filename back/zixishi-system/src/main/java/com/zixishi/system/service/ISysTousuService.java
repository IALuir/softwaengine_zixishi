package com.zixishi.system.service;

import com.zixishi.system.domain.SysTousu;
import com.zixishi.system.domain.SysYuyue;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

public interface ISysTousuService {
    public List<SysTousu> selectTousuList(SysTousu tousu);

    public int insertTousu(SysTousu Tousu);

    public int deleteTousuById(int tousuId);

    public List<SysTousu> selectTousuByTousuId(int tousuId);
    public List<SysTousu> selectTousuByUserId(Long userId);

    public int updateTousu(SysTousu Tousu);
}
