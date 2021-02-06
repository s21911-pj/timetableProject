package pl.pjatk.timetable.service;


import org.springframework.stereotype.Service;
import pl.pjatk.timetable.exception.TimetableExceptions;
import pl.pjatk.timetable.model.Bus;
import pl.pjatk.timetable.model.Road;
import pl.pjatk.timetable.repository.BusRepository;
import pl.pjatk.timetable.repository.RoadRepository;

import javax.persistence.EntityExistsException;
import java.util.List;

@Service
public class RoadService {
    private final RoadRepository roadRepository;
    private final BusRepository busRepository;

    public RoadService(RoadRepository roadRepository, BusRepository busRepository) {
        this.roadRepository = roadRepository;
        this.busRepository = busRepository;
    }

    public List<Road> findAll() {
        return roadRepository.findAll();
    }

    public Road findByRoadId(Long id) {
        return roadRepository.findById(id).orElseThrow(() -> new EntityExistsException("Road with id" + id + "doesn't exist"));
    }

    public Road addNewRoad(Road addNewRoad) {
        Road road = new Road();
        road.setName(addNewRoad.getName());
        road.setDestination(addNewRoad.getDestination());
        road.setNumberOfBusStop(addNewRoad.getNumberOfBusStop());
        return roadRepository.save(road);

    }
    public void deleteRoadByID(Long id) {
        roadRepository.deleteById(id);
    }


}
