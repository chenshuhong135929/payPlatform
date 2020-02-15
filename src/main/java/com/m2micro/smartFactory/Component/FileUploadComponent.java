package com.m2micro.smartFactory.Component;

import com.m2micro.smartFactory.bo.FileBo;
import com.m2micro.smartFactory.utils.RandomUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
@ConfigurationProperties(prefix = "fileuploadcomponent")
@Component
public class FileUploadComponent {

    private String realpath;

    private String picture;
    /**
     * 文件上传处理
     *
     * @param file
     * @return
     */
/*
    public FileBo writeUploadFile(MultipartFile file, String module) {
        String filename = file.getOriginalFilename();
        String imageUrl  = realpath +  module +File.separator;

        File fileDir = new File(imageUrl);
        if (!fileDir.exists())
            fileDir.mkdirs();

        String extname = FilenameUtils.getExtension(filename);
        filename = Math.abs(file.getOriginalFilename().hashCode()) + RandomUtils.createRandomString( 4 ) + "." + extname;
        InputStream input = null;
        FileOutputStream fos = null;
        try {
            input = file.getInputStream();
            fos = new FileOutputStream(imageUrl + "/" + filename);
            IOUtils.copy(input, fos);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            IOUtils.closeQuietly(input);
            IOUtils.closeQuietly(fos);
        }

        FileBo fileBo = new FileBo();
        fileBo.setFileName(file.getOriginalFilename());
        fileBo.setFilePath(picture + module + "/" + filename);

        return fileBo;
    }
*/


    /**
     * 文件上传处理
     *
     * @param multipartFile
     * @return
     */
    public FileBo writeUploadFile(MultipartFile multipartFile, String module) {
        String fileName = multipartFile.getOriginalFilename();
        String imageUrl  = realpath +  module +File.separator;

        File fileDir = new File(imageUrl);
        if (!fileDir.exists())
            fileDir.mkdirs();
        String extname = FilenameUtils.getExtension(fileName);

        fileName = Math.abs(multipartFile.getOriginalFilename().hashCode()) + RandomUtils.createRandomString( 4 ) + "." + extname;

        try {
            File file =  new File(imageUrl + "/" + fileName);
            multipartFile.transferTo(file);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        FileBo fileBo = new FileBo();
        fileBo.setFileName(multipartFile.getOriginalFilename());
        fileBo.setFilePath(picture + module + "/" + fileName);

        return fileBo;
    }




    public String getRealpath() {
        return realpath;
    }

    public void setRealpath(String realpath) {
        this.realpath = realpath;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}
