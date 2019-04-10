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

    /**
     * 根据文章id删除图片
     * @param id
     * @return
     * @throws DaoException
     */
    public boolean delete(String id) throws DaoException{
        int count;
        try {
            session = new DataSource().init();
            mapper = session.getMapper(PhotosMapper.class);
            count = mapper.delete(id);
            session.commit();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        if(count>=1){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean update(Photos photos) throws DaoException {
        int count;
        try{
            session = new DataSource().init();
            mapper = session.getMapper(PhotosMapper.class);
            count = mapper.update(photos);
            session.commit();
        }catch (Exception e){
            session.rollback();
            throw new RuntimeException(e);
        }
        session.close();
        if(count>=1){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public Photos find(Integer id) throws DaoException {
        return null;
    }

    public Photos find(String id) throws DaoException {
        Photos photos;
        try{
            session = new DataSource().init();
            mapper = session.getMapper(PhotosMapper.class);
            photos = mapper.find(id);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        session.close();
        return photos;
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
