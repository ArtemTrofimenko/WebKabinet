package com.web_kabinet.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Carrier {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    private String carrierName;

    public Carrier() {
    }

    public Carrier(String carrierName) {

        this.carrierName = carrierName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCarrierName() {
        return carrierName;
    }

}
