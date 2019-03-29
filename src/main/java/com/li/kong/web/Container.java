package com.li.kong.web;

import com.alibaba.fastjson.JSONObject;
import com.li.kong.entity.Message;
import com.li.kong.entity.Role;
import com.li.kong.entity.User;
import com.li.kong.service.RoleService;
import com.li.kong.service.UserService;
import com.li.kong.utils.MessageDigestType;
import com.li.kong.utils.StringHelper;
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

    private RoleService rs = new RoleService();
    private UserService us = new UserService();
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

    /**
     * 获取验证码，返回提示消息
     * @return
     */
    public @RequestMapping("verificationCode") Message verification(@RequestBody JSONObject json,HttpServletRequest request){
        session = request.getSession();
        String code = (int)(Math.random()*1000000)+"";
        String email = (String)json.get("userName");
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("1689488576@qq.com");
        message.setTo(email);
        message.setSubject("kong给你发的验证码");
        message.setText("验证码："+code);

        mailSender.send(message);
        session.setAttribute("code",code);
        Message msg = new Message();
        msg.setMsg("验证码发送成功");
        return msg;
    }

    /**
     * 注册，点击注册时发送数据到后台，进行判断，然后存储
     * @param json
     * @param request
     * @return
     */
    public @RequestMapping("signUp") Message signUp(@RequestBody JSONObject json,HttpServletRequest request){
        session = request.getSession();
        String code = (String)session.getAttribute("code");
        String email = (String)json.get("username");
        String password = (String)json.get("pass");
        String petName = (String)json.get("petName");
        String pageCode = (String)json.get("pageCode");

        Message message = new Message();
        if(!pageCode.equals(code)){
            message.setCases("-1");
            message.setMsg("验证码不正确");
            return message;
        }else {
            User userload = us.loadEmail(email);
            if(userload!=null){
                message.setCases("-2");
                message.setMsg("用户已经存在");
                return message;
            }else {
                User user = new User();
                user.setEmail(email);
                user.setPassword(password);
                user.setPetName(petName);
                Role role = new Role();
                role.setId(2);
                user.setRole(role);
                us.save(user);
                message.setCases("1");
                message.setMsg("注册成功");
                return message;
            }
        }
    }

    /**
     * 登录，根据用户邮箱登录，并判断是否为管理员
     * @return
     */
    public @RequestMapping("signIn") Message signIn(@RequestBody JSONObject json,HttpServletRequest request){
        session = request.getSession();

        String email = (String)json.get("username");
        String password = (String)json.get("password");
        Message msg = new Message();

        User user = us.loadEmail(email);
        if(user==null){
            msg.setMsg("该用户不存在");
            msg.setCases("-1");
            return msg;
        }else {

            Role role = rs.findId(user.getRoleId());

            if(role==null){
                msg.setMsg("该用户不存在");
                msg.setCases("-1");
                return msg;
            }else {
                String pass = StringHelper.encrypt( password , MessageDigestType.MD5, null );
                if(pass.equals(user.getPassword())){
                    session.setAttribute("user",user);
                    user.setRole(role);
                    msg.setMsg("登录成功");
                    msg.setUser(user);
                    msg.setCases("1");
                    return msg;
                }else {
                    msg.setMsg("密码不正确");
                    msg.setCases("-1");
                    return msg;
                }
            }
        }
    }

    /**
     * 退出登录
     * @param request
     * @return
     */
    public @RequestMapping("logout") Message logout(HttpServletRequest request){
        session = request.getSession();
        session.removeAttribute("user");
        Message message = new Message();
        message.setCases("-1");
        message.setMsg("退出登录");
        User user = (User)session.getAttribute("user");
        message.setUser(user);
        return message;
    }

    /**
     * 更新用户信息
     * @param json 前端传递过来的数据
     * @param request
     * @return
     */
    public @RequestMapping("updateInfo") Message updateInfo(@RequestBody JSONObject json,HttpServletRequest request){
        session = request.getSession();
        User usersess = (User)session.getAttribute("user");
        Message message = new Message();
        String email = (String)json.get("email");
        String petName= (String)json.get("petName");
        String qq = (String)json.get("qq");
        int roleId = usersess.getRoleId();
        User user = new User();
        user.setEmail(email);
        user.setPetName(petName);
        user.setRoleId(roleId);
        user.setQq(qq);
        Role role = rs.findId(user.getRoleId());
        try{
            us.updateInfo(user);
            User user1 = us.loadEmail(email);
            user1.setRole(role);
            message.setCases("1");
            message.setMsg("更新成功");
            message.setUser(user1);
        }catch (Exception e){
            User user1 = us.loadEmail(email);
            user1.setRole(role);
            message.setCases("1");
            message.setMsg("更新失败");
            message.setUser(user1);
        }
        return message;
    }

    public @RequestMapping("updatePassword") Message updatePassword(@RequestBody JSONObject json,HttpServletRequest request){
        session = request.getSession();

        Message message = new Message();
        String email = (String)json.get("email");
        String password = (String)json.get("password");

        /*User user = new User();
        try{
            us.updatePassword(user);
            User user1 = us.loadEmail(email);

            message.setCases("1");
            message.setMsg("更新成功");
            message.setUser(user1);
        }catch (Exception e){
            User user1 = us.loadEmail(email);
            message.setCases("1");
            message.setMsg("更新失败");
            message.setUser(user1);
        }*/
        return message;
    }
}
