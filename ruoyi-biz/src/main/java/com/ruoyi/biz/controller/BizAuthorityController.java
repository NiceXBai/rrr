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
import com.ruoyi.biz.domain.BizAuthority;
import com.ruoyi.biz.service.IBizAuthorityService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 调用keyController
 * 
 * @author ruoyi
 * @date 2021-02-24
 */
@RestController
@RequestMapping("/biz/authority")
public class BizAuthorityController extends BaseController
{
    @Autowired
    private IBizAuthorityService bizAuthorityService;

    /**
     * 查询调用key列表
     */
    @PreAuthorize("@ss.hasPermi('biz:authority:list')")
    @GetMapping("/list")
    public TableDataInfo list(BizAuthority bizAuthority)
    {
        startPage();
        List<BizAuthority> list = bizAuthorityService.selectBizAuthorityList(bizAuthority);
        return getDataTable(list);
    }

    /**
     * 导出调用key列表
     */
    @PreAuthorize("@ss.hasPermi('biz:authority:export')")
    @Log(title = "调用key", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(BizAuthority bizAuthority)
    {
        List<BizAuthority> list = bizAuthorityService.selectBizAuthorityList(bizAuthority);
        ExcelUtil<BizAuthority> util = new ExcelUtil<BizAuthority>(BizAuthority.class);
        return util.exportExcel(list, "authority");
    }

    /**
     * 获取调用key详细信息
     */
    @PreAuthorize("@ss.hasPermi('biz:authority:query')")
    @GetMapping(value = "/{keyId}")
    public AjaxResult getInfo(@PathVariable("keyId") Long keyId)
    {
        return AjaxResult.success(bizAuthorityService.selectBizAuthorityById(keyId));
    }

    /**
     * 新增调用key
     */
    @PreAuthorize("@ss.hasPermi('biz:authority:add')")
    @Log(title = "调用key", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BizAuthority bizAuthority)
    {
        return toAjax(bizAuthorityService.insertBizAuthority(bizAuthority));
    }

    /**
     * 修改调用key
     */
    @PreAuthorize("@ss.hasPermi('biz:authority:edit')")
    @Log(title = "调用key", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BizAuthority bizAuthority)
    {
        return toAjax(bizAuthorityService.updateBizAuthority(bizAuthority));
    }

    /**
     * 删除调用key
     */
    @PreAuthorize("@ss.hasPermi('biz:authority:remove')")
    @Log(title = "调用key", businessType = BusinessType.DELETE)
	@DeleteMapping("/{keyIds}")
    public AjaxResult remove(@PathVariable Long[] keyIds)
    {
        return toAjax(bizAuthorityService.deleteBizAuthorityByIds(keyIds));
    }
}
