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

    @Override
    public List<User> loadList(User user) throws DaoException {
        return null;
    }

    @Override
    public List<User> findAll() throws DaoException {
        return null;
    }
}
