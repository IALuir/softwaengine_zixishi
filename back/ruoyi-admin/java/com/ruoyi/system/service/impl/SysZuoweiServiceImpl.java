package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysZuoweiMapper;
import com.ruoyi.system.service.ISysZuoweiService;

/**
 * 座位管理Service业务层处理
 *
 * @author ww
 * @date 2024-05-25
 */
@Service
public class SysZuoweiServiceImpl implements ISysZuoweiService
{
    @Autowired
    private SysZuoweiMapper sysZuoweiMapper;

    /**
     * 查询座位管理
     *
     * @param zuoweiId 座位管理主键
     * @return 座位管理
     */
    @Override
    public SysZuowei selectSysZuoweiByZuoweiId(String zuoweiId)
    {
        return sysZuoweiMapper.selectSysZuoweiByZuoweiId(zuoweiId);
    }

    /**
     * 查询座位管理列表
     *
     * @param sysZuowei 座位管理
     * @return 座位管理
     */
    @Override
    public List<SysZuowei> selectSysZuoweiList(SysZuowei sysZuowei)
    {
        return sysZuoweiMapper.selectSysZuoweiList(sysZuowei);
    }

    /**
     * 新增座位管理
     *
     * @param sysZuowei 座位管理
     * @return 结果
     */
    @Override
    public int insertSysZuowei(SysZuowei sysZuowei)
    {
        return sysZuoweiMapper.insertSysZuowei(sysZuowei);
    }

    /**
     * 修改座位管理
     *
     * @param sysZuowei 座位管理
     * @return 结果
     */
    @Override
    public int updateSysZuowei(SysZuowei sysZuowei)
    {
        return sysZuoweiMapper.updateSysZuowei(sysZuowei);
    }

    /**
     * 批量删除座位管理
     *
     * @param zuoweiIds 需要删除的座位管理主键
     * @return 结果
     */
    @Override
    public int deleteSysZuoweiByZuoweiIds(String[] zuoweiIds)
    {
        return sysZuoweiMapper.deleteSysZuoweiByZuoweiIds(zuoweiIds);
    }

    /**
     * 删除座位管理信息
     *
     * @param zuoweiId 座位管理主键
     * @return 结果
     */
    @Override
    public int deleteSysZuoweiByZuoweiId(String zuoweiId)
    {
        return sysZuoweiMapper.deleteSysZuoweiByZuoweiId(zuoweiId);
    }
}
