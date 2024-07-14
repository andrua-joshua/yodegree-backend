package com.yodegree.yodegree_backend.services;

import com.yodegree.yodegree_backend.exceptions.InvalidCredentialsException;
import com.yodegree.yodegree_backend.exceptions.ResourceNotFoundException;
import com.yodegree.yodegree_backend.helpers.LoginRequest;
import com.yodegree.yodegree_backend.helpers.SignUpRequest;
import com.yodegree.yodegree_backend.helpers.UpdateGuardianRequest;
import com.yodegree.yodegree_backend.modules.AnalysisRecord;
import com.yodegree.yodegree_backend.modules.AnalysisRecordRepository;
import com.yodegree.yodegree_backend.modules.GuardianUser;
import com.yodegree.yodegree_backend.modules.GuardianUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
public class GuardianAuthService {

    @Autowired
    GuardianUserRepository userRepository;

    @Autowired
    AnalysisRecordRepository recordRepository;


    public GuardianUser signUp(SignUpRequest signUpRequest){

        GuardianUser user = new GuardianUser(
                signUpRequest.getEmail(),
                signUpRequest.getUsername(),
                signUpRequest.getPhone(),
                String.valueOf(signUpRequest.getPassword().hashCode()),
                new ArrayList<AnalysisRecord>()
        );

        return userRepository.save(user);
    }

    public GuardianUser login(LoginRequest loginRequest){

        GuardianUser user = userRepository.findByEmail(loginRequest.getEmail())
                .orElseThrow(
                        ()-> new ResourceNotFoundException(
                                "User not found"
                        )
                );

        String password = user.getPassword();;
        if(password.equals(String.valueOf(loginRequest.getPassword().hashCode()))){
            return user;
        }else{
            throw new InvalidCredentialsException(
                    "Invalid Credential"
            );
        }
    }


    public GuardianUser updateUser(Integer userId, UpdateGuardianRequest updateGuardianRequest){
        GuardianUser user = userRepository.findById(userId)
                .orElseThrow(
                        ()-> new ResourceNotFoundException(
                                "User not found"
                        )
                );

        user.setEmail(updateGuardianRequest.getEmail());
        user.setUsername(updateGuardianRequest.getUsername());
        user.setPhone(user.getPhone());
        user.setPassword(String.valueOf(updateGuardianRequest.getPassword().hashCode()));

        return userRepository.save(user);
    }

}
