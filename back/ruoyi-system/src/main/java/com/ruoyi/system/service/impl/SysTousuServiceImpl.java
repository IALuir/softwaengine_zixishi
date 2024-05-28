package com.ruoyi.system.service.impl;

import com.ruoyi.system.domain.SysTousu;
import com.ruoyi.system.mapper.SysTousuMapper;
import com.ruoyi.system.service.ISysTousuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SysTousuServiceImpl implements ISysTousuService {
    @Autowired
    private SysTousuMapper tousuMapper;
    public List<SysTousu> selectTousuList(SysTousu tousu) {
        return tousuMapper.selectTousuList(tousu);
    }
}
