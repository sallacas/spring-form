package com.springform.app.services;

import com.springform.app.models.domain.Role;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    private final List<Role> list;

    public RoleServiceImpl() {
        this.list = Arrays.asList(
                new Role(1, "ROLE_ADMIN", "Administrator"),
                new Role(2, "ROLE_MODERATOR", "Moderator"),
                new Role(3, "ROLE_USER", "User")
        );
    }

    @Override
    public List<Role> list() {
        return list;
    }

    @Override
    public Role getForId(Integer id) {
        return list.stream()
                .filter(role -> role.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}
