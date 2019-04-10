package com.li.kong.mapper;

import com.li.kong.entity.Photos;

public interface PhotosMapper {
    int save(Photos photos);
    Photos find(String id);
    int update(Photos photos);
    int delete(String id);
}
