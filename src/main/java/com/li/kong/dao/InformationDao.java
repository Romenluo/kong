package com.li.kong.dao;

import com.li.kong.entity.Information;
import com.li.kong.exception.DaoException;
import com.li.kong.mapper.InformationMapper;
import com.li.kong.utils.DataSource;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class InformationDao implements Dao<Information,Integer> {
    private SqlSession session ;
    InformationMapper mapper;
    @Override
    public Integer save(Information o) throws DaoException {
        int count;
        try{
            session = new DataSource().init();
            mapper = session.getMapper(InformationMapper.class);
            count = mapper.save(o);
            session.commit();
        }catch (Exception e){
          throw new RuntimeException(e);
        }
        return count;
    }

    @Override
    public boolean delete(Integer id) throws DaoException {
        int count;
        try {
            session = new DataSource().init();
            mapper = session.getMapper(InformationMapper.class);
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
    public boolean update(Information information) throws DaoException {
        int count;
        try {
            session = new DataSource().init();
            mapper = session.getMapper(InformationMapper.class);
            count = mapper.update(information);
            session.commit();
        }catch (Exception e){
            session.rollback();
            throw new RuntimeException(e);
        }
        if(count>=1){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public Information find(Integer id) throws DaoException {
        Information information;
        try{
            session = new DataSource().init();
            mapper = session.getMapper(InformationMapper.class);
            information = mapper.find(id);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        return information;
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
        List<Information> list;
        try{
            session = new DataSource().init();
            mapper = session.getMapper(InformationMapper.class);
            list = mapper.findAll();
        }catch (Exception e){
          throw new RuntimeException(e);
        }
        return list;
    }
}
