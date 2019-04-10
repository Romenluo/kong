package com.li.kong.dao;

import com.li.kong.entity.Comment;
import com.li.kong.exception.DaoException;
import com.li.kong.mapper.CommentMapper;
import com.li.kong.utils.DataSource;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class CommentDao implements Dao<Comment,Integer> {
    private SqlSession session ;
    private CommentMapper mapper;
    @Override
    public Integer save(Comment o) throws DaoException {
        int count;
        try{
            session = new DataSource().init();
            mapper = session.getMapper(CommentMapper.class);
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
        int count;
        try {
            session = new DataSource().init();
            mapper = session.getMapper(CommentMapper.class);
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

    /**
     * 根据文章id删除评论
     * @param id
     * @return
     * @throws DaoException
     */
    public boolean deleteNote(String id) throws  DaoException{
        int count;
        try {
            session = new DataSource().init();
            mapper = session.getMapper(CommentMapper.class);
            count = mapper.deleteNote(id);
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
    public boolean update(Comment comment) throws DaoException {
        int count;
        try {
            session = new DataSource().init();
            mapper = session.getMapper(CommentMapper.class);
            count = mapper.update(comment);
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
    public Comment find(Integer id) throws DaoException {
        Comment comment;
        try{
            session = new DataSource().init();
            mapper = session.getMapper(CommentMapper.class);
            comment = mapper.find(id);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        session.close();
        return comment;
    }

    @Override
    public Comment load(Comment comment) throws DaoException {
        return null;
    }

    @Override
    public List<Comment> loadList(Comment comment) throws DaoException {
        return null;
    }

    @Override
    public List<Comment> findAll() throws DaoException {
        return null;
    }

    public List<Comment> findNote(String id) throws DaoException {
        List<Comment> list;
        try{
            session = new DataSource().init();
            mapper = session.getMapper(CommentMapper.class);
            list = mapper.findNote(id);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        session.close();
        return list;
    }

}
