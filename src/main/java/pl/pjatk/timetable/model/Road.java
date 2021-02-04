package pl.pjatk.timetable.model;


import javax.persistence.*;
import java.util.List;

@Entity
public class Road {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String name;
    private String destination;
    private Integer numberOfBusStop;

    @OneToMany(mappedBy = "road")
    private List<Bus> busList;

    public Road(Long id, String name, String destination, Integer numberOfBusStop, List<Bus> busList) {
        this.id = id;
        this.name = name;
        this.destination = destination;
        this.numberOfBusStop = numberOfBusStop;
        this.busList = busList;
    }

    public Road() {
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

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Integer getNumberOfBusStop() {
        return numberOfBusStop;
    }

    public void setNumberOfBusStop(Integer numberOfBusStop) {
        this.numberOfBusStop = numberOfBusStop;
    }

    public List<Bus> getBusList() {
        return busList;
    }

    public void setBusList(List<Bus> busList) {
        this.busList = busList;
    }
}
