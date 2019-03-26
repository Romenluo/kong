package com.li.kong.service;

import com.li.kong.dao.RoleDao;
import com.li.kong.entity.Role;
import com.li.kong.exception.DaoException;

public class RoleService {
    RoleDao roleDao = new RoleDao();

    /**
     * 根据角色名称查询角色
     * @param name
     * @return
     */
    public Role find(String name){
        Role role;
       try{
           role = roleDao.find(name);
           return role;
       }catch (Exception e){
           throw new DaoException("查询失败");
       }
    }
    /**
     * 根据角色id查询角色
     * @param id
     * @return
     */
    public Role findId(int id){
        Role role;
        try{
            role = roleDao.findId(id);
            return role;
        }catch (Exception e){
            return null;
        }
    }
}
