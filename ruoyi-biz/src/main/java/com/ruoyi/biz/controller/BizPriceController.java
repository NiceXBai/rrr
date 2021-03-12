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
import com.ruoyi.biz.domain.BizPrice;
import com.ruoyi.biz.service.IBizPriceService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 价格Controller
 * 
 * @author ruoyi
 * @date 2021-03-12
 */
@RestController
@RequestMapping("/biz/price")
public class BizPriceController extends BaseController
{
    @Autowired
    private IBizPriceService bizPriceService;

    /**
     * 查询价格列表
     */
    @PreAuthorize("@ss.hasPermi('biz:price:list')")
    @GetMapping("/list")
    public TableDataInfo list(BizPrice bizPrice)
    {
        startPage();
        List<BizPrice> list = bizPriceService.selectBizPriceList(bizPrice);
        return getDataTable(list);
    }

    /**
     * 导出价格列表
     */
    @PreAuthorize("@ss.hasPermi('biz:price:export')")
    @Log(title = "价格", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(BizPrice bizPrice)
    {
        List<BizPrice> list = bizPriceService.selectBizPriceList(bizPrice);
        ExcelUtil<BizPrice> util = new ExcelUtil<BizPrice>(BizPrice.class);
        return util.exportExcel(list, "price");
    }

    /**
     * 获取价格详细信息
     */
    @PreAuthorize("@ss.hasPermi('biz:price:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(bizPriceService.selectBizPriceById(id));
    }

    /**
     * 新增价格
     */
    @PreAuthorize("@ss.hasPermi('biz:price:add')")
    @Log(title = "价格", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BizPrice bizPrice)
    {
        return toAjax(bizPriceService.insertBizPrice(bizPrice));
    }

    /**
     * 修改价格
     */
    @PreAuthorize("@ss.hasPermi('biz:price:edit')")
    @Log(title = "价格", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BizPrice bizPrice)
    {
        return toAjax(bizPriceService.updateBizPrice(bizPrice));
    }

    /**
     * 删除价格
     */
    @PreAuthorize("@ss.hasPermi('biz:price:remove')")
    @Log(title = "价格", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(bizPriceService.deleteBizPriceByIds(ids));
    }
}
