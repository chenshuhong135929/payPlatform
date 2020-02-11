package com.m2micro.smartFactory.contoller;

import com.m2micro.smartFactory.bo.MerchantBO;
import com.m2micro.smartFactory.bo.PageBo;
import com.m2micro.smartFactory.enums.WebResultVoEnum;
import com.m2micro.smartFactory.model.Merchant;
import com.m2micro.smartFactory.service.FileService;
import com.m2micro.smartFactory.service.MerchantService;
import com.m2micro.smartFactory.utils.FileUpload;
import com.m2micro.smartFactory.utils.PageModel;
import com.m2micro.smartFactory.vo.FileVo;
import com.m2micro.smartFactory.vo.MerchantListVo;
import com.m2micro.smartFactory.vo.WebResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.jws.WebResult;

/**
 * 商户控制层
 */
@RestController
@RequestMapping("/merchant")
public class MerchantController {


    @Autowired
    private MerchantService merchantService;
    @Autowired
    private FileService fileService;
    /*
     * 修改/添加
     * */
    @PostMapping("/editMerchant")
    public WebResultVo editAdminUser(MerchantBO merchantBO) {

        return  merchantService.editMerchant(merchantBO);

    }

    /*
     * 分页获取数据
     * */
    @PostMapping("/pageMerchant")
    public WebResultVo pageMerchant(String searchContent,Integer pageNo,Integer pageSize){
        try {
            PageModel<MerchantListVo> pageModel = merchantService.pageMerchant(searchContent,new PageBo(pageSize,pageNo));
            return WebResultVo.getInstance().buildingSuccess(pageModel);
        }catch (Exception e){
            e.printStackTrace();
            return WebResultVo.getInstance().building(WebResultVoEnum.ERROR);
        }

    }
    /*
     * 修改启禁用状态
     * */
    @PostMapping("/updateDisableStatus")
    public WebResultVo updateDisableStatus(String disableStatus, Integer id){
        try {
            if(!StringUtils.hasText(disableStatus) || id == null){
                return  WebResultVo.getInstance().building(WebResultVoEnum.PARAMETERERROR.getCode(),"参数有误！");
            }
            merchantService.updateDisableStatus(disableStatus, id);
            return WebResultVo.getInstance().buildingSuccess();
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

    @RequestMapping("/uploadFile")
    public WebResultVo uploadFile(@RequestParam("file") MultipartFile file,Integer merchantId){
        FileVo fileVo = null;
        String fileDir = "advert";
        try {
            String filename = FileUpload.writeUploadFile(file,fileDir);
            fileVo =  fileService.saveMerchantFile("picture"+ "/"+fileDir + filename,filename,merchantId);
        }catch (Exception e){

        }
        return WebResultVo.getInstance().buildingSuccess(fileVo);
    }


}
