package com.li.kong.service;

import com.li.kong.dao.CommentDao;
import com.li.kong.dao.UserDao;
import com.li.kong.entity.Comment;
import com.li.kong.entity.User;
import com.li.kong.exception.DaoException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CommentService {
    UserDao ud = new UserDao();
    CommentDao cd = new CommentDao();
    public int save(Comment comment){
        int count ;
        try{
            comment.setUpVote(0);
            comment.setDownVote(0);
            comment.setCommentDate(new Date());
            count = cd.save(comment);
        }catch (Exception e){
            throw new DaoException(""+e);
        }
        return count;
    }

    public List<Comment> findNote(String id){
        List<Comment> list = new ArrayList();

        try {
            List<Comment> lists = cd.findNote(id);
            for (Comment comment:lists){
                User user = ud.loadId(comment.getUserId());
                comment.setUser(user);
                list.add(comment);
            }
        }catch (Exception e){
            throw new DaoException(""+e);
        }
        return list;
    }

    /**
     * 根据id查询评论
     * @param id
     * @return
     */
    public Comment find(Integer id){
        Comment comment;
        try {
            comment = cd.find(id);
        }catch (Exception e){
            throw new DaoException(""+e);
        }
        return comment;
    }

    /**
     * 更新评论
     * @param note
     * @return
     */
    public boolean update(Comment note){
        boolean isUpdate;
        try{
            isUpdate = cd.update(note);
        }catch (Exception e){
            throw new DaoException(""+e);
        }
        return isUpdate;
    }

    /**
     * 根据文章ID删除文章
     * @param id
     * @return
     */
    public boolean delete(String id){
        try {
            cd.deleteNote(id);
        }catch (Exception e){
            throw new DaoException(""+e);
        }
        return true;
    }
}
