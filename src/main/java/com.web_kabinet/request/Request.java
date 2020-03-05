package com.web_kabinet.request;

import com.web_kabinet.domain.Contragent;
import com.web_kabinet.domain.Nomenclature;
import com.web_kabinet.domain.User;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

@Entity
@Table(name = "request")
public class Request implements Serializable {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", updatable = false, nullable = false)
    private String id;

    @ManyToOne(fetch = FetchType.EAGER)
    @Fetch(FetchMode.SELECT)
    @JoinColumn(name = "author_id")
    private User author;

    @ManyToOne(fetch = FetchType.EAGER)
    @Fetch(FetchMode.SELECT)
    @JoinColumn(name = "contragent_id")
    private Contragent contragent;

    @ManyToOne(fetch = FetchType.EAGER)
    @Fetch(FetchMode.SELECT)
    @JoinColumn(name = "nomenclature_id")
    private Nomenclature nomenclature;

    @Column(name = "num")
    private Long num;

    @Column(name = "index_of_number")
    private String indexOfNumber = "ЗАЯ";

    @Column(name = "weight")
    private Float weight;

    @Column(name = "req_number", updatable = false, nullable = false)
    private String reqNumber;

    @Column(name = "req_time", updatable = true, nullable = false)
    private Timestamp reqTime;

    @Column(name = "isChecked", updatable = true, nullable = false)
    private Boolean isChecked;

    public Request(RequestBuilder requestBuilder) {
        this.author = requestBuilder.getAuthor();
        this.contragent = requestBuilder.getContragent();
        this.indexOfNumber = getIndexOfNumber();
        this.isChecked = requestBuilder.getChecked();
        this.nomenclature = requestBuilder.getNomenclature();
        this.reqNumber = requestBuilder.getReqNumber();
        this.reqTime = requestBuilder.getReqTime();
        this.weight = requestBuilder.getWeight();
        this.num = requestBuilder.getNum();
    }

    public Request() {
    }

    public static RequestBuilder builder() {
        return new RequestBuilder();
    }

    public String getId() {
        return id != null ? id : "";
    }

    public void setId(String id) {
        this.id = id;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Contragent getContragent() {
        return contragent;
    }

    public void setContragent(Contragent contragent) {
        this.contragent = contragent;
    }

    public Nomenclature getNomenclature() {
        return nomenclature;
    }

    public void setNomenclature(Nomenclature nomenclature) {
        this.nomenclature = nomenclature;
    }

    public Long getNum() {
        return num;
    }

    public void setNum(Long num) {
        this.num = num;
    }

    public String getIndexOfNumber() {
        return indexOfNumber;
    }

    public void setIndexOfNumber(String indexOfNumber) {
        this.indexOfNumber = indexOfNumber;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public String getReqNumber() {
        return reqNumber;
    }

    public void setReqNumber(String reqNumber) {
        this.reqNumber = reqNumber;
    }

    public Timestamp getReqTime() {
        return reqTime;
    }

    public void setReqTime(Timestamp reqTime) {
        this.reqTime = reqTime;
    }

    public Boolean getChecked() {
        return isChecked;
    }

    public void setChecked(Boolean checked) {
        isChecked = checked;
    }

    public String getCheckedString() {
        return isChecked ? "Подтверждена" : "Неподтверждена";
    }

    public String getReqDate() {
        return reqTime != null ?
                new SimpleDateFormat("dd/MM/yyyy").format(reqTime)
                : "<none>";
    }

    public String getContragentName() {
        return contragent.getContragentName() != null ? contragent.getContragentName() : "<none>";
    }

    public String getContragentId() {
        return contragent.getId() != null ? contragent.getId() : "";
    }

    public String getNomenclatureName() {
        return nomenclature != null ? nomenclature.getName() : "<none>";
    }

    public String getNomenclatureId() {
        return nomenclature != null ? nomenclature.getId() : "";
    }
}
