package com.m2micro.smartFactory.service.impl;

import com.m2micro.smartFactory.bo.FileBo;
import com.m2micro.smartFactory.dao.FileDao;
import com.m2micro.smartFactory.enums.FileTypeEnum;
import com.m2micro.smartFactory.model.File;
import com.m2micro.smartFactory.service.FileService;
import com.m2micro.smartFactory.vo.FileVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FileServiceImpl implements FileService {
    @Autowired
    private FileDao fileDao;
    @Override
    public FileVo saveMerchantFile(String filePath,String fileName,Integer merchantId) {
        File file = new File();
        file.setFileName(fileName);
        file.setFilePath(filePath);
        file.setType(FileTypeEnum.A.toString());
        if(merchantId != null){
            file.setRelated(merchantId);
        }
        fileDao.save(file);
        FileVo fileVo = new FileVo();
        fileVo.setId(file.getId());
        fileVo.setFilePath(file.getFilePath());
        return fileVo;
    }

    @Override
    public List<FileVo> findMerchantImageFile(Integer merchantId) {
        List<File> files = fileDao.findByRelatedAndType(merchantId,FileTypeEnum.A.toString());
        List<FileVo>  fileVos = new ArrayList<>();
        for(File file : files){
            FileVo fileVo = new FileVo();
            fileVo.setId(file.getId());
            fileVo.setFilePath(file.getFilePath());
            fileVos.add(fileVo);
        }
        return fileVos;
    }

    @Override
    public void updateBindMerchantFile(Integer id, List<FileBo> fileVos) {
        for(FileBo fileVo : fileVos){
            File file = this.fileDao.findById(fileVo.getId()).get();
            file.setRelated(id);
            this.fileDao.save(file);

        }

    }

    @Override
    public FileVo saveBusinessLicensetFile(String filePath, String filename, Integer merchantId) {
        //先看看有没有旧的有的话替换掉
        List<File> files = fileDao.findByRelatedAndType(merchantId,FileTypeEnum.B.toString());
        if(files != null && files.size() > 0){
            for(File file : files ){
                fileDao.delete(file);
            }
        }
        File file = new File();
        file.setFileName(filename);
        file.setFilePath(filePath);
        file.setType(FileTypeEnum.B.toString());
        if(merchantId != null){
            file.setRelated(merchantId);
        }
        fileDao.save(file);
        FileVo fileVo = new FileVo();
        fileVo.setId(file.getId());
        fileVo.setFilePath(file.getFilePath());
        return fileVo;
    }

    @Override
    public FileVo findBusinessLicensetFile(Integer merchantId) {
        List<File> files = fileDao.findByRelatedAndType(merchantId,FileTypeEnum.B.toString());
        if(files != null && files.size() > 0){
            FileVo fileVo = new FileVo();
            fileVo.setId(files.get(0).getId());
            fileVo.setFilePath(files.get(0).getFilePath());
            return fileVo;
        }
        return null;
    }
}
