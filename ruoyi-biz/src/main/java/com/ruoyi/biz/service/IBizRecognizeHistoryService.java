package com.ruoyi.biz.service;

import java.util.List;
import com.ruoyi.biz.domain.BizRecognizeHistory;

/**
 * 识别记录Service接口
 * 
 * @author ruoyi
 * @date 2021-02-24
 */
public interface IBizRecognizeHistoryService 
{
    /**
     * 查询识别记录
     * 
     * @param id 识别记录ID
     * @return 识别记录
     */
    public BizRecognizeHistory selectBizRecognizeHistoryById(Long id);

    /**
     * 查询识别记录列表
     * 
     * @param bizRecognizeHistory 识别记录
     * @return 识别记录集合
     */
    public List<BizRecognizeHistory> selectBizRecognizeHistoryList(BizRecognizeHistory bizRecognizeHistory);

    /**
     * 新增识别记录
     * 
     * @param bizRecognizeHistory 识别记录
     * @return 结果
     */
    public int insertBizRecognizeHistory(BizRecognizeHistory bizRecognizeHistory);

    /**
     * 修改识别记录
     * 
     * @param bizRecognizeHistory 识别记录
     * @return 结果
     */
    public int updateBizRecognizeHistory(BizRecognizeHistory bizRecognizeHistory);

    /**
     * 批量删除识别记录
     * 
     * @param ids 需要删除的识别记录ID
     * @return 结果
     */
    public int deleteBizRecognizeHistoryByIds(Long[] ids);

    /**
     * 删除识别记录信息
     * 
     * @param id 识别记录ID
     * @return 结果
     */
    public int deleteBizRecognizeHistoryById(Long id);
}
