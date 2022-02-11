package com.innova.controller;

import com.innova.dto.UserRegisterDto;
import com.innova.entity.UserRegisterEntity;
import com.innova.repository.IUserRegisterRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
@Log4j2
public class UserController {

    @Autowired
    IUserRegisterRepository iUserRegisterRepository;

    // http://localhost:8080/register
    @GetMapping("/register")
    public String getRegisterForm(Model model){
        model.addAttribute("register_key", new UserRegisterDto());
        return "register";
    }

    // http://localhost:8080/register
    @PostMapping("/register")
    public String postRegisterForm(@Valid @ModelAttribute("register_key") UserRegisterDto userRegisterDto, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            log.error("Error");
            log.info(userRegisterDto);
            return "register";
        }else{
            UserRegisterEntity userRegisterEntity =
                    UserRegisterEntity.builder()
                    .userId(0L)
                    .userNameSurname(userRegisterDto.getUserName()+" "+userRegisterDto.getUserSurname())
                    .userAge(userRegisterDto.getUserAge())
                    .userEmail(userRegisterDto.getUserEmail())
                    .userPassword(userRegisterDto.getUserPassword())
                    .build();

            iUserRegisterRepository.save(userRegisterEntity);
            return "success";
        }
    }
}
