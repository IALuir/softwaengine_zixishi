package com.ruoyi.web.controller.system;

import java.util.List;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.service.CarPositionService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.system.domain.CarPosition;

@RestController
@RequestMapping("/system/shebei")
public class shebeiController extends BaseController
{
    @Autowired()
    private CarPositionService position;

    /**
     * 查询压铸设备管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:shebei:query')")
    @GetMapping("/{deviceId}")
    public AjaxResult getInfo(@PathVariable("deviceId") int deviceId)
    {
        return success(position.selectCarPosition(deviceId));
    }

    @PreAuthorize("@ss.hasPermi('system:shebei:list')")
    @GetMapping("/list")
    public TableDataInfo getlist()
    {
        startPage();
        List<CarPosition> list = position.selectCarPositionList();
        return getDataTable(list);
    }

    @PreAuthorize("@ss.hasPermi('system:shebei:carnumidlist')")
    @GetMapping("/carnumidlist/{carnumId}")
    public TableDataInfo getcarnumidlist(@PathVariable("carnumId") int carnumId)
    {
        startPage();
        List<CarPosition> list = position.selectCarNumIdPositionList(carnumId);
        return getDataTable(list);
    }

    @PreAuthorize("@ss.hasPermi('system:shebei:addtemp')")
    @PostMapping("/carnumidlist/addtemp")
    public AjaxResult add(@RequestBody CarPosition car)
    {
        return toAjax(position.insertcar(car));
    }
}

