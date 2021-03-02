package com.ruoyi.biz.service;

import java.util.List;
import com.ruoyi.biz.domain.BizAuthority;

/**
 * 调用keyService接口
 * 
 * @author ruoyi
 * @date 2021-02-24
 */
public interface IBizAuthorityService 
{
    /**
     * 查询调用key
     * 
     * @param keyId 调用keyID
     * @return 调用key
     */
    public BizAuthority selectBizAuthorityById(Long keyId);

    /**
     * 查询调用key列表
     * 
     * @param bizAuthority 调用key
     * @return 调用key集合
     */
    public List<BizAuthority> selectBizAuthorityList(BizAuthority bizAuthority);

    /**
     * 新增调用key
     * 
     * @param bizAuthority 调用key
     * @return 结果
     */
    public int insertBizAuthority(BizAuthority bizAuthority);

    /**
     * 修改调用key
     * 
     * @param bizAuthority 调用key
     * @return 结果
     */
    public int updateBizAuthority(BizAuthority bizAuthority);

    /**
     * 批量删除调用key
     * 
     * @param keyIds 需要删除的调用keyID
     * @return 结果
     */
    public int deleteBizAuthorityByIds(Long[] keyIds);

    /**
     * 删除调用key信息
     * 
     * @param keyId 调用keyID
     * @return 结果
     */
    public int deleteBizAuthorityById(Long keyId);
}
