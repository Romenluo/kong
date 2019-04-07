package com.li.kong.dao;

import com.li.kong.entity.Photos;
import com.li.kong.exception.DaoException;
import com.li.kong.mapper.PhotosMapper;
import com.li.kong.utils.DataSource;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class PhotosDao implements Dao<Photos,Integer> {
    private SqlSession session ;
    PhotosMapper mapper;
    @Override
    public Integer save(Photos o) throws DaoException {
        int count;
        try{
            session = new DataSource().init();
            mapper = session.getMapper(PhotosMapper.class);
            count = mapper.save(o);
            session.commit();
        }catch (Exception e){
            session.rollback();
            throw new RuntimeException(e);
        }
        session.close();
        return count;
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
