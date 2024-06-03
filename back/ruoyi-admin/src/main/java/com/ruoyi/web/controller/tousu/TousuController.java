package com.ruoyi.web.controller.tousu;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.entity.SysRole;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.SysQiandao;
import com.ruoyi.system.domain.SysYuyue;
import com.ruoyi.system.service.ISysTousuService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.system.domain.SysTousu;

import java.util.List;

@RestController
@RequestMapping("/tousufankui/tousu")
public class TousuController extends BaseController {
    @Autowired
    private ISysTousuService tousuService;


    @GetMapping("/list")
    public TableDataInfo list(SysTousu tousu)
    {
        startPage();
        List<SysTousu> list = tousuService.selectTousuList(tousu);
        return getDataTable(list);
    }

    @Log(title = "申请投诉", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@Validated @RequestBody SysTousu tousu)
    {
        tousu.setCreateBy(tousu.getCreateBy());
        return toAjax(tousuService.insertTousu(tousu));
    }

    @Log(title = "删除投诉", businessType = BusinessType.DELETE)
    @DeleteMapping("/{tousuIds}")
    public AjaxResult remove(@PathVariable int tousuIds)
    {
        return toAjax(tousuService.deleteTousuById(tousuIds));
    }

    @GetMapping(value = "/{tousuId}")
    public AjaxResult getInfoBytousuId(@PathVariable int tousuId)
    {
        return success(tousuService.selectTousuByTousuId(tousuId));
    }

    @Log(title = "修改投诉", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult updateTousu(@Validated @RequestBody SysTousu tousu)
    {
        return toAjax(tousuService.updateTousu(tousu));
    }

}
