package com.zixishi.system.mapper;

import com.zixishi.system.domain.SysZuowei;

import java.util.List;

/**
 * 座位管理Mapper接口
 *
 * @author ww
 * @date 2024-05-25
 */
public interface SysZuoweiMapper
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
     * 删除座位管理
     *
     * @param zuoweiId 座位管理主键
     * @return 结果
     */
    public int deleteSysZuoweiByZuoweiId(String zuoweiId);

    /**
     * 批量删除座位管理
     *
     * @param zuoweiIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSysZuoweiByZuoweiIds(String[] zuoweiIds);
}
