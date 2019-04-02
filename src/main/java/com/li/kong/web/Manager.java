package com.li.kong.web;

import com.alibaba.fastjson.JSONObject;
import com.li.kong.entity.Message;
import com.li.kong.entity.User;
import com.li.kong.service.UserService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * 后端管理控制器
 */
@RestController
@EnableAutoConfiguration
@RequestMapping("/manager")
public class Manager {
    private UserService us = new UserService();
    private HttpSession session;

    public @RequestMapping("findAllUser")
    List<User> findAllUser() {
        try {
            List<User> list = us.findAll();
            return list;
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 用户管理，对用户进行禁用或解除冻结
     * @param json
     * @param request
     * @return
     */
    public @RequestMapping("updateForbidden")
    Message updateForbidden(@RequestBody JSONObject json, HttpServletRequest request) {
        session = request.getSession();
        Message message = new Message();
        String email = (String) json.get("email");
        String forbidden = (String) json.get("forbidden");
        System.out.println(email + ":" + forbidden);
        User user = new User();
        user.setEmail(email);
        user.setForbidden(forbidden);
        boolean dd = us.updateForbidden(user);
        String msg = "N".equals(forbidden) ? "用户已经解封" : "用户已经被禁用";
        if (dd == true) {
            message.setCases("1");
            List<User> list = us.findAll();
            message.setList(list);
            message.setMsg(msg);
        } else {
            message.setCases("1");
            List<User> list = us.findAll();
            message.setList(list);
            message.setMsg(msg);
        }
        return message;
    }

    public @RequestMapping("uploadImage")
    String uploadImage() {
        return  "上传成功";
    }

    @PostMapping(value = "/fileUpload")
    public String fileUpload(@RequestParam(value = "file") MultipartFile file, Model model, HttpServletRequest request) {
        if (file.isEmpty()) {
            System.out.println("文件为空空");
        }
        String fileName = file.getOriginalFilename();  // 文件名
        System.out.println(fileName);
        /*String suffixName = fileName.substring(fileName.lastIndexOf("."));  // 后缀名
        String filePath = "D://temp-rainy//"; // 上传后的路径

        File dest = new File(fileName);
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String filename = "/temp-rainy/" + fileName;
        model.addAttribute("filename", filename);*/
        return "file";
    }

}
