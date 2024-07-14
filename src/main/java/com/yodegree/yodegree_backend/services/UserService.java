package com.yodegree.yodegree_backend.services;

import com.yodegree.yodegree_backend.exceptions.InvalidCredentialsException;
import com.yodegree.yodegree_backend.exceptions.ResourceNotFoundException;
import com.yodegree.yodegree_backend.modules.User;
import com.yodegree.yodegree_backend.modules.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService {


    @Autowired
    UserRepository userRepository;

    public User userSignUp(User user){

        return userRepository.save(
                new User(
                     user.getUserName(),
                     user.getEmail(),
                     user.getPhone(),
                     new ArrayList<>(),
                     String.valueOf(user.getPassword().hashCode())
                )
        );
    }

    public User userLogin(String emailOrUsername, String password){
        User user = userRepository.findUserByEmail(emailOrUsername)
                .orElseThrow(
                        InvalidCredentialsException::new
                );
         String _pass = user.getPassword();
         if(_pass.equals(String.valueOf(password.hashCode()))){
             return user;
         }else throw new InvalidCredentialsException();
    }

    public User userProfielUpdate(User user, Integer userId){
        User theUser = userRepository.findById(userId)
                .orElseThrow(
                        ResourceNotFoundException::new
                );

        theUser.setUserName(user.getUserName());
        theUser.setEmail(user.getEmail());
        theUser.setPhone(user.getPhone());

        userRepository.save(theUser);
        return theUser;
    }

    public User getUserProfile(Integer userId){
        User user = userRepository.findById(userId).orElseThrow(
                ()-> new ResourceNotFoundException()
        );

        return user;
    }

    public void userLogout(){

    }

    public void userDeleteAccount(){

    }

}
