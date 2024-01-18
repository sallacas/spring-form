package com.springform.app.models.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Role {
    private Integer id;
    private String name;
    private String role;

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Role rol)) {
            return false;
        }
        return !Objects.isNull(this.id) && this.id.equals(rol.getId());
    }
}
