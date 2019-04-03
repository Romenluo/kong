package com.li.kong.service;

import com.li.kong.dao.CategoryDao;
import com.li.kong.entity.Category;
import com.li.kong.exception.DaoException;

import java.util.List;

public class CategoryService {

    CategoryDao cd = new CategoryDao();
    /**
     * 查询所有的分类
     * @return
     */
    public List<Category> findAll(){
        List<Category> list ;
        try{
            list = cd.findAll();
        }catch (Exception e){
           throw new DaoException(""+e);
        }
        return list;
    }

    public Category find(String name){
        Category category ;
        try{
            category = cd.findString(name);
        }catch (Exception e){
            throw new DaoException(""+e);
        }
        return category;
    }
}
