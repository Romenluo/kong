package com.li.kong.entity;

/**
 * 图片实体类
 */
public class Photos {
    private Integer id;
    private String title;
    private String imageUrl;//图片路径
    private Note note;//一对一，一张图片属于一篇文字

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Note getNote() {
        return note;
    }

    public void setNote(Note note) {
        this.note = note;
    }
}
