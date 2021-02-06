package pl.pjatk.timetable.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Bus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer number;
    private boolean isBusActive;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "road_id")
//    private Road road;

    @JsonIgnore
    @OneToMany(mappedBy = "bus")
    private List<Road> roads;

    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "busDriver_id", referencedColumnName = "id")
    private BusDriver busDriver;

    public Bus() {
    }

    public Bus(Long id, String name, Integer number, List<Road> roads) {
        this.id = id;
        this.name = name;
        this.number = number;
        this.roads = roads;
    }

    public Bus(Long id, String name, Integer number, boolean isBusActive) {
        this.id = id;
        this.name = name;
        this.number = number;
        this.isBusActive = isBusActive;
    }

    public Long getId() {
        return id;
    }

    public boolean isBusActive() {
        return isBusActive;
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

    public boolean getIsActive() {
        return isBusActive;
    }

    public List<Road> getRoads() {
        return roads;
    }

    public void setRoads(List<Road> roads) {
        this.roads = roads;
    }

    public BusDriver getBusDriver() {
        return busDriver;
    }

    public void setBusDriver(BusDriver busDriver) {
        this.busDriver = busDriver;
    }

    public void setIsActive(boolean isBusActive) {
        this.isBusActive = isBusActive;
    }

}
