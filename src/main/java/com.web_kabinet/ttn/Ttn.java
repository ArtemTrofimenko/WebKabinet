package com.web_kabinet.ttn;

import com.web_kabinet.domain.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

@Table(name = "ttn")
@Entity(name = "Ttn")
public class Ttn implements Serializable {


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
    @JoinColumn(name = "carrier_id")
    private Carrier carrier;

    @ManyToOne(fetch = FetchType.EAGER)
    @Fetch(FetchMode.SELECT)
    @JoinColumn(name = "contragent_id")
    private Contragent contragent;

    @ManyToOne(fetch = FetchType.EAGER)
    @Fetch(FetchMode.SELECT)
    @JoinColumn(name = "driver_id")
    private Driver driver;

    @ManyToOne(fetch = FetchType.EAGER)
    @Fetch(FetchMode.SELECT)
    @JoinColumn(name = "elevator_id")
    private Elevator elevator;

    @ManyToOne(fetch = FetchType.EAGER)
    @Fetch(FetchMode.SELECT)
    @JoinColumn(name = "nomenclature_id")
    private Nomenclature nomenclature;

    @ManyToOne(fetch = FetchType.EAGER)
    @Fetch(FetchMode.SELECT)
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

    @Column(name = "ttn_number", updatable = false, nullable = false)
    private String ttnNumber;

    @Column(name = "ttn_time", updatable = true, nullable = false)
    private Timestamp ttnTime;
    @Enumerated(EnumType.STRING)
    @Column(name = "operation", updatable = false, nullable = false)
    private Operation operation;

    public Ttn(TtnBuilder ttnBuilder) {
        this.author = ttnBuilder.getAuthor();
        this.carrier = ttnBuilder.getCarrier();
        this.contragent = ttnBuilder.getContragent();
        this.driver = ttnBuilder.getDriver();
        this.elevator = ttnBuilder.getElevator();
        this.nomenclature = ttnBuilder.getNomenclature();
        this.vehicle = ttnBuilder.getVehicle();
        this.num = ttnBuilder.getNum();
        this.weight = ttnBuilder.getWeight();
        this.rubbish = ttnBuilder.getRubbish();
        this.humidity = ttnBuilder.getHumidity();
        this.ttnTime = ttnBuilder.getTtnTime();
        this.percentByHumidity = ttnBuilder.getPercentByHumidity();
        this.percentByRubbish = ttnBuilder.getPercentByRubbish();
        this.indexOfNumber = getIndexOfNumber();
        this.ttnNumber = ttnBuilder.getNumber();
        this.operation = ttnBuilder.getOperation();
    }

    public static TtnBuilder builder(){
        return new TtnBuilder();
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
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
        ttnNumber = getIndexOfNumber() + getNum();
        return num!=null? ttnNumber:"<none>";
    }

    public void setNumber(String number) {
        this.ttnNumber = number;
    }

    public String getTtnDate(){
        return ttnTime != null ?
                new SimpleDateFormat("dd/MM/yyyy").format(ttnTime)
        : "<none>"; }

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
        return ttnNumber;
    }

    public String getContragentName() {
        return contragent.getContragentName() != null ? contragent.getContragentName() : "<none>";
    }
    public String getContragentId() {
        return contragent.getId() != null ? contragent.getId() : "<none>";
    }

    public String getAuthorName() {
        return author != null ? author.getUsername() : "<none>";
    }

    public String getCarrier() {
        return carrier.getCarrierName() != null ? carrier.getCarrierName() : "<none>";
    }

    public String getDriverName() {
        return driver != null ? driver.getName() : "<none>";
    }

    public void setCarrier(Carrier carrier) {
        this.carrier = carrier;
    }

    public String getElevatorName() {
        return elevator.getElevatorName() != null ? elevator.getElevatorName() : "<none>";
    }

    public String getNomenclatureName() {
        return nomenclature != null ? nomenclature.getName() : "<none>";
    }

    public String getNomenclatureId() {
        return  nomenclature.getId();
    }
    public String getSummaryId() {
        return  getContragentId()+getNomenclatureId();
    }

    public String getVehicleName() {
        return vehicle.getCarModel() + " " + vehicle.getCarNumber();
    }
}
