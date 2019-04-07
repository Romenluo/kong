package com.li.kong.service;

import com.li.kong.dao.NoteDao;
import com.li.kong.entity.Note;
import com.li.kong.exception.DaoException;

import java.util.List;

public class NoteService {
    NoteDao nd = new NoteDao();
    public Boolean save(Note note){
        try {
            nd.save(note);
            return true;
        }catch (Exception e){
            throw new DaoException(""+e);
            //return false;
        }
    }

    public List<Note> findAll(Integer categoryId){
        List<Note> list;
        try{
            list = nd.findCategoryIdAll(categoryId);
        }catch (Exception e){
            throw new DaoException(""+e);
        }
        return  list;
    }
}
