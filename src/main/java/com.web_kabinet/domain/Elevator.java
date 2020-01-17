package com.web_kabinet.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Elevator {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer id;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer elevatorId;

    public Elevator(Integer elevatorId, String elevatorName, Integer elevatorEDRPOU) {
        this.elevatorId = elevatorId;
        this.elevatorName = elevatorName;
        this.elevatorEDRPOU = elevatorEDRPOU;
    }

    public Integer getElevatorId() {
        return elevatorId;
    }

    private String elevatorName;
    private Integer elevatorEDRPOU;

    public Elevator(String elevatorName, Integer elevatorEDRPOU) {
        this.elevatorName = elevatorName;
        this.elevatorEDRPOU = elevatorEDRPOU;
    }

    public void setElevatorId(Integer elevatorId) {
        this.elevatorId = elevatorId;
    }

    public Elevator() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getElevatorName() {
        return elevatorName;
    }

    public void setElevatorName(String elevatorName) {
        this.elevatorName = elevatorName;
    }

    public Integer getElevatorEDRPOU() {
        return elevatorEDRPOU;
    }

    public void setElevatorEDRPOU(Integer elevatorEDRPOU) {
        this.elevatorEDRPOU = elevatorEDRPOU;
    }
}
