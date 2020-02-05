package com.web_kabinet.domain;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class Ttn {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", updatable = false, nullable = false)
    private String id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "author_id")
    private User author;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "carrier_id")
    private Carrier carrier;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "contragent_id")
    private Contragent contragent;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "driver_id")
    private Driver driver;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "elevator_id")
    private Elevator elevator;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "nomenclature_id")
    private Nomenclature nomenclature;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;

    @Column(name = "num")
    private Long num;

    @Column(name = "index_of_number")
    private String indexOfNumber = "ТТН";

    @Column(name = "weight")
    private Float weight;

    @Column(name = "rubbish")
    private Float rubbish;

    @Column(name = "humidity")
    private Float humidity;

    @Column(name = "percent_by_humidity")
    private Float percentByHumidity;

    @Column(name = "percent_by_rubbish")
    private Float percentByRubbish;
    @Column(name = "ttnNumber", updatable = false, nullable = false)
    private String number;
    @Column(name = "ttnTime", updatable = true, nullable = false)
    private Timestamp ttnTime;

    public Ttn(User author, Carrier carrier, Contragent contragent, Driver driver, Elevator elevator, Nomenclature nomenclature, Vehicle vehicle, Long num, Float weight, Float rubbish, Float humidity, Timestamp ttnTime) {
        this.author = author;
        this.carrier = carrier;
        this.contragent = contragent;
        this.driver = driver;
        this.elevator = elevator;
        this.nomenclature = nomenclature;
        this.vehicle = vehicle;
        this.num = num;
        this.weight = weight;
        this.rubbish = rubbish;
        this.humidity = humidity;
        this.ttnTime = ttnTime;
        number = indexOfNumber + this.num;
        getPercent(weight, rubbish, humidity);

    }

    public Ttn(User user) {
        this.author = user;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public Float getRubbish() {
        return rubbish;
    }

    public void setRubbish(Float rubbish) {
        this.rubbish = rubbish;
    }

    public Float getHumidity() {
        return humidity;
    }

    public void setHumidity(Float humidity) {
        this.humidity = humidity;
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

    public String getIndexOfNumber() {
        return indexOfNumber;
    }

    public void setIndexOfNumber(String indexOfNumber) {
        this.indexOfNumber = indexOfNumber;
    }

    public Long getNum() {
        return num;
    }

    public void setNum(Long num) {
        this.num = num;
    }

    public String getNumber() {
        number = getIndexOfNumber() + getNum();
        return num!=null? number:"<none>";
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getTtnDate(){
        return ttnTime != null ? ttnTime.toString(): "<none>"; }

    public Timestamp getTtnTime() {
        return ttnTime;
    }

    public void setTtnTime(Timestamp ttnTime) {
        this.ttnTime = ttnTime;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Ttn() {
    }

    private void getPercent(Float weight, Float rubbish, Float humidity) {
        percentByHumidity = weight * humidity / 100;
        percentByRubbish = weight * rubbish / 100;
    }

    public Contragent getContragent() {
        return contragent;
    }

    public void setContragent(Contragent contragent) {
        this.contragent = contragent;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Elevator getElevator() {
        return elevator;
    }

    public void setElevator(Elevator elevator) {
        this.elevator = elevator;
    }

    public Nomenclature getNomenclature() {
        return nomenclature;
    }

    public void setNomenclature(Nomenclature nomenclature) {
        this.nomenclature = nomenclature;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTTNumber() {
        return number;
    }

    public String getContragentName() {
        return contragent != null ? contragent.getContragentName() : "<none>";
    }

    public String getAuthorName() {
        return author != null ? author.getUsername() : "<none>";
    }

    public String getCarrier() {
        return carrier != null ? carrier.getCarrierName() : "<none>";
    }

    public String getDriverName() {
        return driver != null ? driver.getName() : "<none>";
    }

    public void setCarrier(Carrier carrier) {
        this.carrier = carrier;
    }

    public String getElevatorName() {
        return elevator != null ? elevator.getElevatorName() : "<none>";
    }

    public String getNomenclatureName() {
        return nomenclature != null ? nomenclature.getName() : "<none>";
    }

    public String getVehicleName() {
        return vehicle.getCarModel() + " " + vehicle.getCarNumber();
    }
}
