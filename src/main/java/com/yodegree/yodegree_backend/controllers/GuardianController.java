package com.yodegree.yodegree_backend.controllers;


import com.yodegree.yodegree_backend.helpers.LoginRequest;
import com.yodegree.yodegree_backend.helpers.SaveRecordReq;
import com.yodegree.yodegree_backend.helpers.SignUpRequest;
import com.yodegree.yodegree_backend.helpers.UpdateGuardianRequest;
import com.yodegree.yodegree_backend.modules.AnalysisRecord;
import com.yodegree.yodegree_backend.modules.GuardianUser;
import com.yodegree.yodegree_backend.services.GuardianAuthService;
import com.yodegree.yodegree_backend.services.RecordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class GuardianController {

    @Autowired
    GuardianAuthService authService;

    @Autowired
    RecordsService recordsService;

    @PostMapping("/signUp")
    public ResponseEntity<GuardianUser> signUp(
            @RequestBody SignUpRequest signUpRequest
            ){
        GuardianUser user = authService.signUp(signUpRequest);

        return new ResponseEntity<GuardianUser>(
                user, HttpStatus.CREATED
        );
    }


    @PostMapping("/login")
    public ResponseEntity<GuardianUser> login(
            @RequestBody LoginRequest loginRequest
            ){
        GuardianUser user = authService.login(loginRequest);

        return new ResponseEntity<GuardianUser>(
                user, HttpStatus.CREATED
        );
    }


    @PostMapping("/updateUser/{id}")
    public ResponseEntity<GuardianUser> updateUser(
            @PathVariable("id") Integer id,
            @RequestBody UpdateGuardianRequest updateGuardianRequest
            ){
        GuardianUser user = authService.updateUser(id,updateGuardianRequest);

        return new ResponseEntity<GuardianUser>(
                user, HttpStatus.CREATED
        );
    }


    @PostMapping("/saveRecord/{id}")
    public ResponseEntity<AnalysisRecord> addRecord(
            @PathVariable("id") Integer id,
            @RequestBody SaveRecordReq saveRecordReq
            ){
        AnalysisRecord record = recordsService.saveRecord(id, saveRecordReq);

        return new ResponseEntity<AnalysisRecord>(
                record, HttpStatus.CREATED
        );
    }


    @GetMapping("/getUserRecords/{id}")
    public ResponseEntity<List<AnalysisRecord>> getUserRecords(
            @PathVariable("id") Integer id
    ){
        List<AnalysisRecord> records = recordsService.getUserRecords(id);

        return  new ResponseEntity<List<AnalysisRecord>>(
                records, HttpStatus.OK
        );
    }


    @DeleteMapping("/deleteRecord/{id}")
    public ResponseEntity<Void> deleteRecord(
            @PathVariable("id") Integer id
    ){
        recordsService.deleteRecord(id);
        return new ResponseEntity<Void>(
                HttpStatus.OK
        );
    }
}
