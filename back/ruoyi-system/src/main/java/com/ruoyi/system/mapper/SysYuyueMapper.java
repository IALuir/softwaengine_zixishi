package com.ruoyi.system.mapper;

import java.util.List;

import com.ruoyi.system.domain.SysQiandao;
import com.ruoyi.system.domain.SysYuyue;
import com.ruoyi.system.domain.SysZuowei;

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
}
