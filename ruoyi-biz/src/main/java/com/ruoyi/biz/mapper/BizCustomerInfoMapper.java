package com.ruoyi.biz.mapper;

import java.util.List;
import com.ruoyi.biz.domain.BizCustomerInfo;

/**
 * 用户信息Mapper接口
 * 
 * @author ruoyi
 * @date 2021-02-24
 */
public interface BizCustomerInfoMapper 
{
    /**
     * 查询用户信息
     * 
     * @param id 用户信息ID
     * @return 用户信息
     */
    public BizCustomerInfo selectBizCustomerInfoById(Long id);

    /**
     * 查询用户信息列表
     * 
     * @param bizCustomerInfo 用户信息
     * @return 用户信息集合
     */
    public List<BizCustomerInfo> selectBizCustomerInfoList(BizCustomerInfo bizCustomerInfo);

    /**
     * 新增用户信息
     * 
     * @param bizCustomerInfo 用户信息
     * @return 结果
     */
    public int insertBizCustomerInfo(BizCustomerInfo bizCustomerInfo);

    /**
     * 修改用户信息
     * 
     * @param bizCustomerInfo 用户信息
     * @return 结果
     */
    public int updateBizCustomerInfo(BizCustomerInfo bizCustomerInfo);

    /**
     * 删除用户信息
     * 
     * @param id 用户信息ID
     * @return 结果
     */
    public int deleteBizCustomerInfoById(Long id);

    /**
     * 批量删除用户信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteBizCustomerInfoByIds(Long[] ids);
}
