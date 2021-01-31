package pl.pjatk.timetable.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pl.pjatk.timetable.model.Road;
import pl.pjatk.timetable.repository.RoadRepository;

import javax.persistence.EntityExistsException;
import java.util.List;

@Service
public class RoadService {
    private final RoadRepository roadRepository;

    public RoadService(RoadRepository roadRepository) {
        this.roadRepository = roadRepository;
    }
    public List<Road> findAll() {return roadRepository.findAll();}
    public Road findByRoadId(Long id){
        return roadRepository.findById(id).orElseThrow(()-> new EntityExistsException("Road with id" + id + "doesn't exist"));
    }
    public Road addNewRoad(Road addNewRoad){
        Road road = new Road();
        road.setName(addNewRoad.getName());
        road.setDestination(addNewRoad.getDestination());
        road.setNumberOfBusStop(addNewRoad.getNumberOfBusStop());
        return roadRepository.save(road);

    }
}
