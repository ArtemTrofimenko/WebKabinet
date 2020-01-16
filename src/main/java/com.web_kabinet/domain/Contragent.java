package com.web_kabinet.domain;

import javax.persistence.*;

@Entity
public class Contragent {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String contragentName;
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "contragent_id")
    private User worker;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContragentName() {
        return contragentName;
    }

    public void setContragentName(String contragentName) {
        this.contragentName = contragentName;
    }

    public User getWorker() {
        return worker;
    }

    public void setWorker(User worker) {
        this.worker = worker;
    }

    public Contragent() {
    }

    public Contragent(Integer id, String contragentName) {
        this.id = id;
        this.contragentName = contragentName;
    }
}
