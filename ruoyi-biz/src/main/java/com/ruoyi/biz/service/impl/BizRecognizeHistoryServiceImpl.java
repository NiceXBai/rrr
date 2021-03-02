package com.ruoyi.biz.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.biz.mapper.BizRecognizeHistoryMapper;
import com.ruoyi.biz.domain.BizRecognizeHistory;
import com.ruoyi.biz.service.IBizRecognizeHistoryService;

/**
 * 识别记录Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-02-24
 */
@Service
public class BizRecognizeHistoryServiceImpl implements IBizRecognizeHistoryService 
{
    @Autowired
    private BizRecognizeHistoryMapper bizRecognizeHistoryMapper;

    /**
     * 查询识别记录
     * 
     * @param id 识别记录ID
     * @return 识别记录
     */
    @Override
    public BizRecognizeHistory selectBizRecognizeHistoryById(Long id)
    {
        return bizRecognizeHistoryMapper.selectBizRecognizeHistoryById(id);
    }

    /**
     * 查询识别记录列表
     * 
     * @param bizRecognizeHistory 识别记录
     * @return 识别记录
     */
    @Override
    public List<BizRecognizeHistory> selectBizRecognizeHistoryList(BizRecognizeHistory bizRecognizeHistory)
    {
        return bizRecognizeHistoryMapper.selectBizRecognizeHistoryList(bizRecognizeHistory);
    }

    /**
     * 新增识别记录
     * 
     * @param bizRecognizeHistory 识别记录
     * @return 结果
     */
    @Override
    public int insertBizRecognizeHistory(BizRecognizeHistory bizRecognizeHistory)
    {
        bizRecognizeHistory.setCreateTime(DateUtils.getNowDate());
        return bizRecognizeHistoryMapper.insertBizRecognizeHistory(bizRecognizeHistory);
    }

    /**
     * 修改识别记录
     * 
     * @param bizRecognizeHistory 识别记录
     * @return 结果
     */
    @Override
    public int updateBizRecognizeHistory(BizRecognizeHistory bizRecognizeHistory)
    {
        bizRecognizeHistory.setUpdateTime(DateUtils.getNowDate());
        return bizRecognizeHistoryMapper.updateBizRecognizeHistory(bizRecognizeHistory);
    }

    /**
     * 批量删除识别记录
     * 
     * @param ids 需要删除的识别记录ID
     * @return 结果
     */
    @Override
    public int deleteBizRecognizeHistoryByIds(Long[] ids)
    {
        return bizRecognizeHistoryMapper.deleteBizRecognizeHistoryByIds(ids);
    }

    /**
     * 删除识别记录信息
     * 
     * @param id 识别记录ID
     * @return 结果
     */
    @Override
    public int deleteBizRecognizeHistoryById(Long id)
    {
        return bizRecognizeHistoryMapper.deleteBizRecognizeHistoryById(id);
    }
}
