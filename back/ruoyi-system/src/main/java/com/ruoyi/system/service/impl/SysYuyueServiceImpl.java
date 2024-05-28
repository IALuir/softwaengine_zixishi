package com.ruoyi.system.service.impl;

import java.util.List;

import com.ruoyi.system.domain.SysQiandao;
import com.ruoyi.system.domain.SysYuyue;
import com.ruoyi.system.domain.SysZuowei;
import com.ruoyi.system.mapper.SysYuyueMapper;
import com.ruoyi.system.service.ISysYuyueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysYuyueServiceImpl implements ISysYuyueService{

    @Autowired
    private SysYuyueMapper yuyueMapper;

    @Override
    public List<SysYuyue> selectYuyueList(SysYuyue Yuyue) {
        return yuyueMapper.selectYuyueList(Yuyue);
    }

    @Override
    public List<SysYuyue> selectYuyueByYuyueId(Long yuyueId) {
        return yuyueMapper.selectYuyueByYuyueId(yuyueId);
    }

    @Override
    public List<SysZuowei> selectZuoweiByZuoweiId(String zuoweiId) {
        return yuyueMapper.selectZuoweiByZuoweiId(zuoweiId);
    }

    @Override
    public List<SysYuyue> selectYuyueByZuoweiId(String zuoweiId) {return yuyueMapper.selectYuyueByZuoweiId(zuoweiId);}

    @Override
    public List<SysYuyue> selectYuyueNumberByUserId(Long userId) {return yuyueMapper.selectYuyueNumberByUserId(userId);}

    @Override
    public int insertYuyue(SysYuyue Yuyue){
        return yuyueMapper.insertYuyue(Yuyue);
    }

    @Override
    public int updateYuyue(SysYuyue Yuyue) {return yuyueMapper.updatetYuyue(Yuyue);
    }

    @Override
    public int deleteYuyueByIds(Long[] yuyueIds) {
        return yuyueMapper.deleteYuyueByYuyueIds(yuyueIds);
    }

    @Override
    public int insertQiandao(SysQiandao Qiandao){
        return yuyueMapper.insertQiandao(Qiandao);
    }

    @Override
    public List<SysQiandao> selectQiandaoByYuyueId(Long yuyueId) {
        return yuyueMapper.selectQiandaoByYuyueId(yuyueId);
    }

    @Override
    public int updateQiandao(SysQiandao qiandao) {
        return yuyueMapper.updatetQiandao(qiandao);
    }

    @Override
    public void AutozuoweiShifang(SysQiandao qiandao) {
        yuyueMapper.AutozuoweiShifang(qiandao);
    }

    @Override
    public List<SysQiandao> selectQiandaoAll() {
        return yuyueMapper.selectQiandaoAll();
    }

    @Override
    public List<SysYuyue> selectYuyueAll() {
        return yuyueMapper.selectYuyueAll();
    }
}
