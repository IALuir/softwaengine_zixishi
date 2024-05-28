package com.ruoyi.system.service;

import com.ruoyi.system.domain.SysTousu;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ISysTousuService {
    public List<SysTousu> selectTousuList(SysTousu tousu);
}
