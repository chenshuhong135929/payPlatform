package com.m2micro.smartFactory.contoller;

import com.m2micro.smartFactory.bo.PageBo;
import com.m2micro.smartFactory.enums.WebResultVoEnum;
import com.m2micro.smartFactory.model.Merchant;
import com.m2micro.smartFactory.service.MerchantService;
import com.m2micro.smartFactory.utils.PageModel;
import com.m2micro.smartFactory.vo.WebResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 商户控制层
 */
@RestController
public class MerchantController {


    @Autowired
    private MerchantService merchantService;

    /*
     * 修改/添加
     * */
    @PostMapping("/editMerchant")
    public WebResultVo editAdminUser(Merchant merchant) {

        return  merchantService.editMerchant(merchant);

    }

    /*
     * 分页获取数据
     * */
    @PostMapping("/pageMerchant")
    public WebResultVo pageMerchant(String searchContent,Integer pageNo,Integer pageSize){
        try {
            PageModel<Merchant> pageModel = merchantService.pageMerchant(searchContent,new PageBo(pageSize,pageNo));
            return WebResultVo.getInstance().buildingSuccess(pageModel);
        }catch (Exception e){
            e.printStackTrace();
            return WebResultVo.getInstance().building(WebResultVoEnum.ERROR);
        }

    }

    /**
     * 删除
     * @param id
     * @return
     */
    @PostMapping("/deleteMerchant")
    public WebResultVo deleteMerchant(Integer id ){
        return      merchantService.deleteMerchant(id);
    }


}
