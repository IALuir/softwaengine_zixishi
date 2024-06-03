package com.ruoyi.system.service.impl;

import com.ruoyi.system.domain.SysTousu;
import com.ruoyi.system.domain.SysYuyue;
import com.ruoyi.system.mapper.SysTousuMapper;
import com.ruoyi.system.service.ISysTousuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.util.List;
@Service
public class SysTousuServiceImpl implements ISysTousuService {
    @Autowired
    private SysTousuMapper tousuMapper;
    public List<SysTousu> selectTousuList(SysTousu tousu) {
        return tousuMapper.selectTousuList(tousu);
    }

    public int insertTousu(SysTousu Tousu){
        return tousuMapper.insertTousu(Tousu);
    }

    public int deleteTousuById(int tousuId) { return tousuMapper.deleteTousuById(tousuId); }

    public List<SysTousu> selectTousuByTousuId(int tousuId) {
        return tousuMapper.selectTousuByTousuId(tousuId);
    }
    public List<SysTousu> selectTousuByUserId(Long userId) {
        return tousuMapper.selectTousuByUserId(userId);
    }


    public int updateTousu(SysTousu Tousu) {return tousuMapper.updatetTousu(Tousu);}
}
