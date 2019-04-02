package com.li.kong.service;

import com.li.kong.dao.NoteDao;
import com.li.kong.entity.Note;
import com.li.kong.exception.DaoException;

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
}
