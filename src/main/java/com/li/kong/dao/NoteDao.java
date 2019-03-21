package com.li.kong.dao;

import com.li.kong.entity.Note;
import com.li.kong.exception.DaoException;

import java.util.List;

public class NoteDao implements Dao<Note,Integer> {
    @Override
    public Integer save(Note o) throws DaoException {
        return null;
    }

    @Override
    public boolean delete(Integer id) throws DaoException {
        return false;
    }

    @Override
    public boolean update(Note note) throws DaoException {
        return false;
    }

    @Override
    public Note find(Integer id) throws DaoException {
        return null;
    }

    @Override
    public Note load(Note note) throws DaoException {
        return null;
    }

    @Override
    public List<Note> loadList(Note note) throws DaoException {
        return null;
    }

    @Override
    public List<Note> findAll() throws DaoException {
        return null;
    }
}
