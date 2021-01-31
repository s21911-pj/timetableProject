package pl.pjatk.timetable.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pjatk.timetable.model.Bus;
import pl.pjatk.timetable.service.BusService;

import java.util.List;

@RestController
@RequestMapping("/bus")
public class BusController {

private final BusService busService;


    public BusController(BusService busService) {
        this.busService = busService;
    }
    @GetMapping("/getAll")
    public ResponseEntity<List<Bus>> findAllBuses(){
        return ResponseEntity.status(HttpStatus.OK).body(busService.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Bus> findById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(busService.findById(id));
    }
    @PostMapping("/new")
    public ResponseEntity<Bus> addNewBus(@RequestBody Bus bus){
        return ResponseEntity.status(HttpStatus.OK).body(busService.addNewBus(bus));
    }
    @PostMapping("/changeName/{id}")
    public ResponseEntity<Bus> changeBusName(@PathVariable Long id,@RequestBody Bus bus){
        return ResponseEntity.status(HttpStatus.OK).body(busService.changeBusName(id,bus));
    }
    @PutMapping("/changeRoad/{id}")
    public  ResponseEntity<Bus> changeRoad(@PathVariable Long id, @RequestBody Bus bus){
        return ResponseEntity.status(HttpStatus.OK).body(busService.changeRoad(id,bus));
    }
    @GetMapping("/findByRoadName/{name}")
    public ResponseEntity<List<Bus>> findBusByRoadName(@PathVariable String name){
        return ResponseEntity.status(HttpStatus.OK).body(busService.findBusByRoadName(name));
    }
    @PutMapping("/brokenBus/{id}")
    public  ResponseEntity<Bus> sensNewBus(@PathVariable Long id, @RequestBody Bus bus){
        return ResponseEntity.status(HttpStatus.OK).body(busService.brokenBus(id,bus));
    }

}

