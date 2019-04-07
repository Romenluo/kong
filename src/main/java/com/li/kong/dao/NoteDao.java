package com.li.kong.dao;

import com.li.kong.entity.Note;
import com.li.kong.exception.DaoException;
import com.li.kong.mapper.NoteMapper;
import com.li.kong.utils.DataSource;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class NoteDao implements Dao<Note,Integer> {
    private SqlSession session ;
    NoteMapper noteMapper;
    @Override
    public Integer save(Note o) throws DaoException {
        int count;
        try{
            session = new DataSource().init();
            noteMapper = session.getMapper(NoteMapper.class);
            count = noteMapper.save(o);
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
        /*List<Note> list;
        try{
            session = new DataSource().init();
            noteMapper = session.getMapper(NoteMapper.class);
            list = noteMapper.findAll();
        }catch (Exception e){
            throw new RuntimeException();
        }
        session.close();*/
        return null;
    }
    public List<Note> findCategoryIdAll(Integer categoryId) throws DaoException {
        List<Note> list;
        try{
            session = new DataSource().init();
            noteMapper = session.getMapper(NoteMapper.class);
            list = noteMapper.findAll(categoryId);
        }catch (Exception e){
            throw new RuntimeException();
        }
        session.close();
        return list;
    }
}
