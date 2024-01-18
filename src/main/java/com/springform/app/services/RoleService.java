package com.springform.app.services;

import com.springform.app.models.domain.Role;

import java.util.List;

public interface RoleService {
    List<Role> list();

    Role getForId(Integer id);
}
