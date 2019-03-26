package com.li.kong.service;

import com.li.kong.dao.UserDao;
import com.li.kong.entity.User;
import com.li.kong.utils.MessageDigestType;
import com.li.kong.utils.StringHelper;

public class UserService {
    UserDao userDao = new UserDao();

    /**
     * 保存用户
     * @param user
     * @return
     */
    public Boolean save(User user){
        String pass = StringHelper.encrypt( user.getPassword() , MessageDigestType.MD5, null );
        user.setPassword(pass);
        user.setForbidden("N");
        try {
            userDao.save(user);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    /**
     * 根据邮箱查询用户
     * @param email 邮箱
     * @return 返回用户
     */
    public User loadEmail(String email){
        try{
            return userDao.loadEmail(email);
        }catch (Exception e){
            return null;
        }
    }
}
