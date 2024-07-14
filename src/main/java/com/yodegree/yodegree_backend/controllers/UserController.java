package com.yodegree.yodegree_backend.controllers;

import com.yodegree.yodegree_backend.helpers.LoginRequestHelper;
import com.yodegree.yodegree_backend.modules.User;
import com.yodegree.yodegree_backend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
public class UserController {

    @Autowired
    UserService userService;

    @ResponseBody
    @PostMapping("/signup")
    public ResponseEntity<User>  signUp(
            @RequestBody User user
    ){
        User theUser = userService.userSignUp(user);

        return  new ResponseEntity<User>(
                theUser, HttpStatus.ACCEPTED
        );
    }


    @ResponseBody
    @PostMapping("/login")
    public ResponseEntity<User>  login(
            @RequestBody LoginRequestHelper loginRequestHelper
            ){
        User theUser = userService
                .userLogin(
                        loginRequestHelper.getUserName(),
                        loginRequestHelper.getPassword());

        return  new ResponseEntity<User>(
                theUser, HttpStatus.ACCEPTED
        );
    }


    @ResponseBody
    @GetMapping("/userProfile/{id}")
    public ResponseEntity<User>  getUserProfile(
            @PathVariable("id") Integer userId
    ){
        User theUser = userService
                .getUserProfile(userId);

        return  new ResponseEntity<User>(
                theUser, HttpStatus.ACCEPTED
        );
    }


    @ResponseBody
    @PostMapping("/updateUser/{id}")
    public ResponseEntity<User>  signUp(
            @RequestBody User user,
            @PathVariable("id") Integer userId
    ){
        User theUser = userService.userProfielUpdate(
                user, userId
        );

        return  new ResponseEntity<User>(
                theUser, HttpStatus.ACCEPTED
        );
    }


}
