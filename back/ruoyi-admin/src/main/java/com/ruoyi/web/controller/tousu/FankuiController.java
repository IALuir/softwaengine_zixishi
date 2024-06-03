package com.ruoyi.web.controller.tousu;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;

import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.system.domain.SysTousu;
import com.ruoyi.system.service.ISysTousuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("/tousufankui/fankui")
public class FankuiController extends BaseController {

    @Autowired
    private ISysTousuService tousuService;
    @GetMapping(value = "/{userId}")
    public TableDataInfo getInfoByuserId(@PathVariable Long userId)
    {
        startPage();
        List<SysTousu> list = tousuService.selectTousuByUserId(userId);
        return getDataTable(list);
    }
}
