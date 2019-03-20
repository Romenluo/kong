package com.li.kong.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class Contoner {
    @Autowired
    private JavaMailSender mailSender;
    @RequestMapping("/") String home() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("1689488576@qq.com");
        message.setTo("romenluomen@sina.com");
        message.setSubject("主题：简单邮件");
        message.setText("你好我是测试内容");

        mailSender.send(message);
        return"你好，世界!";
    }
}
