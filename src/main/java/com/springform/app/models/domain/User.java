package com.springform.app.models.domain;

import com.springform.app.validators.Regex;
import com.springform.app.validators.Required;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class User {

    //@Pattern(regexp = "\\d{6}-[A-Z]")
    @Regex
    private String id;
    //@NotEmpty
    private String firstname;
    @Required
    private String lastname;
    @Required
    @Size(min = 3, max = 10)
    private String username;
    @Required
    private String password;
    @Required
    @Email
    private String email;
    @NotNull
    @Min(5)
    @Max(5000)
    private Integer account;
    @NotNull
    @Past
    //@DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
    @NotNull
    private Country country;
    @NotEmpty
    private List<String> roles;
}
