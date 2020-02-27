package com.web_kabinet.request;

import com.web_kabinet.domain.Contragent;
import com.web_kabinet.domain.Nomenclature;
import com.web_kabinet.domain.User;

import java.sql.Timestamp;

public class RequestBuilder {
    private User author;
    private Contragent contragent;
    private Nomenclature nomenclature;
    private Long num;
    private Float weight;
    private Boolean isChecked;
    private Timestamp reqTime = new Timestamp(System.currentTimeMillis());
    private String reqNumber;
    private String indexOfNumber = "ЗАЯ";

    public User getAuthor() {
        return author;
    }

    public Contragent getContragent() {
        return contragent;
    }

    public Boolean getChecked() {
        return isChecked;
    }

    public Nomenclature getNomenclature() {
        return nomenclature;
    }

    public Long getNum() {
        return num;
    }

    public Float getWeight() {
        return weight;
    }

    public Timestamp getReqTime() {
        return reqTime;
    }

    public String getReqNumber() {
        return reqNumber;
    }

    public String getIndexOfNumber() {
        return indexOfNumber;
    }

    public RequestBuilder author(User author){
        this.author = author;
        return this;
    }

    public RequestBuilder contragent (Contragent contragent){
        this.contragent = contragent;
        return this;
    }


    public RequestBuilder nomenclature (Nomenclature nomenclature){
        this.nomenclature = nomenclature;
        return this;
    }
    public RequestBuilder isChecked (String isChecked){
        this.isChecked = Boolean.valueOf(isChecked);
        return this;
    }


    public RequestBuilder num (Long num){
        this.num = num;
        return this;
    }

    public RequestBuilder weight (String weight){
        this.weight = Float.valueOf(weight);
        return this;
    }


    public Request build(){
        reqNumber = this.indexOfNumber + this.num;
        return new Request(this);
    }

}
