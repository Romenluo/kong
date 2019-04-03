package com.li.kong.mapper;

import com.li.kong.entity.Category;

import java.util.List;

public interface CategoryMapper {
    List<Category> findAll();
    Category find(String name);
}
