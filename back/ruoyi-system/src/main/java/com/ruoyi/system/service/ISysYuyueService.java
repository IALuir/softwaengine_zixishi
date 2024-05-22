package com.ruoyi.system.service;

import java.util.List;

import com.ruoyi.common.core.domain.entity.SysRole;
import com.ruoyi.system.domain.SysYuyue;

public interface ISysYuyueService {

    public List<SysYuyue> selectYuyueList(SysYuyue Yuyue);

    public List<SysYuyue> selectYuyueByYuyueId(Long yuyueId);

    public int insertYuyue(SysYuyue Yuyue);

    public int updateYuyue(SysYuyue Yuyue);

    public int deleteYuyueByIds(Long[] yuyueIds);

}
