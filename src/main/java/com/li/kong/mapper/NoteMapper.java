package com.li.kong.mapper;

import com.li.kong.entity.Note;

import java.util.List;

public interface NoteMapper {
    int save(Note note);
    List<Note> findAll(Integer categoryId);
}
