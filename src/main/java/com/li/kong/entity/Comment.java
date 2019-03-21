package com.li.kong.entity;

import java.io.Serializable;

/**
 * 评论实例
 */
public class Comment implements Serializable {
    private Integer id;
    private String content;
    private User user;//一对一。一条评论由一个用户发表
    private Note note;//一对一。一条评论属于一篇文章
    private Integer upVote;
    private Integer downVote;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Note getNote() {
        return note;
    }

    public void setNote(Note note) {
        this.note = note;
    }

    public Integer getUpVote() {
        return upVote;
    }

    public void setUpVote(Integer upVote) {
        this.upVote = upVote;
    }

    public Integer getDownVote() {
        return downVote;
    }

    public void setDownVote(Integer downVote) {
        this.downVote = downVote;
    }
}
