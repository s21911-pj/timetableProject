package pl.pjatk.timetable.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pjatk.timetable.model.Road;
import pl.pjatk.timetable.service.RoadService;

import java.util.List;

@RestController
@RequestMapping("/road")
public class RoadController {

    private final RoadService roadService;

    public RoadController(RoadService roadService) {
        this.roadService = roadService;
    }

    @GetMapping("/allRoad")
    public ResponseEntity<List<Road>> findAllRoads() {
        return ResponseEntity.status(HttpStatus.OK).body(roadService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Road> findByRoadId(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(roadService.findByRoadId(id));
    }

    @PostMapping({"/{id}"})
    public ResponseEntity<Road> addNewRoad(@RequestBody Road road) {
        return ResponseEntity.status(HttpStatus.OK).body(roadService.addNewRoad(road));
    }
    @DeleteMapping("/deleteRoadById/{id}")
    public ResponseEntity<?> deleteRoadById(@PathVariable Long id){
        roadService.deleteRoadByID(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}



