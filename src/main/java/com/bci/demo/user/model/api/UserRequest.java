package com.bci.demo.user.model.api;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.List;

@Getter
@Setter
public class UserRequest {

    @Pattern(regexp = "^[a-zA-Z]{2,15} [a-zA-Z]{2,15}$",
            message = "Name field must not be null or empty or greater thant 50 characters and must only contain letters")
    private String name;

    @Email(message = "Email field should be valid")
    private String email;

    @Pattern(regexp = "^(?=\\w*[A-Z])(?=\\w*[a-z])(?=.*?\\d.*\\d)\\S{8,16}$",
            message = "Password field must have an uppercase letter, lowercase letters and 2 numbers")
    private String password;

    @NotEmpty
    private List<Phone> phones;

}
