package com.ruoyi.biz.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.biz.mapper.BizAuthorityMapper;
import com.ruoyi.biz.domain.BizAuthority;
import com.ruoyi.biz.service.IBizAuthorityService;

/**
 * 调用keyService业务层处理
 * 
 * @author ruoyi
 * @date 2021-02-24
 */
@Service
public class BizAuthorityServiceImpl implements IBizAuthorityService 
{
    @Autowired
    private BizAuthorityMapper bizAuthorityMapper;

    /**
     * 查询调用key
     * 
     * @param keyId 调用keyID
     * @return 调用key
     */
    @Override
    public BizAuthority selectBizAuthorityById(Long keyId)
    {
        return bizAuthorityMapper.selectBizAuthorityById(keyId);
    }

    @Override
    public BizAuthority selectBizAuthorityByCreater(String createBy) {
        return bizAuthorityMapper.selectBizAuthorityByCreater(createBy);
    }


    /**
     * 查询调用key列表
     * 
     * @param bizAuthority 调用key
     * @return 调用key
     */
    @Override
    public List<BizAuthority> selectBizAuthorityList(BizAuthority bizAuthority)
    {
        return bizAuthorityMapper.selectBizAuthorityList(bizAuthority);
    }

    /**
     * 新增调用key
     * 
     * @param bizAuthority 调用key
     * @return 结果
     */
    @Override
    public int insertBizAuthority(BizAuthority bizAuthority)
    {
        bizAuthority.setCreateTime(DateUtils.getNowDate());
        return bizAuthorityMapper.insertBizAuthority(bizAuthority);
    }

    /**
     * 修改调用key
     * 
     * @param bizAuthority 调用key
     * @return 结果
     */
    @Override
    public int updateBizAuthority(BizAuthority bizAuthority)
    {
        bizAuthority.setUpdateTime(DateUtils.getNowDate());
        return bizAuthorityMapper.updateBizAuthority(bizAuthority);
    }

    /**
     * 批量删除调用key
     * 
     * @param keyIds 需要删除的调用keyID
     * @return 结果
     */
    @Override
    public int deleteBizAuthorityByIds(Long[] keyIds)
    {
        return bizAuthorityMapper.deleteBizAuthorityByIds(keyIds);
    }

    /**
     * 删除调用key信息
     * 
     * @param keyId 调用keyID
     * @return 结果
     */
    @Override
    public int deleteBizAuthorityById(Long keyId)
    {
        return bizAuthorityMapper.deleteBizAuthorityById(keyId);
    }
}
