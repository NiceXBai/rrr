package com.ruoyi.biz.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 识别记录对象 biz_recognize_history
 * 
 * @author ruoyi
 * @date 2021-02-24
 */
public class BizRecognizeHistory extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** key */
    @Excel(name = "key")
    private String authorityKey;

    /** 识别耗时 */
    @Excel(name = "识别耗时")
    private String recognizeTime;

    /** 识别方式 */
    @Excel(name = "识别方式")
    private String recognizeFrom;

    /** 费用（元） */
    @Excel(name = "费用", readConverterExp = "元=")
    private String expense;

    /** 结果 */
    @Excel(name = "结果")
    private String result;

    /** 状态（0正常 1错误） */
    @Excel(name = "状态", readConverterExp = "0=正常,1=错误")
    private String status;

    /** 识别类型 */
    @Excel(name = "识别类型")
    private String recognizeType;

    /** 识别ip */
    @Excel(name = "识别ip")
    private String recognizeIp;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setAuthorityKey(String authorityKey) 
    {
        this.authorityKey = authorityKey;
    }

    public String getAuthorityKey() 
    {
        return authorityKey;
    }
    public void setRecognizeTime(String recognizeTime) 
    {
        this.recognizeTime = recognizeTime;
    }

    public String getRecognizeTime() 
    {
        return recognizeTime;
    }
    public void setRecognizeFrom(String recognizeFrom) 
    {
        this.recognizeFrom = recognizeFrom;
    }

    public String getRecognizeFrom() 
    {
        return recognizeFrom;
    }
    public void setExpense(String expense) 
    {
        this.expense = expense;
    }

    public String getExpense() 
    {
        return expense;
    }
    public void setResult(String result) 
    {
        this.result = result;
    }

    public String getResult() 
    {
        return result;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }
    public void setRecognizeType(String recognizeType) 
    {
        this.recognizeType = recognizeType;
    }

    public String getRecognizeType() 
    {
        return recognizeType;
    }
    public void setRecognizeIp(String recognizeIp) 
    {
        this.recognizeIp = recognizeIp;
    }

    public String getRecognizeIp() 
    {
        return recognizeIp;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("authorityKey", getAuthorityKey())
            .append("recognizeTime", getRecognizeTime())
            .append("recognizeFrom", getRecognizeFrom())
            .append("expense", getExpense())
            .append("result", getResult())
            .append("status", getStatus())
            .append("recognizeType", getRecognizeType())
            .append("recognizeIp", getRecognizeIp())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
