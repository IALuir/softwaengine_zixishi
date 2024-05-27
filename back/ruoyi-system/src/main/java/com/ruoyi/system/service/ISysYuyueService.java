package com.ruoyi.system.service;

import java.util.List;

import com.ruoyi.common.core.domain.entity.SysRole;
import com.ruoyi.system.domain.SysQiandao;
import com.ruoyi.system.domain.SysYuyue;
import com.ruoyi.system.domain.SysZuowei;

public interface ISysYuyueService {

    public List<SysYuyue> selectYuyueList(SysYuyue Yuyue);

    public List<SysYuyue> selectYuyueByYuyueId(Long yuyueId);

    public List<SysZuowei> selectZuoweiByZuoweiId(String zuoweiId);

    public List<SysYuyue> selectYuyueByZuoweiId(String zuoweiId);

    public List<SysYuyue> selectYuyueNumberByUserId(Long userId);

    public int insertYuyue(SysYuyue Yuyue);

    public int updateYuyue(SysYuyue Yuyue);

    public int deleteYuyueByIds(Long[] yuyueIds);

    public int insertQiandao(SysQiandao Qiandao);

    public List<SysQiandao> selectQiandaoByYuyueId(Long yuyueId);

    public int updateQiandao(SysQiandao qiandao);

}
