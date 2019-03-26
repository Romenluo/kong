package com.li.kong.mapper;

import com.li.kong.entity.Role;

public interface RoleMapper {
    Role find(String name);
    Role findId(int id);
}
