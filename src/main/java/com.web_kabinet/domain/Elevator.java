package com.web_kabinet.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Elevator {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", updatable = false, nullable = false)
    private String id;

//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long elevatorId;

    public Elevator(String id, String elevatorName, Integer elevatorEDRPOU) {
        this.id = id;
        this.elevatorName = elevatorName;
        this.elevatorEDRPOU = elevatorEDRPOU;
    }

//    public Long getElevatorId() {
//        return elevatorId;
//    }

    private String elevatorName;
    private Integer elevatorEDRPOU;

    public Elevator(String elevatorName, Integer elevatorEDRPOU) {
        this.elevatorName = elevatorName;
        this.elevatorEDRPOU = elevatorEDRPOU;
    }

//    public void setElevatorId(Long elevatorId) {
//        this.elevatorId = elevatorId;
//    }

    public Elevator() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
