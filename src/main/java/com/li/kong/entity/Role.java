package com.li.kong.entity;

import java.io.Serializable;
import java.util.List;

/**
 * 角色实例
 */
public class Role implements Serializable {
    private Integer id;
    private String name;
    private List<User> user; //一对多，当前类型对应的用户

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

    public List<User> getUser() {
        return user;
    }

    public void setUser(List<User> user) {
        this.user = user;
    }
}
