package com.li.kong.web;

import com.alibaba.fastjson.JSONObject;
import com.li.kong.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@EnableAutoConfiguration
@RequestMapping("/user")
public class Container {
    @Autowired
    private JavaMailSender mailSender;

    private HttpSession session;
    @RequestMapping("/") String home() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("1689488576@qq.com");
        message.setTo("romenluomen@sina.com");
        message.setSubject("主题：简单邮件");
        message.setText("你好我是测试内容");

        mailSender.send(message);
        return"你好，世界!";
    }
    public @RequestMapping("signIn")
    User signIn(){
        User user = new User();
        user.setId(1);
        user.setEmail("123456@qq.com");
        user.setQq("123456789");
        return user;
    }

    /**
     * 获取验证码，返回提示消息
     * @return
     */

    public @RequestMapping("verificationCode") String verification(@RequestBody JSONObject json,HttpServletRequest request){
        session = request.getSession();
        String code = (int)(Math.random()*1000000)+"";
        String username = (String)json.get("userName");
        session.setAttribute("code",code);
        return code;
    }
    public @RequestMapping("signUp") String signUp(@RequestBody JSONObject json,HttpServletRequest request){
        session = request.getSession();
        String code = (String)session.getAttribute("code");
        System.out.println(code);
        return "success";
    }
}
