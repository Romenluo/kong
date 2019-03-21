package com.li.kong.entity;

import java.io.Serializable;
import java.util.List;

/**
 * 分类实体类
 */
public class Category implements Serializable {
    private Integer id;
    private String name;
    private List<Note> noteList;//多对一，一个类型对应多篇文字

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Note> getNoteList() {
        return noteList;
    }

    public void setNoteList(List<Note> noteList) {
        this.noteList = noteList;
    }
}
