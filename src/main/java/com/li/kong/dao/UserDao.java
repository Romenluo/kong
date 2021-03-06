package com.li.kong.dao;

import com.li.kong.entity.User;
import com.li.kong.exception.DaoException;
import com.li.kong.mapper.UserMapper;
import com.li.kong.utils.DataSource;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class UserDao implements Dao<User,Integer> {

    private SqlSession session ;
    UserMapper mapper;
    @Override
    public Integer save(User o) throws DaoException{
        int count;
        try{
            session = new DataSource().init();
            mapper = session.getMapper(UserMapper.class);
            count = mapper.save(o);
            session.commit();
        }catch (Exception e){
            session.rollback();
            throw new RuntimeException();
        }
        session.close();
        return count;
    }

    @Override
    public boolean delete(Integer id) throws DaoException {
        return false;
    }

    @Override
    public boolean update(User user) throws DaoException {
        int count;
        try{
            session = new DataSource().init();
            mapper = session.getMapper(UserMapper.class);
            count = mapper.updateInfo(user);
            session.commit();
        }catch (Exception e){
            session.rollback();
            throw new RuntimeException(e);
        }
        session.close();
        if(count>=1){
           return true;
        }else {
            return false;
        }
    }

    /**
     * 修改密码
     * @param user
     * @return
     * @throws DaoException
     */
    public boolean updatePassword(User user) throws DaoException {
        int count;
        try{
            session = new DataSource().init();
            mapper = session.getMapper(UserMapper.class);
            count = mapper.updatePassword(user);
            session.commit();
        }catch (Exception e){
            session.rollback();
            throw new RuntimeException(e);
        }
        session.close();
        if(count>=1){
            return true;
        }else {
            return false;
        }
    }

    /**
     * 修改用户状态，是否被禁用
     * @param user
     * @return
     * @throws DaoException
     */
    public boolean updateForbidden(User user) throws DaoException {
        int count;
        try{
            session = new DataSource().init();
            mapper = session.getMapper(UserMapper.class);
            count = mapper.updateForbidden(user);
            session.commit();
        }catch (Exception e){
            session.rollback();
            throw new RuntimeException(e);
        }
        session.close();
        if(count>=1){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public User find(Integer id) throws DaoException {
        return null;
    }

    @Override
    public User load(User user) throws DaoException {
        return null;
    }

    /**
     * 根据邮箱查询
     * @param email 用户邮箱
     * @return 返回用户信息
     * @throws DaoException
     */
    public User loadEmail(String email) throws DaoException{
        User user;
        try{
            session = new DataSource().init();
            mapper = session.getMapper(UserMapper.class);
            user = mapper.loadEmail(email);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        session.close();
        return user;
    }

    /**
     * 根据用户id查询用户
     * @param id
     * @return
     * @throws DaoException
     */
    public User loadId(Integer id) throws DaoException{
        User user;
        try{
            session = new DataSource().init();
            mapper = session.getMapper(UserMapper.class);
            user = mapper.loadUser(id);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        session.close();
        return user;
    }

    @Override
    public List<User> loadList(User user) throws DaoException {
        return null;
    }

    @Override
    public List<User> findAll() throws DaoException {
        List<User> list;
        try{
            session = new DataSource().init();
            mapper = session.getMapper(UserMapper.class);
            list = mapper.listUser();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        session.close();

        return list;
    }
}
