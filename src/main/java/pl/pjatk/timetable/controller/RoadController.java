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
    public ResponseEntity<List<Road>> findAllRoads(){
        return ResponseEntity.status(HttpStatus.OK).body(roadService.findAll());
    }
    @GetMapping("/id")
    public ResponseEntity<Road> findByRoudId(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(roadService.findByRoadId(id));
    }
    @PostMapping({"/id"})
    public ResponseEntity<Road> addNewRoad(@RequestBody Road road){
        return ResponseEntity.status(HttpStatus.OK).body(roadService.addNewRoad(road));
    }

}

//    public BusController(BusService busService) {
//        this.busService = busService;
//    }
//    @GetMapping("/getAll")
//    public ResponseEntity<List<Bus>> findAllBuses(){
//        return ResponseEntity.status(HttpStatus.OK).body(busService.findAll());
//    }
//    @GetMapping("/{id}")
//    public ResponseEntity<Bus> findById(@PathVariable Long id){
//        return ResponseEntity.status(HttpStatus.OK).body(busService.findById(id));
//    }
//    @PostMapping("/{id}")
//    public ResponseEntity<Bus> addNewBus(@RequestBody Bus bus){
//        return ResponseEntity.status(HttpStatus.OK).body(busService.addNewBus(bus));
//    }
//    @PostMapping("/{name}")
//    public ResponseEntity<Bus> changeBusName(@RequestBody Bus bus){
//        return ResponseEntity.status(HttpStatus.OK).body(busService.changeBusName(findById(Bus)));
//    }
//}

