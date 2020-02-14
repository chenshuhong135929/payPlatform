package com.m2micro.smartFactory.Component;

import com.m2micro.smartFactory.bo.FileBo;
import com.m2micro.smartFactory.utils.RandomUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
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
    public FileBo writeUploadFile(MultipartFile file, String module) {
        String filename = file.getOriginalFilename();
        realpath = realpath +  module +"/";
        File fileDir = new File(realpath);
        if (!fileDir.exists())
            fileDir.mkdirs();

        String extname = FilenameUtils.getExtension(filename);
        filename = Math.abs(file.getOriginalFilename().hashCode()) + RandomUtils.createRandomString( 4 ) + "." + extname;
        InputStream input = null;
        FileOutputStream fos = null;
        try {
            input = file.getInputStream();
            fos = new FileOutputStream(realpath + "/" + filename);
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
