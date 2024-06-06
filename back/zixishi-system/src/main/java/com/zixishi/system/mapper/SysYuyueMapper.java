package com.zixishi.system.mapper;

import java.util.List;

import com.zixishi.system.domain.SysQiandao;
import com.zixishi.system.domain.SysYuyue;
import com.zixishi.system.domain.SysZuowei;

public interface SysYuyueMapper {
    public List<SysYuyue> selectYuyueList(SysYuyue Yuyue);

    public List<SysYuyue> selectYuyueByYuyueId(Long yuyueId);

    public List<SysZuowei> selectZuoweiByZuoweiId(String zuoweiId);

    public List<SysYuyue> selectYuyueByZuoweiId(String zuoweiId);

    public List<SysYuyue> selectYuyueNumberByUserId(Long userId);

    public int insertYuyue(SysYuyue Yuyue);

    public int updatetYuyue(SysYuyue Yuyue);

    public int deleteYuyueByYuyueIds(Long[] yuyueIds);

    public int insertQiandao(SysQiandao Yuyue);

    public List<SysQiandao> selectQiandaoByYuyueId(Long yuyueId);

    public int updatetQiandao(SysQiandao qiandao);

    public void AutozuoweiShifang(SysQiandao qiandao);

    public List<SysQiandao> selectQiandaoAll();

    public List<SysYuyue> selectYuyueAll();
}
