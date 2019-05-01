package com.li.kong.test;

import com.li.kong.entity.Role;
import com.li.kong.entity.User;
import com.li.kong.service.UserService;
import com.li.kong.utils.MessageDigestType;
import com.li.kong.utils.StringHelper;
import org.junit.Test;

import java.util.List;

public class UserTestInit {
    public @Test
    void saveTest(){
        UserService us = new UserService();
        User user = new User();
        Role role = new Role();
        role.setId(2);
        user.setEmail("kong@men.com");
        user.setPassword("123456");
        user.setPetName("kongli");
        user.setQq("123456789");
        user.setForbidden("N");
        user.setRole(role);

        Boolean dd = us.save(user);
        System.out.println(dd);
    }

    public @Test
    void loadEmialTest(){
        UserService us = new UserService();
        User user = us.loadEmail("1689488576@qq.com");
        System.out.println(user.getPetName());
    }

    public @Test
    void updateInfo(){
        UserService us = new UserService();
        User user = new User();
        user.setEmail("1689488576@qq.com");
        user.setPetName("问");
        user.setQq("123");
        Boolean bb = us.updateInfo(user);
        System.out.println(bb);
    }

    public @Test
    void updatePass(){
        UserService us = new UserService();
        User user = new User();
        String password = "222222";
        String pass = StringHelper.encrypt( password , MessageDigestType.MD5, null );
        user.setEmail("1689488576@qq.com");
        user.setPassword(pass);
        Boolean bb = us.updatePassword(user);
        System.out.println(bb);
    }

    public @Test
    void updateForbidden(){
        UserService us = new UserService();
        User user = new User();
        user.setEmail("1689488576@qq.com");
        String forbidden = "Y";
        user.setForbidden(forbidden);
        Boolean bb = us.updateForbidden(user);
        System.out.println(bb);
    }

    public @Test
    void findAll(){
        UserService us = new UserService();
        List<User> list = us.findAll();
        for(int i = 0;i<list.size();i++){
            System.out.println(list.get(i).getPetName());
        }

    }

}
