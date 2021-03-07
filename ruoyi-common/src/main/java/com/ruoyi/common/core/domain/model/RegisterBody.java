package com.ruoyi.common.core.domain.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * 用户注册对象
 * 
 * @author ruoyi
 */
public class RegisterBody
{
    /**
     * 用户名
     */
    private String username;

    /**
     * 用户密码
     */
    private String password;
    /**
     * 重复密码
     */
    private String repassword;
    /**
     * 验证码
     */
    private String code;

    /**
     * 唯一标识
     */
    private String uuid = "";

    public String getUuid()
    {
        return uuid;
    }

    public void setUuid(String uuid)
    {
        this.uuid = uuid;
    }

//    @NotBlank(message = "密码不能为空")
//    @Size(min = 6, max = 11, message = "密码长度不能超过11个字符,小于6个字符")
    public String getRepassword() {
        return repassword;
    }

    public void setRepassword(String repassword) {
        this.repassword = repassword;
    }

//    @NotBlank(message = "用户手机号不能为空")
//    @Size(min = 0, max = 11, message = "手机号码长度不能超过11个字符")
    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }
//    @NotBlank(message = "密码不能为空")
//    @Size(min = 6, max = 11, message = "密码长度不能超过11个字符,小于6个字符")
    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getCode()
    {
        return code;
    }

    public void setCode(String code)
    {
        this.code = code;
    }


}
