package com.springform.app.models.domain;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Country {
    @NotNull
    private Integer id;
    private String code;
    private String name;

    @Override
    public String toString() {
        return this.id.toString();
    }
}
