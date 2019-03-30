package com.li.kong.service;

import com.li.kong.dao.UserDao;
import com.li.kong.entity.User;
import com.li.kong.exception.DaoException;
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
//            throw new DaoException(""+e);
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

    public boolean updateInfo(User user){
         User user1;
        try{
            user1 = userDao.loadEmail(user.getEmail());
            user1.setPetName(user.getPetName());
            user1.setQq(user.getQq());
            userDao.update(user1);
            return true;
        }catch (Exception e){
            throw new DaoException("更新失败"+e);
        }
    }

    /**
     * 修改密码
     * @param user 用户对象
     * @return
     */
    public boolean updatePassword(User user){
        User user1;
        try{
            user1 = userDao.loadEmail(user.getEmail());
            String pass = StringHelper.encrypt( user.getPassword() , MessageDigestType.MD5, null );
            user1.setPassword(pass);
            userDao.updatePassword(user1);
            return true;
        }catch (Exception e){
            throw new DaoException("更新失败"+e);
        }
    }
}
