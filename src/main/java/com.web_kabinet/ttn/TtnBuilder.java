package com.web_kabinet.ttn;

import com.web_kabinet.domain.*;

import java.sql.Timestamp;

public class TtnBuilder {
    Ttn newTtn;
    private  User author;
    private Carrier carrier;
    private Contragent contragent;
    private Driver driver;
    private Nomenclature nomenclature;
    private Vehicle vehicle;
    private Long num;
    private Float weight;
    private Float rubbish;
    private Float humidity;
    private Timestamp ttnTime;
    private  Float percentByHumidity;
    private Float percentByRubbish;
    private String ttnNumber;
    private String indexOfNumber = "ТТН";
    private Operation operation;

    public TtnBuilder() {
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public User getAuthor() {
        return author;
    }

    public Carrier getCarrier() {
        return carrier;
    }

    public Contragent getContragent() {
        return contragent;
    }

    public Float getPercentByHumidity() {
        return percentByHumidity;
    }

    public void setPercentByHumidity(Float percentByHumidity) {
        this.percentByHumidity = percentByHumidity;
    }

    public Float getPercentByRubbish() {
        return percentByRubbish;
    }

    public void setPercentByRubbish(Float percentByRubbish) {
        this.percentByRubbish = percentByRubbish;
    }

    public Driver getDriver() {
        return driver;
    }

    public Nomenclature getNomenclature() {
        return nomenclature;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public Long getNum() {
        return num;
    }

    public Float getWeight() {
        return weight;
    }

    public Float getRubbish() {
        return rubbish;
    }

    public Float getHumidity() {
        return humidity;
    }

    public Timestamp getTtnTime() {
        return ttnTime;
    }

    public String getNumber() {
        return ttnNumber;
    }

    public Ttn getNewTtn() {
        return newTtn;
    }

    public void setNewTtn(Ttn newTtn) {
        this.newTtn = newTtn;
    }

    public TtnBuilder author(User author){
        this.author = author;
        return this;
    }
    public TtnBuilder carrier (Carrier carrier){
        this.carrier = carrier;
        return this;
    }
    public TtnBuilder contragent (Contragent contragent){
        this.contragent = contragent;
        return this;
    }

    public TtnBuilder driver (Driver driver){
        this.driver = driver;
        return this;
    }

    public TtnBuilder nomenclature (Nomenclature nomenclature){
        this.nomenclature = nomenclature;
        return this;
    }

    public TtnBuilder vehicle (Vehicle vehicle){
        this.vehicle = vehicle;
        return this;
    }

    public TtnBuilder num (Long num){
        this.num = num;
        return this;
    }

    public TtnBuilder weight (String weight){
        this.weight = Float.valueOf(weight);
        return this;
    }

    public TtnBuilder rubbish (String rubbish){
        this.rubbish = Float.valueOf(rubbish);
        return this;
    }

    public TtnBuilder humidity(String humidity){
        this.humidity = Float.valueOf(humidity);
        return this;
    }

    public TtnBuilder ttnTime(Timestamp ttnTime){
        this.ttnTime = ttnTime;
        return this;
    }

    public TtnBuilder operation (String operation){

        this.operation = Operation.valueOf(operation);
        return this;
    }

    public Ttn build(){
        ttnNumber = this.indexOfNumber + this.num;
        getPercent(weight, rubbish, humidity);
        return new Ttn(this);
    }

    private void getPercent(Float weight, Float rubbish, Float humidity) {
        percentByHumidity = weight * humidity / 100;
        percentByRubbish = weight * rubbish / 100;
    }


}
