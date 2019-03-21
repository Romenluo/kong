package com.li.kong.dao;

import com.li.kong.entity.Comment;
import com.li.kong.exception.DaoException;

import java.util.List;

public class CommentDao implements Dao<Comment,Integer> {
    @Override
    public Integer save(Comment o) throws DaoException {
        return null;
    }

    @Override
    public boolean delete(Integer id) throws DaoException {
        return false;
    }

    @Override
    public boolean update(Comment comment) throws DaoException {
        return false;
    }

    @Override
    public Comment find(Integer id) throws DaoException {
        return null;
    }

    @Override
    public Comment load(Comment comment) throws DaoException {
        return null;
    }

    @Override
    public List<Comment> loadList(Comment comment) throws DaoException {
        return null;
    }

    @Override
    public List<Comment> findAll() throws DaoException {
        return null;
    }
}
