package com.li.kong.mapper;

import com.li.kong.entity.User;

public interface UserMapper {
    int save(User user);
    User loadEmail(String email);
    int updateInfo(User user);
    int updatePassword(User user);
}
