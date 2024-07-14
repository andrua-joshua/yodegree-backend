package com.yodegree.yodegree_backend.services;

import com.yodegree.yodegree_backend.exceptions.ResourceNotFoundException;
import com.yodegree.yodegree_backend.helpers.SaveRecordReq;
import com.yodegree.yodegree_backend.modules.AnalysisRecord;
import com.yodegree.yodegree_backend.modules.AnalysisRecordRepository;
import com.yodegree.yodegree_backend.modules.GuardianUser;
import com.yodegree.yodegree_backend.modules.GuardianUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class RecordsService {

    @Autowired
    AnalysisRecordRepository recordRepository;

    @Autowired
    GuardianUserRepository userRepository;


    public AnalysisRecord saveRecord(Integer userId, SaveRecordReq saveRecordReq){
        GuardianUser user = userRepository.findById(userId).orElseThrow(
                ()-> new ResourceNotFoundException(
                        "User not found"
                )
        );

        AnalysisRecord record = new AnalysisRecord(
                saveRecordReq.getpH(),
                saveRecordReq.getSummary(),
                saveRecordReq.getHelthImplications(),
                user,
                new Date()
        );

        AnalysisRecord savedRecord =  recordRepository.save(record);

        user.getRecords().add(savedRecord);
        userRepository.save(user);
        return  savedRecord;
    }


    public List<AnalysisRecord> getUserRecords(Integer userId){
        GuardianUser user = userRepository.findById(userId).orElseThrow(
                ()-> new ResourceNotFoundException(
                        "User not found"
                )
        );

        return user.getRecords();
    }

    public void deleteRecord(Integer recordId){
        AnalysisRecord record = recordRepository.findById(recordId).orElseThrow(
                ()-> new ResourceNotFoundException(
                        "Record not found"
                )
        );

        GuardianUser user = record.getUser();
        recordRepository.delete(record);
        user.getRecords().remove(record);
        userRepository.save(user);
    }
}
