package com.li.kong.service;

import com.li.kong.dao.InformationDao;
import com.li.kong.entity.Information;
import com.li.kong.exception.DaoException;

import java.util.Date;
import java.util.List;

public class InformationService {
    InformationDao informationDao = new InformationDao();

    /**
     * 保存全部实时资讯
     * @param information
     * @return
     */
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

    /**
     * 查询全部实时资讯
     * @return
     */
    public List<Information> findAll(){
        List<Information> list;
        try {
           list = informationDao.findAll();
        }catch (Exception e){
            throw new DaoException(""+e);
        }
        return list;
    }

    /**
     * 删除实时资讯
     * @param id
     * @return
     */
    public boolean deleteInfo(Integer id){
        try {
            informationDao.delete(id);
            return true;
        }catch (Exception e){
//            throw new DaoException(""+e);
            return false;
        }
    }

    /**
     * 更新实时资讯
     * @param information
     * @return
     */
    public boolean update(Information information){
        boolean isUpdate;
        try{
            isUpdate = informationDao.update(information);
        }catch (Exception e){
            throw new DaoException(""+e);
        }
        return isUpdate;
    }

    /**
     * 根据查询实时资讯
     * @param id
     * @return
     */
    public Information find(Integer id){
        Information information;
        try{
            information = informationDao.find(id);
        }catch (Exception e){
            throw new DaoException(""+e);
        }
        return information;
    }
}
