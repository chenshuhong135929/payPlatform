package com.m2micro.smartFactory.service;

import com.m2micro.smartFactory.bo.FileBo;
import com.m2micro.smartFactory.vo.FileVo;

import java.util.List;

public interface FileService {
    /*
    保存上传的商户文件
     */
    FileVo saveMerchantFile(String filePath,String fileName,Integer merchantId);

    /*
     获取商户的门头照
     */
    List<FileVo> findMerchantImageFile(Integer merchantId);

    /*
    管理上传的门户图片
     */
    void updateBindMerchantFile(Integer id, List<FileBo> fileVos);

    /*
    保存营业执照图片
     */
    FileVo saveBusinessLicensetFile(String s, String filename, Integer merchantId);

    /*
    获取营业执照路径
     */
    FileVo findBusinessLicensetFile(Integer id);
}
