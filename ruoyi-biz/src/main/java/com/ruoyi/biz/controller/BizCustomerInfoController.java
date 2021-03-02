package com.ruoyi.biz.controller;

import java.util.List;
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
import com.ruoyi.biz.domain.BizCustomerInfo;
import com.ruoyi.biz.service.IBizCustomerInfoService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 用户信息Controller
 * 
 * @author ruoyi
 * @date 2021-02-24
 */
@RestController
@RequestMapping("/biz/info")
public class BizCustomerInfoController extends BaseController
{
    @Autowired
    private IBizCustomerInfoService bizCustomerInfoService;

    /**
     * 查询用户信息列表
     */
    @PreAuthorize("@ss.hasPermi('biz:info:list')")
    @GetMapping("/list")
    public TableDataInfo list(BizCustomerInfo bizCustomerInfo)
    {
        startPage();
        List<BizCustomerInfo> list = bizCustomerInfoService.selectBizCustomerInfoList(bizCustomerInfo);
        return getDataTable(list);
    }

    /**
     * 导出用户信息列表
     */
    @PreAuthorize("@ss.hasPermi('biz:info:export')")
    @Log(title = "用户信息", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(BizCustomerInfo bizCustomerInfo)
    {
        List<BizCustomerInfo> list = bizCustomerInfoService.selectBizCustomerInfoList(bizCustomerInfo);
        ExcelUtil<BizCustomerInfo> util = new ExcelUtil<BizCustomerInfo>(BizCustomerInfo.class);
        return util.exportExcel(list, "info");
    }

    /**
     * 获取用户信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('biz:info:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(bizCustomerInfoService.selectBizCustomerInfoById(id));
    }

    /**
     * 新增用户信息
     */
    @PreAuthorize("@ss.hasPermi('biz:info:add')")
    @Log(title = "用户信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BizCustomerInfo bizCustomerInfo)
    {
        return toAjax(bizCustomerInfoService.insertBizCustomerInfo(bizCustomerInfo));
    }

    /**
     * 修改用户信息
     */
    @PreAuthorize("@ss.hasPermi('biz:info:edit')")
    @Log(title = "用户信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BizCustomerInfo bizCustomerInfo)
    {
        return toAjax(bizCustomerInfoService.updateBizCustomerInfo(bizCustomerInfo));
    }

    /**
     * 删除用户信息
     */
    @PreAuthorize("@ss.hasPermi('biz:info:remove')")
    @Log(title = "用户信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(bizCustomerInfoService.deleteBizCustomerInfoByIds(ids));
    }
}
