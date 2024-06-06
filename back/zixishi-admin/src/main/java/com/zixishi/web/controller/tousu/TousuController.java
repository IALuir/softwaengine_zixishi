package com.zixishi.web.controller.tousu;

import com.zixishi.common.annotation.Log;
import com.zixishi.common.core.controller.BaseController;
import com.zixishi.common.core.domain.AjaxResult;
import com.zixishi.common.core.domain.entity.SysRole;
import com.zixishi.common.core.page.TableDataInfo;
import com.zixishi.common.enums.BusinessType;
import com.zixishi.system.domain.SysQiandao;
import com.zixishi.system.domain.SysYuyue;
import com.zixishi.system.service.ISysTousuService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.zixishi.system.domain.SysTousu;

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
