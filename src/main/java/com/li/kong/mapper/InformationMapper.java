package com.li.kong.mapper;

import com.li.kong.entity.Information;

import java.util.List;

public interface InformationMapper {
    int save(Information information);
    List<Information> findAll();
    Information find(Integer id);
    int delete(Integer id);
    int update(Information information);
}
