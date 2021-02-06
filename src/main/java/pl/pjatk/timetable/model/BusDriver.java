package pl.pjatk.timetable.model;

import javax.persistence.*;


@Entity

public class BusDriver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;


    @OneToOne(mappedBy = "busDriver")
    private Bus bus;


    public BusDriver() {
    }

    public BusDriver(Long id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }

    public BusDriver(Long id, String name, String surname, Bus bus) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.bus = bus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Bus getBus(Bus bus) {
        return this.bus;
    }

    public Bus setBus(Bus bus) {
        this.bus = bus;
        return bus;
    }
}
