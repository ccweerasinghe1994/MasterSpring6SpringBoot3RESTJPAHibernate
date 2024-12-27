package com.cgnexus.example_19.model;

import com.cgnexus.example_19.annotations.FieldsValueMatch;
import com.cgnexus.example_19.annotations.PasswordValidator;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
@FieldsValueMatch.List({
        @FieldsValueMatch(field = "email", fieldMatch = "confirmEmail", message = "Emails do not match!"),
        @FieldsValueMatch(field = "pwd", fieldMatch = "confirmPwd", message = "Passwords do not match!")
})
public class Person extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int personId;

    @NotBlank(message = "Name is mandatory")
    @Size(min = 3, message = "Name should have at least 3 characters long")
    private String name;

    @NotBlank(message = "Mobile number is mandatory")
    @Size(min = 10, max = 10, message = "Mobile number should have 10 characters long")
    private String mobileNumber;

    @NotBlank(message = "Email is mandatory")
    @Email(message = "Email should be valid")
    private String email;

    @NotBlank(message = "Confirm Email is mandatory")
    @Email(message = "Confirm Email should be valid")
    @Transient
    private String confirmEmail;

    @NotBlank(message = "Password must not be blank")
    @Size(min = 5, message = "Password must be at least 5 characters long")
    @PasswordValidator
    private String pwd;

    @NotBlank(message = "Confirm Password must not be blank")
    @Size(min = 5, message = "Confirm Password must be at least 5 characters long")
    @Transient
    private String confirmPwd;

}
