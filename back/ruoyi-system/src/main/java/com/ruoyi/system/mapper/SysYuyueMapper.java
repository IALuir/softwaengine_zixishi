package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.SysYuyue;

public interface SysYuyueMapper {
    public List<SysYuyue> selectYuyueList(SysYuyue Yuyue);

    public List<SysYuyue> selectYuyueByYuyueId(Long yuyueId);

    public int insertYuyue(SysYuyue Yuyue);

    public int updatetYuyue(SysYuyue Yuyue);

    public int deleteYuyueByYuyueIds(Long[] yuyueIds);
}
