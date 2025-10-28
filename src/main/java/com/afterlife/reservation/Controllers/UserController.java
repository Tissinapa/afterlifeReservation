package com.afterlife.reservation.Controllers;


import com.afterlife.reservation.Entities.UserEntity;
import com.afterlife.reservation.Services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    //Post user
    @PostMapping("/create")
    public UserEntity saveUser(@Valid @RequestBody UserEntity user){
        return userService.saveUser(user);
    }
    //Get users
    @GetMapping("/all")
    public List<UserEntity> fetchUserList(){
        return userService.fetchUserList();
    }





    @GetMapping("/hello")
    private String HelloUser(){
        return "Terve käyttäjältä";
    }

}
