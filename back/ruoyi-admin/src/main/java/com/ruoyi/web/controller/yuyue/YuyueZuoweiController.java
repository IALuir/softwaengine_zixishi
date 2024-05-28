package com.ruoyi.web.controller.yuyue;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.system.domain.SysYuyue;
import com.ruoyi.system.domain.SysQiandao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.entity.SysRole;
import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.framework.web.service.SysPermissionService;
import com.ruoyi.framework.web.service.TokenService;
import com.ruoyi.system.service.ISysYuyueService;
import com.ruoyi.system.service.ISysUserService;

@RestController
@RequestMapping("/yuyue/zuowei")
public class YuyueZuoweiController extends BaseController{
    @Autowired
    private ISysYuyueService yuyueService;


    @GetMapping("/list")
    public TableDataInfo list(SysYuyue yuyue)
    {
        startPage();
        List<SysYuyue> list = yuyueService.selectYuyueList(yuyue);
        return getDataTable(list);
    }


    /**
     * 根据记录编号获取详细信息
     */
    @GetMapping(value = "/{yuyueId}")
    public AjaxResult getInfoByyuyueId(@PathVariable Long yuyueId)
    {
        return success(yuyueService.selectYuyueByYuyueId(yuyueId));
    }

    /**
     * 根据座位编号获取详细信息
     */
    @GetMapping(value = "shenqing/{zuoweiId}")
    public AjaxResult getInfoByZuoweiId(@PathVariable String zuoweiId)
    {
        return success(yuyueService.selectZuoweiByZuoweiId(zuoweiId));
    }
    /**
     * 根据座位号查预约记录
     */
    @GetMapping(value = "ybz/{zuoweiId}")
    public AjaxResult getYuyueByZuoweiId(@PathVariable String zuoweiId)
    {
        return success(yuyueService.selectYuyueByZuoweiId(zuoweiId));
    }
    /**
     * 根据用户查预约记录
     */
    @GetMapping(value = "ynbu/{userId}")
    public AjaxResult getYuyueNumberByUserId(@PathVariable Long userId)
    {
        return success(yuyueService.selectYuyueNumberByUserId(userId));
    }

    /**
     * 删除预约记录
     */
    @Log(title = "预约管理", businessType = BusinessType.DELETE)
    @DeleteMapping("{yuyueIds}")
    public AjaxResult remove(@PathVariable Long[] yuyueIds)
    {
        return toAjax(yuyueService.deleteYuyueByIds(yuyueIds));
    }

    /**
     * 新增记录
     */

    @Log(title = "预约管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@Validated @RequestBody SysYuyue yuyue)
    {
        return toAjax(yuyueService.insertYuyue(yuyue));

    }

    /**
     * 修改保存记录
     */

    @Log(title = "预约管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@Validated @RequestBody SysYuyue yuyue)
    {
        return toAjax(yuyueService.updateYuyue(yuyue));
    }

    /**
     * 新增签到记录
     */

    @Log(title = "签到管理", businessType = BusinessType.INSERT)
    @PostMapping(value = "/qiandao")
    public AjaxResult addqiandao(@Validated @RequestBody SysQiandao qiandao)
    {
        return toAjax(yuyueService.insertQiandao(qiandao));

    }

    /**
     * 修改保存记录
     */

    @Log(title = "签到管理", businessType = BusinessType.UPDATE)
    @PutMapping(value ="/qiandao")
    public AjaxResult updateQiandao(@Validated @RequestBody SysQiandao qiandao)
    {
        return toAjax(yuyueService.updateQiandao(qiandao));
    }

    /**
     * 根据预约编号获取签到信息
     */
    @GetMapping(value = "/qiandao/{yuyueId}")
    public AjaxResult getQiandaoByyuyueId(@PathVariable Long yuyueId)
    {
        return success(yuyueService.selectQiandaoByYuyueId(yuyueId));
    }
    @Scheduled(cron="0 0 22 * * *")
    @ResponseBody
    @Log(title = "自动释放座位", businessType = BusinessType.UPDATE)
    public void AutoZuowei()
    {
        List<SysQiandao> qiandaolist = yuyueService.selectQiandaoAll();
        for (SysQiandao q:qiandaolist) {
            if(q.getState() == 0){
                q.setState(8);
            }else if(q.getState() == 2){
                q.setState(3);
            }else if(q.getState() == 5){
                q.setState(9);
            }
            yuyueService.AutozuoweiShifang(q);
        }

        List<SysYuyue> yuyuelist = yuyueService.selectYuyueAll();
        for (SysYuyue y:yuyuelist) {
            y.setIs_del(1);
            yuyueService.updateYuyue(y);
        }
    }

}
