package com.web_kabinet.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Carrier {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer id;

    private String carrierName;

    public Carrier() {
    }

    public Carrier(String carrierName) {

        this.carrierName = carrierName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCarrierName() {
        return carrierName;
    }

}
