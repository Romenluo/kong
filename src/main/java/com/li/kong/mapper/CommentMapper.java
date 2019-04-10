package com.li.kong.mapper;

import com.li.kong.entity.Comment;

import java.util.List;

public interface CommentMapper {
    int save(Comment comment);
    List<Comment> findNote(String id);
    Comment find(Integer id);
    int update(Comment comment);
    int deleteNote(String noteId);
}
