package com.ruoyi.web.controller.client;


import com.ruoyi.biz.domain.BizAuthority;
import com.ruoyi.biz.domain.BizCustomerInfo;
import com.ruoyi.biz.domain.BizRecognizeHistory;
import com.ruoyi.biz.service.IBizAuthorityService;
import com.ruoyi.biz.service.IBizCustomerInfoService;
import com.ruoyi.biz.service.IBizRecognizeHistoryService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.utils.ServletUtils;
import com.ruoyi.common.utils.uuid.IdUtils;
import com.ruoyi.framework.web.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 识别记录Controller
 *
 * @author ruoyi
 * @date 2021-02-24
 */
@RestController
@RequestMapping("/client/history")
public class ClientController extends BaseController {
    @Autowired
    private IBizRecognizeHistoryService bizRecognizeHistoryService;
    @Autowired
    private IBizAuthorityService bizAuthorityService;
    @Autowired
    private IBizCustomerInfoService bizCustomerInfoService;
    @Autowired
    private TokenService tokenService;

    /**
     * 用户查询识别记录列表
     */
    @PreAuthorize("@ss.hasPermi('client:history:list')")
    @GetMapping("/userlist")
    public TableDataInfo userlist(BizRecognizeHistory bizRecognizeHistory) {
        LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
        SysUser user = loginUser.getUser();

        BizAuthority bizAuthority = bizAuthorityService.selectBizAuthorityByCreater(user.getUserId() + "");
        bizRecognizeHistory.setAuthorityKey(bizAuthority.getAuthorityKey());
        startPage();
        List<BizRecognizeHistory> list = bizRecognizeHistoryService.selectBizRecognizeHistoryList(bizRecognizeHistory);
        return getDataTable(list);
    }

    /**
     * 用户信息
     */
    @PreAuthorize("@ss.hasPermi('client:history:userinfo')")
    @GetMapping("/userinfo")
    public AjaxResult userinfo() {
        LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
        if (loginUser == null) {
            return AjaxResult.error();
        }
        SysUser user = loginUser.getUser();

        AjaxResult ajax = AjaxResult.success();
        BizAuthority bizAuthority = bizAuthorityService.selectBizAuthorityByCreater(user.getUserId() + "");

        if(bizAuthority==null){
            BizAuthority newAuthority = new BizAuthority();
            newAuthority.setAuthorityKey(IdUtils.fastSimpleUUID());
            newAuthority.setDelFlag("0");
            newAuthority.setStatus("0");

            newAuthority.setCreateBy(user.getUserId()+"");
            bizAuthorityService.insertBizAuthority(newAuthority);
            ajax.put("authority", newAuthority);
        }else {
            ajax.put("authority", bizAuthority);
        }
        BizCustomerInfo bizCustomerInfo = bizCustomerInfoService.selectBizCustomerInfoByUserId(user.getUserId());
        if(bizCustomerInfo==null){
            BizCustomerInfo newCustomerInfo = new BizCustomerInfo();
            newCustomerInfo.setBalance("0.0");
            newCustomerInfo.setUserId(user.getUserId());
            newCustomerInfo.setCreateBy(user.getUserId()+"");
            bizCustomerInfoService.insertBizCustomerInfo(newCustomerInfo);
            ajax.put("info", newCustomerInfo);
        }else {
            ajax.put("info", bizCustomerInfo);
        }
        return ajax;

    }

}
