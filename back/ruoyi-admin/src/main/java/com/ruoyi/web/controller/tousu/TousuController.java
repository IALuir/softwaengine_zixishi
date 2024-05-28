package com.ruoyi.web.controller.tousu;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.system.service.ISysTousuService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import com.ruoyi.system.domain.SysTousu;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
