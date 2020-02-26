package com.web_kabinet.service;

import com.web_kabinet.repos.RequestRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RequestService {
    @Autowired
    RequestRepo requestRepo;

    public Long getNumber() {
        Long num = 0L;
        Long max = 0L;
        max = requestRepo.findMaxNum();
        if (max == null) {
            return 1L;
        }
        num = max + 1L;
        return num;
    }


}
