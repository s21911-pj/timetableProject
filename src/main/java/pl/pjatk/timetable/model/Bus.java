package pl.pjatk.timetable.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Bus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer number;
    private boolean isBusActive;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "road")
    private Road road;

    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "busDriver_id",referencedColumnName = "id")
    private BusDriver busDriver;

    public Bus() {
    }

    public Bus(Long id, String name, Integer number, Road road) {
        this.id = id;
        this.name = name;
        this.number = number;
        this.road = road;
    }

    public Bus(Long id, String name, Integer number, boolean isBusActive, Road road, BusDriver busDriver) {
        this.id = id;
        this.name = name;
        this.number = number;
        this.isBusActive = isBusActive;
        this.road = road;
        this.busDriver = busDriver;
    }

    public Long getId() {
        return id;
    }

    public boolean isBusActive() {
        return isBusActive;
    }

    public Bus(Long id, String name, Integer number, boolean isBusActive, Road road) {
        this.id = id;
        this.name = name;
        this.number = number;
        this.isBusActive = isBusActive;
        this.road = road;
    }

    public void setBusActive(boolean busActive) {
        isBusActive = busActive;
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

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Road getRoad() {
        return road;
    }

    public void setRoad(Road road) {
        this.road = road;
    }
}
