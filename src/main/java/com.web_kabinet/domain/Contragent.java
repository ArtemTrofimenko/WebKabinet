package com.web_kabinet.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Contragent {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long contragentId;
    private String contragentName;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContragentName() {
        return contragentName;
    }

    public void setContragentName(String contragentName) {
        this.contragentName = contragentName;
    }


    public Contragent() {
    }

    public Contragent(String contragentName) {

        this.contragentName = contragentName;
    }
}
