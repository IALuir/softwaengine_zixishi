package com.zixishi.web.controller.system;

import com.zixishi.common.annotation.Log;
import com.zixishi.common.core.domain.entity.SysUser;
import com.zixishi.common.enums.BusinessType;
import com.zixishi.system.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.zixishi.common.core.controller.BaseController;
import com.zixishi.common.core.domain.AjaxResult;
import com.zixishi.common.core.domain.model.RegisterBody;
import com.zixishi.common.utils.StringUtils;
import com.zixishi.framework.web.service.SysRegisterService;
import com.zixishi.system.service.ISysConfigService;

/**
 * 注册验证
 *
 * @author ruoyi
 */
@RestController
public class SysRegisterController extends BaseController
{
    @Autowired
    private SysRegisterService registerService;

    @Autowired
    private ISysConfigService configService;

    @Autowired
    private ISysUserService userService;

    @PostMapping("/register")
    public AjaxResult register(@RequestBody RegisterBody user)
    {
        if (!("true".equals(configService.selectConfigByKey("sys.account.registerUser"))))
        {
            return error("当前系统没有开启注册功能！");
        }
        String msg = registerService.register(user);
        return StringUtils.isEmpty(msg) ? success() : error(msg);
    }

    @GetMapping(value = { "/register/{userName}" })
    public Long getUserIdByName(@PathVariable(value = "userName", required = false) String userName)
    {
        return userService.selectUserByUserName2(userName).getRoleId();
    }

}
