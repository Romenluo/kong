package com.li.kong.dao;

import com.li.kong.entity.Category;
import com.li.kong.exception.DaoException;
import com.li.kong.mapper.CategoryMapper;
import com.li.kong.utils.DataSource;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class CategoryDao implements Dao<Category, Integer> {
    private SqlSession session;
    private CategoryMapper mapper;

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

    /**
     * 根据类型名称查找类型
     * @param name
     * @return
     * @throws DaoException
     */
    public Category findString(String name) throws DaoException {
        Category category;
        try {
            session = new DataSource().init();
            mapper = session.getMapper(CategoryMapper.class);
            category = mapper.find(name);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        session.close();

        return category;
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
        List<Category> list;
        try {
            session = new DataSource().init();
            mapper = session.getMapper(CategoryMapper.class);
            list = mapper.findAll();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        session.close();

        return list;
    }
}
