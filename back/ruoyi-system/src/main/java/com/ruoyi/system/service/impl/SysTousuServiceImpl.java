package com.ruoyi.system.service.impl;

import com.ruoyi.system.domain.SysTousu;
import com.ruoyi.system.mapper.SysTousuMapper;
import com.ruoyi.system.service.ISysTousuService;

import java.util.List;

public class SysTousuServiceImpl implements ISysTousuService {
    private SysTousuMapper tousuMapper;
    public List<SysTousu> selectTousuList(SysTousu tousu) {
        return tousuMapper.selectTousuList(tousu);
    }
}
