package com.li.kong.dao;

import com.li.kong.entity.Information;
import com.li.kong.exception.DaoException;

import java.util.List;

public class InformationDao implements Dao<Information,Integer> {
    @Override
    public Integer save(Information o) throws DaoException {
        return null;
    }

    @Override
    public boolean delete(Integer id) throws DaoException {
        return false;
    }

    @Override
    public boolean update(Information information) throws DaoException {
        return false;
    }

    @Override
    public Information find(Integer id) throws DaoException {
        return null;
    }

    @Override
    public Information load(Information information) throws DaoException {
        return null;
    }

    @Override
    public List<Information> loadList(Information information) throws DaoException {
        return null;
    }

    @Override
    public List<Information> findAll() throws DaoException {
        return null;
    }
}
