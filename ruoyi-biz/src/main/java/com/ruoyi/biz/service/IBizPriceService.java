package com.ruoyi.biz.service;

import java.util.List;
import com.ruoyi.biz.domain.BizPrice;

/**
 * 价格Service接口
 * 
 * @author ruoyi
 * @date 2021-03-12
 */
public interface IBizPriceService 
{
    /**
     * 查询价格
     * 
     * @param id 价格ID
     * @return 价格
     */
    public BizPrice selectBizPriceById(Long id);

    /**
     * 查询价格列表
     * 
     * @param bizPrice 价格
     * @return 价格集合
     */
    public List<BizPrice> selectBizPriceList(BizPrice bizPrice);

    /**
     * 新增价格
     * 
     * @param bizPrice 价格
     * @return 结果
     */
    public int insertBizPrice(BizPrice bizPrice);

    /**
     * 修改价格
     * 
     * @param bizPrice 价格
     * @return 结果
     */
    public int updateBizPrice(BizPrice bizPrice);

    /**
     * 批量删除价格
     * 
     * @param ids 需要删除的价格ID
     * @return 结果
     */
    public int deleteBizPriceByIds(Long[] ids);

    /**
     * 删除价格信息
     * 
     * @param id 价格ID
     * @return 结果
     */
    public int deleteBizPriceById(Long id);
}
