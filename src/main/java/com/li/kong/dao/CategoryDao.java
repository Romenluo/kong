package com.li.kong.dao;

import com.li.kong.entity.Category;
import com.li.kong.exception.DaoException;

import java.util.List;

public class CategoryDao implements Dao<Category,Integer> {
    @Override
    public Integer save(Category o) throws DaoException {
        return null;
    }

    @Override
    public boolean delete(Integer id) throws DaoException {
        return false;
    }

    @Override
    public boolean update(Category category) throws DaoException {
        return false;
    }

    @Override
    public Category find(Integer id) throws DaoException {
        return null;
    }

    @Override
    public Category load(Category category) throws DaoException {
        return null;
    }

    @Override
    public List<Category> loadList(Category category) throws DaoException {
        return null;
    }

    @Override
    public List<Category> findAll() throws DaoException {
        return null;
    }
}
