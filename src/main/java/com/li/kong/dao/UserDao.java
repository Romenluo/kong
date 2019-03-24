package com.li.kong.dao;

import com.li.kong.entity.User;
import com.li.kong.exception.DaoException;

import java.util.List;

public class UserDao implements Dao<User,Integer> {

    @Override
    public Integer save(User o) throws DaoException {
        return null;
    }

    @Override
    public boolean delete(Integer id) throws DaoException {
        return false;
    }

    @Override
    public boolean update(User user) throws DaoException {
        return false;
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
        User user = new User();
        return user;
    }

    @Override
    public List<User> loadList(User user) throws DaoException {
        return null;
    }

    @Override
    public List<User> findAll() throws DaoException {
        return null;
    }
}
