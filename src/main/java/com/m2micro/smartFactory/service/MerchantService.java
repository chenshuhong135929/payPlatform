package com.m2micro.smartFactory.service;

import com.m2micro.smartFactory.bo.MerchantBO;
import com.m2micro.smartFactory.bo.PageBo;
import com.m2micro.smartFactory.model.Merchant;
import com.m2micro.smartFactory.utils.PageModel;
import com.m2micro.smartFactory.vo.MerchantListVo;
import com.m2micro.smartFactory.vo.WebResultVo;

public interface MerchantService {

    /**
     * 添加或修改
     * @param merchant
     * @return
     */
    WebResultVo editMerchant(MerchantBO merchant);

    /**
     *
     * 分页查找数据
     * @param searchContent
     * @param pageBo
     * @return
     * @throws Exception
     */
    PageModel<MerchantListVo>pageMerchant(String searchContent, PageBo pageBo) throws  Exception;

    /**
     * 删除
     * @param id
     * @return
     */
    WebResultVo deleteMerchant(Integer id);

    /**
     *
     * 修改冻结状态
     * @param disableStatus
     * @param id
     * @return
     * @throws Exception
     */
    void updateDisableStatus(String disableStatus, Integer id) throws  Exception;
}
