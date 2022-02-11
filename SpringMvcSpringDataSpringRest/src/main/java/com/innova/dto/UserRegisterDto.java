package com.innova.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Log4j2
public class UserRegisterDto {


    @NotEmpty(message = "Please enter your name")
    private String userName;

    @NotEmpty(message = "Please enter your surname")
    private String userSurname;

    @Min(value=15,message = "You must be older than 15")
    @Max(value=65,message = "You must be younger than 65")
    private int userAge;

    @NotEmpty(message = "Please enter your email")
    @Email(message = "Email format must be correct")
    private String userEmail;

    @NotEmpty(message = "Please enter a valid password")
    @Size(min=5,max=20)
    private String userPassword;

}
