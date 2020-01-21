package com.web_kabinet.domain;



import javax.persistence.*;


@Entity
public class Ttn {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)

    private Long id;


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


    public Ttn(User author, Carrier carrier, Contragent contragent, Driver driver, Elevator elevator, Nomenclature nomenclature, Vehicle vehicle) {
        this.author = author;
        this.carrier = carrier;
        this.contragent = contragent;
        this.driver = driver;
        this.elevator = elevator;
        this.nomenclature = nomenclature;
        this.vehicle = vehicle;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Ttn() {
    }

    public Ttn(User user) {
        this.author = user;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthorName() {
        return author != null ? author.getUsername() : "<none>";
    }

    public String getDriverName() {
        return driver != null ? driver.getName() : "<none>";
    }

    public String getCarrier() {
        return carrier.getCarrierName();
    }

    public String getElevatorName() {
        return elevator.getElevatorName();
    }

    public String getNomenclatureName() {
        return nomenclature.getName();
    }

    public String getVehicleName() {
        return vehicle.getCarModel() + " " + vehicle.getCarNumber();
    }
}
