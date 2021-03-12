package com.ruoyi.biz.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 价格对象 biz_price
 * 
 * @author ruoyi
 * @date 2021-03-12
 */
public class BizPrice extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** 类型 */
    @Excel(name = "类型")
    private String picType;

    /** 价格 */
    @Excel(name = "价格")
    private String pic;

    /** 说明 */
    @Excel(name = "说明")
    private String explain_pic;

    /** 状态（0正常 1停用） */
    @Excel(name = "状态", readConverterExp = "0=正常,1=停用")
    private String status;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setPicType(String picType) 
    {
        this.picType = picType;
    }

    public String getPicType() 
    {
        return picType;
    }
    public void setPic(String pic) 
    {
        this.pic = pic;
    }

    public String getPic() 
    {
        return pic;
    }
    public void setExplain(String explain) 
    {
        this.explain_pic = explain;
    }

    public String getExplain() 
    {
        return explain_pic;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("picType", getPicType())
            .append("pic", getPic())
            .append("explain", getExplain())
            .append("status", getStatus())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
