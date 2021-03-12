package com.ruoyi.biz.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.biz.mapper.BizPriceMapper;
import com.ruoyi.biz.domain.BizPrice;
import com.ruoyi.biz.service.IBizPriceService;

/**
 * 价格Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-03-12
 */
@Service
public class BizPriceServiceImpl implements IBizPriceService 
{
    @Autowired
    private BizPriceMapper bizPriceMapper;

    /**
     * 查询价格
     * 
     * @param id 价格ID
     * @return 价格
     */
    @Override
    public BizPrice selectBizPriceById(Long id)
    {
        return bizPriceMapper.selectBizPriceById(id);
    }

    /**
     * 查询价格列表
     * 
     * @param bizPrice 价格
     * @return 价格
     */
    @Override
    public List<BizPrice> selectBizPriceList(BizPrice bizPrice)
    {
        return bizPriceMapper.selectBizPriceList(bizPrice);
    }

    /**
     * 新增价格
     * 
     * @param bizPrice 价格
     * @return 结果
     */
    @Override
    public int insertBizPrice(BizPrice bizPrice)
    {
        bizPrice.setCreateTime(DateUtils.getNowDate());
        return bizPriceMapper.insertBizPrice(bizPrice);
    }

    /**
     * 修改价格
     * 
     * @param bizPrice 价格
     * @return 结果
     */
    @Override
    public int updateBizPrice(BizPrice bizPrice)
    {
        bizPrice.setUpdateTime(DateUtils.getNowDate());
        return bizPriceMapper.updateBizPrice(bizPrice);
    }

    /**
     * 批量删除价格
     * 
     * @param ids 需要删除的价格ID
     * @return 结果
     */
    @Override
    public int deleteBizPriceByIds(Long[] ids)
    {
        return bizPriceMapper.deleteBizPriceByIds(ids);
    }

    /**
     * 删除价格信息
     * 
     * @param id 价格ID
     * @return 结果
     */
    @Override
    public int deleteBizPriceById(Long id)
    {
        return bizPriceMapper.deleteBizPriceById(id);
    }
}
