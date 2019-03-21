package com.li.kong.dao;

import com.li.kong.entity.Role;
import com.li.kong.exception.DaoException;

import java.util.List;

public class RoleDao implements Dao<Role,Integer> {

    @Override
    public Integer save(Role o) throws DaoException {
        return null;
    }

    @Override
    public boolean delete(Integer id) throws DaoException {
        return false;
    }

    @Override
    public boolean update(Role role) throws DaoException {
        return false;
    }

    @Override
    public Role find(Integer id) throws DaoException {
        return null;
    }

    @Override
    public Role load(Role role) throws DaoException {
        return null;
    }

    @Override
    public List<Role> loadList(Role role) throws DaoException {
        return null;
    }

    @Override
    public List<Role> findAll() throws DaoException {
        return null;
    }
}
