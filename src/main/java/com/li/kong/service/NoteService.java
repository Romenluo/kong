package com.li.kong.service;

import com.li.kong.dao.NoteDao;
import com.li.kong.entity.Note;
import com.li.kong.exception.DaoException;

import java.util.List;

public class NoteService {
    NoteDao nd = new NoteDao();
    CommentService cs = new CommentService();
    PhotosService ps = new PhotosService();
    /**
     * 保存文章
     * @param note
     * @return
     */
    public Boolean save(Note note){
        try {
            note.setUpVote(0);
            note.setDownVote(0);
            nd.save(note);
            return true;
        }catch (Exception e){
            throw new DaoException(""+e);
            //return false;
        }
    }

    /**
     * 更新文章
     * @param note
     * @return
     */
    public boolean update(Note note){
        boolean isUpdate;
        try{
            isUpdate = nd.update(note);
        }catch (Exception e){
            throw new DaoException(""+e);
        }
        return isUpdate;
    }

    /**
     * 根据id查询文章
     * @param id
     * @return
     */
    public Note find(String id){
        Note note;
        try{
            note = nd.find(id);
        }catch (Exception e){
            throw new DaoException(""+e);
        }
        return  note;
    }
    /**
     * 根据类型查询所有的文章
     * @param categoryId
     * @return
     */
    public List<Note> findCategoryAll(Integer categoryId){
        List<Note> list;
        try{
            list = nd.findCategoryIdAll(categoryId);
        }catch (Exception e){
            throw new DaoException(""+e);
        }
        return  list;
    }

    /**
     * 根据文章id删除文章
     * @param id
     * @return
     */
    public boolean delete(String id){
        try {
            cs.delete(id);
            ps.delete(id);
            nd.delete(id);
        }catch (Exception e){
            throw new DaoException(""+e);
        }
        return true;
    }
}
