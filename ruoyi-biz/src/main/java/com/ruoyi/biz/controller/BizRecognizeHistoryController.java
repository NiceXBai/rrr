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
import com.ruoyi.biz.domain.BizRecognizeHistory;
import com.ruoyi.biz.service.IBizRecognizeHistoryService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 识别记录Controller
 * 
 * @author ruoyi
 * @date 2021-02-24
 */
@RestController
@RequestMapping("/biz/history")
public class BizRecognizeHistoryController extends BaseController
{
    @Autowired
    private IBizRecognizeHistoryService bizRecognizeHistoryService;

    /**
     * 查询识别记录列表
     */
    @PreAuthorize("@ss.hasPermi('biz:history:list')")
    @GetMapping("/list")
    public TableDataInfo list(BizRecognizeHistory bizRecognizeHistory)
    {
        startPage();
        List<BizRecognizeHistory> list = bizRecognizeHistoryService.selectBizRecognizeHistoryList(bizRecognizeHistory);
        return getDataTable(list);
    }

    /**
     * 导出识别记录列表
     */
    @PreAuthorize("@ss.hasPermi('biz:history:export')")
    @Log(title = "识别记录", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(BizRecognizeHistory bizRecognizeHistory)
    {
        List<BizRecognizeHistory> list = bizRecognizeHistoryService.selectBizRecognizeHistoryList(bizRecognizeHistory);
        ExcelUtil<BizRecognizeHistory> util = new ExcelUtil<BizRecognizeHistory>(BizRecognizeHistory.class);
        return util.exportExcel(list, "history");
    }

    /**
     * 获取识别记录详细信息
     */
    @PreAuthorize("@ss.hasPermi('biz:history:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(bizRecognizeHistoryService.selectBizRecognizeHistoryById(id));
    }

    /**
     * 新增识别记录
     */
    @PreAuthorize("@ss.hasPermi('biz:history:add')")
    @Log(title = "识别记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BizRecognizeHistory bizRecognizeHistory)
    {
        return toAjax(bizRecognizeHistoryService.insertBizRecognizeHistory(bizRecognizeHistory));
    }

    /**
     * 修改识别记录
     */
    @PreAuthorize("@ss.hasPermi('biz:history:edit')")
    @Log(title = "识别记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BizRecognizeHistory bizRecognizeHistory)
    {
        return toAjax(bizRecognizeHistoryService.updateBizRecognizeHistory(bizRecognizeHistory));
    }

    /**
     * 删除识别记录
     */
    @PreAuthorize("@ss.hasPermi('biz:history:remove')")
    @Log(title = "识别记录", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(bizRecognizeHistoryService.deleteBizRecognizeHistoryByIds(ids));
    }
}
