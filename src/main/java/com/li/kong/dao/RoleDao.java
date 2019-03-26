package com.li.kong.dao;

import com.li.kong.entity.Role;
import com.li.kong.exception.DaoException;
import com.li.kong.mapper.RoleMapper;
import com.li.kong.utils.DataSource;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class RoleDao implements Dao<Role,Integer> {

    private SqlSession session ;
    RoleMapper mapper;
    @Override
    public Integer save(Role o) throws DaoException {
        return null;
    }

    @Override
    public boolean delete(Integer id) throws DaoException {
        return false;
    }

    @Override
    public boolean update(Role role) throws DaoException {
        return false;
    }

    @Override
    public Role find(Integer id) throws DaoException {
        return null;
    }

    @Override
    public Role load(Role role) throws DaoException {
        return null;
    }

    @Override
    public List<Role> loadList(Role role) throws DaoException {
        return null;
    }

    @Override
    public List<Role> findAll() throws DaoException {
        return null;
    }

    /**
     * 根据角色名称查询角色
     * @param name
     * @return
     * @throws DaoException
     */
    public Role find(String name)throws DaoException {
        Role role;
        try {
            session =  new DataSource().init();
            mapper = session.getMapper(RoleMapper.class);
            role = mapper.find(name);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        return  role;
    }
    /**
     * 根据角色id查询角色
     * @param id
     * @return
     * @throws DaoException
     */
    public Role findId(int id)throws DaoException {
        Role role;
        try {
            session =  new DataSource().init();
            mapper = session.getMapper(RoleMapper.class);
            role = mapper.findId(id);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        return  role;
    }
}
