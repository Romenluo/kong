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
}
