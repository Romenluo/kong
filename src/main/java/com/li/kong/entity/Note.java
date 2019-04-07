package com.li.kong.entity;

import java.io.Serializable;
import java.util.List;

/**
 * 地方特色介绍实体类
 */
public class Note implements Serializable {
    private String id;
    private String title;
    private String content;
    private Integer upVote;
    private Integer downVote;
    private int categoryId;
    private Category category;//一对一，一篇文章对应一个类型
    private List<Photos> photos;//一对多，一篇文字有多张图片
    private List<Comment> commentList;//一对多，一篇文字有多条评论

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Photos> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Photos> photos) {
        this.photos = photos;
    }

    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }
}
