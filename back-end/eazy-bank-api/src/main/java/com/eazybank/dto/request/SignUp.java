package com.eazybank.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SignUp {

    @NotBlank(message = "name required")
    private String name;
    @NotBlank(message = "email required")
    private String email;
    @NotBlank(message = "password required")
    private String password;
    @NotBlank(message = "role required")
    private String role;
    @NotNull(message = "role required")
    private Boolean enabled = true;


}
