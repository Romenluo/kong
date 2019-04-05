package com.li.kong.web;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

@RestController
@EnableAutoConfiguration
@RequestMapping("/upload")
public class Upload {
String uploadDir = "F:/E";

    @RequestMapping(value = "/uploadImage", method = RequestMethod.POST)
    public String uploadImage(@RequestParam(value = "file") MultipartFile[] files){
        StringBuffer result = new StringBuffer();
        try {
            for (int i = 0; i < files.length; i++) {
                if (files[i] != null) {
                    //调用上传方法
                    String fileName = executeUpload(files[i]);
                    result.append(fileName+";");
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return result.toString();
    }




    private String executeUpload(MultipartFile file) throws Exception{

        //文件后缀名
        String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        //上传文件名
        String fileName = UUID.randomUUID()+suffix;
        //服务端保存的文件对象
        File serverFile = new File(uploadDir+suffix);
        // 检测是否存在目录
        if (!serverFile.getParentFile().exists()) {
            serverFile.getParentFile().mkdirs();
        }
        //将上传的文件写入到服务器端文件内
        file.transferTo(serverFile);
        return null;
    }
}
