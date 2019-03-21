package com.li.kong.dao;

import com.li.kong.entity.Photos;
import com.li.kong.exception.DaoException;

import java.util.List;

public class PhotosDao implements Dao<Photos,Integer> {
    @Override
    public Integer save(Photos o) throws DaoException {
        return null;
    }

    @Override
    public boolean delete(Integer id) throws DaoException {
        return false;
    }

    @Override
    public boolean update(Photos photos) throws DaoException {
        return false;
    }

    @Override
    public Photos find(Integer id) throws DaoException {
        return null;
    }

    @Override
    public Photos load(Photos photos) throws DaoException {
        return null;
    }

    @Override
    public List<Photos> loadList(Photos photos) throws DaoException {
        return null;
    }

    @Override
    public List<Photos> findAll() throws DaoException {
        return null;
    }
}
