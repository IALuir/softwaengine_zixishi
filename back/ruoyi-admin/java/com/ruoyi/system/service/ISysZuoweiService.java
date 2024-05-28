package com.ruoyi.system.service;

import java.util.List;

/**
 * 座位管理Service接口
 *
 * @author ww
 * @date 2024-05-25
 */
public interface ISysZuoweiService
{
    /**
     * 查询座位管理
     *
     * @param zuoweiId 座位管理主键
     * @return 座位管理
     */
    public SysZuowei selectSysZuoweiByZuoweiId(String zuoweiId);

    /**
     * 查询座位管理列表
     *
     * @param sysZuowei 座位管理
     * @return 座位管理集合
     */
    public List<SysZuowei> selectSysZuoweiList(SysZuowei sysZuowei);

    /**
     * 新增座位管理
     *
     * @param sysZuowei 座位管理
     * @return 结果
     */
    public int insertSysZuowei(SysZuowei sysZuowei);

    /**
     * 修改座位管理
     *
     * @param sysZuowei 座位管理
     * @return 结果
     */
    public int updateSysZuowei(SysZuowei sysZuowei);

    /**
     * 批量删除座位管理
     *
     * @param zuoweiIds 需要删除的座位管理主键集合
     * @return 结果
     */
    public int deleteSysZuoweiByZuoweiIds(String[] zuoweiIds);

    /**
     * 删除座位管理信息
     *
     * @param zuoweiId 座位管理主键
     * @return 结果
     */
    public int deleteSysZuoweiByZuoweiId(String zuoweiId);
}
