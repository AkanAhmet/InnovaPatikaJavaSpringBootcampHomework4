package com.innova.service;

import com.innova.dto.UserRegisterDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserServices {

    //http://localhost:8080/rest/manueljson
    @GetMapping("/rest/manueljson")
    public String getManuelJson(){
        return "{\"Name\": \"Ahmet\",\"Surname\": \"AKAN\",\"Age\": \"24\",\"Email\": \"ahmet@hotmail.com\",\"Password\": \"ahmet\"}";
    }

    //http://localhost:8080/rest/dynamicsjson
    @GetMapping("/rest/dynamicsjson")
    public UserRegisterDto getDynamicsJson(){
        UserRegisterDto userRegisterDto =
                 UserRegisterDto.builder()
                .userName("ahmet")
                .userSurname("akan")
                .userAge(24)
                .userEmail("ahmet@hotmail.com")
                .userPassword("ahmet")
                .build();
        return userRegisterDto;
    }

    //http://localhost:8080/rest/mediatype
    @GetMapping(value = "/rest/mediatype", produces = MediaType.APPLICATION_JSON_VALUE)
    public UserRegisterDto getMediaType(){
        UserRegisterDto userRegisterDto =
                UserRegisterDto.builder()
                .userName("ahmet")
                .userSurname("akan")
                .userAge(24)
                .userEmail("ahmet@hotmail.com")
                .userPassword("ahmet")
                .build();
        return userRegisterDto;
    }
}
