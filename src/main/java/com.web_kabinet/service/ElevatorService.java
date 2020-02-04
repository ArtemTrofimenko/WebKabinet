package com.web_kabinet.service;

import com.web_kabinet.domain.Elevator;
import com.web_kabinet.repos.ElevatorRepo;
import org.springframework.stereotype.Service;

@Service
public class ElevatorService {

    private ElevatorRepo elevatorRepo;

    public ElevatorService(ElevatorRepo elevatorRepo) {
        this.elevatorRepo = elevatorRepo;
    }

    public Elevator findElevatorByUUID (String elevatorId){
        return elevatorRepo.findById(elevatorId).orElseThrow(NullPointerException::new);
    }
}
