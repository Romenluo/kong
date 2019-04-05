package com.li.kong.service;

import com.li.kong.dao.InformationDao;
import com.li.kong.entity.Information;
import com.li.kong.exception.DaoException;

import java.util.Date;
import java.util.List;

public class InformationService {
    InformationDao informationDao = new InformationDao();

    public int save(Information information){
        Date date = new Date();
        information.setDownVote(0);
        information.setUpVote(0);
        information.setInfoDate(date);
       int count;
       try{
           count = informationDao.save(information);
           return count;
       }catch (Exception e){
           throw new DaoException(""+e);
       }
    }

    public List<Information> findAll(){
        List<Information> list;
        try {
           list = informationDao.findAll();
        }catch (Exception e){
            throw new DaoException(""+e);
        }
        return list;
    }

    public boolean deleteInfo(Integer id){
        try {
            informationDao.delete(id);
            return true;
        }catch (Exception e){
//            throw new DaoException(""+e);
            return false;
        }
    }
}
