package com.li.kong.mapper;

import com.li.kong.entity.User;

import java.util.List;

public interface UserMapper {
    int save(User user);
    User loadEmail(String email);
    int updateInfo(User user);
    int updatePassword(User user);
    List<User> listUser();
    int updateForbidden(User user);
}
