package com.li.kong.web;

import com.alibaba.fastjson.JSONObject;
import com.li.kong.entity.Message;
import com.li.kong.entity.User;
import com.li.kong.service.UserService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
}
