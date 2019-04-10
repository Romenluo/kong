package com.li.kong.service;

import com.li.kong.dao.PhotosDao;
import com.li.kong.entity.Photos;
import com.li.kong.exception.DaoException;

public class PhotosService {
    PhotosDao pd = new PhotosDao();
    public Integer save(Photos photos){
        int count;
       try{
          count = pd.save(photos);
       }catch (Exception e){
           throw new DaoException(""+e);
       }
        return count;
    }

    /**
     * 根据文章ID查询图片
     * @param id
     * @return
     */
    public Photos find(String id){
        Photos photos;
        try {
            photos = pd.find(id);
        }catch (Exception e){
            throw new DaoException(""+e);
        }
        return  photos;
    }

    public boolean update(Photos photos){
        try {
           pd.update(photos);
        }catch (Exception e){
            throw new DaoException(""+e);
        }
        return true;
    }

    /**
     * 根据文章ID删除图片
     * @param id
     * @return
     */
    public boolean delete(String id){
        try {
            pd.delete(id);
        }catch (Exception e){
            throw new DaoException(""+e);
        }
        return true;
    }
}
