package com.ruoyi.biz.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.biz.mapper.BizCustomerInfoMapper;
import com.ruoyi.biz.domain.BizCustomerInfo;
import com.ruoyi.biz.service.IBizCustomerInfoService;

/**
 * 用户信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-02-24
 */
@Service
public class BizCustomerInfoServiceImpl implements IBizCustomerInfoService 
{
    @Autowired
    private BizCustomerInfoMapper bizCustomerInfoMapper;

    /**
     * 查询用户信息
     * 
     * @param id 用户信息ID
     * @return 用户信息
     */
    @Override
    public BizCustomerInfo selectBizCustomerInfoById(Long id)
    {
        return bizCustomerInfoMapper.selectBizCustomerInfoById(id);
    }

    /**
     * 查询用户信息列表
     * 
     * @param bizCustomerInfo 用户信息
     * @return 用户信息
     */
    @Override
    public List<BizCustomerInfo> selectBizCustomerInfoList(BizCustomerInfo bizCustomerInfo)
    {
        return bizCustomerInfoMapper.selectBizCustomerInfoList(bizCustomerInfo);
    }

    /**
     * 新增用户信息
     * 
     * @param bizCustomerInfo 用户信息
     * @return 结果
     */
    @Override
    public int insertBizCustomerInfo(BizCustomerInfo bizCustomerInfo)
    {
        bizCustomerInfo.setCreateTime(DateUtils.getNowDate());
        return bizCustomerInfoMapper.insertBizCustomerInfo(bizCustomerInfo);
    }

    /**
     * 修改用户信息
     * 
     * @param bizCustomerInfo 用户信息
     * @return 结果
     */
    @Override
    public int updateBizCustomerInfo(BizCustomerInfo bizCustomerInfo)
    {
        bizCustomerInfo.setUpdateTime(DateUtils.getNowDate());
        return bizCustomerInfoMapper.updateBizCustomerInfo(bizCustomerInfo);
    }

    /**
     * 批量删除用户信息
     * 
     * @param ids 需要删除的用户信息ID
     * @return 结果
     */
    @Override
    public int deleteBizCustomerInfoByIds(Long[] ids)
    {
        return bizCustomerInfoMapper.deleteBizCustomerInfoByIds(ids);
    }

    /**
     * 删除用户信息信息
     * 
     * @param id 用户信息ID
     * @return 结果
     */
    @Override
    public int deleteBizCustomerInfoById(Long id)
    {
        return bizCustomerInfoMapper.deleteBizCustomerInfoById(id);
    }
}
