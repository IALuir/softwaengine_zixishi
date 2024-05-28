package com.ruoyi.system.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.service.ISysZuoweiService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 座位管理Controller
 *
 * @author ww
 * @date 2024-05-25
 */
@RestController
@RequestMapping("/system/zuowei")
public class SysZuoweiController extends BaseController
{
    @Autowired
    private ISysZuoweiService sysZuoweiService;

    /**
     * 查询座位管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:zuowei:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysZuowei sysZuowei)
    {
        startPage();
        List<SysZuowei> list = sysZuoweiService.selectSysZuoweiList(sysZuowei);
        return getDataTable(list);
    }

    /**
     * 导出座位管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:zuowei:export')")
    @Log(title = "座位管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SysZuowei sysZuowei)
    {
        List<SysZuowei> list = sysZuoweiService.selectSysZuoweiList(sysZuowei);
        ExcelUtil<SysZuowei> util = new ExcelUtil<SysZuowei>(SysZuowei.class);
        util.exportExcel(response, list, "座位管理数据");
    }

    /**
     * 获取座位管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:zuowei:query')")
    @GetMapping(value = "/{zuoweiId}")
    public AjaxResult getInfo(@PathVariable("zuoweiId") String zuoweiId)
    {
        return success(sysZuoweiService.selectSysZuoweiByZuoweiId(zuoweiId));
    }

    /**
     * 新增座位管理
     */
    @PreAuthorize("@ss.hasPermi('system:zuowei:add')")
    @Log(title = "座位管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysZuowei sysZuowei)
    {
        return toAjax(sysZuoweiService.insertSysZuowei(sysZuowei));
    }

    /**
     * 修改座位管理
     */
    @PreAuthorize("@ss.hasPermi('system:zuowei:edit')")
    @Log(title = "座位管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysZuowei sysZuowei)
    {
        return toAjax(sysZuoweiService.updateSysZuowei(sysZuowei));
    }

    /**
     * 删除座位管理
     */
    @PreAuthorize("@ss.hasPermi('system:zuowei:remove')")
    @Log(title = "座位管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{zuoweiIds}")
    public AjaxResult remove(@PathVariable String[] zuoweiIds)
    {
        return toAjax(sysZuoweiService.deleteSysZuoweiByZuoweiIds(zuoweiIds));
    }
}
